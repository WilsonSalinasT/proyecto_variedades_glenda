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
        TextPrompt holder = new TextPrompt("Busque por nombre/apellido", txtbuscar);

        tableClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableClientes.getTableHeader().setOpaque(false);
        tableClientes.getTableHeader().setBackground(new Color(255, 0, 0));
        tableClientes.getTableHeader().setForeground(new Color(255, 0, 0));
        tableClientes.setRowHeight(25);

        tableClientes.setRowSelectionAllowed(true);
        tableClientes.setColumnSelectionAllowed(false);
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
        tableClientes = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
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

        tableClientes.setForeground(new java.awt.Color(0, 0, 0));
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "nombre", "apellido", "teléfono", "Nombre compañía"
            }
        ));
        tableClientes.setGridColor(new java.awt.Color(255, 51, 51));
        tableClientes.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tableClientes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableClientes.setShowHorizontalLines(true);
        tableClientes.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableClientes);
        if (tableClientes.getColumnModel().getColumnCount() > 0) {
            tableClientes.getColumnModel().getColumn(0).setMinWidth(100);
            tableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableClientes.getColumnModel().getColumn(0).setMaxWidth(100);
            tableClientes.getColumnModel().getColumn(2).setResizable(false);
            tableClientes.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 153, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("ver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 153, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Refrescar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addGap(114, 114, 114)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton5))
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
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contable_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        crear_proveedor p2 = new crear_proveedor();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        paginaAnterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguientePagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String texto = txtbuscar.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty())
        {
            buscarDatos(texto);
        } else
        {
            JOptionPane.showMessageDialog(null, "El texto ingresado es erroneo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        // Restablecer la página actual y el término de búsqueda
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        txtbuscar.setText("");

        // Cargar la tabla con los datos actualizados
        cargarTabla();
    }//GEN-LAST:event_jButton5ActionPerformed
    int selectedRow2;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        selectedRow2 = tableClientes.getSelectedRow();
        if (selectedRow2 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor para poder editarlo");
            return;
        }

        try
        {

            int fila = tableClientes.getSelectedRow();
            String valorCelda = tableClientes.getValueAt(fila, 1).toString();
            String valorCelda2 = tableClientes.getValueAt(fila, 2).toString();
            String valorCelda3 = tableClientes.getValueAt(fila, 4).toString();
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT * FROM Proveedor WHERE primer_nombre=? and primer_apellido=? and nombre_compan=?");
            ps.setString(1, valorCelda);
            ps.setString(2, valorCelda2);
            ps.setString(3, valorCelda3);
            rs = ps.executeQuery();

            while (rs.next())
            {

                String nombre1 = rs.getString("primer_nombre");
                String nombre2 = rs.getString("segundo_nombre");

                String apellido1 = rs.getString("primer_apellido");
                String apellido2 = rs.getString("segundo_apellido");
                String nombrecompania = rs.getString("nombre_compan");
                String correo = rs.getString("correo");
                
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String id = rs.getString("id_proveedor");

                editar_proveedor editar = new editar_proveedor();

                editar.txt1nom.setText(nombre1);
                editar.txt2nom.setText(nombre2);
                editar.txt1ape.setText(apellido1);
                editar.txt2ape.setText(apellido2);
                editar.txtcompan.setText(nombrecompania);
                editar.txtcorreo.setText(correo);
                editar.txttel.setText(telefono);
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


    }//GEN-LAST:event_jButton3ActionPerformed

    int selectedRow1;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        selectedRow1 = tableClientes.getSelectedRow();
//        if (selectedRow1 == -1)
//        {
//            JOptionPane.showMessageDialog(null, "Seleccione un cliente para poder visualizarlo");
//            return;
//        }
//
//        try
//        {
//
//            int fila = tableClientes.getSelectedRow();
//            String valorCelda = tableClientes.getValueAt(fila, 1).toString();
//            String valorCelda2 = tableClientes.getValueAt(fila, 2).toString();
//            String valorCelda3 = tableClientes.getValueAt(fila, 4).toString();
//            PreparedStatement ps;
//            ResultSet rs;
//
//            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//            ps = conn.prepareStatement("SELECT * FROM Cliente WHERE nombre=? and apellido=? and correo_electronico=?");
//            ps.setString(1, valorCelda);
//            ps.setString(2, valorCelda2);
//            ps.setString(3, valorCelda3);
//            rs = ps.executeQuery();
//
//            while (rs.next())
//            {
//
//                String nombre = rs.getString("nombre");
//                String apellido = rs.getString("apellido");
//                
//                String direccion = rs.getString("direccion");
//                String telefono = rs.getString("numero_telefono");
//                String correo = rs.getString("correo_electronico");
//                String fecha = rs.getString("fecha_registro");
//
//                ver_cliente mostrar = new ver_cliente();
//                
//                mostrar.txtnombre.setText(nombre);
//                mostrar.txtapellido.setText(apellido);
//                String sexo = rs.getString("genero");
//               
//                if (sexo.equals("Masculino"))
//                {
//                   mostrar.rbmasculino.setSelected(true);
//                } else if (sexo.equals("Femenino"))
//                {
//                    mostrar.rbfemenino.setSelected(true);
//                }
//                mostrar.jtadireccion.setText(direccion);
//                mostrar.txttelefono.setText(telefono);
//                mostrar.txtcorreo.setText(correo);
//                mostrar.fecha_registro.setText(fecha);
//
//
//                
//                mostrar.setSize(1024, 640);
//                mostrar.setLocation(0, 0);
//
//                panelprincipal.revalidate();
//                panelprincipal.repaint();
//                panelprincipal.removeAll();
//                panelprincipal.add(mostrar, BorderLayout.CENTER);
//
//                panelprincipal.revalidate();
//                panelprincipal.repaint();
//
//                break; // Salir del bucle después de encontrar el elemento seleccionado
//
//            }
//
//            rs.close();
//            ps.close();
//            conn.close();
//
//        } catch (SQLException e)
//        {
//            e.printStackTrace();
//            // Manejar cualquier excepción que pueda ocurrir durante la consulta a la base de datos
//        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
        DefaultTableModel modeloTabla = (DefaultTableModel) tableClientes.getModel();
        modeloTabla.setRowCount(0); // Limpiar los datos existentes en la tabla

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            ps = conn.prepareStatement("SELECT COUNT(*) AS TotalFilas FROM Proveedor WHERE primer_nombre LIKE ? OR primer_apellido LIKE ?");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
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

            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY primer_nombre) AS NumRegistro, primer_nombre, primer_apellido, telefono, nombre_compan FROM Proveedor WHERE primer_nombre LIKE ? OR primer_apellido LIKE ? ORDER BY primer_nombre OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
            ps.setInt(3, offset);
            ps.setInt(4, filasPorPagina);
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
        DefaultTableModel modelTabla = (DefaultTableModel) tableClientes.getModel();
        modelTabla.setRowCount(0);
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            if (conn != null && !conn.isClosed())
            {
                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY primer_nombre) AS NumRegistro, primer_nombre, primer_apellido, telefono, nombre_compan FROM Proveedor WHERE primer_nombre LIKE ? OR primer_apellido LIKE ?");

                if (texto != null && !texto.isEmpty())
                {
                    ps.setString(1, "%" + texto + "%");
                    ps.setString(2, "%" + texto + "%");
                    terminoBusqueda = texto; // Actualizar el término de búsqueda
                } else
                {
                    ps.setString(1, "%");
                    ps.setString(2, "%");
                    terminoBusqueda = ""; // Limpiar el término de búsqueda
                }

                ResultSet rs = ps.executeQuery();

                if (rs != null)
                {
                    while (rs.next())
                    {
                        int numRegistro = rs.getInt("NumRegistro");
                        String nombre = rs.getString("primer_nombre");
                        String Dni = rs.getString("primer_apellido");
                        String departamento = rs.getString("telefono");
                        String deducciones = rs.getString("nombre_compan");

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
