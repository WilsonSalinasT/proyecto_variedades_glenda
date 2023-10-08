/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Salinas
 */
public class editar_cliente extends javax.swing.JPanel {

    ButtonGroup rg_sexo = new ButtonGroup();
    private String id_cliente;
    private String numeracion;

    /**
     * Creates new form editar_cliente
     */
    public editar_cliente() {
        initComponents();
        rg_sexo.add(rbfemenino);
        rg_sexo.add(rbmasculino);
        
        TextPrompt holder = new TextPrompt("####-####", txttelefono);
        TextPrompt holdere = new TextPrompt("alguien@example.com", txtcorreo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btncrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Id_cl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnatras = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Editar cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(28, 28, 28))
        );

        txttelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero de celular:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        txtcorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo electrónico:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
            }
        });

        btncrear.setBackground(new java.awt.Color(255, 0, 51));
        btncrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncrear.setText("Editar");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtapellido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        rbmasculino.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        rbmasculino.setForeground(new java.awt.Color(0, 0, 0));
        rbmasculino.setText("Masculino");

        rbfemenino.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        rbfemenino.setForeground(new java.awt.Color(0, 0, 0));
        rbfemenino.setText("Femenino");

        jtadireccion.setColumns(20);
        jtadireccion.setLineWrap(true);
        jtadireccion.setRows(5);
        jtadireccion.setWrapStyleWord(true);
        jtadireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        jtadireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtadireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtadireccion);

        Id_cl.setEditable(false);
        Id_cl.setForeground(new java.awt.Color(255, 255, 255));
        Id_cl.setBorder(null);
        Id_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_clActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(59, 59, 59));
        jLabel4.setText("Género:");

        btnatras.setBackground(new java.awt.Color(255, 0, 51));
        btnatras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnatras.setText("Atras");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Id_cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rbmasculino)
                                .addGap(115, 115, 115)
                                .addComponent(rbfemenino)
                                .addGap(25, 25, 25))
                            .addComponent(txtapellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(201, 201, 201)
                .addComponent(btnatras)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(450, 450, 450))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnatras)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Id_cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbfemenino)
                    .addComponent(rbmasculino))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncrear)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        String id = Id_cl.getText().trim();
        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String direccion = jtadireccion.getText().trim();
        String telefono = txttelefono.getText().trim();
        String correo = txtcorreo.getText().trim();

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

                PreparedStatement updatePs = conn.prepareStatement("UPDATE Cliente SET nombre=?, apellido=?, genero=?, direccion=?, numero_telefono=?, correo_electronico=? WHERE id_cliente=?");

                int numeracion = Integer.parseInt(Id_cl.getText());

                // Configura los primeros 7 parámetros
                updatePs.setString(1, nombre);
                updatePs.setString(2, apellido);
                updatePs.setString(3, sexo);
                updatePs.setObject(4, direccion);
                updatePs.setString(5, telefono);
                updatePs.setString(6, correo);

                // Configura el octavo parámetro (id_cliente)
                updatePs.setInt(7, numeracion); // Asumiendo que id_cliente es un valor numérico

                int rowsUpdated = updatePs.executeUpdate();

                if (rowsUpdated > 0)
                {
                    JOptionPane.showMessageDialog(null, "Registro actualizado");
                    clientes cli = new clientes();

                    cli.setSize(1080, 640);
                    cli.setLocation(0, 0);

                    panelprincipal.revalidate();
                    panelprincipal.repaint();
                    panelprincipal.removeAll();
                    panelprincipal.add(cli, BorderLayout.CENTER);
                    panelprincipal.revalidate();
                    panelprincipal.repaint();
                } else
                {
                    //hola
                    JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
//hola
        }
    }//GEN-LAST:event_btncrearActionPerformed

    private void Id_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_clActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_clActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        clientes p2 = new clientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_btnatrasActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
         char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtnombre.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (!Character.isLetter(c) && !Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si no es una letra o espacio en blanco
        } else if (txtnombre.getText().length() >= 50)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtapellido.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (!Character.isLetter(c) && !Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si no es una letra o espacio en blanco
        } else if (txtapellido.getText().length() >= 50)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void jtadireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtadireccionKeyTyped
       char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (jtadireccion.getText().isEmpty() && Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera letra
        } else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
        {
            evt.consume(); // Consumir el evento si no es una letra, un número o espacio en blanco
        } else if (jtadireccion.getText().length() >= 300)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_jtadireccionKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        String input = txttelefono.getText();
        char c = evt.getKeyChar();
        String texto = txttelefono.getText();

        // Verificar si se ingresó un dígito y el número de caracteres no excede el formato esperado
        if (Character.isDigit(c) && texto.length() < 9)
        {
            // Formato: XXXX-XXXX (4 dígitos seguidos de un guion y otros 4 dígitos)
            if (texto.length() == 4)
            {
                txttelefono.setText(texto + "-");
            }
        } else
        {
            evt.consume();  // Ignorar el carácter ingresado si no cumple con el formato esperado
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyTyped
         char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '&' && c != '#' && c != '$' && c != '?' && c != '-')
        {
            evt.consume(); // Consumir el evento si no es una letra, un número, '@' o '.'
        } else if (txtcorreo.getText().length() >= 30)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_txtcorreoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Id_cl;
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btncrear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTextArea jtadireccion = new javax.swing.JTextArea();
    public static final javax.swing.JRadioButton rbfemenino = new javax.swing.JRadioButton();
    public static final javax.swing.JRadioButton rbmasculino = new javax.swing.JRadioButton();
    public static final javax.swing.JTextField txtapellido = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtcorreo = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtnombre = new javax.swing.JTextField();
    public static final javax.swing.JTextField txttelefono = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables

    private int obtenerIdCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
