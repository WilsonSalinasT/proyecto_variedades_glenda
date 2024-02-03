/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Paneles.Galeria.GalleryProduct;

import Paneles.Listados.Listado_Inventario;
import Paneles.Listados.Listado_Citas;
import Paneles.Listados.Listado_Compras;
import Paneles.Listados.Listado_Empleados;
import Paneles.Listados.Listado_Pedidos_Arreglos;
import Paneles.Listados.Listado_Pedidos_Entregado_Sastreria;
import Paneles.Listados.Listado_Pedidos_Sastreria;


import Paneles.Listados.Listado_Productos;
import Paneles.Listados.Listado_Pedidos_Sublimacion;
import Paneles.Listados.Listado_Ventas;
import Paneles.Listados.Listado_de_Precios_Historial;
import Paneles.Listados.Listado_de_envios;

import Paneles.MenuImagen;

import Paneles.Listados.Listado_Clientes;
import Paneles.Crear.Crear_Envio;
import Paneles.Crear.Crear_Proveedor;
import Paneles.Editar.Editar_Envio;
import Paneles.Listados.Listado_Proveedores;


import java.awt.BorderLayout;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
        jPanel2.add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

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
        jPanel2.add(Listadoclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 30));

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
        jPanel2.add(proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 30));

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
        jPanel2.add(empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 30));

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
        jPanel2.add(envios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 30));

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
        jPanel2.add(citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 30));

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
        jPanel2.add(pedidoSastreria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, 30));

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
        jPanel2.add(arreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, -1));

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
        jPanel2.add(pedidoSublimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 250, 30));

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
        jPanel2.add(inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 250, 30));

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
        jPanel2.add(Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 250, 30));

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
        jPanel2.add(pedidoSublimacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 250, 30));

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
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hyper.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 153, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Picsart_23-12-03_20-19-20-814.png"))); // NOI18N
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        Listado_Clientes p2 = new Listado_Clientes();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_ListadoclientesActionPerformed

    private void proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorActionPerformed
        Listado_Proveedores p2 = new Listado_Proveedores();
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

        Listado_Pedidos_Sastreria p2 = new Listado_Pedidos_Sastreria();
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
        Listado_Pedidos_Sublimacion p1 = new Listado_Pedidos_Sublimacion();
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
        Listado_Inventario p2 = new Listado_Inventario();
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
        Listado_Inventario p2 = new Listado_Inventario();
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
        Listado_Proveedores p2 = new Listado_Proveedores();
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

    private void cerrarsecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsecionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION)
        {
            Login ver = new Login();
            ver.setVisible(true);
            dispose();
        } else
        {
            JOptionPane.showMessageDialog(null, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_cerrarsecionActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        MenuImagen p2 = new MenuImagen();
        p2.setSize(1024, 640);
        p2.setLocation(0, 0);

        panelprincipal.removeAll();
        panelprincipal.add(p2, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
//      
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Compras;
    private javax.swing.JButton Galeria;
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
