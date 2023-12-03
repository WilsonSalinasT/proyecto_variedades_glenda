/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Paneles.TextPrompt;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Fernando Amador
 */
public class Crear_Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Usuario
     */
    TextPrompt holder;

    public Crear_Usuario() {
        initComponents();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Evitar que la ventana se cierre por defecto
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                // Aquí podrías realizar acciones adicionales si es necesario antes de cerrar la ventana
                // Por ejemplo, ocultar la ventana en lugar de cerrarla
                setVisible(false);
            }
        });

        contra1.setVisible(false);

        holder = new TextPrompt("Nombre de usuario", txtNombre);
        holder = new TextPrompt("Introducir la contraseña", txtcontrasena1);
        holder = new TextPrompt("Volver a introducir la contraseña", txtcontrasena2);

        txtcontrasena1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                showWarning();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showWarning();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showWarning();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcontrasena1 = new javax.swing.JTextField();
        txtcontrasena2 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contra1 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Si quieres usar una contraseña, elige algo que te resulte fácil de recordar, pero que sea ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("difícil de adivinar para los demás.");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("¿Quién va usar este programa?");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Dale seguridad.");

        txtcontrasena1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontrasena1FocusLost(evt);
            }
        });
        txtcontrasena1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrasena1KeyTyped(evt);
            }
        });

        txtcontrasena2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrasena2KeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(240, 128, 128));
        btnGuardar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnvolver.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(240, 128, 128));

        jLabel1.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear una cuenta de usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
        );

        contra1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        contra1.setForeground(new java.awt.Color(255, 0, 0));
        contra1.setText("La contraseña debe maximo 12 caracteres, puede incluir mayúsculas, minúsculas, números y caracteres especiales (*, &, $, etc.).");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contra1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtcontrasena2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                .addComponent(txtcontrasena1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 46, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcontrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtcontrasena2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void showWarning() {
        if (txtcontrasena1.getText().isEmpty()) {
            contra1.setVisible(false);
        } else {
            contra1.setVisible(true);
        }
    }


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreUsuario = txtNombre.getText().trim();
        String contrasena = txtcontrasena1.getText().trim();
        String contrasena1 = txtcontrasena2.getText().trim();

        StringBuilder camposVacios = new StringBuilder("Los siguientes campos están vacíos:");

        if (nombreUsuario.isEmpty()) {
            camposVacios.append("\n - Nombre de Usuario");
        }

        if (contrasena.isEmpty()) {
            camposVacios.append("\n - Contraseña");
        }

        if (contrasena1.isEmpty()) {
            camposVacios.append("\n - Volver a introducir la contraseña");
        }

        if (!contrasena.equals(contrasena1)) {
            camposVacios.append("\n - Las contraseñas no coinciden");
        }

        if (!"Los siguientes campos están vacíos:".equals(camposVacios.toString())) {
            JOptionPane.showMessageDialog(null, camposVacios.toString(), "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GlendaDB;encrypt=true;trustServerCertificate=true;", "sa", "123456789");

                PreparedStatement insertPs = conn.prepareStatement("INSERT INTO Usuarios (nombre_usuario, contrasena) VALUES (?, ?)");
                insertPs.setString(1, nombreUsuario);
                insertPs.setString(2, contrasena);

                insertPs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");

                dispose(); // Cierra la ventana

                // Resto del código para limpiar campos y actualizar la interfaz gráfica
                // ...
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (txtNombre.getText().isEmpty() && (Character.isWhitespace(c) || !Character.isLetter(c))) {
            evt.consume(); // Consumir el evento si es un espacio en blanco o no es una letra en la primera posición
        } else if (txtNombre.getText().length() >= 50) {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtcontrasena1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasena1KeyTyped

        String contrasena = txtcontrasena1.getText();
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (contrasena.isEmpty() && Character.isWhitespace(c)) {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera posición
        } else if (contrasena.length() >= 12) {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }


    }//GEN-LAST:event_txtcontrasena1KeyTyped

    private void txtcontrasena2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasena2KeyTyped

        String contrasena = txtcontrasena2.getText();
        char c = evt.getKeyChar(); // Obtener el carácter ingresado

        if (contrasena.isEmpty() && Character.isWhitespace(c)) {
            evt.consume(); // Consumir el evento si es un espacio en blanco en la primera posición
        } else if (contrasena.length() >= 12) {
            evt.consume(); // Consumir el evento si se ha alcanzado la longitud máxima
        }


    }//GEN-LAST:event_txtcontrasena2KeyTyped

    private void txtcontrasena1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontrasena1FocusLost
        //validatePassword();
    }//GEN-LAST:event_txtcontrasena1FocusLost

    private void txtcontrasena1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontrasena1FocusGained

    }//GEN-LAST:event_txtcontrasena1FocusGained

    /**
     * @param args the command line arguments
     */
    
    /*private void validatePassword() {
        String currentPassword = txtcontrasena1.getText();

        // Verificar la longitud de la contraseña
        if (currentPassword.length() < 8 || currentPassword.length() > 25) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener más de 8 dígitos y menos de 25", "Error en contraseña", JOptionPane.ERROR_MESSAGE);
            txtcontrasena2.setEnabled(false);
            btnGuardar.setEnabled(false);
        } else {
            txtcontrasena2.setEnabled(true);
            btnGuardar.setEnabled(true);
        }
    }*/

    /*private boolean isSpecialCharacter(char c) {
        // Lógica para verificar si el carácter es especial
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";
        return specialCharacters.indexOf(c) != -1;
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel contra1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtcontrasena1;
    private javax.swing.JTextField txtcontrasena2;
    // End of variables declaration//GEN-END:variables
}
