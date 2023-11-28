/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author novastar
 */
public class Inventario extends javax.swing.JPanel {

    int paginaActual = 1; // Página actual
    int filasPorPagina = 100; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla
    int numRegistro = 0;
    String terminoBusqueda = ""; // Término de búsqueda actual

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        cargarTablaEmpleados();

        tabla_inventario.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabla_inventario.getTableHeader().setOpaque(false);
        tabla_inventario.getTableHeader().setBackground(new Color(255, 0, 0));
        tabla_inventario.getTableHeader().setForeground(new Color(255, 0, 0));
        tabla_inventario.setRowHeight(25);

        tabla_inventario.setRowSelectionAllowed(true);
        tabla_inventario.setColumnSelectionAllowed(false);
    }

    private void cargarTablaEmpleados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla_inventario.getModel();
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
                    + "FROM Cliente E "
                    + "JOIN PedidoSastreria V ON E.id_cliente = V.id_cliente "
                    + "WHERE (E.nombre LIKE ? OR E.apellido LIKE ? OR V.fechaEntrega LIKE ?) and V.estado = 'pendiente' ");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
            ps.setString(3, "%" + terminoBusqueda + "%");
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

            // Consulta para obtener los datos paginados
            ps = conn.prepareStatement("SELECT \n"
                    + "    ROW_NUMBER() OVER (ORDER BY P.nombre) AS NumRegistro,\n"
                    + "   P.nombre,\n"
                    + "    P.categoria,\n"
                    + "    P.cantidad_disponible,\n"
                    + "    SUM(DC.cantidad_comprada) AS cantidad_comprada,\n"
                    + "    SUM(V.cantidad_vendida) AS cantidad_vendida "
                    + "FROM \n"
                    + "    Productos P "
                    + "LEFT JOIN\n"
                    + "    (\n"
                    + "        SELECT\n"
                    + "            cod_producto,\n"
                    + "            SUM(cantidad) AS cantidad_comprada\n"
                    + "        FROM\n"
                    + "            DetallesCompras DC\n"
                    + "        INNER JOIN\n"
                    + "            Compras co ON DC.id_compra = co.id_compra\n"
                    + "        GROUP BY\n"
                    + "            cod_producto\n"
                    + "    ) DC ON P.cod_producto = DC.cod_producto\n"
                    + "LEFT JOIN\n"
                    + "    (\n"
                    + "        SELECT\n"
                    + "            cod_producto,\n"
                    + "            SUM(cantidad_vendida) AS cantidad_vendida\n"
                    + "        FROM\n"
                    + "            DetallesVentas V\n"
                    + "        INNER JOIN\n"
                    + "            Ventas ve ON V.id_venta = ve.id_venta\n"
                    + "        GROUP BY\n"
                    + "            cod_producto\n"
                    + "    ) V ON P.cod_producto = V.cod_producto "
                    + "WHERE\n"
                    + "    P.nombre LIKE ? \n"
                    + "GROUP BY\n"
                    + "    P.nombre,\n"
                    + "    P.categoria,\n"
                    + "    P.cantidad_disponible\n"
                    + "ORDER BY \n"
                    + "    P.nombre\n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setString(1, "%" + terminoBusqueda + "%");
//            ps.setString(2, "%" + terminoBusqueda + "%");
//            ps.setString(3, "%" + terminoBusqueda + "%");
            ps.setInt(2, offset);
            ps.setInt(3, filasPorPagina);
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
//            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e)
        {
            e.printStackTrace(); // Imprime la pila de excepciones para depuración
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    private void ajustarTabla(int filasDeseadas) {
        tabla_inventario.setPreferredScrollableViewportSize(new Dimension(tabla_inventario.getPreferredSize().width, tabla_inventario.getRowHeight() * filasDeseadas));
        tabla_inventario.setFillsViewportHeight(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inventario = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel1.setText("Inventario de entradas y salidas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(236, 236, 236))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Producto", "Categoria", "Cantidad disponible", "Cantidad comprada", "cantidad vendida"
            }
        ));
        tabla_inventario.setShowHorizontalLines(true);
        tabla_inventario.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tabla_inventario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_inventario;
    // End of variables declaration//GEN-END:variables
}
