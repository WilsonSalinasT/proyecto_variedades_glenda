/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;

/**
 *
 * @author novastar
 */
public class crear_envio extends javax.swing.JPanel {

    /**
     * Creates new form crear_envio
     */
    public crear_envio() {
        initComponents();

        fechaentrega.setMinSelectableDate(new Date());

        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 2); // Suma dos meses a la fecha actual
        fechaentrega.setMaxSelectableDate(maxDate.getTime());

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT PS.prenda,PS.fechaPedido,PS.precio, PA.arreglo, PA.precio AS precioarreglo,PA.fechaPedido as fechaprenda , C.id_cliente, C.nombre, C.apellido, C.numero_telefono, C.direccion\n"
                    + "FROM Cliente C\n"
                    + "INNER JOIN PedidoSastreria PS ON C.id_cliente = PS.id_cliente\n"
                    + "INNER JOIN PedidoArreglo PA ON C.id_cliente = PA.id_cliente;";
            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            Set<String> nombresCompletos = new HashSet<>(); // Utiliza un conjunto para almacenar nombres y apellidos únicos

            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombreCompleto = nombre + " " + apellido;

                // Verifica si el nombre completo ya está en el conjunto
                if (!nombresCompletos.contains(nombreCompleto))
                {
                    txtCliente.addItem(nombreCompleto);
                    nombresCompletos.add(nombreCompleto); // Agrega el nombre completo al conjunto
                }
            }

            connection.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        txtCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCliente.getSelectedIndex() > 0)
                {
                    String selectedClient = (String) txtCliente.getSelectedItem();

                    // Verifica si se seleccionó el elemento "Seleccione"
                    if (!selectedClient.equals("Seleccione"))
                    {
                        // Buscar nuevamente el ID y el teléfono en la base de datos
                        try
                        {
                            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                            Statement stmt = connection.createStatement();

                            String sqlq = "SELECT PS.prenda,PS.fechaPedido,PS.precio, PA.arreglo, PA.precio AS precioarreglo,PA.fechaPedido as fechaprenda, C.id_cliente, C.nombre, C.apellido, C.numero_telefono, C.direccion\n"
                                    + "FROM Cliente C\n"
                                    + "INNER JOIN PedidoSastreria PS ON C.id_cliente = PS.id_cliente\n"
                                    + "INNER JOIN PedidoArreglo PA ON C.id_cliente = PA.id_cliente WHERE CONCAT(C.nombre, ' ', C.apellido) = '" + selectedClient + "'";
                            ResultSet rs = stmt.executeQuery(sqlq);

                            if (rs.next())
                            {
                                int selectedClientId = rs.getInt("id_cliente");
                                String selectedClientTelefono = rs.getString("numero_telefono");
                                String selectedClientDireccion = rs.getString("direccion");

                                // Actualiza los campos de texto con el ID y el teléfono del cliente seleccionado
                                id_cliente.setText(Integer.toString(selectedClientId));
                                txtcelular.setText(selectedClientTelefono);
                                txtdireccion.setText(selectedClientDireccion);

                                // Limpia los elementos existentes en los JComboBox
                                productListComboBox.removeAllItems();
                                arreglo.removeAllItems();

                                Set<String> productoInfoSet = new HashSet<>(); // Utiliza un HashSet para evitar duplicados en productListComboBox
                                Set<String> arregloInfoSet = new HashSet<>();  // Utiliza otro HashSet para evitar duplicados en el JComboBox "arreglo"

                                do
                                {
                                    String selectedPrecioStr = rs.getString("precio");
                                    String selectedprenda = rs.getString("prenda");
                                    String seledtedFecha = rs.getString("fechaPedido");
                                    String productoInfo = "Prenda: " + selectedprenda + " | " + selectedPrecioStr + " lps | " + "Fecha de pedido: " + seledtedFecha;
                                    productoInfoSet.add(productoInfo);

                                    String selectedPrecioArre = rs.getString("arreglo");
                                    String selectedpPrendaArre = rs.getString("precioarreglo");
                                    String seledtedFechaAreglo = rs.getString("fechaprenda");
                                    String productoInfos = selectedPrecioArre + " " + selectedpPrendaArre + " " + seledtedFechaAreglo;
                                    arregloInfoSet.add(productoInfos);
                                } while (rs.next());

                                // Agrega elementos únicos desde el HashSet a productListComboBox
                                for (String producto : productoInfoSet)
                                {
                                    productListComboBox.addItem(producto);
                                }

                                // Agrega elementos únicos desde el HashSet a arreglo
                                for (String producto : arregloInfoSet)
                                {
                                    arreglo.addItem(producto);
                                }
                            } else
                            {
                                // Si no se encontraron productos, establece los campos en blanco y limpia los JComboBox
                                id_cliente.setText("");
                                txtcelular.setText("");
                                txtdireccion.setText("");
                                productListComboBox.removeAllItems();
                                arreglo.removeAllItems();
                            }

                            connection.close();
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    } else
                    {
                        // Si se selecciona "Seleccione", establece los campos en blanco
                        id_cliente.setText("");
                        txtcelular.setText("");
                        txtdireccion.setText("");
                    }
                }
            }
        });

//
//        try
//        {
//            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT prenda, precio, id_pedido FROM PedidoSastreria";
//            ResultSet rs = stmt.executeQuery(sql);
//            DefaultListModel<String> model = new DefaultListModel<>();
//            model.addElement("Seleccione"); // Agrega el elemento "Seleccione" al principio
//
//            while (rs.next())
//            {
//                String prenda = rs.getString("prenda");
//                String precio = rs.getString("precio");
//                int idPedido = rs.getInt("id_pedido");
//                String nombreCompleto = prenda + " " + precio;
//                model.addElement(nombreCompleto);
//            }
//
//            connection.close();
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        txtpedidos.setSelectedIndex(0);
//
//        txtpedidos.addListSelectionListener(e ->
//        {
//            if (!e.getValueIsAdjusting())
//            {
//                String selectedClient = txtpedidos.getSelectedValue();
//                if (selectedClient != null && !selectedClient.equals("Seleccione"))
//                {
//                    try
//                    {
//                        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//                        Statement stmt = connection.createStatement();
//                        String sql = "SELECT prenda, precio, id_pedido FROM PedidoSastreria WHERE CONCAT(prenda, ' ', precio) = '" + selectedClient + "'";
//                        ResultSet rs = stmt.executeQuery(sql);
//
//                        if (rs.next())
//                        {
//                            int selectedClientId = rs.getInt("id_pedido");
//                            String selectedClientTelefono = rs.getString("prenda");
//                            String selectedClientDireccion = rs.getString("precio");
//
//                            // Actualiza los campos de texto con el ID y el teléfono del cliente seleccionado
//                            id_cliente.setText(Integer.toString(selectedClientId));
//                            txtcelular.setText(selectedClientTelefono);
//                            txtdireccion.setText(selectedClientDireccion);
//                        }
//
//                        connection.close();
//                    } catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//                    }
//                } else
//                {
//                    // Si se selecciona "Seleccione", establece los campos en blanco
//                    id_cliente.setText("");
//                    txtcelular.setText("");
//                    txtdireccion.setText("");
//                }
//            }
//        });
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnatras = new javax.swing.JButton();
        txtCliente = new javax.swing.JComboBox<>();
        fechaentrega = new com.toedter.calendar.JDateChooser();
        txtcelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        id_cliente = new javax.swing.JTextField();
        productListComboBox = new javax.swing.JComboBox<>();
        arreglo = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Crear envio");

        btnatras.setBackground(new java.awt.Color(255, 153, 51));
        btnatras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnatras.setText("VOLVER");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnatras)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnatras)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
        );

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12)))); // NOI18N

        fechaentrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        txtcelular.setEditable(false);
        txtcelular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Celular:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 1, 12))); // NOI18N

        txtdireccion.setEditable(false);
        txtdireccion.setColumns(20);
        txtdireccion.setLineWrap(true);
        txtdireccion.setRows(5);
        txtdireccion.setWrapStyleWord(true);
        txtdireccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion:"));
        jScrollPane1.setViewportView(txtdireccion);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        id_cliente.setEditable(false);
        id_cliente.setText("000000000");
        id_cliente.setBorder(null);

        productListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        productListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productListComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(arreglo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fechaentrega, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                    .addComponent(productListComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcelular)
                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(arreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(146, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
//        listado_de_pedidos p2 = new listado_de_pedidos();
//        p2.setSize(1024, 640);
//        p2.setLocation(0, 0);
//
//        jPanel1.removeAll();
//        jPanel1.add(p2, BorderLayout.CENTER);
//        jPanel1.revalidate();
//        jPanel1.repaint();
    }//GEN-LAST:event_btnatrasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void productListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productListComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productListComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> arreglo;
    private javax.swing.JButton btnatras;
    private com.toedter.calendar.JDateChooser fechaentrega;
    public javax.swing.JTextField id_cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> productListComboBox;
    private javax.swing.JComboBox<String> txtCliente;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextArea txtdireccion;
    // End of variables declaration//GEN-END:variables
}
