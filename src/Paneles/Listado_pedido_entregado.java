/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Listado_pedido_entregado extends javax.swing.JPanel {

    int selectedRow;
    TextPrompt holder;

    /**
     * Creates new form Listado_Empleados
     */
    public Listado_pedido_entregado() {
        initComponents();
         cargarTablapedidoentregado();

        holder = new TextPrompt("Busque por nombre / fecha de entrega", txtBuscar);

        tblpedido.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblpedido.getTableHeader().setOpaque(false);
        tblpedido.getTableHeader().setBackground(new Color(255, 0, 0));
        tblpedido.getTableHeader().setForeground(new Color(255, 0, 0));
        tblpedido.setRowHeight(25);

        tblpedido.setRowSelectionAllowed(true);
        tblpedido.setColumnSelectionAllowed(false);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        crearbtn = new javax.swing.JButton();
        editarbtn = new javax.swing.JButton();
        verbtn = new javax.swing.JButton();
        Texto_Buscar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpedido = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        Btn_Buscar = new javax.swing.JButton();
        refrescarbtn = new javax.swing.JButton();
        Texto_Contable = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Listado de pedidos entregado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        crearbtn.setBackground(new java.awt.Color(255, 153, 51));
        crearbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        crearbtn.setForeground(new java.awt.Color(0, 0, 0));
        crearbtn.setText("CREAR");
        crearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearbtnActionPerformed(evt);
            }
        });

        editarbtn.setBackground(new java.awt.Color(255, 153, 51));
        editarbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editarbtn.setForeground(new java.awt.Color(0, 0, 0));
        editarbtn.setText("EDITAR");
        editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarbtnActionPerformed(evt);
            }
        });

        verbtn.setBackground(new java.awt.Color(255, 153, 51));
        verbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        verbtn.setForeground(new java.awt.Color(0, 0, 0));
        verbtn.setText("VER");
        verbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(verbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(crearbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editarbtn)
                .addGap(18, 18, 18)
                .addComponent(verbtn)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        Texto_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Texto_Buscar.setText("Buscar:");

        tblpedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre del Cliente", "Apellido de Cliente", "Estado Pedido", "Descripcion", "Fecha Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpedido.setGridColor(new java.awt.Color(255, 51, 51));
        tblpedido.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tblpedido.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblpedido.setShowHorizontalLines(true);
        tblpedido.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tblpedido);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        Btn_Buscar.setBackground(new java.awt.Color(255, 153, 51));
        Btn_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Buscar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        refrescarbtn.setBackground(new java.awt.Color(255, 153, 51));
        refrescarbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refrescarbtn.setForeground(new java.awt.Color(0, 0, 0));
        refrescarbtn.setText("Refrescar");
        refrescarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarbtnActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(Texto_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refrescarbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 187, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Texto_Buscar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refrescarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
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

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        String texto = txtBuscar.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty())
        {
           buscarDatos(texto);
        } else
        {
            JOptionPane.showMessageDialog(null, "El texto ingresado es erroneo");
        }
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void refrescarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarbtnActionPerformed
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        txtBuscar.setText("");

        // Cargar la tabla con los datos actualizados
         cargarTablapedidoentregado();
    }//GEN-LAST:event_refrescarbtnActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        paginaAnterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguientePagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void crearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearbtnActionPerformed
        // TODO add your handling code here:
        Crear_Empleado p2 = new Crear_Empleado();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_crearbtnActionPerformed

    private void verbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verbtnActionPerformed

        
    }//GEN-LAST:event_verbtnActionPerformed

    private void editarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarbtnActionPerformed
      
    }//GEN-LAST:event_editarbtnActionPerformed


    int paginaActual = 1; // Página actual
    int filasPorPagina = 20; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla
    int numRegistro = 0;
    String terminoBusqueda = ""; // Término de búsqueda actual

    private void cargarTablapedidoentregado() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblpedido.getModel();
        modeloTabla.setRowCount(0); // Eliminar las filas existentes

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Consulta para contar el número total de filas
            ps = conn.prepareStatement("SELECT COUNT(*) FROM PedidoEntregado");
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

ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER (ORDER BY P.id_pedido) AS NumRegistro, C.nombre AS Nombre, C.apellido AS Apellido, P.estadoPedido, P.descripcion, P.fechaEntrega "
        + "FROM Cliente C "
        + "JOIN ("
        + "    SELECT id_cliente, id_pedido, estadoPedido, descripcion, fechaEntrega FROM PedidoEntregado "
        + "    UNION ALL "
        + "    SELECT id_cliente, id_pedido, estado, descripcion, fechaPedido FROM PedidoArreglo "
        + "    UNION ALL "
        + "    SELECT id_cliente, id_sastreria, estado, descripcion, fechaPedido FROM PedidoSastreria "
        + "    UNION ALL "
        + "    SELECT id_cliente, id_pedido, estado, descripcion, fechaPedido FROM PedidoSublimacion "
        + ") AS P ON C.id_cliente = P.id_cliente "
        + "WHERE P.estadoPedido = 'Entregado' "
        + "ORDER BY NumRegistro OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

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

    private void ajustarTabla(int filasDeseadas) {
        tblpedido.setPreferredScrollableViewportSize(new Dimension(tblpedido.getPreferredSize().width, tblpedido.getRowHeight() * filasDeseadas));
        tblpedido.setFillsViewportHeight(true);
    }

    private void siguientePagina() {
        if (paginaActual < totalPaginas) {
            paginaActual++;
            cargarTablapedidoentregado();
        }
    }

    private void paginaAnterior() {
        if (paginaActual > 1) {
            paginaActual--;
             cargarTablapedidoentregado();
        }
    }



             private void buscarDatos(String texto) {
    DefaultTableModel modelTabla = (DefaultTableModel) tblpedido.getModel();
    modelTabla.setRowCount(0);
    boolean foundData = false;

    try {
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
        if (conn != null && !conn.isClosed()) {
            PreparedStatement ps;
            ResultSet rs;

            if (!texto.isEmpty()) {
                // Consulta para contar el número total de filas que cumplen con los criterios de búsqueda
                ps = conn.prepareStatement("SELECT COUNT(*) " +
                        "FROM Cliente E " +
                        "JOIN PedidoEntregado V ON E.id_cliente = V.id_cliente " +
                        "WHERE E.nombre LIKE ? OR E.apellido LIKE ? OR V.fechaEntrega LIKE ?");

                ps.setString(1, "%" + texto + "%");
                ps.setString(2, "%" + texto + "%");
                ps.setString(3, "%" + texto + "%");

                rs = ps.executeQuery();
                if (rs.next()) {
                    totalFilas = rs.getInt(1);
                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                }
                ps.close();

                // Consulta principal con paginación y criterios de búsqueda
                ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY E.nombre) AS NumRegistro, E.nombre, E.apellido, V.estadoPedido, V.descripcion, V.fechaEntrega " +
                        "FROM Cliente E " +
                        "JOIN PedidoEntregado V ON E.id_cliente = V.id_cliente " +
                        "WHERE E.nombre LIKE ? OR E.apellido LIKE ? OR V.fechaEntrega LIKE ? " +
                        "ORDER BY E.nombre " +
                        "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

                ps.setString(1, "%" + texto + "%");
                ps.setString(2, "%" + texto + "%");
                ps.setString(3, "%" + texto + "%");
                ps.setInt(4, (paginaActual - 1) * filasPorPagina);
                ps.setInt(5, filasPorPagina);
            } else {
                // Consulta sin criterios de búsqueda
                ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY E.nombre) AS NumRegistro, E.nombre, E.apellido, V.estadoPedido, V.descripcion, V.fechaEntrega " +
                        "FROM Cliente E " +
                        "JOIN PedidoEntregado V ON E.id_cliente = V.id_cliente " +
                        "ORDER BY E.nombre " +
                        "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

                ps.setInt(1, (paginaActual - 1) * filasPorPagina);
                ps.setInt(2, filasPorPagina);
            }

            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int numRegistro = rs.getInt("NumRegistro");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String estadoPedido = rs.getString("estadoPedido");
                    String descripcion = rs.getString("descripcion");
                    String fechaEntrega = rs.getString("fechaEntrega");

                    if (nombre != null && apellido != null && estadoPedido != null) {
                        modelTabla.addRow(new Object[]{
                            numRegistro, nombre, apellido, estadoPedido, descripcion, fechaEntrega
                        });
                        foundData = true;
                    }
                }

                rs.close();
            }

            ps.close();
            conn.close();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }

    // Actualiza la etiqueta de paginación
    Texto_Contable.setText("Cantidad de filas: " + totalFilas + " - Página " + paginaActual + "/" + totalPaginas);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_Buscar;
    private javax.swing.JLabel Texto_Buscar;
    private javax.swing.JLabel Texto_Contable;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton crearbtn;
    private javax.swing.JButton editarbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refrescarbtn;
    private javax.swing.JTable tblpedido;
    public javax.swing.JTextField txtBuscar;
    private javax.swing.JButton verbtn;
    // End of variables declaration//GEN-END:variables

    private void buscarDatosPorNombre(String nombreBuscado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    }
