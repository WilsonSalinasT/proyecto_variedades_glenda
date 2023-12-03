/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Paneles.GalleryProduct;
import Paneles.IngresarCompra;
import Paneles.Inventario;
import Paneles.Listado_Citas;
import Paneles.Listado_Compras;

import Paneles.Listado_Empleados;
import Paneles.Listado_Pedidos_Arreglos;
import Paneles.Listado_Pedidos_Entregado_Sastreria;
import Paneles.Listado_Pedidos_Pendientes;
import Paneles.Listado_Prod;

import Paneles.Listado_Productos;
import Paneles.Listado_Sublimacion;
import Paneles.Listado_Ventas;
import Paneles.Listado_de_Precios;
import Paneles.Listado_de_envios;
import Paneles.Listado_pedido_entregado;

import Paneles.clientes;
import Paneles.crear_envio;
import Paneles.crear_proveedor;
import Paneles.editar_envio;
import Paneles.listado_proveedores;

import Paneles.ventas;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

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
        producto = new javax.swing.JButton();
        Listadoclientes = new javax.swing.JButton();
        proveedores = new javax.swing.JButton();
        empleados = new javax.swing.JButton();
        envios = new javax.swing.JButton();
        citas = new javax.swing.JButton();
        pedidoSastreria = new javax.swing.JButton();
        arreglo = new javax.swing.JButton();
        pedidoSublimacion = new javax.swing.JButton();
        Galeria = new javax.swing.JButton();
        inventario = new javax.swing.JButton();
        Compras = new javax.swing.JButton();
        pedidoSublimacion3 = new javax.swing.JButton();
        HistorialPrecios = new javax.swing.JButton();
        cerrarsecion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        producto.setBackground(new java.awt.Color(255, 153, 102));
        producto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        producto.setForeground(new java.awt.Color(204, 255, 255));
        producto.setText("Listado de productos");
        producto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        jPanel2.add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 30));

        Listadoclientes.setBackground(new java.awt.Color(255, 153, 102));
        Listadoclientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Listadoclientes.setForeground(new java.awt.Color(204, 255, 255));
        Listadoclientes.setText("Listado de clientes");
        Listadoclientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Listadoclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadoclientesActionPerformed(evt);
            }
        });
        jPanel2.add(Listadoclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        proveedores.setBackground(new java.awt.Color(255, 153, 102));
        proveedores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        proveedores.setForeground(new java.awt.Color(204, 255, 255));
        proveedores.setText("Listado de proveedores");
        proveedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresActionPerformed(evt);
            }
        });
        jPanel2.add(proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 30));

        empleados.setBackground(new java.awt.Color(255, 153, 102));
        empleados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        empleados.setForeground(new java.awt.Color(204, 255, 255));
        empleados.setText("Listado de empleados");
        empleados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadosActionPerformed(evt);
            }
        });
        jPanel2.add(empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 30));

        envios.setBackground(new java.awt.Color(255, 153, 102));
        envios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        envios.setForeground(new java.awt.Color(204, 255, 255));
        envios.setText("Listado de envíos");
        envios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        envios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviosActionPerformed(evt);
            }
        });
        jPanel2.add(envios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 30));

        citas.setBackground(new java.awt.Color(255, 153, 102));
        citas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        citas.setForeground(new java.awt.Color(204, 255, 255));
        citas.setText("Listado de citas");
        citas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citasActionPerformed(evt);
            }
        });
        jPanel2.add(citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 30));

        pedidoSastreria.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSastreria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSastreria.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSastreria.setText("Listado de sastrería");
        pedidoSastreria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSastreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSastreriaActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSastreria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 30));

        arreglo.setBackground(new java.awt.Color(255, 153, 102));
        arreglo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        arreglo.setForeground(new java.awt.Color(204, 255, 255));
        arreglo.setText("Listado de arreglos");
        arreglo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        arreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arregloActionPerformed(evt);
            }
        });
        jPanel2.add(arreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, -1));

        pedidoSublimacion.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSublimacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSublimacion.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSublimacion.setText("Listado de sublimación");
        pedidoSublimacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSublimacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSublimacionActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSublimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 30));

        Galeria.setBackground(new java.awt.Color(255, 153, 102));
        Galeria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Galeria.setForeground(new java.awt.Color(255, 255, 255));
        Galeria.setText("Galería");
        Galeria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Galeria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GaleriaActionPerformed(evt);
            }
        });
        jPanel2.add(Galeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 250, 30));

        inventario.setBackground(new java.awt.Color(255, 153, 102));
        inventario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inventario.setForeground(new java.awt.Color(204, 255, 255));
        inventario.setText("Inventario");
        inventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });
        jPanel2.add(inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 250, 30));

        Compras.setBackground(new java.awt.Color(255, 153, 102));
        Compras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Compras.setForeground(new java.awt.Color(204, 255, 255));
        Compras.setText("Listado de compras");
        Compras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasActionPerformed(evt);
            }
        });
        jPanel2.add(Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 250, 30));

        pedidoSublimacion3.setBackground(new java.awt.Color(255, 153, 102));
        pedidoSublimacion3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pedidoSublimacion3.setForeground(new java.awt.Color(204, 255, 255));
        pedidoSublimacion3.setText("Listado de ventas");
        pedidoSublimacion3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidoSublimacion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoSublimacion3ActionPerformed(evt);
            }
        });
        jPanel2.add(pedidoSublimacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 250, 30));

        HistorialPrecios.setBackground(new java.awt.Color(255, 153, 102));
        HistorialPrecios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HistorialPrecios.setForeground(new java.awt.Color(255, 255, 255));
        HistorialPrecios.setText("Historial de precios");
        HistorialPrecios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HistorialPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialPreciosActionPerformed(evt);
            }
        });
        jPanel2.add(HistorialPrecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 250, 30));

        cerrarsecion.setBackground(new java.awt.Color(255, 153, 102));
        cerrarsecion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cerrarsecion.setForeground(new java.awt.Color(255, 255, 255));
        cerrarsecion.setText("Cerrar sesión");
        cerrarsecion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cerrarsecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsecionActionPerformed(evt);
            }
        });
        jPanel2.add(cerrarsecion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 250, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/work-from-home.png"))); // NOI18N
        jLabel3.setText("Inicio");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hyper.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 153, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido al sistema");

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelprincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(285, 285, 285))
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

    private void nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_ventaActionPerformed
        Listado_Empleados p2 = new Listado_Empleados();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_nueva_ventaActionPerformed

    private void ListadoclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadoclientesActionPerformed
        clientes p2 = new clientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_ListadoclientesActionPerformed

    private void proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorActionPerformed
        listado_proveedores p2 = new listado_proveedores();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_proveedorActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed

        Listado_Productos p2 = new Listado_Productos();
        p2.setSize(1024, 640);

        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_productoActionPerformed

    private void pedidoSastreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSastreriaActionPerformed

        Listado_Pedidos_Pendientes p2 = new Listado_Pedidos_Pendientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSastreriaActionPerformed

    private void arregloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arregloActionPerformed
        // TODO add your handling code here:

        Listado_Pedidos_Arreglos p3 = new Listado_Pedidos_Arreglos();
        p3.setSize(1024, 640);
        p3.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p3, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_arregloActionPerformed

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
        Listado_Sublimacion p1 = new Listado_Sublimacion();
        p1.setSize(1024, 640);
        p1.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p1, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSublimacionActionPerformed

    private void GaleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GaleriaActionPerformed
        // TODO add your handling code here:
        GalleryProduct p2 = new GalleryProduct();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_GaleriaActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
        Listado_Compras p2 = new Listado_Compras();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();


    }//GEN-LAST:event_ComprasActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes1ActionPerformed
        // TODO add your handling code here:
        Inventario p2 = new Inventario();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_clientes1ActionPerformed

    private void pedidoSublimacion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoSublimacion3ActionPerformed
        Listado_Ventas p2 = new Listado_Ventas();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_pedidoSublimacion3ActionPerformed

    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        Inventario p2 = new Inventario();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_inventarioActionPerformed

    private void citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citasActionPerformed
        // TODO add your handling code here:
        Listado_Citas p2 = new Listado_Citas();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_citasActionPerformed

    private void enviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviosActionPerformed
        // TODO add your handling code here:
        Listado_de_envios p2 = new Listado_de_envios();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_enviosActionPerformed

    private void empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadosActionPerformed
        Listado_Empleados p2 = new Listado_Empleados();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_empleadosActionPerformed

    private void proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresActionPerformed
        listado_proveedores p2 = new listado_proveedores();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_proveedoresActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedores1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proveedores1ActionPerformed

    private void HistorialPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialPreciosActionPerformed
        // TODO add your handling code here:
        Listado_de_Precios p2 = new Listado_de_Precios();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_HistorialPreciosActionPerformed

    private void cerrarsecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsecionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        } else
        {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cerrarsecionActionPerformed

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
    private javax.swing.JButton Compras;
    private javax.swing.JButton Galeria;
    private javax.swing.JButton HistorialPrecios;
    private javax.swing.JButton Listadoclientes;
    private javax.swing.JButton arreglo;
    private javax.swing.JButton cerrarsecion;
    private javax.swing.JButton citas;
    private javax.swing.JButton empleados;
    private javax.swing.JButton envios;
    private javax.swing.JButton inventario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static final javax.swing.JPanel panelprincipal = new javax.swing.JPanel();
    private javax.swing.JButton pedidoSastreria;
    private javax.swing.JButton pedidoSublimacion;
    private javax.swing.JButton pedidoSublimacion3;
    private javax.swing.JButton producto;
    private javax.swing.JButton proveedores;
    // End of variables declaration//GEN-END:variables
}
