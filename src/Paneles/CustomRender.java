/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author novastar
 */
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CustomRender extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
        JPanel panel = new JPanel(new BorderLayout());

        ProductosClase productosClase = (ProductosClase) value;

        // Configurar el JLabel para la imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setIcon(productosClase.getFoto());
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imagenLabel, BorderLayout.CENTER);

        // Configurar un panel para contener el título y el separador
        JPanel titleAndSeparatorPanel = new JPanel(new GridBagLayout());

        titleAndSeparatorPanel.setBackground(new Color(255, 108, 34));
        // Configurar el JLabel para el título
        JLabel tituloLabel = new JLabel(productosClase.getNombre());
        tituloLabel.setFont(tituloLabel.getFont().deriveFont(Font.BOLD, 36)); // Ajusta el tamaño según tus preferencias

        tituloLabel.setOpaque(false);
        
        // Configurar un separador (línea) con orientación horizontal y color naranja
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        separator.setForeground(Color.ORANGE); // Color naranja
        separator.setOpaque(false);

        // Configurar las restricciones para el título
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.insets = new Insets(0, 0, 5, 0); // Margen inferior
        titleConstraints.anchor = GridBagConstraints.CENTER;

        // Agregar el título y el separador al panel con GridBagLayout
        titleAndSeparatorPanel.add(tituloLabel, titleConstraints);
        titleAndSeparatorPanel.add(separator);

        panel.add(titleAndSeparatorPanel, BorderLayout.SOUTH);

        // Configurar el estilo de la celda según la selección
        if (isSelected) {
            panel.setBackground(list.getSelectionBackground());
            tituloLabel.setForeground(list.getSelectionForeground());
        } else {
            panel.setBackground(list.getBackground());
            tituloLabel.setForeground(list.getForeground());
        }

        panel.setEnabled(true);

        return panel;
    }
}