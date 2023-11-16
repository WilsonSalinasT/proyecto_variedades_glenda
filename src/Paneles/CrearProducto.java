/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import static Paneles.editar_cliente.txtnombre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Fernando Amador
 */
public class CrearProducto extends javax.swing.JPanel {

    /**
     * Creates new form CrearProducto
     */
    public CrearProducto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        txtprecio = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creación del Producto");

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("9801-4550 / 3308-9197");

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Trojes, El Paraíso");

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("VOLVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Seleccione la categoría del producto");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Arreglos", "Sastrería", "Sublimación" }));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtdescripcion.setColumns(20);
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setRows(5);
        txtdescripcion.setWrapStyleWord(true);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 0, 12))); // NOI18N
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtdescripcion);

        txtprecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtprecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecioFocusLost(evt);
            }
        });
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(txtprecio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String nombre = txtnombre.getText().trim();
String descripcion = txtdescripcion.getText().trim();
String categoria = (String) jComboBox1.getSelectedItem();
String precio = txtprecio.getText().trim(); // Assuming txtPrecio is the field for the price

StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

if (nombre.isEmpty()) {
    camposVacios.append("\n - Nombre");
}
if (descripcion.isEmpty()) {
    camposVacios.append("\n - Descripcion");
}
String categorias = jComboBox1.getSelectedItem().toString();

if (categorias.equals("Seleccione")) {
    camposVacios.append("\n - Categoria");
}
if (precio.isEmpty()) {
    camposVacios.append("\n - Precio");
}

if (!camposVacios.toString().equals("Los siguientes campos están vacíos:")) {
    JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
} else {
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

        // Verifica si ya existe un producto con el mismo nombre
        PreparedStatement checkNamePs = conn.prepareStatement("SELECT COUNT(*) FROM Productos WHERE nombre = ?");
        checkNamePs.setString(1, nombre);
        ResultSet result = checkNamePs.executeQuery();
        result.next();
        int count = result.getInt(1);

        if (count > 0) {
            // Obtenemos el nombre del producto que ya existe
            PreparedStatement getExistingNamePs = conn.prepareStatement("SELECT nombre FROM Productos WHERE nombre = ?");
            getExistingNamePs.setString(1, nombre);
            ResultSet existingNameResult = getExistingNamePs.executeQuery();
            existingNameResult.next();
            String existingName = existingNameResult.getString("nombre");

            JOptionPane.showMessageDialog(null, "El productos con nombre '" + existingName + "' ya existe. Por favor, elige otro nombre.");
        } else {
            // Si el nombre es único, procede con la inserción
            PreparedStatement insertPs = conn.prepareStatement("INSERT INTO Productos (nombre,descripcion,categoria,precio) VALUES (?,?,?,?)");
            insertPs.setString(1, nombre);
            insertPs.setString(2, descripcion);
            insertPs.setString(3, categoria);
            insertPs.setDouble(4, Double.parseDouble(precio));

            insertPs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado");

            Listado_Productos cli = new Listado_Productos();

            cli.setSize(1024, 640);
            cli.setLocation(0, 0);

            panelprincipal.revalidate();
            panelprincipal.repaint();
            panelprincipal.removeAll();
            panelprincipal.add(cli, BorderLayout.CENTER);
            panelprincipal.revalidate();
            panelprincipal.repaint();
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
    }
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtdescripcion.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (txtdescripcion.getText().length() >= 300)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char c = evt.getKeyChar();

        // Verificar si el carácter es una letra (mayúscula o minúscula)
        if (!(Character.isLetter(c)))
        {
            evt.consume(); // Consumir el evento (ignorar la entrada del usuario)
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Listado_Productos l2 = new Listado_Productos();
        l2.setSize(1024, 640);
        l2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(l2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtprecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecioFocusLost
        //        String correo = txtcorreo.getText().trim();
        //
        //        if (isValidEmailAddress(correo))
        //        {
            //            // La dirección de correo electrónico es válida.
            //            // Puedes realizar acciones adicionales aquí si es necesario.
            //        } else
        //        {
            //            // La dirección de correo electrónico no es válida.
            //            // Muestra un mensaje de error o realiza alguna acción de retroalimentación.
            //            JOptionPane.showMessageDialog(null, "Correo electrónico no válido", "Error", JOptionPane.ERROR_MESSAGE);
            //            txtcorreo.requestFocus(); // Devuelve el foco al campo de correo electrónico.
            //        }
    }//GEN-LAST:event_txtprecioFocusLost

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
       String precioTexto = txtprecio.getText().trim();

    // Validar que el precio sea un número y tenga como máximo 6 caracteres
    if (esNumero(precioTexto) && precioTexto.length() <= 6) {
        // Puedes realizar acciones adicionales si la validación es exitosa
        System.out.println("Precio válido: " + precioTexto);
    } else {
        // Mostrar un mensaje de error si la validación falla
        JOptionPane.showMessageDialog(null, "Por favor, introduce un número con un máximo de 6 caracteres en el campo de precio.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        // Puedes restaurar el valor anterior si es necesario
        // txtprecio.setText(valorAnterior);
    }
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyReleased
        //        String email = txtcorreo.getText(); // Obtiene el texto del campo de correo
        //        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        //        Pattern pattern = Pattern.compile(regex);
        //        Matcher matcher = pattern.matcher(email);
        //
        //        if (matcher.matches())
        //        {
            //            String successMessage = "<html><font color='green'>El email cumple con los requisitos</font></html>";
            //            JOptionPane.showMessageDialog(this, successMessage, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            //        } else
        //        {
            //            String errorMessage = "<html><font color='red'>El email no cumple con los requisitos</font></html>";
            //            JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            //        }
    }//GEN-LAST:event_txtprecioKeyReleased

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '&' && c != '#' && c != '$' && c != '?' && c != '-')
        {
            evt.consume(); // Consumir el evento si no es una letra, un número, '@' o '.'
        } else if (txtprecio.getText().length() >= 30)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtprecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables

    private boolean esNumero(String precio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
