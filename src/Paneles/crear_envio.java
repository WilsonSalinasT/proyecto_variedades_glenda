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

/**
 *
 * @author novastar
 */
public class crear_envio extends javax.swing.JPanel {

    /**
     * Creates new form crear_envio
     */
    public crear_envio() {
        initComponents();

        productListComboBox.setPreferredSize(new Dimension(438, 54));
        arreglo.setPreferredSize(new Dimension(438, 54));
        sublimacion.setPreferredSize(new Dimension(438, 54));
        fechaentrega.setMinSelectableDate(new Date());

        Calendar maxDate = Calendar.getInstance();
        maxDate.add(Calendar.MONTH, 2); // Suma dos meses a la fecha actual
        fechaentrega.setMaxSelectableDate(maxDate.getTime());

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            Statement stmt = connection.createStatement();
            String sql = "SELECT C.nombre, C.apellido, C.numero_telefono,C.direccion,\n"
                    + "       PS.prenda, PS.fechaPedido, PS.precio, \n"
                    + "       PSB.material, PSB.fechaPedido as fechasublimacion,PSB.precio as preciosubl, \n"
                    + "       PA.arreglo, PA.precio AS precioarreglo, PA.fechaPedido as fechaprenda\n"
                    + "FROM Cliente C\n"
                    + "LEFT JOIN PedidoSastreria PS ON C.id_cliente = PS.id_cliente\n"
                    + "LEFT JOIN PedidoSublimacion PSB ON C.id_cliente = PSB.id_cliente\n"
                    + "LEFT JOIN PedidoArreglo PA ON C.id_cliente = PA.id_cliente;";
            ResultSet rs = stmt.executeQuery(sql);

            txtCliente.addItem("Seleccione"); // Agrega el elemento "Seleccione" al principio

            Set<String> nombresCompletos = new HashSet<>(); // Utiliza un conjunto para almacenar nombres y apellidos únicos

            while (rs.next())
            {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombreCompleto = nombre + " " + apellido;

                // Verifica si el nombre completo ya está en el conjunto
                if (!nombresCompletos.contains(nombreCompleto))
                {
                    txtCliente.addItem(nombreCompleto);
                    nombresCompletos.add(nombreCompleto); // Agrega el nombre completo al conjunto
                }
            }

            connection.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        txtCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCliente.getSelectedIndex() > 0)
                {
                    String selectedClient = (String) txtCliente.getSelectedItem();

                    // Verifica si se seleccionó el elemento "Seleccione"
                    if (!selectedClient.equals("Seleccione"))
                    {
                        // Buscar nuevamente el ID y el teléfono en la base de datos
                        try
                        {
                            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                            Statement stmt = connection.createStatement();

                            String sqlq = "SELECT C.nombre, C.apellido, C.numero_telefono, C.direccion, C.id_cliente, PS.prenda, PS.fechaPedido, PS.estado, PS.precio, PSB.material, PSB.fechaPedido as fechasublimacion, PSB.precio as preciosubl,\n"
                                    + "     PA.arreglo, PA.precio AS precioarreglo, PA.fechaPedido as fechaprenda\n"
                                    + "FROM Cliente C\n"
                                    + "LEFT JOIN PedidoSastreria PS ON C.id_cliente = PS.id_cliente AND PS.estado = 'Pendiente'\n"
                                    + "LEFT JOIN PedidoSublimacion PSB ON C.id_cliente = PSB.id_cliente AND PSB.estado = 'Pendiente'\n"
                                    + "LEFT JOIN PedidoArreglo PA ON C.id_cliente = PA.id_cliente AND PA.estado = 'Pendiente'\n"
                                    + "WHERE CONCAT(C.nombre, ' ', C.apellido) = '" + selectedClient + "'";
                            ResultSet rs = stmt.executeQuery(sqlq);

                            if (rs.next())
                            {
                                int selectedClientId = rs.getInt("id_cliente");
                                String selectedClientTelefono = rs.getString("numero_telefono");
                                String selectedClientDireccion = rs.getString("direccion");

                                // Actualiza los campos de texto con el ID y el teléfono del cliente seleccionado
                                id_cliente.setText(Integer.toString(selectedClientId));
                                txtcelular.setText(selectedClientTelefono);
                                txtdireccion.setText(selectedClientDireccion);

                                // Limpia los elementos existentes en los JComboBox
                                productListComboBox.removeAllItems();
                                arreglo.removeAllItems();
                                sublimacion.removeAllItems();

                                Set<String> productoInfoSet = new HashSet<>(); // Utiliza un HashSet para evitar duplicados en productListComboBox
                                Set<String> arregloInfoSet = new HashSet<>();  // Utiliza otro HashSet para evitar duplicados en el JComboBox "arreglo"
                                Set<String> sublimacionInfoSet = new HashSet<>();  // Utiliza otro HashSet para evitar duplicados en el JComboBox "sublimacion"

                                do
                                {
                                    String selectedPrecioStr = rs.getString("precio");
                                    String selectedPrenda = rs.getString("prenda");
                                    String selectedFecha = rs.getString("fechaPedido");
//                                    String productoInfo = "Prenda: " + selectedPrenda + " | Precio:" + selectedPrecioStr + " lps | " + "Fecha de pedido: " + selectedFecha;
//                                    productoInfoSet.add(productoInfo);
                                    String productoInfo = "Prenda:" + selectedPrenda + " Precio:" + selectedPrecioStr + " Fecha de pedido:" + selectedFecha;
                                    productoInfoSet.add(productoInfo);

                                    String selectedPrecioArreglo = rs.getString("precioarreglo");  // Nombre de la columna corregido
                                    String selectedPrendaArreglo = rs.getString("arreglo");  // Nombre de la columna corregido
                                    String selectedFechaArreglo = rs.getString("fechaprenda");  // Nombre de la columna corregido
                                    String productoInfoArreglo = "Arreglo:" + selectedPrendaArreglo + " Precio:" + selectedPrecioArreglo + " Fecha de pedido:" + selectedFechaArreglo;
                                    arregloInfoSet.add(productoInfoArreglo);

                                    String selectedMaterialSubli = rs.getString("material");
                                    String selectedPrecioSubli = rs.getString("preciosubl");
                                    String selectedFechaSubli = rs.getString("fechasublimacion");
                                    String productoInfoSubli = "Material:" + selectedMaterialSubli + " Precio:" + selectedPrecioSubli + " Fecha de pedido:" + selectedFechaSubli;
                                    sublimacionInfoSet.add(productoInfoSubli);
                                } while (rs.next());

                                productListComboBox.addItem("Seleccione");
                                arreglo.addItem("Seleccione");
                                sublimacion.addItem("Seleccione");

                                // Agrega elementos únicos desde el HashSet a productListComboBox
                                for (String producto : productoInfoSet)
                                {
                                    productListComboBox.addItem(producto);

                                }

                                // Agrega elementos únicos desde el HashSet a arreglo
                                for (String producto : arregloInfoSet)
                                {
                                    arreglo.addItem(producto);
                                }

                                // Agrega elementos únicos desde el HashSet a sublimacion
                                for (String producto : sublimacionInfoSet)
                                {
                                    sublimacion.addItem(producto);
                                }
                            } else
                            {
                                // Si no se encontraron productos, establece los campos en blanco y limpia los JComboBox
                                id_cliente.setText("");
                                txtcelular.setText("");
                                txtdireccion.setText("");
                                productListComboBox.removeAllItems();
                                arreglo.removeAllItems();
                                sublimacion.removeAllItems();
                            }

                            connection.close();
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    } else
                    {
                        // Si se selecciona "Seleccione", establece los campos en blanco
                        id_cliente.setText("");
                        txtcelular.setText("");
                        txtdireccion.setText("");
                    }
                }

            }
        });

        productListComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) productListComboBox.getSelectedItem();

                if (selectedProduct != null)
                {
                    if (selectedProduct.equals("Seleccione"))
                    {
                        // Si "Seleccione" está seleccionado, establece el valor de id_pedido en 0
                        id_pedidosat.setText("");
                    } else
                    {
                        try
                        {
                            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_sastreria,prenda,precio,fechaPedido,estado FROM PedidoSastreria WHERE CONCAT('Prenda:',prenda, ' ','Precio:', precio, ' ','Fecha de pedido:', fechaPedido) = ? and estado = 'Pendiente'");
                            preparedStatement.setString(1, selectedProduct);
                            ResultSet rs = preparedStatement.executeQuery();

                            if (rs.next())
                            {
                                int idPedido = rs.getInt("id_sastreria"); // Obtiene el valor entero de la columna "id_sastreria"
                                String idPedidoStr = String.valueOf(idPedido); // Convierte el valor entero a una cadena
                                id_pedidosat.setText(idPedidoStr);
                            }

                            connection.close();
                        } catch (SQLException ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        arreglo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) arreglo.getSelectedItem();

                if (selectedProduct != null)
                {
                    if (selectedProduct.equals("Seleccione"))
                    {
                        // Si "Seleccione" está seleccionado, establece el valor de id_pedido en 0
                        id_arreglo.setText("");
                    } else
                    {
                        try
                        {
                            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_arreglo,arreglo,precio,fechaPedido FROM PedidoArreglo WHERE CONCAT('Arreglo:',arreglo, ' ','Precio:', precio, ' ','Fecha de pedido:', fechaPedido) = ? and estado = 'Pendiente'");
                            preparedStatement.setString(1, selectedProduct);
                            ResultSet rs = preparedStatement.executeQuery();

                            if (rs.next())
                            {
                                int idPedido = rs.getInt("id_arreglo"); // Obtiene el valor entero de la columna "id_arreglo"
                                String idPedidoStr = String.valueOf(idPedido); // Convierte el valor entero a una cadena
                                id_arreglo.setText(idPedidoStr);
                            }

                            connection.close();
                        } catch (SQLException ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        sublimacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) sublimacion.getSelectedItem();

                if (selectedProduct != null)
                {
                    if (selectedProduct.equals("Seleccione"))
                    {
                        // Si "Seleccione" está seleccionado, establece el valor de id_pedido en 0
                        id_sublimacion.setText("");
                    } else
                    {
                        try
                        {
                            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
                            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_sublimacion,material,precio,fechaPedido,estado FROM PedidoSublimacion WHERE CONCAT('Material:',material, ' ','Precio:', precio, ' ','Fecha de pedido:', fechaPedido) = ? and estado = 'pendiente' ");
                            preparedStatement.setString(1, selectedProduct);
                            ResultSet rs = preparedStatement.executeQuery();

                            if (rs.next())
                            {
                                int idPedido = rs.getInt("id_sublimacion"); // Obtiene el valor entero de la columna "id_sublimacion"
                                String idPedidoStr = String.valueOf(idPedido); // Convierte el valor entero a una cadena
                                id_sublimacion.setText(idPedidoStr);
                            }

                            connection.close();
                        } catch (SQLException ex)
                        {
                            ex.printStackTrace();
                        }
                    }

                }
            }
        });
//        try
//        {
//            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT prenda, precio, id_pedido FROM PedidoSastreria";
//            ResultSet rs = stmt.executeQuery(sql);
//            DefaultListModel<String> model = new DefaultListModel<>();
//            model.addElement("Seleccione"); // Agrega el elemento "Seleccione" al principio
//
//            while (rs.next())
//            {
//                String prenda = rs.getString("prenda");
//                String precio = rs.getString("precio");
//                int idPedido = rs.getInt("id_pedido");
//                String nombreCompleto = prenda + " " + precio;
//                model.addElement(nombreCompleto);
//            }
//
//            connection.close();
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        txtpedidos.setSelectedIndex(0);
//
//        txtpedidos.addListSelectionListener(e ->
//        {
//            if (!e.getValueIsAdjusting())
//            {
//                String selectedClient = txtpedidos.getSelectedValue();
//                if (selectedClient != null && !selectedClient.equals("Seleccione"))
//                {
//                    try
//                    {
//                        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//                        Statement stmt = connection.createStatement();
//                        String sql = "SELECT prenda, precio, id_pedido FROM PedidoSastreria WHERE CONCAT(prenda, ' ', precio) = '" + selectedClient + "'";
//                        ResultSet rs = stmt.executeQuery(sql);
//
//                        if (rs.next())
//                        {
//                            int selectedClientId = rs.getInt("id_pedido");
//                            String selectedClientTelefono = rs.getString("prenda");
//                            String selectedClientDireccion = rs.getString("precio");
//
//                            // Actualiza los campos de texto con el ID y el teléfono del cliente seleccionado
//                            id_cliente.setText(Integer.toString(selectedClientId));
//                            txtcelular.setText(selectedClientTelefono);
//                            txtdireccion.setText(selectedClientDireccion);
//                        }
//
//                        connection.close();
//                    } catch (Exception ex)
//                    {
//                        ex.printStackTrace();
//                    }
//                } else
//                {
//                    // Si se selecciona "Seleccione", establece los campos en blanco
//                    id_cliente.setText("");
//                    txtcelular.setText("");
//                    txtdireccion.setText("");
//                }
//            }
//        });
    }

//    public void actualizarComboBoxPorNumero(int numero) {
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
//        try
//        {
//            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT material,precio,fechaPedido FROM PedidoSublimacion WHERE id_sublimacion = ? and estado = 'pendiente'");
//            preparedStatement.setInt(1, numero);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next())
//            {
//                String material = rs.getString("material");
//                String precio = rs.getString("precio");
//                String fechaPedido = rs.getString("fechaPedido");
//                model.addElement("Material: " + material + " Precio: " + precio + " Fecha de pedido: " + fechaPedido);
//            }
//
//            connection.close();
//        } catch (SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//
//        sublimacion.setModel(model);
//    }
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
        fechaentrega = new com.toedter.calendar.JDateChooser();
        txtcelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        btnCrear = new javax.swing.JButton();
        id_cliente = new javax.swing.JTextField();
        productListComboBox = new javax.swing.JComboBox<>();
        arreglo = new javax.swing.JComboBox<>();
        sublimacion = new javax.swing.JComboBox<>();
        id_pedidosat = new javax.swing.JTextField();
        id_arreglo = new javax.swing.JTextField();
        id_sublimacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtreferencia = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 640));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Crear envio");

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
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnatras)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        txtCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del cliente:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12)))); // NOI18N

        fechaentrega.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Entrega", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

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

        btnCrear.setBackground(new java.awt.Color(255, 153, 51));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        id_cliente.setEditable(false);
        id_cliente.setBackground(new java.awt.Color(255, 255, 255));
        id_cliente.setForeground(new java.awt.Color(255, 255, 255));
        id_cliente.setText("000000000");
        id_cliente.setBorder(null);

        productListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        productListComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sastrería", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        productListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productListComboBoxActionPerformed(evt);
            }
        });

        arreglo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        arreglo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arreglos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        arreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arregloActionPerformed(evt);
            }
        });

        sublimacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        sublimacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sublimación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N

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
                            .addGap(436, 436, 436))
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
                            .addComponent(fechaentrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addComponent(btnCrear)
                .addGap(155, 155, 155))
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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        String nombre = (String) txtCliente.getSelectedItem();

        Date fecha = fechaentrega.getDate();
        String idC = id_cliente.getText();
        String idSa = id_pedidosat.getText();
        String idA = id_arreglo.getText();
        String idS = id_sublimacion.getText();
        String referencia = txtreferencia.getText().trim();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombre.equals("Seleccione"))
        {
            camposVacios.append("\n - Nombre");
        }
        if (fecha == null)
        {
            camposVacios.append("\n - Fecha");
        }
        String categoria1 = (String) productListComboBox.getSelectedItem();
        String categoria2 = (String) arreglo.getSelectedItem();
        String categoria3 = (String) sublimacion.getSelectedItem();

        if (categoria1.equals("Seleccione") && categoria2.equals("Seleccione") && categoria3.equals("Seleccione"))
        {
            // Ningún JComboBox tiene una selección válida
            camposVacios.append("\n - Debe seleccionar al menos una categoría como sastreria,arreglos,sublimacion .");
        } else
        {
            // Al menos uno de los JComboBox tiene una selección válida
            // Puedes realizar alguna acción adicional aquí
        }
        // Obtiene el elemento seleccionado en el JComboBox

        if (!camposVacios.toString().equals("Los siguientes campos están vacíos:"))
        {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else
        {

            try
            {
                // Resto del código para la inserción en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement insertPs = conn.prepareStatement("INSERT INTO Envios (fechaenvio, id_cliente, id_sastreria, id_arreglo, id_sublimacion, referencia) VALUES (?, ?, ?, ?, ?, ?)");
                insertPs.setDate(1, new java.sql.Date(fecha.getTime()));
                insertPs.setObject(2, idC);
                insertPs.setObject(3, idSa); // Puede ser null si id_sastreria es nulo
                insertPs.setObject(4, idA); // Puede ser null si id_arreglo es nulo
                insertPs.setObject(5, idS); // Puede ser null si id_sublimacion es nulo
                insertPs.setObject(6, referencia);

                insertPs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");

//                TIENE QUE LLEVAR AL LISTADO DE CITAS
                Listado_de_envios cli = new Listado_de_envios();

                cli.setSize(1024, 640);
                cli.setLocation(0, 0);

                panelprincipal.revalidate();
                panelprincipal.repaint();
                panelprincipal.removeAll();
                panelprincipal.add(cli, BorderLayout.CENTER);
                panelprincipal.revalidate();
                panelprincipal.repaint();
            } catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

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
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnatras;
    private com.toedter.calendar.JDateChooser fechaentrega;
    private javax.swing.JTextField id_arreglo;
    public javax.swing.JTextField id_cliente;
    private javax.swing.JTextField id_pedidosat;
    private javax.swing.JTextField id_sublimacion;
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
    private javax.swing.JTextArea txtreferencia;
    // End of variables declaration//GEN-END:variables
}
