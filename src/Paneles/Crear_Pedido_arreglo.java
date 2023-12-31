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
import java.awt.event.KeyEvent;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class Crear_Pedido_arreglo extends javax.swing.JPanel {

    /**
     * Creates new form Crear_Pedido
     */
    public Crear_Pedido_arreglo() {
        initComponents();

        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Crear un formato para la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha como una cadena
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Mostrar la fecha en el JLabel
        fechaP.setText(fechaFormateada);
        
        fechaEntrega.setMinSelectableDate(new Date());

        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 5); // Suma meses a la fecha actual
        fechaEntrega.setMaxSelectableDate(maxDate.getTime());

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT id_cliente, nombre, apellido, numero_telefono FROM Cliente";
            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int idCliente = rs.getInt("id_cliente");
                String telefono = rs.getString("numero_telefono");

                String nombreCompleto = nombre + " " + apellido;
                txtCliente.addItem(nombreCompleto);
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
                            String sql = "SELECT id_cliente, numero_telefono FROM Cliente WHERE CONCAT(nombre, ' ', apellido) = '" + selectedClient + "'";
                            ResultSet rs = stmt.executeQuery(sql);

                            if (rs.next())
                            {
                                int selectedClientId = rs.getInt("id_cliente");
                                String selectedClientTelefono = rs.getString("numero_telefono");

                                // Actualiza los campos de texto con el ID y el teléfono del cliente seleccionado
                                id_cliente.setText(Integer.toString(selectedClientId));
                                txtTel.setText(selectedClientTelefono);
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
                        txtTel.setText("");
                    }
                }
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

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnvolver1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JComboBox<>();
        crea_cliente = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        id_cliente = new javax.swing.JLabel();
        cbxarreglo = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        imagen2 = new javax.swing.JLabel();
        imagen3 = new javax.swing.JLabel();
        imagen1 = new javax.swing.JLabel();
        imagenes = new javax.swing.JButton();
        labelPrendas = new javax.swing.JLabel();
        fechaP = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionArre = new javax.swing.JTextArea();
        fechaEntrega = new com.toedter.calendar.JDateChooser();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        btnvolver1.setBackground(new java.awt.Color(255, 153, 51));
        btnvolver1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnvolver1.setText("VOLVER");
        btnvolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolver1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel2.setText("Creación de Pedido de Arreglo");

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("9801-4550 / 3308-9197");

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Trojes, El Paraíso");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnvolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnvolver1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(23, 23, 23))
        );

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        crea_cliente.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        crea_cliente.setForeground(new java.awt.Color(255, 0, 0));
        crea_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crea_cliente.setText("¿No encontró al cliente? ¿Desea Crear un nuevo cliente?");
        crea_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crea_clienteMouseClicked(evt);
            }
        });

        txtTel.setEditable(false);
        txtTel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teléfono", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        cbxarreglo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Arreglo de Rosas", "Arreglo Rosas naturales", "Arreglo de girasoles", "Arreglo de rosas con chocolates" }));
        cbxarreglo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arreglo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbxarreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxarregloActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Entregado" }));
        cbxEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado del pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbxEstado.setEnabled(false);

        btnCrear.setBackground(new java.awt.Color(255, 153, 51));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagenes.setBackground(new java.awt.Color(255, 152, 52));
        imagenes.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        imagenes.setText("Agregar Imagenes");
        imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenes)
                .addGap(293, 293, 293))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenes)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 37, Short.MAX_VALUE))
        );

        labelPrendas.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        txtprecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        txtDescripcionArre.setColumns(20);
        txtDescripcionArre.setLineWrap(true);
        txtDescripcionArre.setRows(5);
        txtDescripcionArre.setWrapStyleWord(true);
        txtDescripcionArre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtDescripcionArre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionArreKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionArre);

        fechaEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaP)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id_cliente)
                                .addGap(129, 129, 129)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(cbxarreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(crea_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(479, 479, 479)
                        .addComponent(btnCrear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(550, 550, 550)
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addComponent(labelPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_cliente)
                        .addGap(43, 43, 43)
                        .addComponent(fechaP)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel))
                        .addGap(18, 18, 18)
                        .addComponent(crea_cliente)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxEstado)
                    .addComponent(cbxarreglo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(labelPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnCrear)
                .addGap(104, 104, 104))
        );

        id_cliente.setVisible(false);
        fechaP.setVisible(false);

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenesActionPerformed
        if (contador < 3)
        {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                archivos[contador] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivos[contador].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT);

                if (contador == 0)
                {
                    imagen1.setIcon(new ImageIcon(foto));
//                     textField1.setText(archivos[contador].getAbsolutePath());
                } else if (contador == 1)
                {
                    imagen2.setIcon(new ImageIcon(foto));
                } else if (contador == 2)
                {
                    imagen3.setIcon(new ImageIcon(foto));
                    imagenes.setEnabled(false); // Desactivar el botón después de cargar la tercera imagen
                }

                contador++;
            }
        }
    }//GEN-LAST:event_imagenesActionPerformed

       
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombre = (String) txtCliente.getSelectedItem();
        String arreglo = (String) cbxarreglo.getSelectedItem();
        String estado = (String) cbxEstado.getSelectedItem();
        String idC = id_cliente.getText();
        String imagenM1 = imagen1.getText();
        String descripcion = txtDescripcionArre.getText();
        String precio = txtprecio.getText();
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPedido = sdfSQL.format(new Date());
        
         Date fecha = fechaEntrega.getDate();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombre.equals("Seleccione"))
        {
            camposVacios.append("\n - Nombre del cliente");
        }
        if (arreglo.equals("Seleccione"))
        {
            camposVacios.append("\n - Arreglo");
        }
         if (fecha == null)
        {
            camposVacios.append("\n - Fecha de Entrega");
        }
        if (imagen1.getIcon() == null)
        {
            camposVacios.append("\n - Agregue al menos una imagen de muestra");
        }
        if (descripcion.isEmpty())
        {
            camposVacios.append("\n - Descripción");
        }
        if (precio.isEmpty())
        {
            camposVacios.append("\n - Precio");
        }

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:"))
        {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else
        {
            try
            {
                // Rutas de las imágenes
                String rutaImagen1 = archivos[0].getAbsolutePath();
                System.out.println("archivos[0]: " + archivos[0]);
                String rutaImagen2 = archivos[1] != null ? archivos[1].getAbsolutePath() : null;
                String rutaImagen3 = archivos[2] != null ? archivos[2].getAbsolutePath() : null;

                // Resto del código para la inserción en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement insertPs = conn.prepareStatement("INSERT INTO PedidoArreglo (arreglo, estado, descripcion, precio ,imagen1, imagen2, imagen3,"
                        + " fechaPedido,id_cliente, fechaEntrega) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)");
                insertPs.setString(1, arreglo);
                insertPs.setString(2, estado);
                insertPs.setObject(3, descripcion);
                insertPs.setObject(4, precio);

                // Verificar si el archivo de imagen 1 existe y agregarlo si es el caso
                if (rutaImagen1 != null && !rutaImagen1.isEmpty() && new File(rutaImagen1).exists())
                {
                    try
                    {
                        FileInputStream fis1 = new FileInputStream(new File(rutaImagen1));
                        insertPs.setBinaryStream(5, fis1, (int) new File(rutaImagen1).length());
                    } catch (FileNotFoundException e)
                    {
                        // Manejar la excepción si el archivo no se encuentra
                        insertPs.setBinaryStream(5, null, 0); // Imagen 1 no existe
                    }
                } else
                {
                    insertPs.setBinaryStream(5, null, 0); // Imagen 1 no existe
                }

                // Verificar si el archivo de imagen 2 existe y agregarlo si es el caso
                if (rutaImagen2 != null && !rutaImagen2.isEmpty() && new File(rutaImagen2).exists())
                {
                    try
                    {
                        FileInputStream fis2 = new FileInputStream(new File(rutaImagen2));
                        insertPs.setBinaryStream(6, fis2, (int) new File(rutaImagen2).length());
                    } catch (FileNotFoundException e)
                    {
                        // Manejar la excepción si el archivo no se encuentra
                        insertPs.setBinaryStream(6, null, 0); // Imagen 2 no existe
                    }
                } else
                {
                    insertPs.setBinaryStream(6, null, 0); // Imagen 2 no existe
                }

                // Verificar si el archivo de imagen 3 existe y agregarlo si es el caso
                if (rutaImagen3 != null && !rutaImagen3.isEmpty() && new File(rutaImagen3).exists())
                {
                    try
                    {
                        FileInputStream fis3 = new FileInputStream(new File(rutaImagen3));
                        insertPs.setBinaryStream(7, fis3, (int) new File(rutaImagen3).length());
                    } catch (FileNotFoundException e)
                    {
                        // Manejar la excepción si el archivo no se encuentra
                        insertPs.setBinaryStream(7, null, 0); // Imagen 3 no existe
                    }
                } else
                {
                    insertPs.setBinaryStream(7, null, 0); // Imagen 3 no existe
                }

                insertPs.setString(8, fechaPedido);
                insertPs.setObject(9, idC);
                insertPs.setDate(10, new java.sql.Date(fecha.getTime()));

                insertPs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");

                Listado_Pedidos_Arreglos p = new Listado_Pedidos_Arreglos();

                p.setSize(1024, 640);
                p.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(p, BorderLayout.CENTER);
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

    private void cbxarregloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxarregloActionPerformed

    }//GEN-LAST:event_cbxarregloActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void crea_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crea_clienteMouseClicked

        crear_cliente p2 = new crear_cliente();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        /* panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();*/
    }//GEN-LAST:event_crea_clienteMouseClicked

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnvolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolver1ActionPerformed
        Listado_Pedidos_Arreglos l2 = new Listado_Pedidos_Arreglos();
        l2.setSize(1024, 640);
        l2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(l2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btnvolver1ActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        char c = evt.getKeyChar();
        String texto = txtprecio.getText();

        if (c == '0' && (texto.isEmpty() || texto.equals("0")))
        {
            evt.consume(); // Evita que se inicie con un cero
        } else if (!Character.isDigit(c) || texto.length() >= 5)
        {
            evt.consume(); // Evita que se ingresen más de 5 cifras o caracteres que no sean dígitos
        }

    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtDescripcionArreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionArreKeyTyped
      char c = evt.getKeyChar();
        if (Character.isWhitespace(c) && txtDescripcionArre.getText().isEmpty() || (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ((int) evt.getKeyChar() <= 500 && evt.getKeyChar() >= 164) && c != KeyEvent.VK_SPACE || txtDescripcionArre.getText().length() >= 300)
            evt.consume();
    }//GEN-LAST:event_txtDescripcionArreKeyTyped

    private File[] archivos = new File[3];
    private int contador = 0; // Para llevar el registro de cuántas veces se ha presionado el botón


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnvolver1;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxarreglo;
    private javax.swing.JLabel crea_cliente;
    public com.toedter.calendar.JDateChooser fechaEntrega;
    public javax.swing.JLabel fechaP;
    public javax.swing.JLabel id_cliente;
    private javax.swing.JLabel imagen1;
    private javax.swing.JLabel imagen2;
    private javax.swing.JLabel imagen3;
    private javax.swing.JButton imagenes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPrendas;
    private javax.swing.JComboBox<String> txtCliente;
    private javax.swing.JTextArea txtDescripcionArre;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
