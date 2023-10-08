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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Listado_Empleados extends javax.swing.JPanel {

    int selectedRow;
    TextPrompt holder;

    /**
     * Creates new form Listado_Empleados
     */
    public Listado_Empleados() {
        initComponents();
        cargarTablaEmpleados();

        holder = new TextPrompt("Busque por nombre/apellido del empleado", txtBuscar);

        tblEmpleados.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblEmpleados.getTableHeader().setOpaque(false);
        tblEmpleados.getTableHeader().setBackground(new Color(255, 0, 0));
        tblEmpleados.getTableHeader().setForeground(new Color(255, 0, 0));
        tblEmpleados.setRowHeight(25);

        tblEmpleados.setRowSelectionAllowed(true);
        tblEmpleados.setColumnSelectionAllowed(false);
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
        tblEmpleados = new javax.swing.JTable();
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
        jLabel2.setText("Listado de empleados");

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

        crearbtn.setBackground(new java.awt.Color(255, 0, 51));
        crearbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        crearbtn.setText("CREAR");
        crearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearbtnActionPerformed(evt);
            }
        });

        editarbtn.setBackground(new java.awt.Color(255, 0, 51));
        editarbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editarbtn.setText("EDITAR");
        editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarbtnActionPerformed(evt);
            }
        });

        verbtn.setBackground(new java.awt.Color(255, 0, 51));
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

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Primer Nombre", "Primer Apellido", "Celular", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setGridColor(new java.awt.Color(255, 51, 51));
        tblEmpleados.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tblEmpleados.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblEmpleados.setShowVerticalLines(true);
        tblEmpleados.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(tblEmpleados);

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

        Btn_Buscar.setBackground(new java.awt.Color(255, 0, 51));
        Btn_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        refrescarbtn.setBackground(new java.awt.Color(255, 0, 51));
        refrescarbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refrescarbtn.setText("Refrescar");
        refrescarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarbtnActionPerformed(evt);
            }
        });

        Texto_Contable.setText("0");

        btnAnterior.setBackground(new java.awt.Color(255, 102, 102));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(255, 102, 102));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Texto_Buscar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refrescarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && ((int) evt.getKeyChar() <= 160) || txtBuscar.getText().length() >= 20)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        String texto = txtBuscar.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty())
        {
            // Llamada al método con paginación (página 1, 10 registros por página)
            buscarDatos(texto, 1, 10);
        } else
        {
            JOptionPane.showMessageDialog(null, "El texto ingresado es erroneo");
        }
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void refrescarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarbtnActionPerformed
        cargarTablaEmpleados();
        txtBuscar.setText("");
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

        selectedRow = tblEmpleados.getSelectedRow();
        if (selectedRow == -1)
        {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una celda para poder ver el empleado");
            return;
        } else
        {
            try
            {

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                String sql = "SELECT * FROM Empleado WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);

                // Obtener el valor del "id" de la fila seleccionada en la tabla
                String id = tblEmpleados.getValueAt(selectedRow, 0).toString(); // Suponiendo que el ID está en la primera columna (columna 0)

                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {

                    //RECUPERAR DE LA TABLA DE EMPLEADO
                    // String id = rs.getString("id");
                    String nombre1 = rs.getString("nombre1");
                    if (nombre1 != null)
                    {
                        nombre1 = nombre1.trim();
                    }
                    String nombre2 = rs.getString("nombre2");
                    if (nombre2 != null)
                    {
                        nombre2 = nombre2.trim();
                    }
                    String apellido1 = rs.getString("apellido1").trim();
                    String apellido2 = rs.getString("apellido2");
                    if (apellido2 != null)
                    {
                        apellido2 = apellido2.trim();
                    }
                    String fecha_nacimiento = rs.getDate("fecha_nacimiento").toString();
                    String sexo = rs.getString("sexo");
                    String dni = rs.getString("dni").trim();
                    String rtn = rs.getString("rtn").trim();
                    String estado_civil = rs.getString("estado_civil");
                    String nacionalidad = rs.getString("nacionalidad").trim();
                    String barrio = rs.getString("barrio").trim();
                    String municipio = rs.getString("municipio");
                    String aldea = rs.getString("aldea");
                    String referenciaDomicilio = rs.getString("referenciaDomicilio");
                    if (referenciaDomicilio != null)
                    {
                        referenciaDomicilio = referenciaDomicilio.trim();
                    }

                    String celular = rs.getString("celular").trim();
                    String fijo = rs.getString("fijo");
                    if (fijo != null)
                    {
                        fijo = fijo.trim();
                    }

                    String salario = rs.getString("salario").trim();

                    // Crear y mostrar el formulario correspondiente
                    Ver_Empleado mostrar = new Ver_Empleado();
                    mostrar.setVisible(true);
                    //this.dispose();

                    mostrar.nombre1.setText(nombre1);

                    if (nombre2.isEmpty())
                    {
                        mostrar.nombre2.setText("-----------");
                        mostrar.nombre2.setHorizontalAlignment(SwingConstants.CENTER);
                    } else
                    {
                        mostrar.nombre2.setText(nombre2);
                    }
                    mostrar.apellido1.setText(apellido1);

                    if (apellido2.isEmpty())
                    {
                        mostrar.apellido2.setText("-----------");
                        mostrar.apellido2.setHorizontalAlignment(SwingConstants.CENTER);

                    } else
                    {
                        mostrar.apellido2.setText(apellido2);
                    }
                    mostrar.fecha_nacimiento.setText(fecha_nacimiento);
                    mostrar.sexo.setText(sexo);
                    mostrar.dni.setText(dni);
                    mostrar.rtn.setText(rtn);
                    mostrar.estado_civil.setText(estado_civil);
                    mostrar.nacionalidad.setText(nacionalidad);
                    mostrar.barrio.setText(barrio);
                    mostrar.municipio.setText(municipio);
                    mostrar.aldea.setText(aldea);

                    if (referenciaDomicilio.isEmpty())
                    {
                        mostrar.referenciaDomicilio.setText("---------------------------------");
                        mostrar.referenciaDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
                    } else
                    {
                        mostrar.referenciaDomicilio.setText(referenciaDomicilio);
                    }
                    mostrar.celular.setText(celular);

                    if (fijo.isEmpty())
                    {
                        mostrar.fijo.setText("-----------");
                        mostrar.fijo.setHorizontalAlignment(SwingConstants.CENTER);
                    } else
                    {
                        mostrar.fijo.setText(fijo);
                    }
                    mostrar.salario.setText(salario);

                    mostrar.setSize(1024, 640);
                    mostrar.setLocation(0, 0);

                    panelprincipal.revalidate();
                    panelprincipal.repaint();
                    panelprincipal.removeAll();
                    panelprincipal.add(mostrar, BorderLayout.CENTER);

                    panelprincipal.revalidate();
                    panelprincipal.repaint();

                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(Listado_Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_verbtnActionPerformed

    private void editarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarbtnActionPerformed
        selectedRow = tblEmpleados.getSelectedRow();
        if (selectedRow == -1)
        {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una celda para poder modificar el empleado");
            return;
        } else
        {
            try
            {

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                String sql = "SELECT * FROM Empleado WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);

                // Obtener el valor del "id" de la fila seleccionada en la tabla
                String id = tblEmpleados.getValueAt(selectedRow, 0).toString(); // Suponiendo que el ID está en la primera columna (columna 0)

                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {

                    //RECUPERAR DE LA TABLA DE EMPLEADO
                    // String id = rs.getString("id");
                    String nombre1 = rs.getString("nombre1");
                    if (nombre1 != null)
                    {
                        nombre1 = nombre1.trim();
                    }
                    String nombre2 = rs.getString("nombre2");
                    if (nombre2 != null)
                    {
                        nombre2 = nombre2.trim();
                    }
                    String apellido1 = rs.getString("apellido1").trim();
                    String apellido2 = rs.getString("apellido2");
                    if (apellido2 != null)
                    {
                        apellido2 = apellido2.trim();
                    }
                    Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                    String sexo = rs.getString("sexo");
                    String dni = rs.getString("dni").trim();
                    String rtn = rs.getString("rtn").trim();
                    String estado_civil = rs.getString("estado_civil");
                    String nacionalidad = rs.getString("nacionalidad").trim();
                    String barrio = rs.getString("barrio").trim();
                    String municipio = rs.getString("municipio");
                    String aldea = rs.getString("aldea");
                    String referenciaDomicilio = rs.getString("referenciaDomicilio");
                    if (referenciaDomicilio != null)
                    {
                        referenciaDomicilio = referenciaDomicilio.trim();
                    }

                    String celular = rs.getString("celular").trim();
                    String fijo = rs.getString("fijo");
                    if (fijo != null)
                    {
                        fijo = fijo.trim();
                    }

                    String salario = rs.getString("salario").trim();
                    String id_empleado = rs.getString("id");

                    Editar_Empleado mostrar = new Editar_Empleado();

                    /*this.dispose();
                    mostrar.pack();*/
                    mostrar.id_empleado.setText(id);
                    mostrar.txtNombre1.setText(nombre1);
                    mostrar.txtNombre2.setText(nombre2);
                    mostrar.txtApellido1.setText(apellido1);
                    mostrar.txtApellido2.setText(apellido2);
                    mostrar.jdFechaNac.setDate(fecha_nacimiento);
                    mostrar.cbxSexo.setSelectedItem(sexo);
                    mostrar.txtDni.setText(dni);
                    mostrar.txtRtn.setText(rtn);
                    mostrar.cbxEstC.setSelectedItem(estado_civil);
                    mostrar.txtNacionalidad.setText(nacionalidad);
                    mostrar.txtDireccion.setText(barrio);
                    mostrar.cbxMuni.setSelectedItem(municipio);
                    mostrar.cbxAldea.setSelectedItem(aldea);
                    mostrar.txt_RefeDireccion.setText(referenciaDomicilio);
                    mostrar.txtCelular.setText(celular);
                    mostrar.txt_FijoCel.setText(fijo);
                    mostrar.txtSalario.setText(salario);

                    mostrar.setSize(1024, 640);
                    mostrar.setLocation(0, 0);

                    panelprincipal.revalidate();
                    panelprincipal.repaint();
                    panelprincipal.removeAll();
                    panelprincipal.add(mostrar, BorderLayout.CENTER);

                    panelprincipal.revalidate();
                    panelprincipal.repaint();

                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(Listado_Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_editarbtnActionPerformed

    int paginaActual = 1; // Página actual
    int filasPorPagina = 15; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla

    private void cargarTablaEmpleados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEmpleados.getModel();
        modeloTabla.setRowCount(0); // Eliminar las filas existentes

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            ps = conn.prepareStatement("SELECT COUNT(*) FROM Empleado");
            rs = ps.executeQuery();
            rs.next();
            totalFilas = rs.getInt(1);
            totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);

            // Cambiar filasPorPagina a 15
            int filasPorPagina = 15;

            int offset = (paginaActual - 1) * filasPorPagina;
            ps = conn.prepareStatement("SELECT id, nombre1, apellido1, celular, barrio "
                    + "FROM Empleado ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setInt(1, offset);
            ps.setInt(2, filasPorPagina);
            rs = ps.executeQuery();

            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            // Remover el contador de fila si ya no es necesario
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

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        // Obtener el número de filas actualizado
        int rowCount = modeloTabla.getRowCount();

        Texto_Contable.setText(
                "Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);
    }

    private void siguientePagina() {
        if (paginaActual < totalPaginas)
        {
            paginaActual++;
            cargarTablaEmpleados();
        }
    }

    private void paginaAnterior() {
        if (paginaActual > 1)
        {
            paginaActual--;
            cargarTablaEmpleados();
        }
    }

    private void ajustarTabla(int filasDeseadas) {
        tblEmpleados.setPreferredScrollableViewportSize(new Dimension(tblEmpleados.getPreferredSize().width, tblEmpleados.getRowHeight() * filasDeseadas));
        tblEmpleados.setFillsViewportHeight(true);
    }

    private void buscarDatos(String texto, int pagina, int registrosPorPagina) {
        DefaultTableModel modelTabla = (DefaultTableModel) tblEmpleados.getModel();
        modelTabla.setRowCount(0);

        try
        {
            // Conexión a la base de datos
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            if (conn != null && !conn.isClosed())
            {
                // Consulta SQL con paginación
                String consulta = "SELECT id, nombre1, apellido1, celular, barrio FROM Empleado WHERE nombre1 LIKE ? OR apellido1 LIKE ? "
                        + "ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, "%" + texto + "%");
                ps.setString(2, "%" + texto + "%");

                // Calcular el offset (desplazamiento) y el número de registros a obtener
                int offset = (pagina - 1) * registrosPorPagina;
                ps.setInt(3, offset);
                ps.setInt(4, registrosPorPagina);

                ResultSet rs = ps.executeQuery();

                int totalRegistros = 0;

                while (rs.next())
                {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre1");
                    String apellido = rs.getString("apellido1");
                    String celular = rs.getString("celular");
                    String direccion = rs.getString("barrio");

                    if (id != null && nombre != null && apellido != null && celular != null && direccion != null)
                    {
                        modelTabla.addRow(new Object[]
                        {
                            id, nombre, apellido, celular, direccion
                        });
                        totalRegistros++;
                    }
                }

                rs.close();
                ps.close();

                // Mostrar la página actual
                Texto_Contable.setText("Total de registros encontrados: " + totalRegistros + "-" + "Página " + pagina + "/" + totalPaginas);

                // Realizar una acción apropiada cuando no se encuentran datos
                if (totalRegistros == 0)
                {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos");
                }
            }

            conn.close();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
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
    private javax.swing.JTable tblEmpleados;
    public javax.swing.JTextField txtBuscar;
    private javax.swing.JButton verbtn;
    // End of variables declaration//GEN-END:variables
}