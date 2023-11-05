/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Paneles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ModeloProductos {
    
    Connection con;
    PreparedStatement ps;
    
    public int registroProducto(String nombre, String descripcion, String categoria, byte[] foto, String ip, String puerto, String dbName, String user, String password) {
    
        try {
            con =  ConexionSQLServer.getConexion(ip, puerto, dbName, user, password);
            String query = "INSERT INTO productos (nombre, descripcion, categoria, foto) VALUES (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, categoria);
            ps.setBytes(4, foto);
            int result = ps.executeUpdate();
            if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de ingresar el registro: " + e.toString(), "Proceso incompleto", JOptionPane.WARNING_MESSAGE);
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public int updateProducto(int cod_producto, String nombre, String descripcion, String categoria, byte[] foto, String ip, String puerto, String dbName, String user, String password) {
    
        try {
            con =  ConexionSQLServer.getConexion(ip, puerto, dbName, user, password);
            String query = "UPDATE productos SET nombre = ?, descripcion = ?, categoria = ?, foto = ? WHERE cod_producto = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, categoria);
            ps.setBytes(4, foto);
            ps.setInt(5, cod_producto);
            int result = ps.executeUpdate();
            if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de ingresar el registro: " + e.toString(), "Proceso incompleto", JOptionPane.WARNING_MESSAGE);
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public int updateProducto2(int cod_producto, String nombre, String descripcion, String categoria, String ip, String puerto, String dbName, String user, String password) {
    
        try {
            con =  ConexionSQLServer.getConexion(ip, puerto, dbName, user, password);
            String query = "UPDATE productos SET nombre = ?, descripcion = ?, categoria = ? WHERE cod_producto = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, categoria);
            ps.setInt(4, cod_producto);
            int result = ps.executeUpdate();
            if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de ingresar el registro: " + e.toString(), "Proceso incompleto", JOptionPane.WARNING_MESSAGE);
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
