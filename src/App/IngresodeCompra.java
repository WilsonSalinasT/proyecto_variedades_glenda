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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author novastar
 */
public class IngresodeCompra extends javax.swing.JFrame {

    DefaultTableModel modelo;

    
    /**
     * Creates new form IngresodeCompra
     */
    public IngresodeCompra() {
        initComponents();
        
        
    
        
        txtfecha.setMinSelectableDate(new Date());

         Calendar maxDate = Calendar.getInstance();
         maxDate.add(Calendar.MONTH, 2); // Suma dos meses a la fecha actual
         txtfecha.setMaxSelectableDate(maxDate.getTime());


        tablecompras.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablecompras.getTableHeader().setOpaque(false);
        tablecompras.getTableHeader().setBackground(new Color(255, 0, 0));
        tablecompras.getTableHeader().setForeground(new Color(255, 0, 0));
        tablecompras.setRowHeight(25);

        tablecompras.setRowSelectionAllowed(true);
        tablecompras.setColumnSelectionAllowed(false);

      
//     sumarColumna();
//        Tsum.setText(Integer.toString((int) getsumarColumna()));
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT id_proveedor, nombreEmpresa FROM Proveedor";
            ResultSet rs = stmt.executeQuery(sql);

            txtProveedor.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            while (rs.next())
            {
                String nombreProveedor = rs.getString("nombreEmpresa");

                int idProveedor = rs.getInt("id_proveedor");

                txtProveedor.addItem(nombreProveedor);

                // Almacena el ID del cliente en un mapa con el nombre completo como clave
                txtProveedor.putClientProperty(nombreProveedor, idProveedor);
            }

            connection.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        txtProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClient = (String) txtProveedor.getSelectedItem();
                int selectedClientId = (int) txtProveedor.getClientProperty(selectedClient);

                // Actualiza el campo de texto con el ID del cliente seleccionado
                id_proveedor.setText(Integer.toString(selectedClientId));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnAgregarproducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tipoCompra = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        numFactura = new javax.swing.JFormattedTextField();
        jSeparator5 = new javax.swing.JSeparator();
        id_proveedor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablecompras = new javax.swing.JTable();
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
        jLabel1.setText("Ingresar Compra");

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
        jButton4.setText("Cancelar");
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

        jLabel5.setText("Proveedor:");

        jLabel4.setText("Tipo de Compra:");

        tipoCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Credito", "Contado" }));
        tipoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCompraActionPerformed(evt);
            }
        });

        jLabel3.setText("No. de Factura");

        numFactura.setText("- - -");
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

        id_proveedor.setEditable(false);
        id_proveedor.setBackground(new java.awt.Color(255, 255, 255));
        id_proveedor.setForeground(new java.awt.Color(255, 255, 255));
        id_proveedor.setBorder(null);
        id_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_proveedorActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(numFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addComponent(jSeparator5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
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

        tablecompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Cantidad", "Precio unitario", "Total"
            }
        ));
        tablecompras.setShowHorizontalLines(true);
        tablecompras.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablecompras);

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
        jButton5.setText("Ver");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tsum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
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
        int filaSeleccionada = tablecompras.getSelectedRow();

        if (filaSeleccionada >= 0)
        {
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablecompras.getModel();

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

     public void calcular(){

        float suma = 0;
        for(int i = 0; i < tablecompras.getRowCount(); i++){
        
            float renglon;
            renglon = Float.parseFloat(tablecompras.getValueAt(i, 3).toString());
            
            suma = suma + renglon;
        }
        Tsum.setText(String.valueOf(suma));

}
    private void btnAgregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarproductoActionPerformed
        ProductoParaCompra prod = new ProductoParaCompra();
        prod.setVisible(true);
        prod.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarproductoActionPerformed

   public void bill() {
    // Obtener valores de los campos
  // Obtener valores de los campos
String num = numFactura.getText();
String tipo = (String) tipoCompra.getSelectedItem();
String proveedor = (String) txtProveedor.getSelectedItem();
Date fecha = txtfecha.getDate();
String agregarProducto = btnAgregarproducto.getText().trim(); // Nuevo campo

StringBuilder camposVacios = new StringBuilder("Por favor, complete los siguientes campos obligatorios:\n");

String numeroFacturaSinSeparadores = num.replaceAll("[\\s-]+", "");
String digitosSignificativos = numeroFacturaSinSeparadores.replaceAll("\\D", "");

if (digitosSignificativos.length() < 3) {
    camposVacios.append("- Número de factura\n");
}

if (tipoCompra.getSelectedItem() == null || tipoCompra.getSelectedItem().toString().trim().isEmpty() ||
    tipoCompra.getSelectedItem().toString().trim().equalsIgnoreCase("Seleccione")) {
    camposVacios.append("- Tipo de compra\n");
}



if (proveedor.isEmpty()) {
    camposVacios.append("- Proveedor\n");
}
if (fecha == null) {
    camposVacios.append("- Fecha\n");
}
        boolean agregarProductoPresionado = true;
if (!agregarProductoPresionado) {
    camposVacios.append("- Agregar Producto\n");
}

// Verificar si hay al menos una fila en la tabla
if (tablecompras.getRowCount() == 0) {
    camposVacios.append("- Por favor, agregue al menos un producto a la factura.\n");
}

// Mostrar mensajes de error solo si hay campos vacíos
if (camposVacios.length() > "Por favor, complete los siguientes campos obligatorios:\n".length()) {
    JOptionPane.showMessageDialog(null, camposVacios.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    return; // Salir del método si falta algún campo obligatorio
}


 
    factura ver = new factura();
    DefaultTableModel model = (DefaultTableModel) tablecompras.getModel();

    // Verificar si hay al menos una fila en la tabla
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Por favor, agregue al menos un producto a la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si la tabla está vacía
    }

    StringBuilder facturaText = new StringBuilder();

    // Resto del código para generar la factura
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String fechaFormateada = formato.format(fecha);

    facturaText.append("*********************************************************************\n");
    facturaText.append("                    Factura de compra                   \n");
    facturaText.append("*********************************************************************\n");

    facturaText.append("No. de Factura: ").append(num).append("\n");
    facturaText.append("Tipo de compra: ").append(tipo).append("\n");
    facturaText.append("Proveedor: ").append(proveedor).append("\n");
    facturaText.append("Fecha: ").append(fechaFormateada).append("\n");

    facturaText.append("*********************************************************************\n");
    facturaText.append("\n");
    facturaText.append(String.format("%-20s %-10s %-20s %-10s\n", "Producto", "Cantidad", "Precio unitario", "Total"));

    for (int i = 0; i < model.getRowCount(); i++) {
        String name = (String) model.getValueAt(i, 0);
        String cantidad = (String) model.getValueAt(i, 1);
        String preciounitario = (String) model.getValueAt(i, 2);
        String total = (String) model.getValueAt(i, 3);

        facturaText.append(String.format("%-20s %-10s %-20s %-10s\n", name, cantidad, preciounitario, total));
    }

    ver.txtbill.setText(facturaText.toString());
    ver.txtbill.setText(ver.txtbill.getText() + "*********************************************************************\n");
    ver.txtbill.setText(ver.txtbill.getText() + "Total: " + Tsum.getText() + "\n");
    facturaText.append("*********************************************************************\n");

    ver.setVisible(true);
}



    private void numFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numFacturaKeyTyped
        // Obtiene el texto actual del campo de número de factura
    String numeroFactura = numFactura.getText().trim();

    // Permite solo dígitos y el carácter '-'
    char c = evt.getKeyChar();
    if (!Character.isDigit(c) && c != '-') {
        evt.consume(); // Ignora la tecla si no es un dígito ni '-'
        return;
    }

    // Verifica la longitud del número de factura después de la nueva pulsación de tecla
    if ((numeroFactura + evt.getKeyChar()).length() > 14) {
        evt.consume(); // Ignora la tecla si supera los 14 caracteres
        return;
    }

    // Actualiza el número de factura en el campo
    numFactura.setText(numeroFactura);
    
    // Realiza la validación del formato usando la expresión regular
    if (!numeroFactura.matches("\\d{1,3}-\\d{1,3}-\\d{1,3}-\\d{1,3}")) {
        // Muestra un mensaje de error o toma alguna acción
        // Puedes también deshabilitar el botón de guardar, por ejemplo
        // btnGuardar.setEnabled(false);
    } else {
        // Puedes habilitar el botón de guardar si es necesario
        // btnGuardar.setEnabled(true);
    }
    }//GEN-LAST:event_numFacturaKeyTyped

    private void tipoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCompraActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

   String nunfactura = numFactura.getText().trim();
String id = id_proveedor.getText().trim();
String tipo = (String) tipoCompra.getSelectedItem();
Date fecha = (Date) txtfecha.getDate();
String agregarProducto = btnAgregarproducto.getText().trim(); // Nuevo campo

StringBuilder camposVacios = new StringBuilder("Por favor, complete los siguientes campos obligatorios:\n");

String numeroFacturaSinSeparadores = nunfactura.replaceAll("[\\s-]+", "");
String digitosSignificativos = numeroFacturaSinSeparadores.replaceAll("\\D", "");

if (digitosSignificativos.length() < 3) {
    camposVacios.append("- Número de factura\n");
}

if (tipoCompra.getSelectedItem() == null || tipoCompra.getSelectedItem().toString().trim().isEmpty() ||
    tipoCompra.getSelectedItem().toString().trim().equalsIgnoreCase("Seleccione")) {
    camposVacios.append("- Tipo de compra\n");
}

if (id.isEmpty()) {
    camposVacios.append("- Proveedor\n");
}
if (fecha == null) {
    camposVacios.append("- Fecha\n");
}

boolean agregarProductoPresionado = true;
if (!agregarProductoPresionado) {
    camposVacios.append("- Agregar Producto\n");
}

// Verificar si hay al menos una fila en la tabla
if (tablecompras.getRowCount() == 0) {
    camposVacios.append("- Por favor, agregue al menos un producto a la factura.\n");
}

// Mostrar mensajes de error solo si hay campos vacíos
if (camposVacios.length() > "Por favor, complete los siguientes campos obligatorios:\n".length()) {
    JOptionPane.showMessageDialog(null, camposVacios.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    return; // Salir del método si falta algún campo obligatorio
}

// Resto del código para la inserción en la base de datos
try {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

    // Inserción en la tabla Compras
    PreparedStatement insertCompras = conn.prepareStatement("INSERT INTO Compras (numfactura, tipoCategoria, fecha, total, id_proveedor) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
    insertCompras.setString(1, nunfactura);
    insertCompras.setString(2, tipo);
    insertCompras.setDate(3, new java.sql.Date(fecha.getTime()));
    // Asegúrate de tener la variable totalFactura definida y con un valor asignado
    insertCompras.setObject(4, totalFactura);
    insertCompras.setString(5, id);

    int filasAfectadasCompras = insertCompras.executeUpdate();

    // Obtener el ID generado para la compra
    int idCompraGenerado = -1;
    ResultSet rsCompras = insertCompras.getGeneratedKeys();
    if (rsCompras.next()) {
        idCompraGenerado = rsCompras.getInt(1);
    }

    // Inserción en la tabla DetallesCompras
    if (filasAfectadasCompras > 0) {
        PreparedStatement insertDetallesCompras = conn.prepareStatement("INSERT INTO DetallesCompras (id_compra, numfactura, tipoCategoria, fecha, total, id_proveedor) VALUES (?,?,?,?,?,?)");
        insertDetallesCompras.setInt(1, idCompraGenerado);
        insertDetallesCompras.setString(2, nunfactura);
        insertDetallesCompras.setString(3, tipo);
        insertDetallesCompras.setDate(4, new java.sql.Date(fecha.getTime()));
        // Asegúrate de tener la variable totalFactura definida y con un valor asignado
        insertDetallesCompras.setObject(5, totalFactura);
        insertDetallesCompras.setString(6, id);

        insertDetallesCompras.executeUpdate();
    }

    JOptionPane.showMessageDialog(null, "Registro guardado");

} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, e.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
} catch (ClassNotFoundException ex) {
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

    private void id_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_proveedorActionPerformed

    private void numFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFacturaActionPerformed
        
    }//GEN-LAST:event_numFacturaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(IngresodeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(IngresodeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(IngresodeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(IngresodeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresodeCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Tsum;
    private javax.swing.JButton btnAgregarproducto;
    private javax.swing.JButton btnguardar;
    public javax.swing.JTextField id_proveedor;
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
    public static javax.swing.JTable tablecompras;
    public javax.swing.JComboBox<String> tipoCompra;
    public javax.swing.JComboBox<String> txtProveedor;
    public com.toedter.calendar.JDateChooser txtfecha;
    // End of variables declaration//GEN-END:variables

    private boolean existeNumeroFactura(Connection conn, String nunfactura) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
