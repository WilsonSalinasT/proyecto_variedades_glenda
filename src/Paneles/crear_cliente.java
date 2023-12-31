/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import static App.Menu.panelprincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.Time;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;

/**
 *
 * @author novastar
 */
public class crear_cliente extends javax.swing.JPanel {

    TextPrompt holder;
    ButtonGroup rg_Sexo = new ButtonGroup();

    /**
     *
     * Creates new form crear_cliente
     */
    public crear_cliente() {
        initComponents();
        TextPrompt holder = new TextPrompt("####-####", txttelefono);
        TextPrompt holdere = new TextPrompt("alguien@example.com", txtcorreo);

        rg_Sexo.add(rbfemenino);
        rg_Sexo.add(rbmasculino);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFechaHora();
            }
        });
        timer.start();

//        txtfecharegistro.setText(FechaParaM());
    }

    private void actualizarFechaHora() {
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdfFecha.format(new Date());
        lbfecha.setText(fechaActual);

    }

    public String FechaParaM() {

        Date fecha = new Date();
        SimpleDateFormat FechaActual = new SimpleDateFormat("yyyy-MM-dd");

        return FechaActual.format(fecha);

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
        jLabel4 = new javax.swing.JLabel();
        btncrear = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        rbmasculino = new javax.swing.JRadioButton();
        rbfemenino = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtadireccion = new javax.swing.JTextArea();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        lbfecha = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Crear cliente");

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
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnatras)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnatras)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(59, 59, 59));
        jLabel4.setText("Género:");

        btncrear.setBackground(new java.awt.Color(255, 153, 51));
        btncrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncrear.setText("Crear");
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
        rbmasculino.setSelected(true);
        rbmasculino.setText("Masculino");

        rbfemenino.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
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

        txttelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de celular:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        txtcorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo electrónico:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 2, 12))); // NOI18N
        txtcorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcorreoFocusLost(evt);
            }
        });
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
            }
        });

        lbfecha.setBackground(new java.awt.Color(255, 255, 255));
        lbfecha.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(rbmasculino)
                .addGap(133, 133, 133)
                .addComponent(rbfemenino)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtapellido)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(192, 192, 192)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
                .addGap(345, 345, 345))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbmasculino)
                    .addComponent(rbfemenino))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncrear)
                .addGap(18, 18, 18)
                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed

        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String direccion = jtadireccion.getText().trim();
        String telefono = txttelefono.getText().trim();
        String correo = txtcorreo.getText().trim();
        // Obtener la fecha en el formato requerido por SQL Server
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaRegistro = sdfSQL.format(new Date());

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
        } else if (!correo.matches("^[A-Za-z0-9+_.-]+@.+\\.com$"))
        {
            camposVacios.append("\n - Correo no cumple con los requisitos");
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
                // Resto del código para la inserción en la base de datos
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement insertPs = conn.prepareStatement("INSERT INTO Cliente (nombre, apellido, genero, direccion, numero_telefono, correo_electronico, fecha_registro) VALUES (?,?,?,?,?,?,?)");
                insertPs.setString(1, nombre);
                insertPs.setString(2, apellido);
                insertPs.setString(3, sexo);
                insertPs.setObject(4, direccion);
                insertPs.setString(5, telefono);
                insertPs.setString(6, correo);
                insertPs.setString(7, fechaRegistro);

                insertPs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");

                clientes cli = new clientes();

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
    }//GEN-LAST:event_btncrearActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txtcorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcorreoFocusLost
//        String correo = txtcorreo.getText().trim();
//
//        if (isValidEmailAddress(correo)) {
//            // La dirección de correo electrónico es válida.
//            // Puedes realizar acciones adicionales aquí si es necesario.
//        } else {
//            // La dirección de correo electrónico no es válida.
//            // Muestra un mensaje de error o realiza alguna acción de retroalimentación.
//            JOptionPane.showMessageDialog(null, "Correo electrónico no válido", "Error", JOptionPane.ERROR_MESSAGE);
//            txtcorreo.requestFocus(); // Devuelve el foco al campo de correo electrónico.
//        }

    }//GEN-LAST:event_txtcorreoFocusLost

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
        } else if (jtadireccion.getText().length() >= 300)
        {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }
    }//GEN-LAST:event_jtadireccionKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
     // Obtener el carácter que se está ingresando
    char c = evt.getKeyChar();

    // Validar que el carácter sea un número
    if (!Character.isDigit(c)) {
        // Si no es un número, cancelar el evento
        evt.consume();
        return;
    }

    // Obtener el texto actual del campo de texto
    String texto = txttelefono.getText();

    // Validar que el primer carácter sea 9, 8, o 3
    if (texto.length() == 0 && (c != '9' && c != '8' && c != '3')) {
        // Si no es 9, 8, o 3, cancelar el evento
        evt.consume();
        return;
    }

    // Insertar un guion después del cuarto número
    if (texto.length() == 4) {
        txttelefono.setText(texto + "-");
    }

    // No permitir más de 9 caracteres
    if (texto.length() == 9) {
        evt.consume();
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

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        clientes p2 = new clientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        jPanel1.removeAll();
        jPanel1.add(p2, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_btnatrasActionPerformed

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        String texto = txttelefono.getText().trim();
        char c = evt.getKeyChar();

        if (texto.startsWith("9") || texto.startsWith("8") || texto.startsWith("3") || c == 9 && c == 8 & c == 3)
        {
            txttelefono.setBackground(Color.green);
        } else
        {
            // El texto no cumple con la validación
            evt.consume(); // Bloquea el carácter
            JOptionPane.showMessageDialog(this, "El número de celular debe comenzar con 9, 8 o 3", "Error", JOptionPane.ERROR_MESSAGE);
            txttelefono.setBackground(Color.red);
            txttelefono.setText("");
        }
    }//GEN-LAST:event_txttelefonoKeyReleased

//    public boolean isValidEmailAddress(String email) {
//        // Define una expresión regular para validar direcciones de correo electrónico.
//        // Esta es una implementación básica y puede necesitar ser ajustada.
//        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btncrear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtadireccion;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JRadioButton rbfemenino;
    private javax.swing.JRadioButton rbmasculino;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    private boolean isValidDateFormat(String fechaHora, String ddMMyyyy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
