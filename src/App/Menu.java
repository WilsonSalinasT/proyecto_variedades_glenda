/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Paneles.GalleryProduct;
import Paneles.IngresarCompra;
import Paneles.Listado_Citas;
import Paneles.Listado_Empleados;
import Paneles.Listado_Pedidos_Arreglos;
import Paneles.Listado_Pedidos_Pendientes;
import Paneles.Listado_Prod;

import Paneles.Listado_Productos;
import Paneles.Listado_Sublimacion;
import Paneles.Listado_de_envios;
import Paneles.Listado_pedido_entregado;

import Paneles.clientes;
import Paneles.crear_envio;
import Paneles.crear_proveedor;
import Paneles.editar_envio;
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
        pedidoSastreria = new javax.swing.JButton();
        pedidoSastreria1 = new javax.swing.JButton();
        nueva_venta1 = new javax.swing.JButton();
        pedidoSublimacion = new javax.swing.JButton();
        pedidoSublimacion1 = new javax.swing.JButton();
        pedidoSublimacion2 = new javax.swing.JButton();
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
        jPanel2.add(clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 260, 40));

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
        jPanel2.add(nueva_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 250, 40));

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
        jPanel2.add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 40));

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
        jPanel2.add(productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 250, 40));

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
        jPanel2.add(citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 250, 40));

        pedidoSastreria.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSastreria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSastreria.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSastreria.setText("Pedido Sastreria");
        pedidoSastreria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSastreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSastreriaActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSastreria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 40));

        pedidoSastreria1.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSastreria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSastreria1.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSastreria1.setText("Pedido Arreglo");
        pedidoSastreria1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSastreria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSastreria1ActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSastreria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 250, 40));

        nueva_venta1.setBackground(new java.awt.Color(255, 153, 102));
        nueva_venta1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nueva_venta1.setForeground(new java.awt.Color(255, 255, 255));
        nueva_venta1.setText("Envios");
        nueva_venta1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nueva_venta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_venta1ActionPerformed(evt);
            }
        });
        jPanel2.add(nueva_venta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 250, 40));

        pedidoSublimacion.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSublimacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSublimacion.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSublimacion.setText("Pedido Sublimación");
        pedidoSublimacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSublimacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSublimacionActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSublimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 250, 40));

        pedidoSublimacion1.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSublimacion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSublimacion1.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSublimacion1.setText("Galeria");
        pedidoSublimacion1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSublimacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSublimacion1ActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSublimacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 250, 40));

        pedidoSublimacion2.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSublimacion2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSublimacion2.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSublimacion2.setText("Compras");
        pedidoSublimacion2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSublimacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSublimacion2ActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSublimacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hyper.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        Listado_Prod p2 = new Listado_Prod();
        p2.setSize(1024, 640);

        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();


    }//GEN-LAST:event_productosActionPerformed

    private void pedidoSastreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSastreriaActionPerformed

        Listado_Pedidos_Pendientes p2 = new Listado_Pedidos_Pendientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSastreriaActionPerformed

    private void pedidoSastreria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSastreria1ActionPerformed
        // TODO add your handling code here:

        Listado_Pedidos_Arreglos p2 = new Listado_Pedidos_Arreglos();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSastreria1ActionPerformed

    private void nueva_venta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_venta1ActionPerformed
        // TODO add your handling code here:
        Listado_de_envios p2 = new Listado_de_envios();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_nueva_venta1ActionPerformed

    private void pedidoSublimacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSublimacionActionPerformed
        // TODO add your handling code here:
        Listado_Sublimacion p2 = new Listado_Sublimacion();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSublimacionActionPerformed

    private void pedidoSublimacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSublimacion1ActionPerformed
        // TODO add your handling code here:
        GalleryProduct p2 = new GalleryProduct();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSublimacion1ActionPerformed

    private void pedidoSublimacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSublimacion2ActionPerformed
        IngresodeCompra ver = new IngresodeCompra();
        ver.setVisible(true);
        ver.setLocationRelativeTo(null);

    }//GEN-LAST:event_pedidoSublimacion2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
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
    private javax.swing.JButton clientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nueva_venta;
    private javax.swing.JButton nueva_venta1;
    public static final javax.swing.JPanel panelprincipal = new javax.swing.JPanel();
    private javax.swing.JButton pedidoSastreria;
    private javax.swing.JButton pedidoSastreria1;
    private javax.swing.JButton pedidoSublimacion;
    private javax.swing.JButton pedidoSublimacion1;
    private javax.swing.JButton pedidoSublimacion2;
    private javax.swing.JButton productos;
    private javax.swing.JButton proveedor;
    // End of variables declaration//GEN-END:variables
}
