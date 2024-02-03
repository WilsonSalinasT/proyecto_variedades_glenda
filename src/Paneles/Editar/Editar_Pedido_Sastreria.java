/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles.Editar;

import Paneles.Listados.Listado_Pedidos_Sastreria;
import static App.Menu.panelprincipal;
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
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class Editar_Pedido_Sastreria extends javax.swing.JPanel {

    /**
     * Creates new form Crear_Pedido
     */
    public Editar_Pedido_Sastreria() {
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnvolver1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescrip = new javax.swing.JTextArea();
        txtprecio = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        id_cliente = new javax.swing.JLabel();
        cbxPrenda = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        imagen2 = new javax.swing.JLabel();
        imagen3 = new javax.swing.JLabel();
        imagenes = new javax.swing.JButton();
        imagen1 = new javax.swing.JLabel();
        labelPrendas = new javax.swing.JLabel();
        txtLargo = new javax.swing.JTextField();
        txtCadera = new javax.swing.JTextField();
        txtCintura = new javax.swing.JTextField();
        txtLManga = new javax.swing.JTextField();
        txtAManga = new javax.swing.JTextField();
        txtCuello = new javax.swing.JTextField();
        txtPecho = new javax.swing.JTextField();
        txtMuneca = new javax.swing.JTextField();
        txtHombro = new javax.swing.JTextField();
        txtAEspalda = new javax.swing.JTextField();
        txtLEspalda = new javax.swing.JTextField();
        txtRodilla = new javax.swing.JTextField();
        txtTobillo = new javax.swing.JTextField();
        txtTiro = new javax.swing.JTextField();
        txtMuslo = new javax.swing.JTextField();
        fechaP = new javax.swing.JLabel();
        fechaEntrega = new com.toedter.calendar.JDateChooser();
        idPedido = new javax.swing.JLabel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabel2.setText("Edición de Pedido de Sastrería");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnvolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnvolver1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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

        txtDescrip.setColumns(20);
        txtDescrip.setLineWrap(true);
        txtDescrip.setRows(5);
        txtDescrip.setWrapStyleWord(true);
        txtDescrip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtDescrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescrip);

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

        txtTel.setEditable(false);
        txtTel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teléfono", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        cbxPrenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Camisa", "Camiseta", "Pantalón", "Vestido", "Falda" }));
        cbxPrenda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prenda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbxPrenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrendaActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Entregado" }));
        cbxEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado del pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        cbxEstado.setEnabled(true);

        btnEditar.setBackground(new java.awt.Color(255, 153, 51));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagen3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        imagenes.setBackground(new java.awt.Color(255, 152, 52));
        imagenes.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        imagenes.setText("Agregar Imagenes");
        imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenesActionPerformed(evt);
            }
        });

        imagen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenes)
                .addGap(266, 266, 266))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagen2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagen3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(imagenes)
                .addGap(17, 17, 17))
        );

        imagenes.setVisible(false);

        labelPrendas.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        txtLargo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Largo ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtLargo.setPreferredSize(new java.awt.Dimension(30, 50));
        txtLargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLargoActionPerformed(evt);
            }
        });
        txtLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLargoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLargoKeyTyped(evt);
            }
        });

        txtCadera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtCadera.setPreferredSize(new java.awt.Dimension(30, 50));
        txtCadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaderaActionPerformed(evt);
            }
        });
        txtCadera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCaderaKeyTyped(evt);
            }
        });

        txtCintura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cintura", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtCintura.setPreferredSize(new java.awt.Dimension(30, 50));
        txtCintura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCinturaKeyTyped(evt);
            }
        });

        txtLManga.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Largo de Manga", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtLManga.setPreferredSize(new java.awt.Dimension(25, 45));
        txtLManga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLMangaKeyTyped(evt);
            }
        });

        txtAManga.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ancho de Manga", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtAManga.setMinimumSize(new java.awt.Dimension(25, 45));
        txtAManga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAMangaKeyTyped(evt);
            }
        });

        txtCuello.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuello", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtCuello.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuelloKeyTyped(evt);
            }
        });

        txtPecho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pecho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtPecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPechoActionPerformed(evt);
            }
        });
        txtPecho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPechoKeyTyped(evt);
            }
        });

        txtMuneca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Muñeca", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtMuneca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunecaActionPerformed(evt);
            }
        });
        txtMuneca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMunecaKeyTyped(evt);
            }
        });

        txtHombro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hombro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtHombro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHombroKeyTyped(evt);
            }
        });

        txtAEspalda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ancho de Espalda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtAEspalda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAEspaldaKeyTyped(evt);
            }
        });

        txtLEspalda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Largo de Espalda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtLEspalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLEspaldaActionPerformed(evt);
            }
        });
        txtLEspalda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLEspaldaKeyTyped(evt);
            }
        });

        txtRodilla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rodilla", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtRodilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRodillaActionPerformed(evt);
            }
        });
        txtRodilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRodillaKeyTyped(evt);
            }
        });

        txtTobillo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tobillo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtTobillo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTobilloKeyTyped(evt);
            }
        });

        txtTiro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtTiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiroActionPerformed(evt);
            }
        });
        txtTiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiroKeyTyped(evt);
            }
        });

        txtMuslo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Muslo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        txtMuslo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMusloActionPerformed(evt);
            }
        });
        txtMuslo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMusloKeyTyped(evt);
            }
        });

        fechaEntrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addComponent(btnEditar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCintura, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCadera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLargo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMuneca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(txtLManga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(txtRodilla, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtAManga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCuello, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPecho, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTobillo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(txtHombro, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtAEspalda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLEspalda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtTiro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMuslo, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(labelPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaP)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id_cliente)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbxPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(idPedido))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idPedido)
                .addGap(8, 8, 8)
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
                        .addGap(42, 42, 42)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxEstado)
                    .addComponent(cbxPrenda))
                .addGap(40, 40, 40)
                .addComponent(labelPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLManga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAManga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMuneca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHombro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAEspalda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLEspalda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRodilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTobillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMuslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(btnEditar)
                .addContainerGap())
        );

        txtCliente.setEditable(false);
        txtCliente.setEnabled(false);
        id_cliente.setVisible(false);
        cbxPrenda.setEnabled(false);
        txtLargo.setVisible(false);
        txtCadera.setVisible(false);
        txtCintura.setVisible(false);
        txtLManga.setVisible(false);
        txtAManga.setVisible(false);
        txtCuello.setVisible(false);
        txtPecho.setVisible(false);
        txtMuneca.setVisible(false);
        txtHombro.setVisible(false);
        txtAEspalda.setVisible(false);
        txtLEspalda.setVisible(false);
        txtRodilla.setVisible(false);
        txtTobillo.setVisible(false);
        txtTiro.setVisible(false);
        txtMuslo.setVisible(false);
        fechaP.setVisible(false);
        idPedido.setVisible(false);

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolver1ActionPerformed
        Listado_Pedidos_Sastreria l2 = new Listado_Pedidos_Sastreria();
        l2.setSize(1024, 640);
        l2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(l2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btnvolver1ActionPerformed

    private void txtDescripKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripKeyTyped
        char c = evt.getKeyChar();
        if (Character.isWhitespace(c) && txtDescrip.getText().isEmpty() || (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ((int) evt.getKeyChar() <= 500 && evt.getKeyChar() >= 164) && c != KeyEvent.VK_SPACE || txtDescrip.getText().length() >= 300)
            evt.consume();
    }//GEN-LAST:event_txtDescripKeyTyped

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        char c = evt.getKeyChar();
        String texto = txtprecio.getText();

        if (c == '0' && (texto.isEmpty() || texto.equals("0"))) {
            evt.consume(); // Evita que se inicie con un cero
        } else if ((c < '0' || c > '9') || texto.length() >= 5) {
            evt.consume(); // Evita que se ingresen más de 6 caracteres o caracteres que no sean dígitos
        }

    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void cbxPrendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrendaActionPerformed
        String seleccion = cbxPrenda.getSelectedItem().toString();

        if (seleccion.equals("Camisa")) {
            labelPrendas.setText("Medidas para Camisa (cm)");

            txtCintura.setVisible(true);
            txtCadera.setVisible(true);
            txtLargo.setVisible(true);
            txtLManga.setVisible(true);
            txtAManga.setVisible(true);
            txtCuello.setVisible(true);
            txtPecho.setVisible(true);
            txtMuneca.setVisible(true);
            txtHombro.setVisible(true);
            txtAEspalda.setVisible(true);
            txtLEspalda.setVisible(true);

            txtRodilla.setVisible(false);
            txtTobillo.setVisible(false);
            txtTiro.setVisible(false);
            txtMuslo.setVisible(false);

        } else if (seleccion.equals("Camiseta")) {
            labelPrendas.setText("Medidas para Camiseta (cm)");
            txtCintura.setVisible(true);
            txtCadera.setVisible(true);
            txtLargo.setVisible(true);
            txtLManga.setVisible(true);
            txtAManga.setVisible(true);
            txtCuello.setVisible(true);
            txtPecho.setVisible(true);
            txtHombro.setVisible(true);
            txtAEspalda.setVisible(true);
            txtLEspalda.setVisible(true);

            txtMuneca.setVisible(false);
            txtRodilla.setVisible(false);
            txtTobillo.setVisible(false);
            txtTiro.setVisible(false);
            txtMuslo.setVisible(false);
        } else if (seleccion.equals("Pantalón")) {
            labelPrendas.setText("Medidas para Pantalón (cm)");
            txtCintura.setVisible(true);
            txtCadera.setVisible(true);
            txtLargo.setVisible(true);
            txtRodilla.setVisible(true);
            txtTobillo.setVisible(true);
            txtTiro.setVisible(true);
            txtMuslo.setVisible(true);

            txtLManga.setVisible(false);
            txtAManga.setVisible(false);
            txtCuello.setVisible(false);
            txtPecho.setVisible(false);
            txtMuneca.setVisible(false);
            txtHombro.setVisible(false);
            txtAEspalda.setVisible(false);
            txtLEspalda.setVisible(false);

        } else if (seleccion.equals("Vestido")) {
            labelPrendas.setText("Medidas para Vestido (cm)");
            txtCintura.setVisible(true);
            txtCadera.setVisible(true);
            txtLargo.setVisible(true);
            txtTiro.setVisible(true);
            txtPecho.setVisible(true);
            txtAEspalda.setVisible(true);
            txtLEspalda.setVisible(true);
            txtLManga.setVisible(true);
            txtAManga.setVisible(true);
            txtCuello.setVisible(true);

            txtRodilla.setVisible(false);
            txtTobillo.setVisible(false);
            txtTiro.setVisible(false);
            txtMuslo.setVisible(false);

        } else if (seleccion.equals("Falda")) {
            labelPrendas.setText("Medidas para Falda (cm)");
            txtCintura.setVisible(true);
            txtCadera.setVisible(true);
            txtLargo.setVisible(true);

            txtRodilla.setVisible(false);
            txtTobillo.setVisible(false);
            txtTiro.setVisible(false);
            txtMuslo.setVisible(false);
            txtAManga.setVisible(false);
            txtCuello.setVisible(false);
            txtPecho.setVisible(false);
            txtMuneca.setVisible(false);
            txtHombro.setVisible(false);
            txtAEspalda.setVisible(false);
            txtLEspalda.setVisible(false);
            txtLManga.setVisible(false);
        } else {

            labelPrendas.setText("Medidas...");

            txtCintura.setVisible(false);
            txtCadera.setVisible(false);
            txtLargo.setVisible(false);
            txtLManga.setVisible(false);
            txtAManga.setVisible(false);
            txtCuello.setVisible(false);
            txtPecho.setVisible(false);
            txtMuneca.setVisible(false);
            txtHombro.setVisible(false);
            txtAEspalda.setVisible(false);
            txtLEspalda.setVisible(false);
            txtRodilla.setVisible(false);
            txtTobillo.setVisible(false);
            txtTiro.setVisible(false);
            txtMuslo.setVisible(false);
        }

    }//GEN-LAST:event_cbxPrendaActionPerformed

    private void txtLargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLargoActionPerformed

    private void txtMusloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMusloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMusloActionPerformed

    private File[] archivos = new File[3];
    private int contador = 0; // Para llevar el registro de cuántas veces se ha presionado el botón

    private void imagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenesActionPerformed
        if (contador < 3) {
            JFileChooser fclAbrirArchivo = new JFileChooser();
            fclAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen", "jpg", "jpeg", "png"));

            int respuesta = fclAbrirArchivo.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                archivos[contador] = fclAbrirArchivo.getSelectedFile();

                // Cargar la imagen en el label correspondiente (imagen1, imagen2, o imagen3)
                ImageIcon icono = new ImageIcon(archivos[contador].getAbsolutePath());
                Image foto = icono.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT);

                // Verificar si el primer label ya está lleno
                if (imagen1.getIcon() == null) {
                    imagen1.setIcon(new ImageIcon(foto));
                } else if (imagen2.getIcon() == null) {
                    imagen2.setIcon(new ImageIcon(foto));
                } else if (imagen3.getIcon() == null) {
                    imagen3.setIcon(new ImageIcon(foto));
                    imagenes.setEnabled(false); // Desactivar el botón después de cargar la tercera imagen
                }

                contador++;
            }
        }
    }//GEN-LAST:event_imagenesActionPerformed

    private void txtMunecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunecaActionPerformed

    private void txtCaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaderaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaderaActionPerformed

    private void txtPechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPechoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPechoActionPerformed

    private void txtRodillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRodillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRodillaActionPerformed

    private void txtTiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiroActionPerformed

    private void txtLEspaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLEspaldaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLEspaldaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nombre = (String) txtCliente.getSelectedItem();
        String prenda = (String) cbxPrenda.getSelectedItem();
        String estado = (String) cbxEstado.getSelectedItem();
        String idC = id_cliente.getText();
        String imagenM1 = imagen1.getText();
        String descripcion = txtDescrip.getText();
        String precio = txtprecio.getText();
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPedido = sdfSQL.format(new Date());

        Date fecha = fechaEntrega.getDate();

        String cadera = txtCadera.getText();
        String cintura = txtCintura.getText();
        String largo = txtLargo.getText();
        String largoManga = txtLManga.getText();
        String anchoManga = txtAManga.getText();
        String cuello = txtCuello.getText();
        String pecho = txtPecho.getText();
        String muneca = txtMuneca.getText();
        String hombro = txtHombro.getText();
        String anchoEsp = txtAEspalda.getText();
        String largoEsp = txtLEspalda.getText();
        String rodilla = txtRodilla.getText();
        String tobillo = txtTobillo.getText();
        String tiro = txtTiro.getText();
        String muslo = txtMuslo.getText();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombre.equals("Seleccione")) {
            camposVacios.append("\n - Nombre del cliente");
        }
        if (prenda.equals("Seleccione")) {
            camposVacios.append("\n - Prenda");
        }
        if (imagen1.getIcon() == null) {
            camposVacios.append("\n - Agregue al menos una imagen de muestra");
        }
        if (descripcion.isEmpty()) {
            camposVacios.append("\n - Descripción");
        }
        if (fecha == null) {
            camposVacios.append("\n - Fecha de Entrega");
        }
        if (precio.isEmpty()) {
            camposVacios.append("\n - Precio");
        }

        if (prenda.equals("Camisa")) {

            if (txtCintura.getText().isEmpty()) {
                camposVacios.append("\n - Cintura");
            }

            if (txtCadera.getText().isEmpty()) {
                camposVacios.append("\n - Cadera");
            }

            if (txtLargo.getText().isEmpty()) {
                camposVacios.append("\n - Largo");
            }
            if (txtLManga.getText().isEmpty()) {
                camposVacios.append("\n - Largo de Manga");
            }

            if (txtAManga.getText().isEmpty()) {
                camposVacios.append("\n - Ancho de Manga");
            }

            if (txtCuello.getText().isEmpty()) {
                camposVacios.append("\n - Cuello");
            }

            if (txtPecho.getText().isEmpty()) {
                camposVacios.append("\n - Pecho");
            }

            if (txtMuneca.getText().isEmpty()) {
                camposVacios.append("\n - Muñeca");
            }

            if (txtHombro.getText().isEmpty()) {
                camposVacios.append("\n - Hombro");
            }

            if (txtAEspalda.getText().isEmpty()) {
                camposVacios.append("\n - Ancho de Espalda");
            }

            if (txtLEspalda.getText().isEmpty()) {
                camposVacios.append("\n - Largo de Espalda");
            }

        }
        if (prenda.equals("Camiseta")) {
            if (txtCintura.getText().isEmpty()) {
                camposVacios.append("\n - Cintura");
            }

            if (txtCadera.getText().isEmpty()) {
                camposVacios.append("\n - Cadera");
            }

            if (txtLargo.getText().isEmpty()) {
                camposVacios.append("\n - Largo");
            }
            if (txtLManga.getText().isEmpty()) {
                camposVacios.append("\n - Largo de Manga");
            }

            if (txtAManga.getText().isEmpty()) {
                camposVacios.append("\n - Ancho de Manga");
            }

            if (txtCuello.getText().isEmpty()) {
                camposVacios.append("\n - Cuello");
            }

            if (txtPecho.getText().isEmpty()) {
                camposVacios.append("\n - Pecho");
            }
            if (txtHombro.getText().isEmpty()) {
                camposVacios.append("\n - Hombro");
            }

            if (txtAEspalda.getText().isEmpty()) {
                camposVacios.append("\n - Ancho de Espalda");
            }

            if (txtLEspalda.getText().isEmpty()) {
                camposVacios.append("\n - Largo de Espalda");
            }

        }
        if (prenda.equals("Pantalón")) {

            if (txtCintura.getText().isEmpty()) {
                camposVacios.append("\n - Cintura");
            }

            if (txtCadera.getText().isEmpty()) {
                camposVacios.append("\n - Cadera");
            }

            if (txtLargo.getText().isEmpty()) {
                camposVacios.append("\n - Largo");
            }
            if (txtRodilla.getText().isEmpty()) {
                camposVacios.append("\n - Rodilla");
            }
            if (txtTobillo.getText().isEmpty()) {
                camposVacios.append("\n - Tobillo");
            }
            if (txtTiro.getText().isEmpty()) {
                camposVacios.append("\n - Tiro");
            }
            if (txtMuslo.getText().isEmpty()) {
                camposVacios.append("\n - Muslo");
            }
        }
        if (prenda.equals("Vestido")) {

            if (txtCintura.getText().isEmpty()) {
                camposVacios.append("\n - Cintura");
            }

            if (txtCadera.getText().isEmpty()) {
                camposVacios.append("\n - Cadera");
            }

            if (txtLargo.getText().isEmpty()) {
                camposVacios.append("\n - Largo");
            }

            if (txtPecho.getText().isEmpty()) {
                camposVacios.append("\n - Pecho");
            }

            if (txtAEspalda.getText().isEmpty()) {
                camposVacios.append("\n - Ancho de Espalda");
            }

            if (txtLEspalda.getText().isEmpty()) {
                camposVacios.append("\n - Largo de Espalda");
            }
            if (txtLManga.getText().isEmpty()) {
                camposVacios.append("\n - Largo de Manga");
            }

            if (txtAManga.getText().isEmpty()) {
                camposVacios.append("\n - Ancho de Manga");
            }
            if (txtCuello.getText().isEmpty()) {
                camposVacios.append("\n - Cuello");
            }
        }
        if (prenda.equals("Falda")) {
            if (txtCintura.getText().isEmpty()) {
                camposVacios.append("\n - Cintura");
            }

            if (txtCadera.getText().isEmpty()) {
                camposVacios.append("\n - Cadera");
            }

            if (txtLargo.getText().isEmpty()) {
                camposVacios.append("\n - Largo");
            }
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

                PreparedStatement updatePs = conn.prepareStatement("UPDATE PedidoSastreria SET prenda=?, estado=?, descripcion=?, precio=?, cadera=?, cintura=?, "
                        + "largo=?, largoManga=?, anchoManga=?, cuello=?, pecho=?, muneca=?, hombro=?, anchoEsp=?, largoEsp=?, rodilla=?, tobillo=?, tiro=?, muslo=?, "
                        + "imagen1=?, imagen2=?, imagen3=?, fechaPedido=?, id_cliente=?, fechaEntrega=? "
                        + "WHERE id_sastreria=?");

                updatePs.setString(1, prenda);
                updatePs.setString(2, estado);
                updatePs.setObject(3, descripcion);
                updatePs.setObject(4, precio);
                updatePs.setObject(5, cadera);
                updatePs.setObject(6, cintura);
                updatePs.setObject(7, largo);
                updatePs.setObject(8, largoManga);
                updatePs.setObject(9, anchoManga);
                updatePs.setObject(10, cuello);
                updatePs.setObject(11, pecho);
                updatePs.setObject(12, muneca);
                updatePs.setObject(13, hombro);
                updatePs.setObject(14, anchoEsp);
                updatePs.setObject(15, largoEsp);
                updatePs.setObject(16, rodilla);
                updatePs.setObject(17, tobillo);
                updatePs.setObject(18, tiro);
                updatePs.setObject(19, muslo);

                // Verificar y actualizar la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty() && archivos[0] != null) {
                    File file1 = new File(rutaImagen1);
                    if (file1.exists()) {
                        try (FileInputStream fis1 = new FileInputStream(file1)) {
                            byte[] bytes1 = new byte[(int) file1.length()];
                            fis1.read(bytes1);
                            updatePs.setBytes(20, bytes1);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(Editar_Pedido_Sastreria.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(20, Types.BLOB); // Imagen 1 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(20, obtenerImagenExistente(20));
                }

                // Verificar y actualizar la imagen 2 solo si hay una nueva imagen y no se ha cargado antes
                if (rutaImagen2 != null && !rutaImagen2.isEmpty() && archivos[1] != null) {
                    File file2 = new File(rutaImagen2);
                    if (file2.exists()) {
                        try (FileInputStream fis2 = new FileInputStream(file2)) {
                            byte[] bytes2 = new byte[(int) file2.length()];
                            fis2.read(bytes2);
                            updatePs.setBytes(21, bytes2);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(Editar_Pedido_Sastreria.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(21, Types.BLOB); // Imagen 2 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(21, obtenerImagenExistente(21));
                }

                // Verificar y actualizar la imagen 3 solo si hay una nueva imagen y no se ha cargado antes
                if (rutaImagen3 != null && !rutaImagen3.isEmpty() && archivos[2] != null) {
                    File file3 = new File(rutaImagen3);
                    if (file3.exists()) {
                        try (FileInputStream fis3 = new FileInputStream(file3)) {
                            byte[] bytes3 = new byte[(int) file3.length()];
                            fis3.read(bytes3);
                            updatePs.setBytes(22, bytes3);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(Editar_Pedido_Sastreria.class.getName()).log(Level.SEVERE, null, ex);
                            updatePs.setNull(22, Types.BLOB); // Imagen 3 no pudo ser leída
                        }
                    }
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(22, obtenerImagenExistente(22));
                }

                // Verifica y actualiza la imagen 1 solo si hay una nueva imagen
                if (rutaImagen1 != null && !rutaImagen1.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen1, 20);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(20, obtenerImagenExistente(20));
                }

                // Verifica y actualiza la imagen 2 solo si hay una nueva imagen
                if (rutaImagen2 != null && !rutaImagen2.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen2, 21);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(21, obtenerImagenExistente(21));
                }

                 // Verifica y actualiza la imagen 3 solo si hay una nueva imagen
                if (rutaImagen3 != null && !rutaImagen3.isEmpty()) {
                    actualizarImagen(updatePs, rutaImagen3, 22);
                } else {
                    // Si no hay una nueva imagen, mantén la imagen existente en la base de datos
                    updatePs.setBytes(22, obtenerImagenExistente(22));
                }
                
                updatePs.setString(23, fechaPedido);
                updatePs.setObject(24, idC);
                updatePs.setDate(25, new java.sql.Date(fecha.getTime()));

                // Establece el valor de la clave primaria
                int numeracion = Integer.parseInt(idPedido.getText());
                updatePs.setInt(26, numeracion); // Reemplaza idPedido con el valor adecuado para identificar el registro que deseas actualizar

                updatePs.executeUpdate();

                // Restaura las imágenes en los JLabel después de la actualización
                imagen1.setIcon(icon1);
                imagen2.setIcon(icon2);
                imagen3.setIcon(icon3);

                JOptionPane.showMessageDialog(null, "Registro editado exitosamente");

                Listado_Pedidos_Sastreria p = new Listado_Pedidos_Sastreria();

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

    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtCinturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCinturaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtCintura.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }

    }//GEN-LAST:event_txtCinturaKeyTyped

    private void txtCaderaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaderaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtCadera.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCaderaKeyTyped

    private void txtLargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLargoKeyReleased

    private void txtLargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyTyped
        char c = evt.getKeyChar();
        String texto = txtLargo.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtLargoKeyTyped

    private void txtLMangaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLMangaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtLManga.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }

    }//GEN-LAST:event_txtLMangaKeyTyped

    private void txtAMangaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMangaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtAManga.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAMangaKeyTyped

    private void txtCuelloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuelloKeyTyped
        char c = evt.getKeyChar();
        String texto = txtCuello.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCuelloKeyTyped

    private void txtPechoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPechoKeyTyped
        char c = evt.getKeyChar();
        String texto = txtPecho.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtPechoKeyTyped

    private void txtMunecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunecaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtMuneca.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtMunecaKeyTyped

    private void txtHombroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHombroKeyTyped
        char c = evt.getKeyChar();
        String texto = txtHombro.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtHombroKeyTyped

    private void txtLEspaldaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLEspaldaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtLEspalda.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtLEspaldaKeyTyped

    private void txtRodillaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRodillaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtRodilla.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtRodillaKeyTyped

    private void txtTobilloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTobilloKeyTyped
        char c = evt.getKeyChar();
        String texto = txtTobillo.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTobilloKeyTyped

    private void txtTiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiroKeyTyped
        char c = evt.getKeyChar();
        String texto = txtTiro.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTiroKeyTyped

    private void txtMusloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMusloKeyTyped
        char c = evt.getKeyChar();
        String texto = txtMuslo.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtMusloKeyTyped

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtAEspaldaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAEspaldaKeyTyped
        char c = evt.getKeyChar();
        String texto = txtAEspalda.getText();

        if (texto.isEmpty() && c == '0') {
            evt.consume(); // Evita que el campo inicie con "0"
        } else if ((c < '0' || c > '9') && c != '.' || texto.length() >= 5 || texto.contains(".") && c == '.' || texto.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAEspaldaKeyTyped

// Método para obtener la imagen existente en la base de datos
    private byte[] obtenerImagenExistente(int posicion) throws SQLException, ClassNotFoundException {
        byte[] imagenExistente = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789")) {
            String sql = "SELECT imagen1, imagen2, imagen3 FROM PedidoSastreria WHERE id_sastreria = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, Integer.parseInt(idPedido.getText()));
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        switch (posicion) {
                            case 20:
                                imagenExistente = rs.getBytes(1); // Imagen 1
                                break;
                            case 21:
                                imagenExistente = rs.getBytes(2); // Imagen 2
                                break;
                            case 22:
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnvolver1;
    public javax.swing.JComboBox<String> cbxEstado;
    public javax.swing.JComboBox<String> cbxPrenda;
    public com.toedter.calendar.JDateChooser fechaEntrega;
    public javax.swing.JLabel fechaP;
    public javax.swing.JLabel idPedido;
    public javax.swing.JLabel id_cliente;
    public javax.swing.JLabel imagen1;
    public javax.swing.JLabel imagen2;
    public javax.swing.JLabel imagen3;
    public javax.swing.JButton imagenes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPrendas;
    public javax.swing.JTextField txtAEspalda;
    public javax.swing.JTextField txtAManga;
    public javax.swing.JTextField txtCadera;
    public javax.swing.JTextField txtCintura;
    public javax.swing.JComboBox<String> txtCliente;
    public javax.swing.JTextField txtCuello;
    public javax.swing.JTextArea txtDescrip;
    public javax.swing.JTextField txtHombro;
    public javax.swing.JTextField txtLEspalda;
    public javax.swing.JTextField txtLManga;
    public javax.swing.JTextField txtLargo;
    public javax.swing.JTextField txtMuneca;
    public javax.swing.JTextField txtMuslo;
    public javax.swing.JTextField txtPecho;
    public javax.swing.JTextField txtRodilla;
    public javax.swing.JTextField txtTel;
    public javax.swing.JTextField txtTiro;
    public javax.swing.JTextField txtTobillo;
    public javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
