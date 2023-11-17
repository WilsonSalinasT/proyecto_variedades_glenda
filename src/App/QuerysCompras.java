/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author PC
 */
public class QuerysCompras {

    public static Object getItemAt(int selectedIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int id_compra;
    private String numfactura;
    private String tipoCategoria;
    private String fecha;
    public double total;
    private String nombreEmpresa;

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public static String getLISTARCOMPRAS() {
        return LISTARCOMPRAS;
    }

    public static void setLISTARCOMPRAS(String LISTARCOMPRAS) {
        QuerysCompras.LISTARCOMPRAS = LISTARCOMPRAS;
    }

    public static String LISTARCOMPRAS = "SELECT Compras.id_compra, Compras.numfactura, Compras.tipoCategoria, Compras.fecha, Compras.total, Proveedor.nombreEmpresa\n"
            + "FROM Compras\n"
            + "JOIN Proveedor ON Compras.id_proveedor = Proveedor.id_proveedor";
}
