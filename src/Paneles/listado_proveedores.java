/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class listado_proveedores extends javax.swing.JPanel {

    int filasPorPagina = 20; // Cantidad de filas que se mostrarán en cada página
    int paginaActual = 1; // Página actual
    int totalPaginas = 1; // Total de páginas
    String terminoBusqueda = ""; // Término de búsqueda actual
    TextPrompt holder;

    /**
     * Creates new form Nueva_venta
     */
    public listado_proveedores() {
        initComponents();
        cargarTabla();
        TextPrompt holder = new TextPrompt("Busque por empresa/vendedor/número de la empresa", txtbuscar);

        tableProveedor.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableProveedor.getTableHeader().setOpaque(false);
        tableProveedor.getTableHeader().setBackground(new Color(255, 0, 0));
        tableProveedor.getTableHeader().setForeground(new Color(255, 0, 0));
        tableProveedor.setRowHeight(25);

        tableProveedor.setRowSelectionAllowed(true);
        tableProveedor.setColumnSelectionAllowed(false);
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
        tableProveedor = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btncrear = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnver = new javax.swing.JButton();
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
        jLabel2.setText("Listado de proveedores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(743, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tableProveedor.setForeground(new java.awt.Color(0, 0, 0));
        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Empresa", "Vendedor", "Número de la empresa", "dirección"
            }
        ));
        tableProveedor.setGridColor(new java.awt.Color(255, 51, 51));
        tableProveedor.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tableProveedor.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableProveedor.setShowHorizontalLines(true);
        tableProveedor.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableProveedor);
        if (tableProveedor.getColumnModel().getColumnCount() > 0) {
            tableProveedor.getColumnModel().getColumn(0).setMinWidth(100);
            tableProveedor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableProveedor.getColumnModel().getColumn(0).setMaxWidth(100);
            tableProveedor.getColumnModel().getColumn(2).setResizable(false);
            tableProveedor.getColumnModel().getColumn(4).setResizable(false);
        }

        btnbuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btncrear.setBackground(new java.awt.Color(255, 153, 51));
        btncrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncrear.setForeground(new java.awt.Color(0, 0, 0));
        btncrear.setText("Crear");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(255, 153, 51));
        btneditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btneditar.setForeground(new java.awt.Color(0, 0, 0));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnver.setBackground(new java.awt.Color(255, 153, 51));
        btnver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnver.setForeground(new java.awt.Color(0, 0, 0));
        btnver.setText("ver");
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrefrescar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Contable_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btncrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(btnver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnver)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contable_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        crear_proveedor p2 = new crear_proveedor();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btncrearActionPerformed

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
            JOptionPane.showMessageDialog(null, "El texto ingresado es erroneo");
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
    int selectedRow2;
    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        selectedRow2 = tableProveedor.getSelectedRow();
        if (selectedRow2 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor para poder editarlo");
            return;
        }

        try
        {

            int fila = tableProveedor.getSelectedRow();
            String valorCelda = tableProveedor.getValueAt(fila, 1).toString();
            String valorCelda2 = tableProveedor.getValueAt(fila, 2).toString();
            String valorCelda3 = tableProveedor.getValueAt(fila, 4).toString();
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT * FROM Proveedor WHERE nombreEmpresa=? and nombreProveedor=? and direccion=?");
            ps.setString(1, valorCelda);
            ps.setString(2, valorCelda2);
            ps.setString(3, valorCelda3);
            rs = ps.executeQuery();

            while (rs.next())
            {

                String nombreempresa = rs.getString("nombreEmpresa");
                String nombrevendedor = rs.getString("nombreProveedor");

                String email = rs.getString("correo");
                String tempresa = rs.getString("telefonoempresa");
                String tvendedor = rs.getString("telefonoproveedor");
                String direccion = rs.getString("direccion");
                
              
                String id = rs.getString("id_proveedor");

                editar_proveedor editar = new editar_proveedor();

                editar.txtempresa.setText(nombreempresa);
                editar.txtnombrevendedor.setText(nombrevendedor);
                editar.txtcorreo.setText(email);
                editar.txtnumeroempresa.setText(tempresa);
                editar.txtnumerovendedor.setText(tvendedor);
                editar.txtdire.setText(direccion);

                editar.txtid.setText(id);

                editar.setSize(1024, 640);
                editar.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(editar, BorderLayout.CENTER);

                panelprincipal.revalidate();
                panelprincipal.repaint();

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


    }//GEN-LAST:event_btneditarActionPerformed

    int selectedRow1;
    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
  // TODO add your handling code here:
        selectedRow1 = tableProveedor.getSelectedRow();
        if (selectedRow1 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor para poder visualizarlo");
            return;
        }

        try
        {

            int fila = tableProveedor.getSelectedRow();
            String valorCelda = tableProveedor.getValueAt(fila, 1).toString();
            String valorCelda2 = tableProveedor.getValueAt(fila, 2).toString();
            String valorCelda3 = tableProveedor.getValueAt(fila, 4).toString();
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT * FROM Proveedor WHERE nombreEmpresa=? and nombreProveedor=? and direccion=?");
            ps.setString(1, valorCelda);
            ps.setString(2, valorCelda2);
            ps.setString(3, valorCelda3);
            rs = ps.executeQuery();

            while (rs.next())
            {

                String nombreempresa = rs.getString("nombreEmpresa");
                String nombrevendedor = rs.getString("nombreProveedor");

                String email = rs.getString("correo");
                String tempresa = rs.getString("telefonoempresa");
                String tvendedor = rs.getString("telefonoproveedor");
                String direccion = rs.getString("direccion");
                
              
                String id = rs.getString("id_proveedor");

                ver_proveedor ver = new ver_proveedor();

                ver.txtempresa.setText(nombreempresa);
                ver.txtnombrevendedor.setText(nombrevendedor);
                ver.txtcorreo.setText(email);
                ver.txtnumeroempresa.setText(tempresa);
                ver.txtnumerovendedor.setText(tvendedor);
                ver.txtdire.setText(direccion);

                ver.txtid.setText(id);

                ver.setSize(1024, 640);
                ver.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(ver, BorderLayout.CENTER);

                panelprincipal.revalidate();
                panelprincipal.repaint();

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

    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tableProveedor.getModel();
        modeloTabla.setRowCount(0); // Limpiar los datos existentes en la tabla

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            ps = conn.prepareStatement("SELECT COUNT(*) AS TotalFilas FROM Proveedor WHERE nombreEmpresa LIKE ? OR nombreProveedor LIKE ? OR telefonoempresa LIKE ? ");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
            ps.setString(3, "%" + terminoBusqueda + "%");
            rs = ps.executeQuery();

            int cantidadFilas = 0;
            if (rs.next())
            {
                cantidadFilas = rs.getInt("TotalFilas");
            }

            totalPaginas = (int) Math.ceil((double) cantidadFilas / filasPorPagina);

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

            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY nombreEmpresa) AS NumRegistro, nombreEmpresa, nombreProveedor, telefonoempresa, direccion FROM Proveedor WHERE nombreEmpresa LIKE ? OR nombreProveedor LIKE ? OR telefonoempresa LIKE ? ORDER BY nombreEmpresa OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
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

            if (!foundData)
            {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
            }

            Contable_Registro.setText("Cantidad de filas: " + cantidadFilas + " - Página " + paginaActual + " de " + totalPaginas);
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void buscarDatos(String texto) {
        DefaultTableModel modelTabla = (DefaultTableModel) tableProveedor.getModel();
        modelTabla.setRowCount(0);
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            if (conn != null && !conn.isClosed())
            {
                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY nombreEmpresa) AS NumRegistro, nombreEmpresa, nombreProveedor, telefonoempresa, direccion FROM Proveedor WHERE nombreEmpresa LIKE ? OR nombreProveedor LIKE ? OR telefonoempresa LIKE ?");

                if (texto != null && !texto.isEmpty())
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

                ResultSet rs = ps.executeQuery();

                if (rs != null)
                {
                    while (rs.next())
                    {
                        int numRegistro = rs.getInt("NumRegistro");
                        String nombre = rs.getString("nombreEmpresa");
                        String Dni = rs.getString("nombreProveedor");
                        String departamento = rs.getString("telefonoempresa");
                        String deducciones = rs.getString("direccion");

                        if (nombre != null && Dni != null && departamento != null)
                        {
                            modelTabla.addRow(new Object[]
                            {
                                numRegistro, nombre, Dni, departamento, deducciones
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

        cargarTabla(); // Recargar la tabla después de la búsqueda
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contable_Registro;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncrear;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton btnver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProveedor;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
