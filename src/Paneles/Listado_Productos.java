/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Paneles.verProducto;
import Paneles.EditarProducto;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;

/**
 *
 * @author Fernando Amador
 */
public class Listado_Productos extends javax.swing.JPanel {

    int paginaActual = 1; // Página actual
    int filasPorPagina = 18; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla

    /**
     * Creates new form Listado_Productos
     */
    public Listado_Productos() {
        initComponents();
        cargarTablaProductos();

        tabla_productos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabla_productos.getTableHeader().setOpaque(false);
        tabla_productos.getTableHeader().setBackground(new Color(255, 0, 0));
        tabla_productos.getTableHeader().setForeground(new Color(255, 0, 0));
        tabla_productos.setRowHeight(25);

        tabla_productos.setRowSelectionAllowed(true);
        tabla_productos.setColumnSelectionAllowed(false);

    }

    public void verProducto() {
        producto verProducto = new producto();
        verProducto.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        btn_refrescar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Texto_Contable = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Crear Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnver.setBackground(new java.awt.Color(255, 153, 51));
        btnver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnver.setForeground(new java.awt.Color(0, 0, 0));
        btnver.setText("Ver");
        btnver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnverMouseClicked(evt);
            }
        });
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Listado de productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
        );

        tabla_productos.setForeground(new java.awt.Color(0, 0, 0));
        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre", "Descripción", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_productos.setGridColor(new java.awt.Color(255, 51, 51));
        tabla_productos.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla_productos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabla_productos.setShowHorizontalLines(true);
        tabla_productos.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tabla_productos);
        if (tabla_productos.getColumnModel().getColumnCount() > 0) {
            tabla_productos.getColumnModel().getColumn(0).setResizable(false);
            tabla_productos.getColumnModel().getColumn(1).setResizable(false);
            tabla_productos.getColumnModel().getColumn(2).setResizable(false);
            tabla_productos.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar:");

        txtbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusquedaActionPerformed(evt);
            }
        });

        btn_buscar.setBackground(new java.awt.Color(255, 153, 51));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 0, 0));
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "sastreria", "sublimación", "arreglos" }));

        btn_refrescar.setBackground(new java.awt.Color(255, 153, 51));
        btn_refrescar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_refrescar.setForeground(new java.awt.Color(0, 0, 0));
        btn_refrescar.setText("Refrescar");
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Categoria:");

        Texto_Contable.setText("0");

        btnAnterior.setBackground(new java.awt.Color(255, 102, 102));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/previous.png"))); // NOI18N
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(255, 102, 102));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(255, 153, 51));
        btneditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditar.setForeground(new java.awt.Color(0, 0, 0));
        btneditar.setText("Editar");
        btneditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditarMouseClicked(evt);
            }
        });
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_refrescar)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnver, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_refrescar)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btneditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnver))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CrearProducto p1 = new CrearProducto();
        p1.setSize(1024, 640);
        p1.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(p1, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusquedaActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String texto = txtbusqueda.getText().trim();

        buscarDatos(texto);

        //Validacion del texto ingresado
        /*if (!texto.isEmpty()) {
            buscarDatos(texto);
        } else {
            JOptionPane.showMessageDialog(null, "El texto ingresado es erroneo");
        }*/
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        txtbusqueda.setText("");
        btnAnterior.setEnabled(true);
        btnSiguiente.setEnabled(true);

        // Cargar la tabla con los datos actualizados
        cargarTablaProductos();
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        paginaAnteriores();

    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguientePaginario();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    int selectedRow1;
    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
//        // Obtener la fila seleccionada
//        int filaSeleccionada = tabla_productos.getSelectedRow();
//
//        // Verificar si se ha seleccionado una fila
//        if (filaSeleccionada >= 0)
//        {
//            // Obtener los valores de las celdas en la fila seleccionada
//            Object idProducto = tabla_productos.getValueAt(filaSeleccionada, 0); // Supongamos que la columna 0 contiene el ID del producto
//            Object nombreProducto = tabla_productos.getValueAt(filaSeleccionada, 1); // Supongamos que la columna 1 contiene el nombre del producto
//            Object precioProducto = tabla_productos.getValueAt(filaSeleccionada, 2); // Supongamos que la columna 2 contiene el precio del producto
//
//            // Luego puedes usar estos valores como desees, por ejemplo, para pasarlos a la ventana verProducto
//            verProducto p2 = new verProducto();
//            p2.setSize(1024, 640);
//            p2.setLocation(0, 0);
//
//            // Puedes pasar los datos recuperados a la ventana verProducto
//            p2.mostrarDatos(idProducto, nombreProducto, precioProducto);
//
//            // Remover el contenido actual del panel principal
//            panelprincipal.removeAll();
//
//            // Agregar la ventana verProducto al panel principal
//            panelprincipal.add(p2, BorderLayout.CENTER);
//
//            // Revalidar y repintar el panel principal para mostrar la nueva ventana
//            panelprincipal.revalidate();
//            panelprincipal.repaint();
//        }

       selectedRow1 = tabla_productos.getSelectedRow();
if (selectedRow1 == -1)
{
    JOptionPane.showMessageDialog(null, "Seleccione un producto para poder visualizarlo");
    return;
}

try
{

    int fila = tabla_productos.getSelectedRow();
    String valorCelda = tabla_productos.getValueAt(fila, 1).toString();
    String valorCelda2 = tabla_productos.getValueAt(fila, 2).toString();
    String valorCelda3 = tabla_productos.getValueAt(fila, 3).toString();
    PreparedStatement ps;
    ResultSet rs;

    Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
    ps = conn.prepareStatement("SELECT * FROM Producto WHERE nombre=? and descripcion=? and categoria=?");
    ps.setString(1, valorCelda);
    ps.setString(2, valorCelda2);
    ps.setString(3, valorCelda3);
    rs = ps.executeQuery();

    while (rs.next())
    {

        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");

    
        String categoria = rs.getString("categoria");

        String Id = rs.getString("cod_producto");

        verProducto mostrar = new verProducto();

        mostrar.txtNombre.setText(nombre);
        mostrar.txtNombre.setEditable(false); // Establece el campo de texto como no editable

        mostrar.AreaDescripcion.setText(descripcion);
        mostrar.AreaDescripcion.setEditable(false); // Establece el área de texto como no editable

//        mostrar.txtExistencia.setText(existencias);
//        mostrar.txtExistencia.setEditable(false); // Establece el campo de texto como no editable

//        mostrar.txtPrecio.setText(precio);
//        mostrar.txtPrecio.setEditable(false); // Establece el campo de texto como no editable

        mostrar.txtCategoria.setText(categoria);
        mostrar.txtCategoria.setEditable(false); // Establece el campo de texto como no editable

//        mostrar.txtProveedor.setText(proveedor);
//        mostrar.txtProveedor.setEditable(false); // Establece el campo de texto como no editable

//        mostrar.txtFechaAdquision.setText(fecha);
//        mostrar.txtFechaAdquision.setEditable(false); // Establece el campo de texto como no editable

        mostrar.txtId.setText(Id);
        mostrar.txtId.setEditable(false); // Establece el campo de texto como no editable

        mostrar.setSize(1024, 640);
        mostrar.setLocation(0, 0);

        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.removeAll();
        jPanel2.add(mostrar, BorderLayout.CENTER);

        jPanel2.revalidate();
        jPanel2.repaint();

        break; // Salir del bucle después de encontrar el elemento seleccionado

    }

    rs.close();
    ps.close();
    conn.close();

} catch (SQLException e)
{
    e.printStackTrace();
    // Manejar cualquier excepción que pueda ocurrir durante la consulta a la base de datos
}


    }//GEN-LAST:event_btnverActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
   
  selectedRow1 = tabla_productos.getSelectedRow();
if (selectedRow1 == -1) {
    JOptionPane.showMessageDialog(null, "Seleccione un producto para poder editarlo");
    return;
}

try {
    int fila = tabla_productos.getSelectedRow();
    String valorCelda = tabla_productos.getValueAt(fila, 1).toString();
    String valorCelda2 = tabla_productos.getValueAt(fila, 2).toString();
    String valorCelda3 = tabla_productos.getValueAt(fila, 3).toString();

    // Verificar que todos los campos sean obligatorios
    if (valorCelda.isEmpty() || valorCelda2.isEmpty() || valorCelda3.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, completa todos los campos antes de actualizar.");
        return;
    }

    // Crear una conexión y un PreparedStatement usando try-with-resources
    try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM Producto WHERE nombre=? AND descripcion=? AND categoria=?")) {

        ps.setString(1, valorCelda);
        ps.setString(2, valorCelda2);
        ps.setString(3, valorCelda3);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
  
                String Id = rs.getString("cod_producto");

                EditarProducto mostrar = new EditarProducto();
                mostrar.txtnombre.setText(nombre);
                mostrar.txtdescripcion.setText(descripcion);
               mostrar.jComboBox1.setSelectedItem(rs.getString("categoria"));

                mostrar.txtId.setText(Id);

                mostrar.setSize(1024, 640);
                mostrar.setLocation(0, 0);

                jPanel2.revalidate();
                jPanel2.repaint();
                jPanel2.removeAll();
                jPanel2.add(mostrar, BorderLayout.CENTER);

                jPanel2.revalidate();
                jPanel2.repaint();
            }
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
}

    }//GEN-LAST:event_btneditarActionPerformed

    private void btneditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarMouseClicked

    private void btnverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnverMouseClicked
        // Obtener la fila seleccionada
        int filaSeleccionada = tabla_productos.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (filaSeleccionada >= 0)
        {
            // Crear una instancia de la ventana verProducto
            verProducto p2 = new verProducto();
            p2.setSize(1024, 640);
            p2.setLocation(0, 0);

            // Remover el contenido actual del panel principal
            panelprincipal.removeAll();

            // Agregar la ventana verProducto al panel principal
            panelprincipal.add(p2, BorderLayout.CENTER);

            // Revalidar y repintar el panel principal para mostrar la nueva ventana
            panelprincipal.revalidate();
            panelprincipal.repaint();
        }
    }//GEN-LAST:event_btnverMouseClicked

    String terminoBusqueda = ""; // Término de búsqueda actual

    private void cargarTablaProductos() {

        DefaultTableModel modeloTabla = (DefaultTableModel) tabla_productos.getModel();

        modeloTabla.setRowCount(0); // Eliminar las filas existentes

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Consulta para contar el número total de filas
            ps = conn.prepareStatement("SELECT COUNT(*) FROM Producto");
            rs = ps.executeQuery();
            if (rs.next())
            {
                totalFilas = rs.getInt(1);
            }
            totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);

            if (paginaActual < 1)
            {
                paginaActual = 1;
            } else if (paginaActual > totalPaginas)
            {
                paginaActual = totalPaginas;
            }

            int offset = (paginaActual - 1) * filasPorPagina;
            if (offset < 0)
            {
                offset = 0;
            }

            // Consulta principal con paginación
            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY cod_producto) AS NumRegistro, nombre, descripcion, categoria "
                    + "FROM Producto ORDER BY cod_producto OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setInt(1, offset);
            ps.setInt(2, filasPorPagina);
            rs = ps.executeQuery();

            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next())
            {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++)
                {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

            ajustarTabla(filasPorPagina);

            // Eliminar filas vacías del modelo
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--)
            {
                boolean isEmptyRow = true;
                for (int j = 0; j < modeloTabla.getColumnCount(); j++)
                {
                    Object value = modeloTabla.getValueAt(i, j);
                    if (value != null && !value.toString().isEmpty())
                    {
                        isEmptyRow = false;
                        break;
                    }
                }
                if (isEmptyRow)
                {
                    modeloTabla.removeRow(i);
                }
            }

            // Obtener el número de filas actualizado
            int rowCount = modeloTabla.getRowCount();
            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    private void buscarDatos(String texto) {
        DefaultTableModel modelTabla = (DefaultTableModel) tabla_productos.getModel();
        modelTabla.setRowCount(0); // Limpia el modelo de la tabla antes de agregar nuevos datos
        boolean foundData = false;

        String categoriaSeleccionada = comboBoxCategoria.getSelectedItem().toString();

        // Consulta SQL principal
        String sqlQuery;
        if ("Todas".equals(categoriaSeleccionada))
        {
            sqlQuery = "SELECT ROW_NUMBER() OVER(ORDER BY cod_producto) AS NumRegistro, nombre, descripcion, categoria"
                    + " FROM Producto WHERE nombre LIKE ? OR descripcion LIKE ?";
        } else
        {
            sqlQuery = "SELECT ROW_NUMBER() OVER(ORDER BY cod_producto) AS NumRegistro, nombre, descripcion, categoria"
                    + " FROM Producto WHERE categoria = ? AND (nombre LIKE ? OR descripcion LIKE ?)";
        }

        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789"); PreparedStatement ps = conn.prepareStatement(sqlQuery))
        {

            // Configurar los parámetros de la consulta
            if (!"Todas".equals(categoriaSeleccionada))
            {
                ps.setString(1, categoriaSeleccionada);
                ps.setString(2, "%" + texto + "%");
                ps.setString(3, "%" + texto + "%");
            } else
            {
                ps.setString(1, "%" + texto + "%");
                ps.setString(2, "%" + texto + "%");
            }

            try (ResultSet rs = ps.executeQuery())
            {
                while (rs.next())
                {
                    int numRegistro = rs.getInt("NumRegistro");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    String categoria = rs.getString("categoria");

                    if (nombre != null && descripcion != null && categoria != null)
                    {
                        modelTabla.addRow(new Object[]
                        {
                            numRegistro, nombre, descripcion, categoria
                        });
                        foundData = true;
                    }
                }
            }

            // Actualiza el número de filas en tu interfaz gráfica aquí
            int rowCount = modelTabla.getRowCount();
            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + (rowCount > 0 ? "1/1" : "0/0"));

            // Bloquea o desbloquea los botones de paginación según sea necesario
            if (rowCount <= filasPorPagina)
            {
                // Si hay una página o menos, bloquea los botones de paginación
                btnAnterior.setEnabled(false);
                btnSiguiente.setEnabled(false);
            } else
            {
                // Si hay más de una página, habilita los botones de paginación
                btnAnterior.setEnabled(true);
                btnSiguiente.setEnabled(true);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar datos: " + e.getMessage());
        }

        // Si no se encontraron datos, puedes mostrar un mensaje de advertencia
        if (!foundData)
        {
            JOptionPane.showMessageDialog(null, "No se encontraron datos.");
        }
    }

    private void ajustarTabla(int filasDeseadas) {
        tabla_productos.setPreferredScrollableViewportSize(new Dimension(tabla_productos.getPreferredSize().width, tabla_productos.getRowHeight() * filasDeseadas));
        tabla_productos.setFillsViewportHeight(true);
    }

    private void siguientePaginario() {
        if (paginaActual < totalPaginas)
        {
            paginaActual++;

            cargarTablaProductos();

        }
    }

    private void paginaAnteriores() {
        if (paginaActual > 1)
        {
            paginaActual--;

            cargarTablaProductos();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Texto_Contable;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnver;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables

    private static class producto {

        public producto() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

       

    
}

    
}
