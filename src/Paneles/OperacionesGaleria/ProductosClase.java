/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paneles.OperacionesGaleria;

import javax.swing.Icon;

/**
 *
 * @author novastar
 */
public class ProductosClase {
    private String nombre;
    private Icon foto;
    private String categoria;

    public ProductosClase(String nombre, Icon foto , String categoria) {
        this.nombre = nombre;
        this.foto = foto;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Icon getFoto() {
        return foto;
    }

    public void setFoto(Icon foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
