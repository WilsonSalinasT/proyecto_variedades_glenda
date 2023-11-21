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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Icon;
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
public class Editar_Pedido_Sublimacion extends javax.swing.JPanel {

    private double[] materialPrices = {0, 180, 120, 100, 130, 80};

    /**
     * Creates new form Crear_Pedido_Sublimacion
     */
    public Editar_Pedido_Sublimacion() {
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
        jDateChooser.setMinSelectableDate(fechaActual);

        // Crea un objeto Calendar para la fecha actual más tres meses
        Calendar maxDateCalendar = Calendar.getInstance();
        maxDateCalendar.setTime(fechaActual);
        maxDateCalendar.add(Calendar.MONTH, 3);

        // Restringe las fechas dentro de tres meses a partir de la fecha actual
        jDateChooser.setMaxSelectableDate(maxDateCalendar.getTime());

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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCambiarImagen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        jLabel59.setText("Editar Pedido de Sublimación");

        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Trojes, El Paraíso");

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("9801-4550 / 3308-9197");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(652, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(619, 619, 619))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idSubli)
                    .addComponent(btnVolve))
                .addGap(604, 604, 604))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnVolve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idSubli))
        );

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 3, 12))); // NOI18N
        txtCliente.setEnabled(false);

        txtTel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teléfono", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtTel.setFocusable(false);
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        cbnProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Camisa", "Taza", "Plato", "Gorra", "Llavero" }));
        cbnProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Material:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnProductoActionPerformed(evt);
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

        btnEditar.setBackground(new java.awt.Color(255, 153, 51));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setText("GUARDAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jDateChooser.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de entrega:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 3, 12))); // NOI18N

        cbxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Entregado" }));
        cbxestado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado del pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

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

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtPrecio.setFocusable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        Imagen.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        Imagen.setForeground(new java.awt.Color(153, 153, 153));
        Imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        Imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImagenMousePressed(evt);
            }
        });

        btnCambiarImagen.setBackground(new java.awt.Color(255, 153, 51));
        btnCambiarImagen.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnCambiarImagen.setText("Cambiar imagen");
        btnCambiarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarImagenActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admiracion.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74)
                        .addComponent(btnCambiarImagen)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCambiarImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                        .addComponent(cbxestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
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
        } else if (txtdescripcion.getText().length() >= 150) {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void cbnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnProductoActionPerformed

        int selectedIndex = cbnProducto.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < materialPrices.length) {
            double selectedPrice = materialPrices[selectedIndex];
            txtPrecio.setText(String.valueOf(selectedPrice));
        }

    }//GEN-LAST:event_cbnProductoActionPerformed

    private void actualizarTotal() {
        try {
            int selectedIndex = cbnProducto.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < materialPrices.length) {
                double selectedPrice = materialPrices[selectedIndex];
                double cantidad = Double.parseDouble(txtcantidad.getText());
                double total = selectedPrice * cantidad;
                txtPrecio.setText(String.valueOf(total));
            }
        } catch (NumberFormatException e) {
            txtPrecio.setText("0.0");
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombre = (String) txtCliente.getSelectedItem();
        String material = (String) cbnProducto.getSelectedItem();
        String descripcion = txtdescripcion.getText().trim();
        String estado = (String) cbxestado.getSelectedItem();
        String precio = txtPrecio.getText().trim();
        String cantidad = txtcantidad.getText().trim();
        Date fechaSeleccionada = jDateChooser.getDate();
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPedido = fechaSeleccionada != null ? sdfSQL.format(fechaSeleccionada) : null;
        String imagenM1 = Imagen.getText();
        String idC = id_cliente.getText();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if ("Seleccione".equals(nombre)) {
            camposVacios.append("\n - Nombre del cliente");
        }

        if (descripcion.isEmpty()) {
            camposVacios.append("\n - Descripción");
        }

        String materiales = cbnProducto.getSelectedItem().toString();

        if ("Seleccione".equals(materiales)) {
            camposVacios.append("\n - Material");
        }

        if (cantidad.isEmpty()) {
            camposVacios.append("\n - Cantidad");
        }

        if (Imagen.getIcon() == null) {
            camposVacios.append("\n - Agregue una imagen de muestra");
        }

        if (fechaPedido == null) {
            camposVacios.append("\n - Fecha de Entrega");
        } else {
            try {
                Date fechaActual = new Date(); // Fecha actual
                Date fechaEntrega = sdfSQL.parse(fechaPedido); // Fecha de entrega seleccionada

                if (fechaEntrega.before(fechaActual)) {
                    camposVacios.append("\n - La fecha de entrega debe ser posterior a la fecha actual");
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
                camposVacios.append("\n - Error al analizar la fecha de entrega");
            }
        }

        if (!"Los siguientes campos están vacíos:".equals(camposVacios.toString())) {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else {

            try {

                // Obtén las imágenes actuales de los JLabel
                Icon icon1 = Imagen.getIcon();
                String rutaImagen1 = null;

                // Verifica si archivos[0] no es null antes de acceder a sus propiedades
                if (archivos[0] != null) {
                    rutaImagen1 = archivos[0].getAbsolutePath();
                }

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement updatePs = conn.prepareStatement("UPDATE PedidoSublimacion SET material=?, cantidad=?, estado=?, descripcion=?, precio=?,"
                        + "imagen1=?, fechaPedido=? WHERE id_cliente=?");

                updatePs.setString(1, material);
                updatePs.setString(2, cantidad);
                updatePs.setString(3, estado);
                updatePs.setObject(4, descripcion);
                updatePs.setObject(5, precio);

                // Verificar si el archivo de imagen 1 existe y agregarlo si es el caso
                if (rutaImagen1 != null && !rutaImagen1.isEmpty() && new File(rutaImagen1).exists()) {
                    try {
                        FileInputStream fis1 = new FileInputStream(new File(rutaImagen1));
                        updatePs.setBinaryStream(6, fis1, (int) new File(rutaImagen1).length());
                    } catch (FileNotFoundException e) {
                        // Manejar la excepción si el archivo no se encuentra
                        updatePs.setBinaryStream(6, null, 0); // Imagen 1 no existe
                    }
                } else {
                    updatePs.setBinaryStream(6, null, 0); // Imagen 1 no existe
                }

                // Verifica y actualiza la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen1, 6);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(6, obtenerImagenExistente(6));
                }

                updatePs.setString(7, fechaPedido);
                updatePs.setObject(8, idC);

                updatePs.executeUpdate();

                // Restaura las imágenes en los JLabel después de la actualización
                Imagen.setIcon(icon1);

                JOptionPane.showMessageDialog(null, "Registro actualizado");

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
    }//GEN-LAST:event_btnEditarActionPerformed

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

    private void ImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenMouseClicked

    }//GEN-LAST:event_ImagenMouseClicked

    private void ImagenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenMousePressed

    }//GEN-LAST:event_ImagenMousePressed

    private void btnCambiarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarImagenActionPerformed
        if (contador < 1) {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                archivos[contador] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivos[contador].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT);

                if (contador == 0) {
                    Imagen.setIcon(new ImageIcon(foto));
                    //JOptionPane.showMessageDialog(this, "Ya se ha cargado una imagen. No se puede agregar otra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    btnCambiarImagen.setEnabled(false); // Desactivar el botón después de cargar la tercera imagen
                }

                contador++;
            }
        }
    }//GEN-LAST:event_btnCambiarImagenActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JOptionPane.showMessageDialog(this, "¡Importante! Solo se permite cambiar la imagen una vez. Si necesitas modificarla de nuevo, por favor, sal y vuelve a entrar. ¡Gracias!.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jLabel1MouseClicked

    // Método para obtener la imagen existente en la base de datos
    private byte[] obtenerImagenExistente(int posicion) throws SQLException, ClassNotFoundException {
        byte[] imagenExistente = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String idSubliText = idSubli.getText();

        if (!idSubliText.isEmpty()) {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789")) {
                String sql = "SELECT imagen1 FROM PedidoSublimacion WHERE id_sublimacion = ?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    try {
                        ps.setInt(1, Integer.parseInt(idSubliText));
                    } catch (NumberFormatException e) {
                        // Manejar el caso en que el texto no sea un entero válido
                        e.printStackTrace(); // Puedes querer registrar esto o manejarlo de manera apropiada
                        return null; // Otra opción es devolver un valor predeterminado o lanzar una excepción
                    }

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            switch (posicion) {
                                case 6:
                                    imagenExistente = rs.getBytes(1); // Imagen 1
                                    break;
                                default:
                                    // Manejar caso no válido según sea necesario
                                    break;
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                // Manejar excepciones de SQL o de clase no encontrada según sea necesario
                e.printStackTrace(); // Puedes querer registrar esto o manejarlo de manera apropiada
            }
        } else {
            // Manejar el caso en que el texto esté vacío
        }

        return imagenExistente;
    }

    private byte[] obtenerBytesImagen(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        }
    }

    private void actualizarImagen(PreparedStatement updatePs, String rutaImagen, int parametro) throws SQLException, ClassNotFoundException {
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            File file = new File(rutaImagen);
            if (file.exists()) {
                try {
                    byte[] bytes = obtenerBytesImagen(file);
                    updatePs.setBytes(parametro, bytes);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    updatePs.setNull(parametro, Types.BLOB);
                }
            }
        } else {
            updatePs.setBytes(parametro, obtenerImagenExistente(parametro));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel Imagen = new javax.swing.JLabel();
    private javax.swing.JButton btnCambiarImagen;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolve;
    public static final javax.swing.JComboBox<String> cbnProducto = new javax.swing.JComboBox<>();
    public static final javax.swing.JComboBox<String> cbxestado = new javax.swing.JComboBox<>();
    public static final javax.swing.JLabel idSubli = new javax.swing.JLabel();
    public static final javax.swing.JLabel id_cliente = new javax.swing.JLabel();
    public static final com.toedter.calendar.JDateChooser jDateChooser = new com.toedter.calendar.JDateChooser();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
