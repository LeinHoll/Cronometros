package setters_getters;

public class setGetProdProv {

    public int getIdProdServ() {
        return idProdServ;
    }

    public void setIdProdServ(int idProdServ) {
        this.idProdServ = idProdServ;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
    int idProdServ      ;
    int idProveedor     ;
    double precio       = 0.0;
    String producto     ;
    String proveedor    ;
}
