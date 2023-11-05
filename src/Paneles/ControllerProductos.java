package Paneles;

public class ControllerProductos {

    private String nombre;
    private String descripcion;
    private String categoria;
    private byte[] foto;
    private int cod_producto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getCodProducto() {
        return cod_producto;
    }

    public void setCodProducto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int registrarProductosController() {
        ModeloProductos productos = new ModeloProductos();
        ConfigController p = new ConfigController();
        return productos.registroProducto(nombre, descripcion, categoria, foto,  p.getIp(), p.getPuerto(), p.getDbName(), p.getUser(), p.getPassword());
    }
    
    public int actualizar(){
    
        ModeloProductos productos1 = new ModeloProductos();
        ConfigController p = new ConfigController();
        return  productos1.updateProducto(cod_producto, nombre, descripcion, categoria, foto,  p.getIp(), p.getPuerto(), p.getDbName(), p.getUser(), p.getPassword());
    
    }
    
     public int actualizar2(){
    
        ModeloProductos productos2 = new ModeloProductos();
        ConfigController p = new ConfigController();
        return  productos2.updateProducto2(cod_producto, nombre, descripcion, categoria,  p.getIp(), p.getPuerto(), p.getDbName(), p.getUser(), p.getPassword());
    
    }
}