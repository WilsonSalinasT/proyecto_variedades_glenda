/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Fernando Amador
 */
public class Crear_Pedido_Sublimacion extends javax.swing.JPanel {

    private double[] materialPrices = {0, 180, 120, 100, 130, 80};

    /**
     * Creates new form Crear_Pedido_Sublimacion
     */
    public Crear_Pedido_Sublimacion() {
        initComponents();
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Crear un formato para la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha como una cadena
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Mostrar la fecha en el JLabel
        //fechaP.setText(fechaFormateada);
        //--------------------------------------------------
        // Crea un objeto Calendar para manipular la fecha actual
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(fechaActual);

        // Restringe las fechas anteriores a la fecha actual
        jDateChooser1.setMinSelectableDate(fechaActual);

        // Crea un objeto Calendar para la fecha actual más tres meses
        Calendar maxDateCalendar = Calendar.getInstance();
        maxDateCalendar.setTime(fechaActual);
        maxDateCalendar.add(Calendar.MONTH, 3);

        // Restringe las fechas dentro de tres meses a partir de la fecha actual
        jDateChooser1.setMaxSelectableDate(maxDateCalendar.getTime());

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT id_cliente, nombre, apellido, numero_telefono FROM Cliente";
            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int idCliente = rs.getInt("id_cliente");
                String telefono = rs.getString("numero_telefono");

                String nombreCompleto = nombre + " " + apellido;
                txtCliente.addItem(nombreCompleto);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        txtCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCliente.getSelectedIndex() > 0) {
                    String selectedClient = (String) txtCliente.getSelectedItem();

                    // Verifica si se seleccionó el elemento "Seleccione"
                    if (!selectedClient.equals("Seleccione")) {
                        // Buscar nuevamente el ID y el teléfono en la base de datos
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                            Statement stmt = connection.createStatement();
                            String sql = "SELECT id_cliente, numero_telefono FROM Cliente WHERE CONCAT(nombre, ' ', apellido) = '" + selectedClient + "'";
                            ResultSet rs = stmt.executeQuery(sql);

                            if (rs.next()) {
                                int selectedClientId = rs.getInt("id_cliente");
                                String selectedClientTelefono = rs.getString("numero_telefono");

                                // Actualiza los campos de texto con el ID y el teléfono del cliente seleccionado
                                id_cliente.setText(Integer.toString(selectedClientId));
                                txtTel.setText(selectedClientTelefono);
                            }

                            connection.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        // Si se selecciona "Seleccione", establece los campos en blanco
                        id_cliente.setText("");
                        txtTel.setText("");
                    }
                }
            }
        });

        txtcantidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTotal();
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

        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnVolve = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnCrear = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        AgregarImagen = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cbxEstado = new javax.swing.JComboBox<>();

        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("9801-4550/3308-9197");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        btnVolve.setBackground(new java.awt.Color(255, 153, 51));
        btnVolve.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolve.setText("VOLVER");
        btnVolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolveActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Creación de Pedido de Sublimación");

        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Trojes, El Paraíso");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolve)
                .addGap(110, 110, 110))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnVolve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 3, 12))); // NOI18N

        txtTel.setEditable(false);
        txtTel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teléfono", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtTel.setEnabled(false);
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Seleccione el material para sublimar");

        cbnproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Camisa", "Taza", "Plato", "Gorra", "Llavero" }));
        cbnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnproductoActionPerformed(evt);
            }
        });

        txtdescripcion.setColumns(20);
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setRows(5);
        txtdescripcion.setWrapStyleWord(true);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 0, 12))); // NOI18N
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtdescripcion);

        btnCrear.setBackground(new java.awt.Color(255, 153, 51));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        imagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        AgregarImagen.setBackground(new java.awt.Color(255, 153, 51));
        AgregarImagen.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        AgregarImagen.setText("Agregar imagen");
        AgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarImagenActionPerformed(evt);
            }
        });

        jDateChooser1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de entrega:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 3, 12))); // NOI18N

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Entregado" }));
        cbxEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado del pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        txtcantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        txtPrecio.setEditable(false);
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtPrecio.setEnabled(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbnproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(AgregarImagen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                        .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(cbnproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(AgregarImagen)
                        .addGap(60, 60, 60)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolveActionPerformed
        Listado_Sublimacion p2 = new Listado_Sublimacion();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btnVolveActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtdescripcion.getText().isEmpty() && Character.isWhitespace(c)) {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (txtdescripcion.getText().length() >= 300) {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void cbnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnproductoActionPerformed

        int selectedIndex = cbnproducto.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < materialPrices.length) {
            double selectedPrice = materialPrices[selectedIndex];
            txtPrecio.setText(String.valueOf(selectedPrice));
        }

    }//GEN-LAST:event_cbnproductoActionPerformed

    private void actualizarTotal() {
        try {
            int selectedIndex = cbnproducto.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < materialPrices.length) {
                double selectedPrice = materialPrices[selectedIndex];
                double cantidad = Double.parseDouble(txtcantidad.getText());
                double total = selectedPrice * cantidad;
                txtPrecio.setText(String.valueOf(total));
            }
        } catch (NumberFormatException e) {
            txtPrecio.setText("Ingrese una cantidad válida");
        }
    }

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombre = (String) txtCliente.getSelectedItem();
        String material = (String) cbnproducto.getSelectedItem();
        String descripcion = txtdescripcion.getText().trim();
        String estado = (String) cbxEstado.getSelectedItem();
        String precio = txtPrecio.getText().trim();
        String cantidad = txtcantidad.getText().trim();
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPedido = sdfSQL.format(new Date());
        String imagenM1 = imagen.getText();
        String idC = id_cliente.getText();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombre.equals("Seleccione")) {
            camposVacios.append("\n - Nombre del cliente");
        }

        if (descripcion.isEmpty()) {
            camposVacios.append("\n - Descripcion");
        }
        String materiales = cbnproducto.getSelectedItem().toString(); // Obtiene el elemento seleccionado en el JComboBox

        if (materiales.equals("Seleccione")) {
            camposVacios.append("\n - Material");
        }

        if (cantidad.isEmpty()) {
            camposVacios.append("\n - Cantidad");
        }

        if (imagen.getIcon() == null) {
            camposVacios.append("\n - Agregue una imagen de muestra");
        }

        if (jDateChooser1.getDate() == null) {
            camposVacios.append("\n - Fecha de Entrega");
        }

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:")) {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                // Rutas de las imágenes
                String rutaImagen1 = archivos[0].getAbsolutePath();
                System.out.println("archivos[0]: " + archivos[0]);

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement insertPs = conn.prepareStatement("INSERT INTO PedidoSublimacion (material, cantidad, estado, descripcion, precio,"
                        + "imagen1,fechaPedido,id_cliente) "
                        + "VALUES (?,?,?,?,?,?,?,?)");
                insertPs.setString(1, material);
                insertPs.setString(2, cantidad);
                insertPs.setString(3, estado);
                insertPs.setObject(4, descripcion);
                insertPs.setObject(5, precio);

                // Verificar si el archivo de imagen 1 existe y agregarlo si es el caso
                if (rutaImagen1 != null && !rutaImagen1.isEmpty() && new File(rutaImagen1).exists()) {
                    try {
                        FileInputStream fis1 = new FileInputStream(new File(rutaImagen1));
                        insertPs.setBinaryStream(6, fis1, (int) new File(rutaImagen1).length());
                    } catch (FileNotFoundException e) {
                        // Manejar la excepción si el archivo no se encuentra
                        insertPs.setBinaryStream(6, null, 0); // Imagen 1 no existe
                    }
                } else {
                    insertPs.setBinaryStream(5, null, 0); // Imagen 1 no existe
                }

                insertPs.setString(7, fechaPedido);
                // insertPs.setDate(24, new java.sql.Date(fecha.getTime()));
                insertPs.setObject(8, idC);

                insertPs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");

                Listado_Sublimacion sub = new Listado_Sublimacion();

                sub.setSize(1024, 640);
                sub.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(sub, BorderLayout.CENTER);
                panelprincipal.revalidate();
                panelprincipal.repaint();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped

        char c = evt.getKeyChar();
        String texto = txtcantidad.getText();

        if (c == '0' && (texto.isEmpty() || texto.equals("0"))) {
            evt.consume(); // Evita que se inicie con un cero
        } else if ((c < '0' || c > '9') || texto.length() >= 3 || (texto.isEmpty() && c == ' ')) {
            evt.consume(); // Evita que se ingresen más de 3 caracteres, caracteres que no sean dígitos o un espacio en blanco al inicio
        }

    }//GEN-LAST:event_txtcantidadKeyTyped

    private File[] archivos = new File[1];
    private int contador = 0; // Para llevar el registro de cuántas veces se ha presionado el botón

    private void AgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarImagenActionPerformed
        if (contador < 3) {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                archivos[contador] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivos[contador].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT);

                if (contador == 0) {
                    imagen.setIcon(new ImageIcon(foto));
                }

                contador++;
            }
        }
    }//GEN-LAST:event_AgregarImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarImagen;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnVolve;
    private static final javax.swing.JComboBox<String> cbnproducto = new javax.swing.JComboBox<>();
    private javax.swing.JComboBox<String> cbxEstado;
    public static final javax.swing.JLabel id_cliente = new javax.swing.JLabel();
    private javax.swing.JLabel imagen;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static final javax.swing.JComboBox<String> txtCliente = new javax.swing.JComboBox<>();
    public static final javax.swing.JTextField txtPrecio = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtTel = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtcantidad = new javax.swing.JTextField();
    public static final javax.swing.JTextArea txtdescripcion = new javax.swing.JTextArea();
    // End of variables declaration//GEN-END:variables
}
