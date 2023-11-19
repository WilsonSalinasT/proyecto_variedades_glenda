/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author novastar
 */
public class ver_envio extends javax.swing.JPanel {

    /**
     * Creates new form crear_envio
     */
    public ver_envio() {
        initComponents();

        productListComboBox.setPreferredSize(new Dimension(438, 54));
        arreglo.setPreferredSize(new Dimension(438, 54));
        sublimacion.setPreferredSize(new Dimension(438, 54));
        fechaenvio.setMinSelectableDate(new Date());

        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 2); // Suma dos meses a la fecha actual
        fechaenvio.setMaxSelectableDate(maxDate.getTime());

        configurarComboBoxClientes();

        ((JTextComponent) id_cliente).getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarComboBoxPorNumero(id_cliente.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarComboBoxPorNumero(id_cliente.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No relevante para JTextField
            }
        });

        id_sublimacion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarComboBoxPorNumero();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarComboBoxPorNumero();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarComboBoxPorNumero();
            }
        });

        id_arreglo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarComboBoxArreglo();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarComboBoxArreglo();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarComboBoxArreglo();
            }
        });

        id_pedidosat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarComboBoxSastreria();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarComboBoxSastreria();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarComboBoxSastreria();
            }
        });
    }

    public void actualizarComboBoxPorNumero() {
        String numeroIngresado = id_sublimacion.getText();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        if (!numeroIngresado.isEmpty())
        {
            try
            {
                int numero = Integer.parseInt(numeroIngresado);

                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT material,precio,fechaPedido FROM PedidoSublimacion WHERE id_sublimacion = ? and estado = 'pendiente'");
                preparedStatement.setInt(1, numero);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next())
                {
                    String material = rs.getString("material");
                    String precio = rs.getString("precio");
                    String fechaPedido = rs.getString("fechaPedido");
                    model.addElement("Material: " + material + " Precio: " + precio + " Fecha de pedido: " + fechaPedido);
                }

                connection.close();
            } catch (NumberFormatException | SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        sublimacion.setModel(model);

    }

    public void configurarComboBoxClientes() {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT C.nombre, C.apellido, C.numero_telefono, C.direccion, "
                    + "PS.prenda, PS.fechaPedido, PS.precio, "
                    + "PSB.material, PSB.fechaPedido as fechasublimacion, PSB.precio as preciosubl, "
                    + "PA.arreglo, PA.precio AS precioarreglo, PA.fechaPedido as fechaprenda "
                    + "FROM Cliente C "
                    + "LEFT JOIN PedidoSastreria PS ON C.id_cliente = PS.id_cliente "
                    + "LEFT JOIN PedidoSublimacion PSB ON C.id_cliente = PSB.id_cliente "
                    + "LEFT JOIN PedidoArreglo PA ON C.id_cliente = PA.id_cliente;";

            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            Set<String> nombresCompletos = new HashSet<>(); // Utiliza un conjunto para almacenar nombres y apellidos únicos

            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombreCompleto = nombre + " " + apellido;
                String telefono = rs.getString("numero_telefono");

                // Verifica si el nombre completo ya está en el conjunto
                if (!nombresCompletos.contains(nombreCompleto))
                {
                    txtCliente.addItem(nombreCompleto);
                    nombresCompletos.add(nombreCompleto); // Agrega el nombre completo al conjunto
                    txtcelular.setText(telefono);
                    txtdireccion.setText(rs.getString("direccion"));
                }
            }

            connection.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void actualizarComboBoxPorNumero(String numeroIngresado) {
        DefaultComboBoxModel<String> nuevoModelo = new DefaultComboBoxModel<>();

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Realiza una consulta en la base de datos para buscar el nombre correspondiente al número ingresado
            // Reemplaza este bloque con tu consulta real en la base de datos
            String sql = "SELECT nombre, apellido, numero_telefono,direccion FROM Cliente WHERE id_cliente = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, numeroIngresado);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("numero_telefono");
                String direccion = rs.getString("direccion");
                String nombreCompleto = nombre + " " + apellido;
                nuevoModelo.addElement(nombreCompleto);
                txtcelular.setText(telefono);
                txtdireccion.setText(direccion);
            }

            txtCliente.setModel(nuevoModelo);

            connection.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void actualizarComboBoxPorNumero(int numero) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT material,precio,fechaPedido FROM PedidoSublimacion WHERE id_sublimacion = ? and estado = 'pendiente'");
            preparedStatement.setInt(1, numero);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                String material = rs.getString("material");
                String precio = rs.getString("precio");
                String fechaPedido = rs.getString("fechaPedido");
                model.addElement("Material: " + material + " Precio: " + precio + " Fecha de pedido: " + fechaPedido);
            }

            connection.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        sublimacion.setModel(model);
    }

    public void actualizarComboBoxArreglo() {
        String numeroIngresado = id_arreglo.getText();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        if (!numeroIngresado.isEmpty())
        {
            try
            {
                int numero = Integer.parseInt(numeroIngresado);

                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_arreglo,arreglo,precio,fechaPedido FROM PedidoArreglo WHERE id_arreglo = ? and estado = 'pendiente'");
                preparedStatement.setInt(1, numero);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next())
                {
                    String material = rs.getString("arreglo");
                    String precio = rs.getString("precio");
                    String fechaPedido = rs.getString("fechaPedido");
                    model.addElement("Arreglo: " + material + " Precio: " + precio + " Fecha de pedido: " + fechaPedido);
                }

                connection.close();
            } catch (NumberFormatException | SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        arreglo.setModel(model);

    }

    public void actualizarComboBoxArreglo(int numero) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_arreglo,arreglo,precio,fechaPedido FROM PedidoArreglo WHERE CONCAT('Arreglo:',arreglo, ' ','Precio:', precio, ' ','Fecha de pedido:', fechaPedido) = ? and estado = 'pendiente'");
            preparedStatement.setInt(1, numero);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                String material = rs.getString("Arreglo");
                String precio = rs.getString("precio");
                String fechaPedido = rs.getString("fechaPedido");
                model.addElement("Material: " + material + " Precio: " + precio + " Fecha de pedido: " + fechaPedido);
            }

            connection.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        arreglo.setModel(model);
    }

    public void actualizarComboBoxSastreria() {
        String numeroIngresado = id_pedidosat.getText();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        if (!numeroIngresado.isEmpty())
        {
            try
            {
                int numero = Integer.parseInt(numeroIngresado);

                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_sastreria,prenda,precio,fechaPedido FROM PedidoSastreria WHERE id_sastreria=? and estado = 'pendiente'");
                preparedStatement.setInt(1, numero);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next())
                {
                    String material = rs.getString("prenda");
                    String precio = rs.getString("precio");
                    String fechaPedido = rs.getString("fechaPedido");
                    model.addElement("Arreglo: " + material + " Precio: " + precio + " Fecha de pedido: " + fechaPedido);
                }

                connection.close();
            } catch (NumberFormatException | SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        productListComboBox.setModel(model);

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
        jLabel2 = new javax.swing.JLabel();
        btnatras = new javax.swing.JButton();
        txtCliente = new javax.swing.JComboBox<>();
        fechaenvio = new com.toedter.calendar.JDateChooser();
        txtcelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        id_cliente = new javax.swing.JTextField();
        productListComboBox = new javax.swing.JComboBox<>();
        arreglo = new javax.swing.JComboBox<>();
        sublimacion = new javax.swing.JComboBox<>();
        id_pedidosat = new javax.swing.JTextField();
        id_arreglo = new javax.swing.JTextField();
        id_sublimacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtreferencia = new javax.swing.JTextArea();
        id_envio = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 640));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Editar envio");

        btnatras.setBackground(new java.awt.Color(255, 153, 51));
        btnatras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnatras.setText("VOLVER");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnatras)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnatras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12)))); // NOI18N
        txtCliente.setEnabled(false);

        fechaenvio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

        txtcelular.setEditable(false);
        txtcelular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teléfono", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 1, 12))); // NOI18N
        txtcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelularActionPerformed(evt);
            }
        });

        txtdireccion.setEditable(false);
        txtdireccion.setColumns(20);
        txtdireccion.setLineWrap(true);
        txtdireccion.setRows(5);
        txtdireccion.setWrapStyleWord(true);
        txtdireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        jScrollPane1.setViewportView(txtdireccion);

        id_cliente.setEditable(false);
        id_cliente.setBackground(new java.awt.Color(255, 255, 255));
        id_cliente.setForeground(new java.awt.Color(255, 255, 255));
        id_cliente.setText("000000000");
        id_cliente.setBorder(null);

        productListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        productListComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sastrería", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        productListComboBox.setEnabled(false);
        productListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productListComboBoxActionPerformed(evt);
            }
        });

        arreglo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        arreglo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arreglos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        arreglo.setEnabled(false);
        arreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arregloActionPerformed(evt);
            }
        });

        sublimacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        sublimacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sublimación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        sublimacion.setEnabled(false);

        id_pedidosat.setEditable(false);
        id_pedidosat.setBackground(new java.awt.Color(255, 255, 255));
        id_pedidosat.setForeground(new java.awt.Color(255, 255, 255));
        id_pedidosat.setText("0000");
        id_pedidosat.setBorder(null);

        id_arreglo.setEditable(false);
        id_arreglo.setBackground(new java.awt.Color(255, 255, 255));
        id_arreglo.setForeground(new java.awt.Color(255, 255, 255));
        id_arreglo.setText("0000");
        id_arreglo.setBorder(null);

        id_sublimacion.setEditable(false);
        id_sublimacion.setBackground(new java.awt.Color(255, 255, 255));
        id_sublimacion.setForeground(new java.awt.Color(255, 255, 255));
        id_sublimacion.setText("0000");
        id_sublimacion.setBorder(null);

        txtreferencia.setColumns(20);
        txtreferencia.setLineWrap(true);
        txtreferencia.setRows(5);
        txtreferencia.setWrapStyleWord(true);
        txtreferencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otra referencia de domicilio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtreferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtreferenciaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtreferencia);

        id_envio.setEditable(false);
        id_envio.setBackground(new java.awt.Color(255, 255, 255));
        id_envio.setForeground(new java.awt.Color(255, 255, 255));
        id_envio.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(id_pedidosat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(id_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69)
                            .addComponent(id_envio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(297, 297, 297))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(id_arreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(487, 487, 487))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(sublimacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(68, 68, 68)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(arreglo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaenvio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productListComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_sublimacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_envio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechaenvio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productListComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(id_sublimacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(arreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sublimacion, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_pedidosat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_arreglo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        Listado_de_envios p2 = new Listado_de_envios();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        jPanel1.removeAll();
        jPanel1.add(p2, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_btnatrasActionPerformed

    private void productListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productListComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productListComboBoxActionPerformed

    private void arregloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arregloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arregloActionPerformed

    private void txtcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcelularActionPerformed

    private void txtreferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreferenciaKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtreferencia.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (txtreferencia.getText().length() >= 300)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtreferenciaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> arreglo;
    private javax.swing.JButton btnatras;
    public com.toedter.calendar.JDateChooser fechaenvio;
    public javax.swing.JTextField id_arreglo;
    public javax.swing.JTextField id_cliente;
    public javax.swing.JTextField id_envio;
    public javax.swing.JTextField id_pedidosat;
    public javax.swing.JTextField id_sublimacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> productListComboBox;
    private javax.swing.JComboBox<String> sublimacion;
    private javax.swing.JComboBox<String> txtCliente;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextArea txtdireccion;
    public javax.swing.JTextArea txtreferencia;
    // End of variables declaration//GEN-END:variables
}
