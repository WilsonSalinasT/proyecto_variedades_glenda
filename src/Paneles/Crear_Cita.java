/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Crear_Cita extends javax.swing.JPanel {

    TextPrompt holder;

    /**
     * Creates new form Crear_Cita
     */
    public Crear_Cita() {
        initComponents();
        // holder = new TextPrompt("Busque al cliente por su nombre", txtCliente);

//        fechaCita.setMinSelectableDate(new Date());
//
//        Calendar maxDate = Calendar.getInstance();
//        maxDate.set(2024, Calendar.DECEMBER, 1);
//        fechaCita.setMaxSelectableDate(maxDate.getTime());
        fechaCita.setMinSelectableDate(new Date());

        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 2); // Suma dos meses a la fecha actual
        fechaCita.setMaxSelectableDate(maxDate.getTime());

        // Generar ítems para el JComboBox
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        // Agregar "Seleccione" como primer elemento
        model.addElement("Seleccione");

        for (int hora = 8; hora <= 16; hora++)
        { // Hasta las 4:30 p.m. (16:30)
            for (int minuto = 0; minuto <= 30; minuto += 30)
            {
                if (hora == 8 && minuto < 30)
                {
                    continue; // Saltar 8:00 a 8:30
                }
                String amPm = (hora < 12) ? "a.m." : "p.m.";
                model.addElement(String.format("%02d:%02d %s", hora, minuto, amPm));
            }
        }

        cbxHoras.setModel(model);

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT id_cliente, nombre, apellido FROM Cliente";
            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int idCliente = rs.getInt("id_cliente");

                txtCliente.addItem(nombre + " " + apellido);

                // Almacena el ID del cliente en un mapa con el nombre completo como clave
                txtCliente.putClientProperty(nombre + " " + apellido, idCliente);
            }

            connection.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        txtCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClient = (String) txtCliente.getSelectedItem();
                int selectedClientId = (int) txtCliente.getClientProperty(selectedClient);

                // Actualiza el campo de texto con el ID del cliente seleccionado
                id_cliente.setText(Integer.toString(selectedClientId));
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fechaCita = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        btnCrear = new javax.swing.JButton();
        id_cliente = new javax.swing.JTextField();
        cbxHoras = new javax.swing.JComboBox<>();
        txtCliente = new javax.swing.JComboBox<>();
        crea_cliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnvolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        fechaCita.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Cita", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        txtMotivo.setColumns(20);
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(5);
        txtMotivo.setWrapStyleWord(true);
        txtMotivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo de la Cita", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMotivoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtMotivo);

        btnCrear.setBackground(new java.awt.Color(255, 153, 51));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        id_cliente.setEditable(false);
        id_cliente.setBackground(new java.awt.Color(255, 255, 255));
        id_cliente.setForeground(new java.awt.Color(255, 255, 255));
        id_cliente.setBorder(null);

        cbxHoras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora de la cita", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        crea_cliente.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        crea_cliente.setForeground(new java.awt.Color(255, 0, 0));
        crea_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crea_cliente.setText("¿No encontró al cliente? ¿Desea Crear un nuevo cliente?");
        crea_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crea_clienteMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        btnvolver.setBackground(new java.awt.Color(255, 153, 51));
        btnvolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnvolver.setForeground(new java.awt.Color(0, 0, 0));
        btnvolver.setText("VOLVER");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Creación de Cita");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnvolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(crea_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                                .addComponent(txtCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crea_cliente)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnCrear)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isWhitespace(c) && txtMotivo.getText().isEmpty() || (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ((int) evt.getKeyChar() <= 500 && evt.getKeyChar() >= 164) && c != KeyEvent.VK_SPACE || txtMotivo.getText().length() >= 250)
            evt.consume();
    }//GEN-LAST:event_txtMotivoKeyTyped

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombre = (String) txtCliente.getSelectedItem();
        String motivo = txtMotivo.getText().trim();
        Date fecha = fechaCita.getDate();
        String idC = id_cliente.getText();

        String hora = (String) cbxHoras.getSelectedItem();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombre.equals("Seleccione"))
        {
            camposVacios.append("\n - Nombre");
        }
        if (fecha == null)
        {
            camposVacios.append("\n - Fecha");
        }
        String categorias = cbxHoras.getSelectedItem().toString(); // Obtiene el elemento seleccionado en el JComboBox

        if (categorias.equals("Seleccione"))
        {
            camposVacios.append("\n - Hora");
        }
        if (motivo.isEmpty())
        {
            camposVacios.append("\n - Motivo");
        }

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:"))
        {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else
        {

            try
            {
                // Resto del código para la inserción en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement insertPs = conn.prepareStatement("INSERT INTO Cita ( fecha_cita, hora_cita, motivo, id_cliente) VALUES (?,?,?,?)");
                insertPs.setDate(1, new java.sql.Date(fecha.getTime()));
                insertPs.setString(2, hora);
                insertPs.setObject(3, motivo);
                insertPs.setObject(4, idC);

                insertPs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");

//                TIENE QUE LLEVAR AL LISTADO DE CITAS
                Listado_Citas cli = new Listado_Citas();

                cli.setSize(1024, 640);
                cli.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(cli, BorderLayout.CENTER);
                panelprincipal.revalidate();
                panelprincipal.repaint();
            } catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void crea_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crea_clienteMouseClicked

        crear_cliente p2 = new crear_cliente();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_crea_clienteMouseClicked

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        Listado_Citas l2 = new Listado_Citas();
        l2.setSize(1024, 640);
        l2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(l2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btnvolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cbxHoras;
    private javax.swing.JLabel crea_cliente;
    private com.toedter.calendar.JDateChooser fechaCita;
    public javax.swing.JTextField id_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> txtCliente;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
