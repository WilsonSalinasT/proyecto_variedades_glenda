/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import App.IngresodeCompra;
import App.IngresodeVenta;
import static App.Menu.panelprincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import static java.time.Clock.offset;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author novastar
 */
public class Listado_de_Precios extends javax.swing.JPanel {

    TextPrompt holder;

    /**
     * Creates new form Nueva_venta
     */
    public Listado_de_Precios() {
        initComponents();
        cargarTabla();
        TextPrompt holder = new TextPrompt("Busque por producto /categoria/fecha", txtbuscar);

        tblcompras.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblcompras.getTableHeader().setOpaque(false);
        tblcompras.getTableHeader().setBackground(new Color(255, 0, 0));
        tblcompras.getTableHeader().setForeground(new Color(255, 0, 0));
        tblcompras.setRowHeight(25);

        tblcompras.setRowSelectionAllowed(true);
        tblcompras.setColumnSelectionAllowed(false);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcompras = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnrefrescar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        Contable_Registro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Historial de precios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tblcompras.setForeground(new java.awt.Color(0, 0, 0));
        tblcompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Producto", "Categoría", "Precio de compra(unitario)", "Precio de venta", "Fecha"
            }
        ));
        tblcompras.setGridColor(new java.awt.Color(255, 51, 51));
        tblcompras.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tblcompras.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblcompras.setShowHorizontalLines(true);
        tblcompras.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tblcompras);
        if (tblcompras.getColumnModel().getColumnCount() > 0) {
            tblcompras.getColumnModel().getColumn(0).setMinWidth(100);
            tblcompras.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblcompras.getColumnModel().getColumn(0).setMaxWidth(100);
            tblcompras.getColumnModel().getColumn(3).setResizable(false);
            tblcompras.getColumnModel().getColumn(5).setResizable(false);
        }

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnrefrescar.setBackground(new java.awt.Color(255, 153, 51));
        btnrefrescar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnrefrescar.setForeground(new java.awt.Color(0, 0, 0));
        btnrefrescar.setText("Refrescar");
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });

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

        Contable_Registro.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnrefrescar)
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Contable_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(574, 574, 574)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contable_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        paginaAnterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguientePagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String texto = txtbuscar.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty())
        {
            buscarDatos(texto);
        } else
        {
            JOptionPane.showMessageDialog(null, "Tiene que ingresar texto para hacer la respectiva búsqueda");
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed

        // Restablecer la página actual y el término de búsqueda
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        txtbuscar.setText("");

        // Cargar la tabla con los datos actualizados
        cargarTabla();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtbuscar.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (txtbuscar.getText().length() >= 100)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed

    }//GEN-LAST:event_txtbuscarActionPerformed

    int selectedRow2;
    int paginaActual = 1; // Página actual
    int filasPorPagina = 20; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla
    int numRegistro = 0;
    String terminoBusqueda = ""; // Término de búsqueda actual

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblcompras.getModel();
        modeloTabla.setRowCount(0); // Limpiar los datos existentes en la tabla

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Obtener el total de filas que cumplen con el criterio de búsqueda
            ps = conn.prepareStatement("SELECT COUNT(*) AS TotalFilas "
                    + " FROM PrecioHistorial ph "
                    + "JOIN Productos p ON ph.cod_producto = p.cod_producto\n"
                    + "JOIN Compras c ON ph.id_compra = c.id_compra Where p.nombre LIKE ? OR p.categoria Like ? OR c.fecha LIKE ?\n");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
            ps.setString(3, "%" + terminoBusqueda + "%");
          
            rs = ps.executeQuery();

            if (rs.next())
            {
                totalFilas = rs.getInt("TotalFilas");
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

            // Consulta para obtener los datos paginados
            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER (ORDER BY p.nombre) AS NumRegistro, p.nombre,p.categoria,\n"
                    + "    ph.precio_unitario,\n"
                    + "    ph.precio_venta,\n"
                    + "    c.fecha\n"
                    + "FROM PrecioHistorial ph\n"
                    + "JOIN Productos p ON ph.cod_producto = p.cod_producto\n"
                    + "JOIN Compras c ON ph.id_compra = c.id_compra Where p.nombre LIKE ? OR p.categoria Like ? OR c.fecha LIKE ?\n"
                    + "ORDER BY p.nombre\n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
            ps.setString(3, "%" + terminoBusqueda + "%");
            ps.setInt(4, offset);
            ps.setInt(5, filasPorPagina);
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
                foundData = true;
            }

            ajustarTabla(filasPorPagina);

            if (!foundData)
            {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
            }

            // Obtener el número de filas actualizado
            int rowCount = modeloTabla.getRowCount();
            Contable_Registro.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e)
        {
            e.printStackTrace(); // Imprime la pila de excepciones para depuración
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void ajustarTabla(int filasDeseadas) {
        tblcompras.setPreferredScrollableViewportSize(new Dimension(tblcompras.getPreferredSize().width, tblcompras.getRowHeight() * filasDeseadas));
        tblcompras.setFillsViewportHeight(true);
    }

    private void siguientePagina() {
        if (paginaActual < totalPaginas)
        {
            paginaActual++;
            cargarTabla();
        }
    }

    private void paginaAnterior() {
        if (paginaActual > 1)
        {
            paginaActual--;
            cargarTabla();
        }
    }

    private void buscarDatos(String texto) {
        DefaultTableModel modelTabla = (DefaultTableModel) tblcompras.getModel();
        modelTabla.setRowCount(0);
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            if (conn != null && !conn.isClosed())
            {
                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER (ORDER BY p.nombre) AS NumRegistro, p.nombre,p.categoria,\n"
                    + "    ph.precio_unitario,\n"
                    + "    ph.precio_venta,\n"
                    + "    c.fecha\n"
                    + "FROM PrecioHistorial ph\n"
                    + "JOIN Productos p ON ph.cod_producto = p.cod_producto\n"
                    + "JOIN Compras c ON ph.id_compra = c.id_compra Where p.nombre LIKE ? OR p.categoria Like ? OR c.fecha LIKE ?\n"
                    + "ORDER BY p.nombre\n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

                if (texto != null)
                {
                    ps.setString(1, "%" + texto + "%");
                    ps.setString(2, "%" + texto + "%");
                    ps.setString(3, "%" + texto + "%");
                   
                    terminoBusqueda = texto; // Actualizar el término de búsqueda
                } else
                {
                    ps.setString(1, "%");
                    ps.setString(2, "%");
                    ps.setString(3, "%");
                  
                    terminoBusqueda = ""; // Limpiar el término de búsqueda
                }

                // Define el OFFSET y FETCH NEXT de acuerdo a tus necesidades
                int offset = 0; // Cambia el valor del offset según tus requerimientos
                int fetchNext = 10; // Cambia la cantidad de registros a recuperar según tus requerimientos

                ps.setInt(4, offset);
                ps.setInt(5, fetchNext);

                ResultSet rs = ps.executeQuery();

                if (rs != null)
                {
                    while (rs.next())
                    {
                        int numRegistro = rs.getInt("NumRegistro");
                        String nombreCompleto = rs.getString("nombre");
                        String categoria = rs.getString("categoria");
                        String pU = rs.getString("precio_unitario");
                        String PV = rs.getString("precio_venta");
                        String fecha = rs.getString("fecha");
                        

                        if (nombreCompleto != null && categoria != null && pU != null && PV != null && fecha != null)
                        {
                            modelTabla.addRow(new Object[]
                            {
                                numRegistro, nombreCompleto, categoria, pU, PV, fecha
                            });
                            foundData = true;
                        }
                    }

                    rs.close();
                }

                ps.close();
                conn.close();
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        // Llama a la función de cargarTablaEmpleados() si es necesario recargar la tabla después de la búsqueda
        cargarTabla(); // Recargar la tabla después de la búsqueda
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contable_Registro;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcompras;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
