package Paneles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author Admin
 */
public class Listado_Citas extends javax.swing.JPanel {

    int selectedRow;
    TextPrompt holder;

    /**
     * Creates new form Listado_Empleados
     */
    public Listado_Citas() {
        initComponents();
        cargarTablaEmpleados();

        holder = new TextPrompt("Busque por nombre/apellido del cliente", txtBuscar);

        tblCitas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblCitas.getTableHeader().setOpaque(false);
        tblCitas.getTableHeader().setBackground(new Color(255, 0, 0));
        tblCitas.getTableHeader().setForeground(new Color(255, 0, 0));
        tblCitas.setRowHeight(25);

        tblCitas.setRowSelectionAllowed(true);
        tblCitas.setColumnSelectionAllowed(false);
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
        tblCitas = new javax.swing.JTable();
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
        jLabel2.setText("Listado de Citas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
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
        crearbtn.setText("CREAR");
        crearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearbtnActionPerformed(evt);
            }
        });

        editarbtn.setBackground(new java.awt.Color(255, 153, 51));
        editarbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editarbtn.setText("EDITAR");
        editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarbtnActionPerformed(evt);
            }
        });

        verbtn.setBackground(new java.awt.Color(255, 153, 51));
        verbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre Cliente", "Apellido Cliente", "Celular", "Fecha de la cita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCitas.setGridColor(new java.awt.Color(255, 51, 51));
        tblCitas.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tblCitas.setShowHorizontalLines(true);
        tblCitas.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tblCitas);

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
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        refrescarbtn.setBackground(new java.awt.Color(255, 153, 51));
        refrescarbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(Texto_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refrescarbtn))
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
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        // validación en el campo de buscar para que acepte solo letra y letras tildades, se utiliza el codigo ASCII para las letras tildades
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ((int) evt.getKeyChar() <= 160) || txtBuscar.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        String texto = txtBuscar.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty()) {
            buscarDatos(texto);
        } else {
            JOptionPane.showMessageDialog(null, "Tiene que ingrese texto");
        }
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void refrescarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarbtnActionPerformed
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        txtBuscar.setText("");
        holder = new TextPrompt("Busque por nombre/apellido del cliente", txtBuscar);

        // Cargar la tabla con los datos actualizados
        cargarTablaEmpleados();
    }//GEN-LAST:event_refrescarbtnActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        paginaAnterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguientePagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void crearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearbtnActionPerformed

        Crear_Cita p2 = new Crear_Cita();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_crearbtnActionPerformed
     int selectedRow1;
    private void verbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verbtnActionPerformed
             // TODO add your handling code here:
      selectedRow1 = tblCitas.getSelectedRow();
        if (selectedRow1 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una cita para poder visualizarla");
            return;
        }

        try
        {

            int fila = tblCitas.getSelectedRow();
            String valorCelda = tblCitas.getValueAt(fila, 1).toString();
            String valorCelda2 = tblCitas.getValueAt(fila, 2).toString();
            String valorCelda3 = tblCitas.getValueAt(fila, 4).toString();
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT * FROM cliente JOIN Cita ON cliente.id_cliente = Cita.id_cliente where nombre =? and apellido=? and fecha_cita=? ");
            ps.setString(1, valorCelda);
            ps.setString(2, valorCelda2);
            ps.setString(3, valorCelda3);
            rs = ps.executeQuery();

            while (rs.next())
            {


               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
                ver_cita ver = new ver_cita();
                

                ver.fechaCita.setText(rs.getString("fecha_cita"));
                ver.cbxHoras.setText(rs.getString("hora_cita"));
                 ver.txtMotivo.setText(rs.getString("motivo"));
                 ver.txtCliente.setText(nombre+ " "+ apellido);
                 ver.id_cliente.setText(rs.getString("id"));

                
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

    }//GEN-LAST:event_verbtnActionPerformed

    int selectedRow2;
    private void editarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarbtnActionPerformed

            // TODO add your handling code here:
      selectedRow2 = tblCitas.getSelectedRow();
        if (selectedRow2 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una cita para poder editarla");
            return;
        }

        try
        {

            int fila = tblCitas.getSelectedRow();
            String valorCelda = tblCitas.getValueAt(fila, 1).toString();
            String valorCelda2 = tblCitas.getValueAt(fila, 2).toString();
            String valorCelda3 = tblCitas.getValueAt(fila, 4).toString();
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT * FROM cliente JOIN Cita ON cliente.id_cliente = Cita.id_cliente where nombre =? and apellido=? and fecha_cita=? ");
            ps.setString(1, valorCelda);
            ps.setString(2, valorCelda2);
            ps.setString(3, valorCelda3);
            rs = ps.executeQuery();

            while (rs.next())
            {


               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
                EditarCita editar = new EditarCita();
                

                editar.fechaCita.setDate(rs.getDate("fecha_cita"));
                editar.cbxHoras.setSelectedItem(rs.getString("hora_cita"));
                 editar.txtMotivo.setText(rs.getString("motivo"));
                 editar.txtCliente.setSelectedItem(nombre+ " "+ apellido);
                 editar.id_cliente.setText(rs.getString("id"));

                
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

    }//GEN-LAST:event_editarbtnActionPerformed

    int paginaActual = 1; // Página actual
    int filasPorPagina = 15; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla
    int numRegistro = 0;
    String terminoBusqueda = ""; // Término de búsqueda actual

    private void cargarTablaEmpleados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblCitas.getModel();
        modeloTabla.setRowCount(0); // Limpiar los datos existentes en la tabla

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        boolean foundData = false;

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Obtener el total de filas que cumplen con el criterio de búsqueda
            ps = conn.prepareStatement("SELECT COUNT(*) AS TotalFilas "
                    + "FROM Cliente E "
                    + "JOIN Cita V ON E.id_cliente = V.id_cliente "
                    + "WHERE E.nombre LIKE ? OR E.apellido LIKE ?");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
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

            // Consulta para obtener los datos paginados
            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY E.nombre) AS NumRegistro, E.nombre, E.apellido, E.numero_telefono, V.fecha_cita "
                    + "FROM Cliente E "
                    + "JOIN Cita V ON E.id_cliente = V.id_cliente "
                    + "WHERE E.nombre LIKE ? OR E.apellido LIKE ? "
                    + "ORDER BY E.nombre "
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");
            ps.setInt(3, offset);
            ps.setInt(4, filasPorPagina);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
                foundData = true;
            }

            ajustarTabla(filasPorPagina);

            if (!foundData) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
            }

            // Obtener el número de filas actualizado
            int rowCount = modeloTabla.getRowCount();
            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e) {
            e.printStackTrace(); // Imprime la pila de excepciones para depuración
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    private void ajustarTabla(int filasDeseadas) {
        tblCitas.setPreferredScrollableViewportSize(new Dimension(tblCitas.getPreferredSize().width, tblCitas.getRowHeight() * filasDeseadas));
        tblCitas.setFillsViewportHeight(true);
    }

    private void siguientePagina() {
        if (paginaActual < totalPaginas) {
            paginaActual++;
            cargarTablaEmpleados();
        }
    }

    private void paginaAnterior() {
        if (paginaActual > 1) {
            paginaActual--;
            cargarTablaEmpleados();
        }
    }

    private void buscarDatos(String texto) {
        DefaultTableModel modelTabla = (DefaultTableModel) tblCitas.getModel();
        modelTabla.setRowCount(0);
        boolean foundData = false;

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            if (conn != null && !conn.isClosed()) {
                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY E.nombre) AS NumRegistro, E.nombre, E.apellido, E.numero_telefono, V.fecha_cita "
                        + "FROM Cliente E "
                        + "JOIN Cita V ON E.id_cliente = V.id_cliente "
                        + "WHERE E.nombre LIKE ? OR E.apellido LIKE ? "
                        + "ORDER BY E.nombre "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

                if (texto != null && !texto.isEmpty()) {
                    ps.setString(1, "%" + texto + "%");
                    ps.setString(2, "%" + texto + "%");
                    terminoBusqueda = texto; // Actualizar el término de búsqueda
                } else {
                    ps.setString(1, "%");
                    ps.setString(2, "%");
                    terminoBusqueda = ""; // Limpiar el término de búsqueda
                }

                // Define el OFFSET y FETCH NEXT de acuerdo a tus necesidades
                int offset = 0; // Cambia el valor del offset según tus requerimientos
                int fetchNext = 10; // Cambia la cantidad de registros a recuperar según tus requerimientos

                ps.setInt(3, offset);
                ps.setInt(4, fetchNext);

                ResultSet rs = ps.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        int numRegistro = rs.getInt("NumRegistro");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String numeroTelefono = rs.getString("numero_telefono");
                        String fechaCita = rs.getString("fecha_cita");

                        if (nombre != null && apellido != null && numeroTelefono != null) {
                            modelTabla.addRow(new Object[]{
                                numRegistro, nombre, apellido, numeroTelefono, fechaCita
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

        // Llama a la función de cargarTablaEmpleados() si es necesario recargar la tabla después de la búsqueda
        cargarTablaEmpleados(); // Recargar la tabla después de la búsqueda
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
    private javax.swing.JTable tblCitas;
    public javax.swing.JTextField txtBuscar;
    private javax.swing.JButton verbtn;
    // End of variables declaration//GEN-END:variables

    private void mostrarVentanaDeEdicion(EditarCita editarCita) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
