/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import static App.IngresodeCompra.tablecompras;
import static App.IngresodeCompra.Tsum;
import static App.Menu.panelprincipal;

import Paneles.Crear_Pedido_arreglo;
import Paneles.IngresarCompra;
import Paneles.TextPrompt;
import Paneles.crear_producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import static App.IngresodeCompra.panelcompra;
import static Paneles.Crear_Pedido_Sublimacion.txtPrecio;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author PC
 */
public class ProductoParaCompra extends javax.swing.JFrame {

    TextPrompt holder;

    //Variables para calcular el total de la factura
    static double totalFactura, suma;
    private boolean foundData;

    /**
     * Creates new form ProductoParaCompra
     */
    private IngresodeCompra ingresodeCompra;

    public ProductoParaCompra() {

        initComponents();
        this.setLocationRelativeTo(null);
        holder = new TextPrompt("Busque por nombre del producto y tipo de categoría", CuadroBuscarProducto);
        cargarTablaProductos();
        //Inicializando la variable para calcular el total de la factura
        totalFactura = 0;
        suma = 0;

        tblProductosParafactura.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblProductosParafactura.getTableHeader().setOpaque(false);
        tblProductosParafactura.getTableHeader().setBackground(new Color(255, 0, 0));
        tblProductosParafactura.getTableHeader().setForeground(new Color(255, 0, 0));
        tblProductosParafactura.setRowHeight(25);

        tblProductosParafactura.setRowSelectionAllowed(true);
        tblProductosParafactura.setColumnSelectionAllowed(false);

        int columnIndexToHide = 7;
        TableColumn column = tblProductosParafactura.getColumnModel().getColumn(columnIndexToHide);

        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);

        // Agregar DocumentListener a textField1
        cantidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarResultado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarResultado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarResultado();
            }
        });

        // Agregar DocumentListener a textField2
        txtPrecioUnitario.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarResultado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarResultado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarResultado();
            }
        });

//        tblProductosParafactura.getTableHeader().setReorderingAllowed(false);
//        Controlador.ProductosFactura.ProductoParaCompra("");
//        
//            tblProductosParafactura.addMouseListener(new MouseAdapter() {
//            public void MouseClicked(MouseEvent e){
//                int fila = tblProductosParafactura.getSelectedRow();
//            }
//        });   
    }

//    public static void calcular(){
//        suma = 0;
//        for(int i = 0; i< tblProductosCompras.getRowCount(); i++){
//            float renglon;
//            renglon = (float) Float.parseFloat(tblProductosCompras.getValueAt(i, 3).toString());
//            
//            suma = suma + renglon;
//        }
//    }
    /*
    private void cargarTablaProductos() {

        DefaultTableModel modeloTabla = (DefaultTableModel) tblProductosParafactura.getModel();

        modeloTabla.setRowCount(0); // Eliminar las filas existentes

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

            // Consulta para contar el número total de filas
            ps = conn.prepareStatement("SELECT COUNT(*) FROM Productos");
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

            // Consulta principal con paginación
            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY cod_producto) AS NumRegistro, nombre, categoria, precio, cod_producto "
                    + "FROM Productos ORDER BY cod_producto OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setInt(1, offset);
            ps.setInt(2, filasPorPagina);
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
            }

            ajustarTabla(filasPorPagina);

            // Eliminar filas vacías del modelo
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--)
            {
                boolean isEmptyRow = true;
                for (int j = 0; j < modeloTabla.getColumnCount(); j++)
                {
                    Object value = modeloTabla.getValueAt(i, j);
                    if (value != null && !value.toString().isEmpty())
                    {
                        isEmptyRow = false;
                        break;
                    }
                }
                if (isEmptyRow)
                {
                    modeloTabla.removeRow(i);
                }
            }

            // Obtener el número de filas actualizado
            int rowCount = modeloTabla.getRowCount();
//            Texto_Contable.setText("Cantidad de filas: " + rowCount + " - Página " + paginaActual + "/" + totalPaginas);

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    private void ajustarTabla(int filasDeseadas) {
        tblProductosParafactura.setPreferredScrollableViewportSize(new Dimension(tblProductosParafactura.getPreferredSize().width, tblProductosParafactura.getRowHeight() * filasDeseadas));
        tblProductosParafactura.setFillsViewportHeight(true);
    }
     */
//    private void buscarDatos(String texto) {
//        DefaultTableModel modelTabla = (DefaultTableModel) tablecompras.getModel();
//        modelTabla.setRowCount(0);
//        boolean foundData = false;
//
//        try
//        {
//            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
//            if (conn != null && !conn.isClosed())
//            {
//                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY E.nombre) AS NumRegistro, E.nombre, E.apellido, E.numero_telefono, V.fecha_cita "
//                        + "FROM Cliente E "
//                        + "JOIN Cita V ON E.id_cliente = V.id_cliente "
//                        + "WHERE E.nombre LIKE ? OR E.apellido LIKE ? OR V.fecha_cita LIKE ? "
//                        + "ORDER BY E.nombre "
//                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
//
//                if (texto != null && !texto.isEmpty())
//                {
//                    ps.setString(1, "%" + texto + "%");
//                    ps.setString(2, "%" + texto + "%");
//                    ps.setString(3, "%" + texto + "%");
//                    terminoBusqueda = texto; // Actualizar el término de búsqueda
//                } else
//                {
//                    ps.setString(1, "%");
//                    ps.setString(2, "%");
//                    ps.setString(3, "%");
//                    terminoBusqueda = ""; // Limpiar el término de búsqueda
//                }
//
//                // Define el OFFSET y FETCH NEXT de acuerdo a tus necesidades
//                int offset = 0; // Cambia el valor del offset según tus requerimientos
//                int fetchNext = 10; // Cambia la cantidad de registros a recuperar según tus requerimientos
//
//                ps.setInt(4, offset);
//                ps.setInt(5, fetchNext);
//
//                ResultSet rs = ps.executeQuery();
//
//                if (rs != null)
//                {
//                    while (rs.next())
//                    {
//                        int numRegistro = rs.getInt("NumRegistro");
//                        String nombre = rs.getString("nombre");
//                        String apellido = rs.getString("apellido");
//                        String numeroTelefono = rs.getString("numero_telefono");
//                        String fechaCita = rs.getString("fecha_cita");
//
//                        if (nombre != null && apellido != null && numeroTelefono != null)
//                        {
//                            modelTabla.addRow(new Object[]
//                            {
//                                numRegistro, nombre, apellido, numeroTelefono, fechaCita
//                            });
//                            foundData = true;
//                        }
//                    }
//
//                    rs.close();
//                }
//
//                ps.close();
//                conn.close();
//            }
//        } catch (Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//
//        // Llama a la función de cargarTablaEmpleados() si es necesario recargar la tabla después de la búsqueda
//        cargarTablaProductos(); // Recargar la tabla después de la búsqueda
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        cancelar = new javax.swing.JButton();
        cantidad = new javax.swing.JTextField();
        CuadroBuscarProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductosParafactura = new javax.swing.JTable();
        btncrear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Texto_Contable = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        txtPrecioventa = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar productos a la factura");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cancelar.setBackground(new java.awt.Color(255, 153, 51));
        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setText("Volver");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });

        CuadroBuscarProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CuadroBuscarProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CuadroBuscarProductoFocusLost(evt);
            }
        });
        CuadroBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuadroBuscarProductoActionPerformed(evt);
            }
        });
        CuadroBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CuadroBuscarProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CuadroBuscarProductoKeyTyped(evt);
            }
        });

        tblProductosParafactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num.", "Nombre del Producto", "Tipo de Categoria", "Cantidad disponible", "Precio unitario", "Precio de venta", "Precio de compra", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosParafactura.setShowHorizontalLines(true);
        tblProductosParafactura.setShowVerticalLines(true);
        tblProductosParafactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosParafacturaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProductosParafactura);

        btncrear.setBackground(new java.awt.Color(255, 153, 51));
        btncrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncrear.setText("Agregar Producto");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Agregar Producto a la Factura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        btnbuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnbuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Refrescar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        txtPrecioventa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio de venta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtPrecioventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioventaActionPerformed(evt);
            }
        });
        txtPrecioventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioventaKeyTyped(evt);
            }
        });

        txtPrecioCompra.setEditable(false);
        txtPrecioCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sub total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });

        txtPrecioUnitario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio de compra(unitario)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitarioActionPerformed(evt);
            }
        });
        txtPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUnitarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(CuadroBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(258, 258, 258)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtPrecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CuadroBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Texto_Contable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncrear)
                    .addComponent(cancelar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void calcular() {

        float suma = 0;
        for (int i = 0; i < tablecompras.getRowCount(); i++)
        {

            float renglon;
            renglon = Float.parseFloat(tablecompras.getValueAt(i, 4).toString());

            suma = suma + renglon;
        }
        Tsum.setText(String.valueOf(suma));

    }


    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void CuadroBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CuadroBuscarProductoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_CuadroBuscarProductoKeyTyped

    private void actualizarResultado() {
        try
        {
            double value1 = Double.parseDouble(cantidad.getText());
            double value2 = Double.parseDouble(txtPrecioUnitario.getText());
            double result = value1 * value2;
            txtPrecioCompra.setText(String.valueOf(result));
        } catch (NumberFormatException ex)
        {
            txtPrecioCompra.setText("0.0");
        }
    }
    private void CuadroBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CuadroBuscarProductoKeyReleased
        // TODO add your handling code here:
//        filtrarDatosProductos(CuadroBuscarProducto.getText());
    }//GEN-LAST:event_CuadroBuscarProductoKeyReleased

    private void CuadroBuscarProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CuadroBuscarProductoFocusGained
        // TODO add your handling code here:
        //placeholder para notificar como realizar la busqueda
        //JTextField textField = (JTextField) evt.getSource();
        // String placeholder = "Buscar por nombre de producto y tipo de inventario";

        //if (textField.getText().equals(placeholder))
        // {
        //     textField.setText("");
        //     textField.setForeground(Color.BLACK); // Establece el color de fuente adecuado
        //   }
    }//GEN-LAST:event_CuadroBuscarProductoFocusGained

    private void CuadroBuscarProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CuadroBuscarProductoFocusLost
        // TODO add your handling code here:
        //placeholder para notificar como realizar la busqueda
        //  JTextField textField = (JTextField) evt.getSource();
        //  String placeholder = "Buscar por nombre de producto y tipo de categoria";

        //  if (textField.getText().isEmpty())
        //  {
        //      textField.setText(placeholder);
        //     textField.setForeground(Color.GRAY); // Establece el color de fuente del placeholder
        // }
    }//GEN-LAST:event_CuadroBuscarProductoFocusLost

    private void CuadroBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuadroBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuadroBuscarProductoActionPerformed

    private void tblProductosParafacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosParafacturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProductosParafacturaMouseClicked

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
        // TODO add your handling code here:
        //validacion para que no acepte letras
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
        }
        //validacion de que no permita espacios o caracteres especiales
        if (evt.getKeyChar() >= 30 && evt.getKeyChar() <= 47 || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 97)
        {
            getToolkit().beep();
            evt.consume();
        }
        //Validar que solo se puedan ingresar una cantidad de 3 numeros
        if (cantidad.getText().length() >= 4)
        {
            getToolkit().beep();
            evt.consume();
        }
        //validar que no se ingrese primero un cero
        if (cantidad.getText().startsWith("0"))
        {
            // Emitir un sonido de error
            getToolkit().beep();
            // Consumir el evento para evitar que se ingrese el cero
            evt.consume();
        }
    }//GEN-LAST:event_cantidadKeyTyped

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        paginaActual = 1;
        terminoBusqueda = "";

        // Limpiar el campo de búsqueda
        CuadroBuscarProducto.setText("");

        // Cargar la tabla con los datos actualizados
        cargarTablaProductos();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String texto = CuadroBuscarProducto.getText().trim();

        //Validacion del texto ingresado
        if (!texto.isEmpty())
        {
            buscarDatos(texto);
        } else
        {
            JOptionPane.showMessageDialog(null, "Tiene que ingresar texto para hacer la respectiva búsqueda");
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        paginaAnterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguientePagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed

        int fila = tblProductosParafactura.getSelectedRow();

        try
        {
            //Variables para capturar los campos de la tabla de productos
            String nombreProd, cantid, precU, PrecV, PrecC, idProducto;
            double tot = 0.0, calcula = 0.0;

            if (fila < 0)
            {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún producto",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se seleccionó ningún producto
            }

            if (cantidad.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "No se ingresó una cantidad",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se ingresó una cantidad
            }

            if (cantidad.getText().startsWith("0"))
            {
                JOptionPane.showMessageDialog(null, "Ingrese cantidades mayores a cero(0)",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se ingresó una cantidad
            }

            if (txtPrecioUnitario.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "No se ingresó un Precio unitario",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se ingresó una cantidad
            }

            if (txtPrecioUnitario.getText().startsWith("0"))
            {
                JOptionPane.showMessageDialog(null, "Ingrese un precio unitario mayor a cero(0)",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se ingresó una cantidad
            }

            if (txtPrecioventa.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "No se ingresó un Precio de venta",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se ingresó una cantidad
            }

            if (txtPrecioventa.getText().startsWith("0"))
            {
                JOptionPane.showMessageDialog(null, "Ingrese un precio de venta mayor a cero(0)",
                        "Error al agregar producto", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se ingresó una cantidad
            }

            DefaultTableModel modelo = (DefaultTableModel) tblProductosParafactura.getModel();
            nombreProd = tblProductosParafactura.getValueAt(fila, 1).toString();
//            precU = tblProductosParafactura.getValueAt(fila, 4).toString();
//            PrecV = tblProductosParafactura.getValueAt(fila, 5).toString();
//            PrecC = tblProductosParafactura.getValueAt(fila, 6).toString();
            idProducto = tblProductosParafactura.getValueAt(fila, 7).toString();
            precU = txtPrecioUnitario.getText();
            PrecV = txtPrecioventa.getText();
            PrecC = txtPrecioCompra.getText();
            cantid = cantidad.getText();

            //Se realizan los cálculos para el total en la factura
            tot = (Double.parseDouble(precU) * Integer.parseInt(cantid));

            DecimalFormat df = new DecimalFormat("#0.00");
//            totalP = df.format(tot);
            //            totalP = String.valueOf(tot);

            //Enviar los campos seleccionados de la tabla de productos a la tabla de factura de compras
            modelo = (DefaultTableModel) tablecompras.getModel();
            // Buscar el producto en la tabla tblProductosCompras
            int rowCount = modelo.getRowCount();
            boolean productoEncontrado = false;

            for (int i = 0; i < rowCount; i++)
            {
                String productoExistente = modelo.getValueAt(i, 0).toString();
                if (productoExistente.equals(nombreProd))
                {
                    // El producto ya existe en la tabla, actualizar la cantidad y el total
                    String cantidadExistente = modelo.getValueAt(i, 1).toString();
                    int nuevaCantidad = Integer.parseInt(cantidadExistente) + Integer.parseInt(cantid);
                    modelo.setValueAt(String.valueOf(nuevaCantidad), i, 1);

                    String totalExistente = modelo.getValueAt(i, 5).toString();
                    double precioUnitario = Double.parseDouble(precU);
                    double nuevoTotal = precioUnitario * nuevaCantidad;
                    modelo.setValueAt(String.valueOf(nuevoTotal), i, 5);

                    String totalExistentes = modelo.getValueAt(i, 4).toString();
                    double precioUnitarios = Double.parseDouble(precU);
                    double nuevoTotals = precioUnitarios * nuevaCantidad;
                    modelo.setValueAt(String.valueOf(nuevoTotals), i, 4);

                    productoEncontrado = true;
                    break;
                }
            }

            if (!productoEncontrado)
            {
                // El producto no existe en la tabla, agregarlo como una nueva fila
                tot = Double.parseDouble(precU) * Integer.parseInt(cantid);
//                totalP = String.valueOf(tot);

                String filaElemento[] =
                {
                    nombreProd, cantid, precU, PrecV, PrecC, idProducto
                };
                modelo.addRow(filaElemento);
            }
            calcular();

            //calculo para que se sumen los totales de la factura a uno solo y se envíe a la tabla de facturas
            calcula = Double.parseDouble(precU) * Integer.parseInt(cantidad.getText());
            totalFactura += calcula; // Sumar al total existente

            //this.dispose();
            // Limpiar el campo de cantidad después de agregar el producto
            cantidad.setText("");
            txtPrecioCompra.setText("");
            txtPrecioUnitario.setText("");
            txtPrecioventa.setText("");

            JOptionPane.showMessageDialog(null, "Se agrego el producto!");

            //            ver.setSize(1024, 640);
            //            ver.setLocation(0, 0);
            //            jPanel1.removeAll();
            //            jPanel1.add(ver, BorderLayout.CENTER);
            //            jPanel1.revalidate();
            //            jPanel1.repaint();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btncrearActionPerformed

    private void txtPrecioventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioventaActionPerformed

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed

    private void txtPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUnitarioActionPerformed

    private void txtPrecioUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
        }
        //validacion de que no permita espacios o caracteres especiales
        if (evt.getKeyChar() >= 30 && evt.getKeyChar() <= 47 || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 97)
        {
            getToolkit().beep();
            evt.consume();
        }
        //Validar que solo se puedan ingresar una cantidad de 3 numeros
        if (txtPrecioUnitario.getText().length() >= 5)
        {
            getToolkit().beep();
            evt.consume();
        }
        //validar que no se ingrese primero un cero
        if (txtPrecioUnitario.getText().startsWith("0"))
        {
            // Emitir un sonido de error
            getToolkit().beep();
            // Consumir el evento para evitar que se ingrese el cero
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioUnitarioKeyTyped

    private void txtPrecioventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioventaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
        }
        //validacion de que no permita espacios o caracteres especiales
        if (evt.getKeyChar() >= 30 && evt.getKeyChar() <= 47 || evt.getKeyChar() >= 58 && evt.getKeyChar() <= 97)
        {
            getToolkit().beep();
            evt.consume();
        }
        //Validar que solo se puedan ingresar una cantidad de 3 numeros
        if (txtPrecioventa.getText().length() >= 5)
        {
            getToolkit().beep();
            evt.consume();
        }
        //validar que no se ingrese primero un cero
        if (txtPrecioventa.getText().startsWith("0"))
        {
            // Emitir un sonido de error
            getToolkit().beep();
            // Consumir el evento para evitar que se ingrese el cero
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioventaKeyTyped

    int selectedRow2;
    int paginaActual = 1; // Página actual
    int filasPorPagina = 20; // Número de filas a mostrar por página
    int totalFilas = 0; // Total de filas en la tabla
    int totalPaginas = 0; // Total de páginas en la tabla
    int numRegistro = 0;
    String terminoBusqueda = ""; // Término de búsqueda actual

    private void cargarTablaProductos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblProductosParafactura.getModel();
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
                    + "FROM Productos "
                    + "WHERE nombre LIKE ? OR categoria LIKE ?");
            ps.setString(1, "%" + terminoBusqueda + "%");
            ps.setString(2, "%" + terminoBusqueda + "%");

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
            ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER (ORDER BY nombre) AS NumRegistro, \n"
                    + "       Productos.nombre, \n"
                    + "       Productos.categoria, \n"
                    + "       Productos.cantidad_disponible, \n"
                    + "       Pr.precio_unitario, \n"
                    + "       Pr.precio_venta, \n"
                    + "       Pr.precio_compra, \n"
                    + "       Productos.cod_producto\n"
                    + "FROM Productos \n"
                    + "JOIN Precio Pr ON Productos.cod_producto = Pr.cod_producto\n"
                    + "WHERE Productos.nombre LIKE ? OR Productos.categoria LIKE ? \n"
                    + "ORDER BY Productos.nombre \n"
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
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
        tblProductosParafactura.setPreferredScrollableViewportSize(new Dimension(tblProductosParafactura.getPreferredSize().width, tblProductosParafactura.getRowHeight() * filasDeseadas));
        tblProductosParafactura.setFillsViewportHeight(true);
    }

    private void siguientePagina() {
        if (paginaActual < totalPaginas)
        {
            paginaActual++;
            cargarTablaProductos();
        }
    }

    private void paginaAnterior() {
        if (paginaActual > 1)
        {
            paginaActual--;
            cargarTablaProductos();
        }
    }

    private void buscarDatos(String texto) {
        DefaultTableModel modelTabla = (DefaultTableModel) tblProductosParafactura.getModel();
        modelTabla.setRowCount(0);
        boolean foundData = false;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");
            if (conn != null && !conn.isClosed())
            {
                PreparedStatement ps = conn.prepareStatement("SELECT ROW_NUMBER() OVER (ORDER BY nombre) AS NumRegistro, \n"
                        + "       Productos.nombre, \n"
                        + "       Productos.categoria, \n"
                        + "       Productos.cantidad_disponible, \n"
                        + "       Pr.precio_unitario, \n"
                        + "       Pr.precio_venta, \n"
                        + "       Pr.precio_compra, \n"
                        + "       Productos.cod_producto\n"
                        + "FROM Productos \n"
                        + "JOIN Precio Pr ON Productos.cod_producto = Pr.cod_producto\n"
                        + "WHERE Productos.nombre LIKE ? OR Productos.categoria LIKE ? ");

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
                        String categoria = rs.getString("categoria");
                        String cantidad = rs.getString("cantidad_disponible");
                        String PU = rs.getString("precio_unitario");
                        String PV = rs.getString("precio_venta");
                        String PC = rs.getString("precio_compra");
                        String CP = rs.getString("cod_producto");

                        if (nombre != null && categoria != null)
                        {
                            modelTabla.addRow(new Object[]
                            {
                                numRegistro, nombre, categoria, cantidad, PU, PV, PC, CP
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

        cargarTablaProductos(); // Recargar la tabla después de la búsqueda
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CuadroBuscarProducto;
    private javax.swing.JLabel Texto_Contable;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btncrear;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tblProductosParafactura;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtPrecioventa;
    // End of variables declaration//GEN-END:variables

}
