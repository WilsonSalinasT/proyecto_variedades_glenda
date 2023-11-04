/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Paneles.Crear_Cita;
import Paneles.Crear_Pedido;
import Paneles.Listado_Citas;
import Paneles.Listado_Empleados;

import Paneles.Listado_Productos;
import Paneles.Listado_pedido_entregado;

import Paneles.clientes;
import Paneles.crear_proveedor;
import Paneles.listado_proveedores;

import Paneles.ventas;
import java.awt.BorderLayout;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();

//        ImageIcon icon = new ImageIcon(getClass().getResource("/img/Hyper.png"));
//        jLabel1 = new JLabel(icon);
//        String filePath = "img/Hyper.png";
//        ImageIcon icon = new ImageIcon(filePath);
//        jLabel1.setIcon(icon);
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
        clientes = new javax.swing.JButton();
        nueva_venta = new javax.swing.JButton();
        proveedor = new javax.swing.JButton();
        productos = new javax.swing.JButton();
        citas = new javax.swing.JButton();
        citas1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clientes.setBackground(new java.awt.Color(255, 153, 102));
        clientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clientes.setForeground(new java.awt.Color(204, 255, 255));
        clientes.setText("Clientes");
        clientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clientes.setMaximumSize(new java.awt.Dimension(70, 20));
        clientes.setMinimumSize(new java.awt.Dimension(70, 20));
        clientes.setRolloverEnabled(false);
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        jPanel2.add(clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 200, 260, 40));

        nueva_venta.setBackground(new java.awt.Color(255, 153, 102));
        nueva_venta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nueva_venta.setForeground(new java.awt.Color(255, 255, 255));
        nueva_venta.setText("Empleados");
        nueva_venta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nueva_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_ventaActionPerformed(evt);
            }
        });
        jPanel2.add(nueva_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 40));

        proveedor.setBackground(new java.awt.Color(255, 153, 102));
        proveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        proveedor.setForeground(new java.awt.Color(204, 255, 255));
        proveedor.setText("Proveedor");
        proveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedorActionPerformed(evt);
            }
        });
        jPanel2.add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 250, 40));

        productos.setBackground(new java.awt.Color(255, 153, 102));
        productos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productos.setForeground(new java.awt.Color(204, 255, 255));
        productos.setText("Productos");
        productos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        productos.setMaximumSize(new java.awt.Dimension(70, 20));
        productos.setMinimumSize(new java.awt.Dimension(70, 20));
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });
        jPanel2.add(productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 250, 40));

        citas.setBackground(new java.awt.Color(255, 153, 102));
        citas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        citas.setForeground(new java.awt.Color(204, 255, 255));
        citas.setText("Cita");
        citas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citasActionPerformed(evt);
            }
        });
        jPanel2.add(citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 250, 40));

        citas1.setBackground(new java.awt.Color(255, 153, 102));
        citas1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        citas1.setForeground(new java.awt.Color(204, 255, 255));
        citas1.setText("Pedido Sastreria");
        citas1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        citas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citas1ActionPerformed(evt);
            }
        });
        jPanel2.add(citas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 250, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hyper.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1027, Short.MAX_VALUE)
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citasActionPerformed
        Listado_Citas p2 = new Listado_Citas();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_citasActionPerformed

    private void nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_ventaActionPerformed
        Listado_Empleados p2 = new Listado_Empleados();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_nueva_ventaActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        clientes p2 = new clientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_clientesActionPerformed

    private void proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorActionPerformed
        listado_proveedores p2 = new listado_proveedores();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_proveedorActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        // jTabbedPane1.setSelectedIndex(11);

        Listado_Productos p2 = new Listado_Productos();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();


    }//GEN-LAST:event_productosActionPerformed

    private void citas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citas1ActionPerformed
         
        Crear_Pedido p2 = new Crear_Pedido();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);
        
        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_citas1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton citas;
    private javax.swing.JButton citas1;
    private javax.swing.JButton clientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nueva_venta;
    public static final javax.swing.JPanel panelprincipal = new javax.swing.JPanel();
    private javax.swing.JButton productos;
    private javax.swing.JButton proveedor;
    // End of variables declaration//GEN-END:variables
}
