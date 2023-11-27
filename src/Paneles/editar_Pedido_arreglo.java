/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import static Paneles.Editar_Pedido_Sublimacion.Imagen;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class editar_Pedido_arreglo extends javax.swing.JPanel {

    /**
     * Creates new form Crear_Pedido
     */
    public editar_Pedido_arreglo() {
        initComponents();

        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Crear un formato para la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha como una cadena
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Mostrar la fecha en el JLabel
        fechaP.setText(fechaFormateada);

        JDfechaEntrega.setMinSelectableDate(new Date());

        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 5); // Suma meses a la fecha actual
        JDfechaEntrega.setMaxSelectableDate(maxDate.getTime());

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
                                id_client.setText(Integer.toString(selectedClientId));
                                txtTel.setText(selectedClientTelefono);
                            }

                            connection.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        // Si se selecciona "Seleccione", establece los campos en blanco
                        id_client.setText("");
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
        crea_cliente = new javax.swing.JLabel();
        Cimagen1 = new javax.swing.JButton();
        Cimagen2 = new javax.swing.JButton();
        Cimagen3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fechaP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JDfechaEntrega = new com.toedter.calendar.JDateChooser();

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
        jLabel2.setText("Editar Pedido de Arreglo");

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
                .addContainerGap(134, Short.MAX_VALUE)
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
        txtCliente.setEnabled(false);
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
        txtTel.setEnabled(false);
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        cbxarreglo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Arreglo de Rosas", "Arreglo Rosas naturales", "Arreglo de girasoles", "Arreglo de rosas con chocolates" }));
        cbxarreglo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arreglo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbxarreglo.setEnabled(false);
        cbxarreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxarregloActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Entregado" }));
        cbxEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado del pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbxEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbxEstadoMouseEntered(evt);
            }
        });
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(255, 153, 51));
        btneditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        Cimagen1.setBackground(new java.awt.Color(255, 152, 52));
        Cimagen1.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        Cimagen1.setText("Editar Imagen");
        Cimagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cimagen1ActionPerformed(evt);
            }
        });

        Cimagen2.setBackground(new java.awt.Color(255, 152, 52));
        Cimagen2.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        Cimagen2.setText("Editar Imagen");
        Cimagen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cimagen2ActionPerformed(evt);
            }
        });

        Cimagen3.setBackground(new java.awt.Color(255, 152, 52));
        Cimagen3.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        Cimagen3.setText("Editar Imagen");
        Cimagen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cimagen3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admiracion.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(Cimagen1)
                .addGap(89, 89, 89)
                .addComponent(Cimagen2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cimagen3)
                .addGap(82, 82, 82))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cimagen1)
                            .addComponent(Cimagen2)
                            .addComponent(Cimagen3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

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

        JDfechaEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

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
                                .addComponent(id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_id_arregl)
                                .addGap(110, 110, 110)
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
                                        .addComponent(crea_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JDfechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(516, 516, 516)
                        .addComponent(btneditar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_id_arregl)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JDfechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btneditar)
                .addContainerGap())
        );

        id_client.setVisible(false);
        fechaP.setVisible(false);
        lbl_id_arregl.setVisible(false);

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
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

    private void Cimagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cimagen1ActionPerformed
        if (contador1 < 1) {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                archivo1[contador1] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivo1[contador1].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT);

                if (contador1 == 0) {
                    imagen1.setIcon(new ImageIcon(foto));
                    //JOptionPane.showMessageDialog(this, "Ya se ha cargado una imagen. No se puede agregar otra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Cimagen1.setEnabled(false); // Desactivar el botón después de cargar la tercera imagen
                }

                contador1++;
                // Reactivar el botón después de cargar la tercera imagen
            if (contador1 == 1) {
                Cimagen1.setEnabled(true);
            }
            }
        }
    }//GEN-LAST:event_Cimagen1ActionPerformed

// ...

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        String nombre = (String) txtCliente.getSelectedItem();
        String arreglo = (String) cbxarreglo.getSelectedItem();
        String estado = (String) cbxEstado.getSelectedItem();
        String idC = id_client.getText();
        String idA = lbl_id_arregl.getText();
        String imagenM1 = imagen1.getText();
        String descripcion = txtDescripcionArre.getText();
        String precio = txtprecio.getText();
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPedido = sdfSQL.format(new Date());

        Date fecha = JDfechaEntrega.getDate();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if ("Seleccione".equals(nombre)) {
            camposVacios.append("\n - Nombre del cliente");
        }
        if ("Seleccione".equals(arreglo)) {
            camposVacios.append("\n - Arreglo");
        }
        if (fecha == null) {
            camposVacios.append("\n - Fecha de Entrega");
        }
        if (imagen1.getIcon() == null) {
            camposVacios.append("\n - Agregue al menos una imagen de muestra");
        }
        if (descripcion.isEmpty()) {
            camposVacios.append("\n - Descripción");
        }
        if (precio.isEmpty()) {
            camposVacios.append("\n - Precio");
        }

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:")) {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                // Obtén las imágenes actuales de los JLabel
                Icon icon1 = imagen1.getIcon();
                Icon icon2 = imagen2.getIcon();
                Icon icon3 = imagen3.getIcon();
                String rutaImagen1 = null;
                String rutaImagen2 = null;
                String rutaImagen3 = null;

                // Verifica si archivos[0] no es null antes de acceder a sus propiedades
                if (archivo1[0] != null) {
                    rutaImagen1 = archivo1[0].getAbsolutePath();
                }

                if (archivo2[0] != null) {
                    rutaImagen2 = archivo2[0].getAbsolutePath();
                }

                if (archivo3[0] != null) {
                    rutaImagen3 = archivo3[0].getAbsolutePath();
                }

                // Resto del código para la inserción en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                PreparedStatement updatePs = conn.prepareStatement(
                        "UPDATE PedidoArreglo SET arreglo=?, estado=?, descripcion=?, precio=?, "
                        + "imagen1=?, imagen2=?, imagen3=?, fechaPedido=?, fechaEntrega=? "
                        + "WHERE id_arreglo=?"
                );

                // Luego, establece los parámetros como lo estabas haciendo antes
                updatePs.setString(1, arreglo);
                updatePs.setString(2, estado);
                updatePs.setString(3, descripcion);
                updatePs.setString(4, precio);

                // Verificar y actualizar la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty() && archivo1[0] != null) {
                    File file1 = new File(rutaImagen1);
                    if (file1.exists()) {
                        try (FileInputStream fis1 = new FileInputStream(file1)) {
                            byte[] bytes1 = new byte[(int) file1.length()];
                            fis1.read(bytes1);
                            updatePs.setBytes(5, bytes1);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(editar_pedidoSas.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(5, Types.BLOB); // Imagen 1 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(5, obtenerImagenExistente(5));
                }

                // Verificar y actualizar la imagen 2 solo si hay una nueva imagen y no se ha cargado antes
                if (rutaImagen2 != null && !rutaImagen2.isEmpty() && archivo2[0] != null) {
                    File file2 = new File(rutaImagen2);
                    if (file2.exists()) {
                        try (FileInputStream fis2 = new FileInputStream(file2)) {
                            byte[] bytes2 = new byte[(int) file2.length()];
                            fis2.read(bytes2);
                            updatePs.setBytes(6, bytes2);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(editar_pedidoSas.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(6, Types.BLOB); // Imagen 2 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(6, obtenerImagenExistente(6));
                }

                // Verificar y actualizar la imagen 3 solo si hay una nueva imagen y no se ha cargado antes
                if (rutaImagen3 != null && !rutaImagen3.isEmpty() && archivo3[0] != null) {
                    File file3 = new File(rutaImagen3);
                    if (file3.exists()) {
                        try (FileInputStream fis3 = new FileInputStream(file3)) {
                            byte[] bytes3 = new byte[(int) file3.length()];
                            fis3.read(bytes3);
                            updatePs.setBytes(7, bytes3);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(editar_pedidoSas.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(7, Types.BLOB); // Imagen 3 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(7, obtenerImagenExistente(7));
                }

                // Verifica y actualiza la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen1, 5);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(5, obtenerImagenExistente(5));
                }

                // Verifica y actualiza la imagen 2 solo si hay una nueva imagen
                if (rutaImagen2 != null && !rutaImagen2.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen2, 6);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(6, obtenerImagenExistente(6));
                }

                // Verifica y actualiza la imagen 3 solo si hay una nueva imagen
                if (rutaImagen3 != null && !rutaImagen3.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen3, 7);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(7, obtenerImagenExistente(7));
                }

                updatePs.setString(8, fechaPedido);

                updatePs.setDate(9, new java.sql.Date(fecha.getTime())); // Ajustar el índice a 9
                int numeracion = Integer.parseInt(idA);
                updatePs.setInt(10, numeracion); // Ajustar el índice a 10

                updatePs.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro editado exitosamente");

                // Restaura las imágenes en los JLabel después de la actualización
                imagen1.setIcon(icon1);
                imagen2.setIcon(icon2);
                imagen3.setIcon(icon3);

                Listado_Pedidos_Arreglos p = new Listado_Pedidos_Arreglos();

                p.setSize(1024, 640);
                p.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(p, BorderLayout.CENTER);
                panelprincipal.revalidate();
                panelprincipal.repaint();
                return;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btneditarActionPerformed

    /*  private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre = (String) txtCliente.getSelectedItem();
        String arreglo = (String) cbxarreglo.getSelectedItem();
        String estado = (String) cbxEstado.getSelectedItem();
        String idC = id_client.getText();
        String idA = lbl_id_arregl.getText();
        String imagenM1 = imagen1.getText();
        String descripcion = txtDescripcionArre.getText();
        String precio = txtprecio.getText();
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPedido = sdfSQL.format(new Date());

        Date fecha = JDfechaEntrega.getDate();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if ("Seleccione".equals(nombre)) {
            camposVacios.append("\n - Nombre del cliente");
        }
        if ("Seleccione".equals(arreglo)) {
            camposVacios.append("\n - Arreglo");
        }
        if (fecha == null) {
            camposVacios.append("\n - Fecha de Entrega");
        }
        if (imagen1.getIcon() == null) {
            camposVacios.append("\n - Agregue al menos una imagen de muestra");
        }
        if (descripcion.isEmpty()) {
            camposVacios.append("\n - Descripción");
        }
        if (precio.isEmpty()) {
            camposVacios.append("\n - Precio");
        }

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:")) {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                // Obtén las imágenes actuales de los JLabel
                Icon icon1 = imagen1.getIcon();
                Icon icon2 = imagen2.getIcon();
                Icon icon3 = imagen3.getIcon();
                String rutaImagen1 = null;
                String rutaImagen2 = null;
                String rutaImagen3 = null;

                // Verifica si archivos[0] no es null antes de acceder a sus propiedades
                if (archivos[0] != null) {
                    rutaImagen1 = archivos[0].getAbsolutePath();
                }

                if (archivos[1] != null) {
                    rutaImagen2 = archivos[1].getAbsolutePath();
                }

                if (archivos[2] != null) {
                    rutaImagen3 = archivos[2].getAbsolutePath();
                }

                // Resto del código para la inserción en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                PreparedStatement updatePs = conn.prepareStatement(
                        "UPDATE PedidoArreglo SET arreglo=?, estado=?, descripcion=?, precio=?, "
                        + "imagen1=?, imagen2=?, imagen3=?, fechaPedido=?, id_cliente=?, fechaEntrega=? "
                        + "WHERE id_arreglo=?"
                );

                // Luego, establece los parámetros como lo estabas haciendo antes
                updatePs.setString(1, arreglo);
                updatePs.setString(2, estado);
                updatePs.setString(3, descripcion);
                updatePs.setString(4, precio);

                // Verificar y actualizar la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty() && archivos[0] != null) {
                    File file1 = new File(rutaImagen1);
                    if (file1.exists()) {
                        try (FileInputStream fis1 = new FileInputStream(file1)) {
                            byte[] bytes1 = new byte[(int) file1.length()];
                            fis1.read(bytes1);
                            updatePs.setBytes(5, bytes1);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(editar_pedidoSas.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(5, Types.BLOB); // Imagen 1 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(5, obtenerImagenExistente(5));
                }

                // Verificar y actualizar la imagen 2 solo si hay una nueva imagen y no se ha cargado antes
                if (rutaImagen2 != null && !rutaImagen2.isEmpty() && archivos[1] != null) {
                    File file2 = new File(rutaImagen2);
                    if (file2.exists()) {
                        try (FileInputStream fis2 = new FileInputStream(file2)) {
                            byte[] bytes2 = new byte[(int) file2.length()];
                            fis2.read(bytes2);
                            updatePs.setBytes(6, bytes2);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(editar_pedidoSas.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(6, Types.BLOB); // Imagen 2 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(6, obtenerImagenExistente(6));
                }

                // Verificar y actualizar la imagen 3 solo si hay una nueva imagen y no se ha cargado antes
                if (rutaImagen3 != null && !rutaImagen3.isEmpty() && archivos[2] != null) {
                    File file3 = new File(rutaImagen3);
                    if (file3.exists()) {
                        try (FileInputStream fis3 = new FileInputStream(file3)) {
                            byte[] bytes3 = new byte[(int) file3.length()];
                            fis3.read(bytes3);
                            updatePs.setBytes(7, bytes3);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(editar_pedidoSas.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(7, Types.BLOB); // Imagen 3 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(7, obtenerImagenExistente(7));
                }

                // Verifica y actualiza la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen1, 5);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(5, obtenerImagenExistente(5));
                }

                // Verifica y actualiza la imagen 2 solo si hay una nueva imagen
                if (rutaImagen2 != null && !rutaImagen2.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen2, 6);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(6, obtenerImagenExistente(6));
                }

                // Verifica y actualiza la imagen 3 solo si hay una nueva imagen
                if (rutaImagen3 != null && !rutaImagen3.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen3, 7);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(7, obtenerImagenExistente(7));
                }

                updatePs.setString(8, fechaPedido);
                updatePs.setString(9, idC);
                updatePs.setDate(10, new java.sql.Date(fecha.getTime())); // Ajustar el índice a 9
                int numeracion = Integer.parseInt(idA);
                updatePs.setInt(11, numeracion); // Ajustar el índice a 10


                  // Establece el valor de la clave primaria
                try {
                    int numeracion = Integer.parseInt(lbl_id_arregl.getText());
                    updatePs.setInt(11, numeracion);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: El valor de lbl_id_arregl no es un número válido", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    return; // Sale del método para evitar continuar con la ejecución
                }
                 
                updatePs.executeUpdate();

                // Restaura las imágenes en los JLabel después de la actualización
                imagen1.setIcon(icon1);
                imagen2.setIcon(icon2);
                imagen3.setIcon(icon3);

                JOptionPane.showMessageDialog(null, "Registro editado exitosamente");

                Listado_Pedidos_Arreglos p = new Listado_Pedidos_Arreglos();

                p.setSize(1024, 640);
                p.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(p, BorderLayout.CENTER);
                panelprincipal.revalidate();
                panelprincipal.repaint();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
     */

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

        if (c == '0' && (texto.isEmpty() || texto.equals("0"))) {
            evt.consume(); // Evita que se inicie con un cero
        } else if (!Character.isDigit(c) || texto.length() >= 5) {
            evt.consume(); // Evita que se ingresen más de 5 cifras o caracteres que no sean dígitos
        }

    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtDescripcionArreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionArreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isWhitespace(c) && txtDescripcionArre.getText().isEmpty() || (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ((int) evt.getKeyChar() <= 500 && evt.getKeyChar() >= 164) && c != KeyEvent.VK_SPACE || txtDescripcionArre.getText().length() >= 300)
            evt.consume();
    }//GEN-LAST:event_txtDescripcionArreKeyTyped


    private void cbxEstadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEstadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoMouseEntered

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void Cimagen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cimagen2ActionPerformed
        if (contador2 < 1) {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                archivo2[contador2] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivo2[contador2].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT);

                if (contador2 == 0) {
                    imagen2.setIcon(new ImageIcon(foto));
                    //JOptionPane.showMessageDialog(this, "Ya se ha cargado una imagen. No se puede agregar otra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Cimagen2.setEnabled(false); // Desactivar el botón después de cargar la tercera imagen
                }

                contador2++;
                // Reactivar el botón después de cargar la tercera imagen
            if (contador2 == 1) {
                Cimagen2.setEnabled(true);
            }
            }
        }
    }//GEN-LAST:event_Cimagen2ActionPerformed

    private void Cimagen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cimagen3ActionPerformed
        if (contador3 < 1) {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                archivo3[contador3] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivo3[contador3].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(imagen3.getWidth(), imagen3.getHeight(), Image.SCALE_DEFAULT);

                if (contador3 == 0) {
                    imagen3.setIcon(new ImageIcon(foto));
                    //JOptionPane.showMessageDialog(this, "Ya se ha cargado una imagen. No se puede agregar otra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Cimagen3.setEnabled(false); // Desactivar el botón después de cargar la tercera imagen
                }

                contador3++;
                // Reactivar el botón después de cargar la tercera imagen
                if (contador3 == 1) {
                    Cimagen3.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_Cimagen3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JOptionPane.showMessageDialog(this, "¡Atención! Si cambiaste una imagen en una de las tres secciones diferentes y necesitas más cambios, por favor, sal y vuelve a entrar. ¡Gracias!", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jLabel1MouseClicked

    private File[] archivo1 = new File[1];
    private int contador1 = 0; // Para llevar el registro de cuántas veces se ha presionado el botón
    private File[] archivo2 = new File[1];
    private int contador2 = 0; // Para llevar el registro de cuántas veces se ha presionado el botón
    private File[] archivo3 = new File[1];
    private int contador3 = 0; // Para llevar el registro de cuántas veces se ha presionado el botón

    private void resetearBotones() {
        Cimagen1.setEnabled(true);
        Cimagen2.setEnabled(true);
        Cimagen3.setEnabled(true);

        contador1 = 0;
        contador2 = 0;
        contador3 = 0;

        archivo1 = new File[1];
        archivo2 = new File[1];
        archivo3 = new File[1];
    }

// Método para obtener la imagen existente en la base de datos
    private byte[] obtenerImagenExistente(int posicion) throws SQLException, ClassNotFoundException {
        byte[] imagenExistente = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789")) {
            String sql = "SELECT imagen1, imagen2, imagen3 FROM PedidoArreglo WHERE id_arreglo = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(lbl_id_arregl.getText()));
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        switch (posicion) {
                            case 5:
                                imagenExistente = rs.getBytes(1); // Imagen 1
                                break;
                            case 6:
                                imagenExistente = rs.getBytes(2); // Imagen 2
                                break;
                            case 7:
                                imagenExistente = rs.getBytes(3); // Imagen 3
                                break;
                            default:
                                // Manejar caso no válido según sea necesario
                                break;
                        }
                    }
                }
            }
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
    private javax.swing.JButton Cimagen1;
    private javax.swing.JButton Cimagen2;
    private javax.swing.JButton Cimagen3;
    public com.toedter.calendar.JDateChooser JDfechaEntrega;
    public static final javax.swing.JButton btneditar = new javax.swing.JButton();
    private javax.swing.JButton btnvolver1;
    public static final javax.swing.JComboBox<String> cbxEstado = new javax.swing.JComboBox<>();
    public static final javax.swing.JComboBox<String> cbxarreglo = new javax.swing.JComboBox<>();
    private javax.swing.JLabel crea_cliente;
    public javax.swing.JLabel fechaP;
    public static final javax.swing.JLabel id_client = new javax.swing.JLabel();
    public static final javax.swing.JLabel imagen1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel imagen2 = new javax.swing.JLabel();
    public static final javax.swing.JLabel imagen3 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static final javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static final javax.swing.JLabel lbl_id_arregl = new javax.swing.JLabel();
    public static final javax.swing.JComboBox<String> txtCliente = new javax.swing.JComboBox<>();
    public static final javax.swing.JTextArea txtDescripcionArre = new javax.swing.JTextArea();
    public static final javax.swing.JTextField txtTel = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtprecio = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
