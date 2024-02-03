/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paneles.OperacionesGaleria;



import Paneles.CustomRender;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author novastar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

public class OperationsTodos {

    public static void ListProductsInJlist(JList list, JPanel frame) {
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//            PreparedStatement checkNamePs = conn.prepareStatement("SELECT * FROM Productos where categoria = 'arreglos' ");
            PreparedStatement checkNamePs = conn.prepareStatement("SELECT * FROM Productos");
            ResultSet result = checkNamePs.executeQuery();

            while (result.next()) {
                byte[] productimage = result.getBytes("foto");
                productimage = scaleBytes(productimage, 380, 320, frame);
               listModel.addElement(new ProductosClase(result.getString("nombre"), new ImageIcon(productimage), result.getString("categoria")));

            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }

        list.setCellRenderer(new CustomRender());
        list.setModel(listModel);
    }

    public static byte[] scaleBytes(byte[] filedata, int width, int height, JPanel frame) {
        if (filedata == null) {
        // En caso de que filedata sea nulo, puedes devolver un valor por defecto o manejarlo según tus necesidades
        // Por ejemplo, podrías devolver una imagen predeterminada
        // return getDefaultImageByteArray(); // Define una función para obtener una imagen predeterminada
        return null; // O simplemente devolver nulo
    }
        
        ByteArrayInputStream byteArrayInsStream = new ByteArrayInputStream(filedata);

        try {
            BufferedImage img = ImageIO.read(byteArrayInsStream);
            if (height == 0) {
                height = (width * img.getHeight() / img.getWidth());
            }
            if (width == 0) {
                width = (height * img.getWidth() / img.getHeight());
            }

            Image scaledimage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage imagebuild = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imagebuild.getGraphics().drawImage(scaledimage, 0, 0, new Color(0, 0, 0), null);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(imagebuild, "jpg", byteArrayOutputStream);
            ImageIO.write(imagebuild, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
            JOptionPane.showMessageDialog(frame, "Byte scale error: " + e.getMessage());
        }

        return null;
    }
}
