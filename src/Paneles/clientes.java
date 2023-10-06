/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import static Paneles.editar_cliente.jtadireccion;
import static Paneles.editar_cliente.rbfemenino;
import static Paneles.editar_cliente.rbmasculino;
import static Paneles.editar_cliente.txtapellido;
import static Paneles.editar_cliente.txtcorreo;
import static Paneles.editar_cliente.txtfecharegistro;
import static Paneles.editar_cliente.txtnombre;
import static Paneles.editar_cliente.txttelefono;
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
public class clientes extends javax.swing.JPanel {

    int filasPorPagina = 20; // Cantidad de filas que se mostrarán en cada página
    int paginaActual = 1; // Página actual
    int totalPaginas = 1; // Total de páginas
    String terminoBusqueda = ""; // Término de búsqueda actual
    TextPrompt holder;

    /**
     * Creates new form Nueva_venta
     */
    public clientes() {
        initComponents();
        cargarTabla();
        TextPrompt holder = new TextPrompt("Busque por nombre/apellido", txtbuscar);

        tableClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableClientes.getTableHeader().setOpaque(false);
        tableClientes.getTableHeader().setBackground(new Color(32, 136, 203));
        tableClientes.getTableHeader().setForeground(new Color(128, 0, 128));
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

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Listado de Clientes");

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

        tableClientes.setForeground(new java.awt.Color(0, 0, 0));
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre", "Apellido", "Género", "Correo electrónico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableClientes.setGridColor(new java.awt.Color(51, 255, 204));
        tableClientes.setSelectionForeground(new java.awt.Color(51, 255, 153));
        tableClientes.setShowHorizontalLines(true);
        tableClientes.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableClientes);
        if (tableClientes.getColumnModel().getColumnCount() > 0) {
            tableClientes.getColumnModel().getColumn(0).setMinWidth(60);
            tableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableClientes.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(180, 180, 180)
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
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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
        crear_cliente p2 = new crear_cliente();
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String direccion = jtadireccion.getText().trim();
        String telefono = txttelefono.getText().trim();
        String correo = txtcorreo.getText().trim();
        String fechaRegistro = txtfecharegistro.getText().trim();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombre.isEmpty())
        {
            camposVacios.append("\n - Nombre");
        }
        if (apellido.isEmpty())
        {
            camposVacios.append("\n - Apellido");
        }
        if (direccion.isEmpty())
        {
            camposVacios.append("\n - Dirección");
        }
        if (telefono.isEmpty())
        {
            camposVacios.append("\n - Teléfono");
        }
        if (correo.isEmpty())
        {
            camposVacios.append("\n - Correo");
        }

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:"))
        {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else
        {
            String sexo;
            if (rbmasculino.isSelected())
            {
                sexo = "Masculino";
            } else if (rbfemenino.isSelected())
            {
                sexo = "Femenino";
            } else
            {
                sexo = "Masculino"; // Valor predeterminado si no se selecciona un sexo
            }

            try
            {
                // Resto del código para la actualización en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement updatePs = conn.prepareStatement("UPDATE Cliente SET nombre=?, apellido=?, genero=?, direccion=?, numero_telefono=?, correo_electronico=?, fecha_registro=? WHERE id=?");
                updatePs.setString(1, nombre);
                updatePs.setString(2, apellido);
                updatePs.setString(3, sexo);
                updatePs.setObject(4, direccion);
                updatePs.setString(5, telefono);
                updatePs.setString(6, correo);
                updatePs.setString(7, fechaRegistro);
                // Aquí deberías proporcionar el ID del cliente que deseas actualizar en lugar de "?".
                // Puedes obtener este ID desde algún lugar de tu aplicación, por ejemplo, un campo oculto en tu interfaz de usuario.

                int rowsUpdated = updatePs.executeUpdate();
                if (rowsUpdated > 0)
                {
                    JOptionPane.showMessageDialog(null, "Registro actualizado");
                } else
                {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
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

            ps = conn.prepareStatement("SELECT COUNT(*) AS TotalFilas FROM Cliente WHERE nombre LIKE ? OR apellido LIKE ?");
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

            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY nombre) AS NumRegistro, nombre, apellido, genero, correo_electronico FROM Cliente WHERE nombre LIKE ? OR apellido LIKE ? ORDER BY nombre OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
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
                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY nombre) AS NumRegistro, nombre, apellido, genero, correo_electronico FROM Cliente WHERE nombre LIKE ? OR apellido LIKE ?");

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
                        String nombre = rs.getString("nombre");
                        String Dni = rs.getString("apellido");
                        String departamento = rs.getString("genero");
                        String deducciones = rs.getString("correo_electronico");

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
