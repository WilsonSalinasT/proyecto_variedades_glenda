/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import static App.Menu.panelprincipal;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static App.ProductoParaCompra.totalFactura;
import Paneles.clientes;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import static App.factura.txtbill;
import Paneles.Listado_Citas;
import Paneles.Listado_Ventas;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author novastar
 */
public class IngresodeVenta extends javax.swing.JFrame {

    DefaultTableModel modelo;

    /**
     * Creates new form IngresodeCompra
     */
    private int contadorFacturas = 1;

    public IngresodeVenta() {
        initComponents();

//        txtfecha.setMinSelectableDate(new Date());
//
//        Calendar maxDate = Calendar.getInstance();
//        maxDate.add(Calendar.MONTH, 2); // Suma dos meses a la fecha actual
//        txtfecha.setMaxSelectableDate(maxDate.getTime());
        tableventas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableventas.getTableHeader().setOpaque(false);
        tableventas.getTableHeader().setBackground(new Color(255, 0, 0));
        tableventas.getTableHeader().setForeground(new Color(255, 0, 0));
        tableventas.setRowHeight(25);

        tableventas.setRowSelectionAllowed(true);
        tableventas.setColumnSelectionAllowed(false);

        Date fechaActual = new Date();

        // Crear un formato para la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        // Formatear la fecha como una cadena
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Mostrar la fecha en el JLabel
        txtfecha.setText(fechaFormateada);

        int columnIndexToHide = 4;
        TableColumn column = tableventas.getColumnModel().getColumn(columnIndexToHide);

        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);
//     sumarColumna();
//        Tsum.setText(Integer.toString((int) getsumarColumna()));
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT id_cliente, nombre,apellido FROM Cliente";
            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            while (rs.next())
            {
                String nombreCliente = rs.getString("nombre");
                String apellidoProvverod = rs.getString("apellido");
                int idProveedor = rs.getInt("id_cliente");

                String nombres = nombreCliente + " " + apellidoProvverod;
                txtCliente.addItem(nombres);

                // Almacena el ID del cliente en un mapa con el nombre completo como clave
                txtCliente.putClientProperty(nombres, idProveedor);
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

//        fecha();
        generarserie();

    }

//    void fecha() {
//        Calendar calendar = new GregorianCalendar();
//        txtfecha.setText("" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
//
//    }
    void generarserie() {
        String serie = Seriedeventa();

        if (serie == null)
        {
            // Initialize the invoice number to "000001" if no previous invoice exists
            numFactura.setText("00001");
        } else
        {
            try
            {
                // Parse the retrieved invoice number as an integer
                int increment = Integer.parseInt(serie);

                // Increment the invoice number by 1
                increment++;

                // Format the incremented invoice number to 5 digits and pad with zeros
                String nroSerie = String.format("%5s", String.valueOf(increment)).replace(' ', '0');

                // Set the invoice number text field with the formatted value
                numFactura.setText(nroSerie);
            } catch (NumberFormatException e)
            {
                // Handle any exceptions that occur during parsing
                // You can log the error or display an appropriate message
                System.err.println("Invalid invoice number format: " + serie);
            }
        }
    }

    public String Seriedeventa() {
        String serie = "";
        String sql = "select count(numfactura) from Ventas";

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                serie = rs.getString(1);
            }
        } catch (Exception e)
        {
        }
        return serie;
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnAgregarproducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tipoCompra = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        numFactura = new javax.swing.JFormattedTextField();
        jSeparator5 = new javax.swing.JSeparator();
        id_cliente = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableventas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        Tsum = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresar venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 3, true), "Datos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jButton4.setBackground(new java.awt.Color(255, 153, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(255, 153, 51));
        btnguardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator4.setOpaque(true);

        btnAgregarproducto.setBackground(new java.awt.Color(255, 153, 51));
        btnAgregarproducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarproducto.setText("Agregar Producto");
        btnAgregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarproductoActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha");

        jLabel5.setText("Cliente");

        jLabel4.setText("Tipo de Venta:");

        tipoCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Credito", "Contado" }));
        tipoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCompraActionPerformed(evt);
            }
        });

        jLabel3.setText("No. de Factura");

        numFactura.setEditable(false);
        numFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFacturaActionPerformed(evt);
            }
        });
        numFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numFacturaKeyTyped(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator5.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator5.setOpaque(true);

        id_cliente.setEditable(false);
        id_cliente.setBackground(new java.awt.Color(255, 255, 255));
        id_cliente.setForeground(new java.awt.Color(255, 255, 255));
        id_cliente.setBorder(null);
        id_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_clienteActionPerformed(evt);
            }
        });

        txtfecha.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tipoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCliente, 0, 263, Short.MAX_VALUE)
                            .addComponent(txtfecha))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tipoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 3, true), "Productos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        tableventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Cantidad", "Precio de venta", "sub total", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableventas.setShowHorizontalLines(true);
        tableventas.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableventas);

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Eliminar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator3.setOpaque(true);

        Tsum.setEditable(false);
        Tsum.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Tsum.setForeground(new java.awt.Color(0, 0, 0));
        Tsum.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 102), 1, true));

        jButton5.setBackground(new java.awt.Color(255, 153, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Ver factura");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Total:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(418, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tsum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tsum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //codigo para eliminar filas de las tablas 
        //Obtener el índice de la fila seleccionada
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tableventas.getSelectedRow();

        if (filaSeleccionada >= 0)
        {
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tableventas.getModel();

            // Obtener el total de la fila seleccionada
            double totalP = Double.parseDouble(modelo.getValueAt(filaSeleccionada, 3).toString());

            // Eliminar la fila seleccionada del modelo de la tabla
            modelo.removeRow(filaSeleccionada);

            // Restar el total de la fila eliminada del totalFactura
            totalFactura -= totalP;

            calcular();

            // Actualizar el total de la factura en el componente adecuado (lblTotalFactura)
            //lblTotalFactura.setText(String.valueOf(totalFactura));
        } else
        {
            // No se seleccionó ninguna fila, mostrar un mensaje de advertencia o error
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila", "Error al eliminar fila", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    public void calcular() {

        float suma = 0;
        for (int i = 0; i < tableventas.getRowCount(); i++)
        {

            float renglon;
            renglon = Float.parseFloat(tableventas.getValueAt(i, 3).toString());

            suma = suma + renglon;
        }
        Tsum.setText(String.valueOf(suma));

    }
    private void btnAgregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarproductoActionPerformed
        ProductoParaVenta prod = new ProductoParaVenta();
        prod.setVisible(true);
        prod.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarproductoActionPerformed

    public void bill() {
        // Obtener valores de los campos
        // Obtener valores de los campos
        String num = numFactura.getText();
        String tipo = (String) tipoCompra.getSelectedItem();
        String proveedor = (String) txtCliente.getSelectedItem();
        String fecha = txtfecha.getText();
        String agregarProducto = btnAgregarproducto.getText().trim(); // Nuevo campo

        StringBuilder camposVacios = new StringBuilder("Por favor, complete los siguientes campos obligatorios:\n");

        String numeroFacturaSinSeparadores = num.replaceAll("[\\s-]+", "");
        String digitosSignificativos = numeroFacturaSinSeparadores.replaceAll("\\D", "");

        if (tipoCompra.getSelectedItem() == null || tipoCompra.getSelectedItem().toString().trim().isEmpty()
                || tipoCompra.getSelectedItem().toString().trim().equalsIgnoreCase("Seleccione"))
        {
            camposVacios.append("- Tipo de venta");
        }
        String cliente = txtCliente.getSelectedItem().toString();

        if (cliente.equals("Seleccione"))
        {
            camposVacios.append("\n - Cliente\n");
        }

        boolean agregarProductoPresionado = true;
        if (!agregarProductoPresionado)
        {
            camposVacios.append("- Agregar Producto\n");
        }

// Verificar si hay al menos una fila en la tabla
        if (tableventas.getRowCount() == 0)
        {
            camposVacios.append("- Por favor, agregue al menos un producto a la factura.\n");
        }

// Mostrar mensajes de error solo si hay campos vacíos
        if (camposVacios.length() > "Por favor, complete los siguientes campos obligatorios:\n".length())
        {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si falta algún campo obligatorio
        }

        factura ver = new factura();
        DefaultTableModel model = (DefaultTableModel) tableventas.getModel();

        // Verificar si hay al menos una fila en la tabla
        if (model.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Por favor, agregue al menos un producto a la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si la tabla está vacía
        }

        StringBuilder facturaText = new StringBuilder();

        // Resto del código para generar la factura
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String fechaFormateada = formato.format(fecha);

        facturaText.append("*********************************************************************\n");
        facturaText.append("                           Factura de venta                   \n");
        facturaText.append("*********************************************************************\n");

        facturaText.append(" No. de Factura: ").append(num).append("\n");
        facturaText.append(" Tipo de venta: ").append(tipo).append("\n");
        facturaText.append(" Cliente: ").append(proveedor).append("\n");
        facturaText.append(" Fecha: ").append(fecha).append("\n");

        facturaText.append("*********************************************************************\n");
        facturaText.append("\n");
        facturaText.append(String.format("%-20s%-10s%-20s%-10s\n", " Producto", " Cantidad", " Precio de venta", " subtotal"));

        for (int i = 0; i < model.getRowCount(); i++)
        {
            String name = (String) model.getValueAt(i, 0);
            String cantidad = (String) model.getValueAt(i, 1);
            String preciounitario = (String) model.getValueAt(i, 2);
            String total = (String) model.getValueAt(i, 3);

            facturaText.append(String.format(" %-20s %-10s %-20s%-10s\n", name, cantidad, preciounitario, total));
        }

        ver.txtbill.setText(facturaText.toString());
        ver.txtbill.setText(ver.txtbill.getText() + "*********************************************************************\n");
        ver.txtbill.setText(ver.txtbill.getText() + " Total: " + Tsum.getText() + "\n");
        facturaText.append("*********************************************************************\n");

        ver.setVisible(true);
    }


    private void numFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numFacturaKeyTyped

    }//GEN-LAST:event_numFacturaKeyTyped

    private void tipoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCompraActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        String nunfactura = numFactura.getText().trim();
        String id = id_cliente.getText().trim();
        String tipo = (String) tipoCompra.getSelectedItem();

        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaventa = sdfSQL.format(new Date());

        String agregarProducto = btnAgregarproducto.getText().trim(); // Nuevo campo

        StringBuilder camposVacios = new StringBuilder("Por favor, complete los siguientes campos obligatorios:\n");

        String numeroFacturaSinSeparadores = nunfactura.replaceAll("[\\s-]+", "");
        String digitosSignificativos = numeroFacturaSinSeparadores.replaceAll("\\D", "");

//        if (digitosSignificativos.length() < 3)
//        {
//            camposVacios.append("- Número de factura\n");
//        }
        if (tipoCompra.getSelectedItem() == null || tipoCompra.getSelectedItem().toString().trim().isEmpty()
                || tipoCompra.getSelectedItem().toString().trim().equalsIgnoreCase("Seleccione"))
        {
            camposVacios.append("- Tipo de venta\n");
        }

        if (id.isEmpty())
        {
            camposVacios.append("- Cliente\n");
        }

        boolean agregarProductoPresionado = true;
        if (!agregarProductoPresionado)
        {
            camposVacios.append("- Agregar Producto\n");
        }

// Verificar si hay al menos una fila en la tabla
        if (tableventas.getRowCount() == 0)
        {
            camposVacios.append("- Por favor, agregue al menos un producto a la factura.\n");
        }

// Mostrar mensajes de error solo si hay campos vacíos
        if (camposVacios.length() > "Por favor, complete los siguientes campos obligatorios:\n".length())
        {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si falta algún campo obligatorio
        }

        try
        {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            PreparedStatement insertCompras = conn.prepareStatement("INSERT INTO Ventas (numfactura, tipoCategoria,fecha, total, id_cliente) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertCompras.setString(1, nunfactura);
            insertCompras.setString(2, tipo);
            insertCompras.setString(3, fechaventa);
            insertCompras.setObject(4, Tsum.getText());
            insertCompras.setString(5, id);

            int filasAfectadasCompras = insertCompras.executeUpdate();

            ResultSet rsCompras = insertCompras.getGeneratedKeys();
            if (rsCompras.next())
            {
                int idCompraGenerado = rsCompras.getInt(1);

                // Inserción en la tabla DetallesVentas con verificación de cantidad disponible
                for (int i = 0; i < tableventas.getRowCount(); i++)
                {
                    // Obtener la cantidad disponible del producto antes de la venta
                    String codProducto = tableventas.getValueAt(i, 4).toString();
                    String nombre = tableventas.getValueAt(i, 0).toString();
                    int cantidadVendida = Integer.parseInt(tableventas.getValueAt(i, 1).toString());

                    String queryCantidadDisponible = "SELECT cantidad_disponible,nombre FROM Productos WHERE cod_producto = ?";
                    try (PreparedStatement pstmtCantidadDisponible = conn.prepareStatement(queryCantidadDisponible))
                    {
                        pstmtCantidadDisponible.setString(1, codProducto);
                        ResultSet rsCantidadDisponible = pstmtCantidadDisponible.executeQuery();

                        if (rsCantidadDisponible.next())
                        {
                            int cantidadDisponible = rsCantidadDisponible.getInt("cantidad_disponible");

                            // Verificar si la cantidad vendida supera la cantidad disponible
                            if (cantidadVendida > cantidadDisponible)
                            {
                                // Mostrar mensaje y detener el proceso
                                JOptionPane.showMessageDialog(null, "La cantidad vendida del producto " + nombre + " supera la cantidad disponible.");
                                return; // Puedes ajustar esto según tu lógica de manejo de errores
                            }
                        }
                    }

                    // Resto del código para la inserción en DetallesVentas y actualización de inventario
                    PreparedStatement insertDetallesCompras = conn.prepareStatement("INSERT INTO DetallesVentas (id_venta, cantidad_vendida, precio_venta, total, cod_producto) VALUES (?,?,?,?,?)");
                    insertDetallesCompras.setInt(1, idCompraGenerado);
                    insertDetallesCompras.setString(2, tableventas.getValueAt(i, 1).toString());
                    String valorTabla = tableventas.getValueAt(i, 2).toString();
                    BigDecimal valorDecimal = new BigDecimal(valorTabla);

// Estableciendo el valor decimal en la posición 3
                    insertDetallesCompras.setBigDecimal(3, valorDecimal);
                    insertDetallesCompras.setString(4, tableventas.getValueAt(i, 3).toString());
                    insertDetallesCompras.setString(5, tableventas.getValueAt(i, 4).toString());

                    insertDetallesCompras.executeUpdate();

                    String queryActualizarInventario = "UPDATE Productos SET cantidad_disponible = cantidad_disponible - ? WHERE cod_producto = ?";
                    try (PreparedStatement pstmtActualizarInventario = conn.prepareStatement(queryActualizarInventario))
                    {
                        pstmtActualizarInventario.setString(1, tableventas.getValueAt(i, 1).toString());
                        pstmtActualizarInventario.setString(2, tableventas.getValueAt(i, 4).toString());
                        pstmtActualizarInventario.executeUpdate();
                    }
                }

                JOptionPane.showMessageDialog(null, "Registro guardado");
                Listado_Ventas cli = new Listado_Ventas();

                cli.setSize(1024, 640);
                cli.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(cli, BorderLayout.CENTER);
                panelprincipal.revalidate();
                panelprincipal.repaint();
                this.dispose();
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        bill();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void id_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_clienteActionPerformed

    private void numFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFacturaActionPerformed

    }//GEN-LAST:event_numFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Tsum;
    private javax.swing.JButton btnAgregarproducto;
    private javax.swing.JButton btnguardar;
    public javax.swing.JTextField id_cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JFormattedTextField numFactura;
    public static javax.swing.JTable tableventas;
    public javax.swing.JComboBox<String> tipoCompra;
    public javax.swing.JComboBox<String> txtCliente;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables

    private boolean existeNumeroFactura(Connection conn, String nunfactura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int obtenerIdProductoSeleccionado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int obtenerCantidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private BigDecimal obtenerPrecioUnitario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private BigDecimal obtenerTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private BigDecimal obtenerTotalDetalle() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int obtenerIdProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
