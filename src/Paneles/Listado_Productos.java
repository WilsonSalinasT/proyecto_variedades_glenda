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

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setText("Crear Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnver.setBackground(new java.awt.Color(153, 255, 153));
        btnver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnver.setForeground(new java.awt.Color(0, 0, 0));
        btnver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver (1).png"))); // NOI18N
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

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        jScrollPane1.setViewportView(tabla_productos);
        if (tabla_productos.getColumnModel().getColumnCount() > 0) {
            tabla_productos.getColumnModel().getColumn(0).setResizable(false);
            tabla_productos.getColumnModel().getColumn(1).setResizable(false);
            tabla_productos.getColumnModel().getColumn(2).setResizable(false);
            tabla_productos.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Buscar:");

        txtbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusquedaActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "sastreria", "sublimacion", "arreglos" }));

        btn_refrescar.setText("Refrescar");
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Categoria:");

        Texto_Contable.setText("0");

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(153, 255, 153));
        btneditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneditar.setForeground(new java.awt.Color(0, 0, 0));
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-codigo.png"))); // NOI18N
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
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_buscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_refrescar)
                            .addGap(73, 73, 73)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnver, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
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
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(24, 24, 24)
                        .addComponent(btneditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnver))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
    // Obtener la fila seleccionada
    int filaSeleccionada = tabla_productos.getSelectedRow();
    
    // Verificar si se ha seleccionado una fila
    if (filaSeleccionada >= 0) {
        // Obtener los valores de las celdas en la fila seleccionada
        Object idProducto = tabla_productos.getValueAt(filaSeleccionada, 0); // Supongamos que la columna 0 contiene el ID del producto
        Object nombreProducto = tabla_productos.getValueAt(filaSeleccionada, 1); // Supongamos que la columna 1 contiene el nombre del producto
        Object precioProducto = tabla_productos.getValueAt(filaSeleccionada, 2); // Supongamos que la columna 2 contiene el precio del producto
        
        // Luego puedes usar estos valores como desees, por ejemplo, para pasarlos a la ventana verProducto
        verProducto p2 = new verProducto();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        // Puedes pasar los datos recuperados a la ventana verProducto
        p2.mostrarDatos(idProducto, nombreProducto, precioProducto);

        // Remover el contenido actual del panel principal
        panelprincipal.removeAll();

        // Agregar la ventana verProducto al panel principal
        panelprincipal.add(p2, BorderLayout.CENTER);

        // Revalidar y repintar el panel principal para mostrar la nueva ventana
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }
    }//GEN-LAST:event_btnverActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
       EditarProducto p2 = new EditarProducto();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarMouseClicked

    private void btnverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnverMouseClicked
        // Obtener la fila seleccionada
    int filaSeleccionada = tabla_productos.getSelectedRow();
    
    // Verificar si se ha seleccionado una fila
    if (filaSeleccionada >= 0) {
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

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Consulta para contar el número total de filas
            ps = conn.prepareStatement("SELECT COUNT(*) FROM Producto");
            rs = ps.executeQuery();
            if (rs.next()) {
                totalFilas = rs.getInt(1);
            }
            totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);

            if (paginaActual < 1) {
                paginaActual = 1;
            } else if (paginaActual > totalPaginas) {
                paginaActual = totalPaginas;
            }

            int offset = (paginaActual - 1) * filasPorPagina;
            if (offset < 0) {
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

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

            ajustarTabla(filasPorPagina);

            // Eliminar filas vacías del modelo
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                boolean isEmptyRow = true;
                for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                    Object value = modeloTabla.getValueAt(i, j);
                    if (value != null && !value.toString().isEmpty()) {
                        isEmptyRow = false;
                        break;
                    }
                }
                if (isEmptyRow) {
                    modeloTabla.removeRow(i);
                }
            }

            // Obtener el número de filas actualizado
            int rowCount = modeloTabla.getRowCount();
            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e) {
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
        if ("Todas".equals(categoriaSeleccionada)) {
            sqlQuery = "SELECT ROW_NUMBER() OVER(ORDER BY cod_producto) AS NumRegistro, nombre, descripcion, categoria"
                    + " FROM Producto WHERE nombre LIKE ? OR descripcion LIKE ?";
        } else {
            sqlQuery = "SELECT ROW_NUMBER() OVER(ORDER BY cod_producto) AS NumRegistro, nombre, descripcion, categoria"
                    + " FROM Producto WHERE categoria = ? AND (nombre LIKE ? OR descripcion LIKE ?)";
        }

        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789"); PreparedStatement ps = conn.prepareStatement(sqlQuery)) {

            // Configurar los parámetros de la consulta
            if (!"Todas".equals(categoriaSeleccionada)) {
                ps.setString(1, categoriaSeleccionada);
                ps.setString(2, "%" + texto + "%");
                ps.setString(3, "%" + texto + "%");
            } else {
                ps.setString(1, "%" + texto + "%");
                ps.setString(2, "%" + texto + "%");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int numRegistro = rs.getInt("NumRegistro");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    String categoria = rs.getString("categoria");

                    if (nombre != null && descripcion != null && categoria != null) {
                        modelTabla.addRow(new Object[]{numRegistro, nombre, descripcion, categoria});
                        foundData = true;
                    }
                }
            }

            // Actualiza el número de filas en tu interfaz gráfica aquí
            int rowCount = modelTabla.getRowCount();
            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + (rowCount > 0 ? "1/1" : "0/0"));

            // Bloquea o desbloquea los botones de paginación según sea necesario
            if (rowCount <= filasPorPagina) {
                // Si hay una página o menos, bloquea los botones de paginación
                btnAnterior.setEnabled(false);
                btnSiguiente.setEnabled(false);
            } else {
                // Si hay más de una página, habilita los botones de paginación
                btnAnterior.setEnabled(true);
                btnSiguiente.setEnabled(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar datos: " + e.getMessage());
        }

        // Si no se encontraron datos, puedes mostrar un mensaje de advertencia
        if (!foundData) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos.");
        }
    }

    private void ajustarTabla(int filasDeseadas) {
        tabla_productos.setPreferredScrollableViewportSize(new Dimension(tabla_productos.getPreferredSize().width, tabla_productos.getRowHeight() * filasDeseadas));
        tabla_productos.setFillsViewportHeight(true);
    }

    private void siguientePaginario() {
        if (paginaActual < totalPaginas) {
            paginaActual++;

            cargarTablaProductos();

        }
    }

    private void paginaAnteriores() {
        if (paginaActual > 1) {
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

    private static class EditarProductoVentana {

        public EditarProductoVentana() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
