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
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class Listado_de_envios extends javax.swing.JPanel {

    int selectedRow;
    TextPrompt holder;

    /**
     * Creates new form Listado_Empleados
     */
    public Listado_de_envios() {
        initComponents();

        cargarTablaEmpleados();

        holder = new TextPrompt("Busque por nombre/apellido del cliente/fecha de entrega", txtBuscar);

        tblEnvios.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblEnvios.getTableHeader().setOpaque(false);
        tblEnvios.getTableHeader().setBackground(new Color(255, 0, 0));
        tblEnvios.getTableHeader().setForeground(new Color(255, 0, 0));
        tblEnvios.setRowHeight(25);

        tblEnvios.setRowSelectionAllowed(true);
        tblEnvios.setColumnSelectionAllowed(false);

        int columnIndexToHide = 5;
        TableColumn column = tblEnvios.getColumnModel().getColumn(columnIndexToHide);

        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);
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
        editarbtn = new javax.swing.JButton();
        verbtn = new javax.swing.JButton();
        crearbtn1 = new javax.swing.JButton();
        Texto_Buscar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnvios = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        Btn_Buscar = new javax.swing.JButton();
        refrescarbtn = new javax.swing.JButton();
        Texto_Contable = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 640));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Listado de envios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        crearbtn1.setBackground(new java.awt.Color(255, 153, 51));
        crearbtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        crearbtn1.setText("CREAR ");
        crearbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(crearbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(editarbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(verbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(crearbtn1)
                .addGap(18, 18, 18)
                .addComponent(editarbtn)
                .addGap(18, 18, 18)
                .addComponent(verbtn)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        Texto_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Texto_Buscar.setText("Buscar:");

        tblEnvios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre", "Apellido", "Producto", "Fecha de entrega", "id_envio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEnvios.setGridColor(new java.awt.Color(255, 51, 51));
        tblEnvios.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tblEnvios.setShowHorizontalLines(true);
        tblEnvios.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tblEnvios);
        if (tblEnvios.getColumnModel().getColumnCount() > 0) {
            tblEnvios.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblEnvios.getColumnModel().getColumn(1).setMinWidth(150);
            tblEnvios.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblEnvios.getColumnModel().getColumn(1).setMaxWidth(200);
            tblEnvios.getColumnModel().getColumn(3).setMinWidth(250);
            tblEnvios.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblEnvios.getColumnModel().getColumn(3).setMaxWidth(250);
        }

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
                        .addGap(37, 37, 37)
                        .addComponent(Texto_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refrescarbtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Texto_Buscar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refrescarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtBuscar.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (txtBuscar.getText().length() >= 100)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        String texto = txtBuscar.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty())
        {
            buscarDatos(texto);
        } else
        {
            JOptionPane.showMessageDialog(null, "Tiene que ingresar texto para hacer la respectiva búsqueda");
        }
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void refrescarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarbtnActionPerformed
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        txtBuscar.setText("");

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
    int selectedRow1;

    private void verbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verbtnActionPerformed

        selectedRow1 = tblEnvios.getSelectedRow();
        if (selectedRow1 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un envio para poder visualizarlo");
            return;
        }

        try
        {

            int fila = tblEnvios.getSelectedRow();
            int valorEntero = Integer.parseInt(tblEnvios.getValueAt(fila, 5).toString());
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT\n"
                    + "    E.id_envio,\n"
                    + "    E.fechaenvio,E.referencia,\n"
                    + "    PA.arreglo,PA.precio as precioarreglo,PA.fechaPedido as fechaArreglo,PS.material,PS.precio as precisublimacion,\n"
                    + "	PS.fechaPedido as fechasublimacion,\n"
                    + "	SA.prenda,SA.precio as preciosastreria,SA.fechaPedido as fechaSatreria,C.nombre AS nombreCliente,C.apellido AS apellidoCliente,C.numero_telefono,C.direccion\n"
                    + "FROM\n"
                    + "    Envios E\n"
                    + "LEFT JOIN\n"
                    + "    PedidoArreglo PA ON E.id_arreglo = PA.id_arreglo\n"
                    + " LEFT JOIN\n"
                    + "    PedidoSublimacion PS ON E.id_sublimacion = PS.id_sublimacion\n"
                    + "LEFT JOIN\n"
                    + "    PedidoSastreria SA ON E.id_sastreria = SA.id_sastreria\n"
                    + "LEFT JOIN\n"
                    + "    Cliente C ON E.id_cliente = C.id_cliente WHERE E.id_envio=?");
            ps.setInt(1, valorEntero);

            rs = ps.executeQuery();

            while (rs.next())
            {

                String nombre = rs.getString("nombreCliente");
                String apellido = rs.getString("apellidoCliente");
                String tel = rs.getString("numero_telefono");
                String direccion = rs.getString("direccion");
                String fechaenvio = rs.getString("fechaenvio");
                String prenda = rs.getString("prenda");
                String precioPS = rs.getString("preciosastreria");
                String fechaPS = rs.getString("fechaSatreria");

                String arreglo = rs.getString("arreglo");
                String precioArreglo = rs.getString("precioarreglo");
                String fechaArreglo = rs.getString("fechaArreglo");

                String material = rs.getString("material");
                String preciosublimacion = rs.getString("precisublimacion");
                String fechasublimacion = rs.getString("fechasublimacion");

                String referencia = rs.getString("referencia");

                ver_envio ver = new ver_envio();

                ver.txtCliente.setText(nombre + " " + apellido);
                ver.txtcelular.setText(tel);
                ver.txtdireccion.setText(direccion);
                ver.txtfechaEntrega.setText(fechaenvio);

                ver.txtPrenda.setText(prenda);
                ver.txtPreciosastereia.setText(precioPS);
                ver.txtfechapedidosast.setText(fechaPS);

                ver.txtarreglo.setText(arreglo);
                ver.txtprecioarreglo.setText(precioArreglo);
                ver.txtfechaarreglo.setText(fechaArreglo);

                ver.txtmaterial.setText(material);
                ver.txtpreciosublimacion.setText(preciosublimacion);
                ver.txtfechasublimacion.setText(fechasublimacion);
                ver.txtreferencia.setText(referencia);

//                ver.txtArreglo.setText(arregloA);
//                ver.txtestado.setText(estadoA);
//                ver.txtDescripcionA.setText(descripcionA);
//                ver.txtprecio.setText(precioA);
//                ver.id.setText(rs.getString("id_arreglo"));
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
        selectedRow2 = tblEnvios.getSelectedRow();
        if (selectedRow2 == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un envio para poder editarlo");
            return;
        }

        try
        {

            int fila = tblEnvios.getSelectedRow();
            int valorEntero = Integer.parseInt(tblEnvios.getValueAt(fila, 5).toString());
            PreparedStatement ps;
            ResultSet rs;

            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            ps = conn.prepareStatement("SELECT * FROM Envios where id_envio=?");
            ps.setInt(1, valorEntero);

            rs = ps.executeQuery();

            while (rs.next())
            {

                String id_envio = rs.getString("id_envio");
                String id_cliente = rs.getString("id_cliente");
                String id_sastreria = rs.getString("id_sastreria");
                String id_arreglo = rs.getString("id_arreglo");
                String id_sublimacion = rs.getString("id_sublimacion");
                String referencia = rs.getString("referencia");

                editar_envio editar = new editar_envio();

                editar.id_envio.setText(id_envio);
                editar.id_cliente.setText(id_cliente);
                editar.id_pedidosat.setText(id_sastreria);
                editar.id_arreglo.setText(id_arreglo);
                editar.id_sublimacion.setText(id_sublimacion);
                editar.txtreferencia.setText(referencia);
                editar.fechaenvio.setDate(rs.getDate("fechaenvio"));

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

    private void crearbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearbtn1ActionPerformed
        // TODO add your handling code here:

        crear_envio p2 = new crear_envio();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_crearbtn1ActionPerformed

    int paginaActual = 1; // Página actual
    int filasPorPagina = 20; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla
    int numRegistro = 0;
    String terminoBusqueda = ""; // Término de búsqueda actual

    private void cargarTablaEmpleados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEnvios.getModel();
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
            ps = conn.prepareStatement("SELECT\n"
                    + "	COUNT(*) AS TotalFilas\n"
                    + "FROM\n"
                    + "    Envios E\n"
                    + "LEFT JOIN\n"
                    + "    PedidoArreglo PA ON E.id_arreglo = PA.id_arreglo\n"
                    + "LEFT JOIN\n"
                    + "    PedidoSublimacion PS ON E.id_sublimacion = PS.id_sublimacion\n"
                    + "LEFT JOIN\n"
                    + "    PedidoSastreria SA ON E.id_sastreria = SA.id_sastreria\n"
                    + "LEFT JOIN\n"
                    + "    Cliente C ON E.id_cliente = C.id_cliente "
                    + "WHERE C.nombre LIKE ? OR C.apellido LIKE ? OR E.fechaenvio LIKE ? ");
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
            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY C.nombre) AS NumRegistro,  C.nombre, C.apellido, ISNULL(NULLIF(CONCAT( NULLIF(PA.arreglo, ''), \n"
                    + "               CASE WHEN PA.arreglo IS NOT NULL AND (PS.material IS NOT NULL OR SA.prenda IS NOT NULL) THEN ', ' ELSE '' END,\n"
                    + "                NULLIF(PS.material, ''),\n"
                    + "             CASE WHEN PS.material IS NOT NULL AND SA.prenda IS NOT NULL THEN ', ' ELSE '' END,\n"
                    + "              NULLIF(SA.prenda, '')\n"
                    + "           ), ''), 'Ninguno') AS detalle_pedido,\n"
                    + "         	E.fechaenvio,\n"
                    + "            E.id_envio FROM Envios E\n"
                    + "        LEFT JOIN\n"
                    + "            PedidoArreglo PA ON E.id_arreglo = PA.id_arreglo\n"
                    + "         LEFT JOIN\n"
                    + "             PedidoSublimacion PS ON E.id_sublimacion = PS.id_sublimacion\n"
                    + "         LEFT JOIN\n"
                    + "             PedidoSastreria SA ON E.id_sastreria = SA.id_sastreria\n"
                    + "         LEFT JOIN Cliente C ON E.id_cliente = C.id_cliente "
                    + "        WHERE C.nombre LIKE ? OR C.apellido LIKE ? OR E.fechaenvio LIKE ? ORDER BY C.nombre OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
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
            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e)
        {
            e.printStackTrace(); // Imprime la pila de excepciones para depuración
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    private void ajustarTabla(int filasDeseadas) {
        tblEnvios.setPreferredScrollableViewportSize(new Dimension(tblEnvios.getPreferredSize().width, tblEnvios.getRowHeight() * filasDeseadas));
        tblEnvios.setFillsViewportHeight(true);
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

    private void buscarDatos(String texto) {
        DefaultTableModel modelTabla = (DefaultTableModel) tblEnvios.getModel();
        modelTabla.setRowCount(0);
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            if (conn != null && !conn.isClosed())
            {
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT ROW_NUMBER() OVER(ORDER BY C.nombre) AS NumRegistro,  C.nombre, C.apellido, "
                        + "ISNULL(NULLIF(CONCAT(NULLIF(PA.arreglo, ''), "
                        + "CASE WHEN PA.arreglo IS NOT NULL AND (PS.material IS NOT NULL OR SA.prenda IS NOT NULL) THEN ', ' ELSE '' END, "
                        + "NULLIF(PS.material, ''), "
                        + "CASE WHEN PS.material IS NOT NULL AND SA.prenda IS NOT NULL THEN ', ' ELSE '' END, "
                        + "NULLIF(SA.prenda, '')), ''), 'Ninguno') AS detalle_pedido, "
                        + "E.fechaenvio, E.id_envio "
                        + "FROM Envios E "
                        + "LEFT JOIN PedidoArreglo PA ON E.id_arreglo = PA.id_arreglo "
                        + "LEFT JOIN PedidoSublimacion PS ON E.id_sublimacion = PS.id_sublimacion "
                        + "LEFT JOIN PedidoSastreria SA ON E.id_sastreria = SA.id_sastreria "
                        + "LEFT JOIN Cliente C ON E.id_cliente = C.id_cliente "
                        + "WHERE C.nombre LIKE ? OR C.apellido LIKE ? OR E.fechaenvio LIKE ? "
                        + "ORDER BY C.nombre OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

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
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String detalle_pedido = rs.getString("detalle_pedido");
                        String fechaPedido = rs.getString("fechaenvio");
                        int idArreglo = rs.getInt("id_envio");

                        modelTabla.addRow(new Object[]
                        {
                            numRegistro, nombre, apellido, detalle_pedido, fechaPedido, idArreglo
                        });
                        foundData = true;
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
        cargarTablaEmpleados(); // Recargar la tabla después de la búsqueda
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_Buscar;
    private javax.swing.JLabel Texto_Buscar;
    private javax.swing.JLabel Texto_Contable;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton crearbtn1;
    private javax.swing.JButton editarbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refrescarbtn;
    private javax.swing.JTable tblEnvios;
    public javax.swing.JTextField txtBuscar;
    private javax.swing.JButton verbtn;
    // End of variables declaration//GEN-END:variables

    private void mostrarVentanaDeEdicion(EditarCita editarCita) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
