package setters_getters;

import java.util.ArrayList;

public class setGetProdServ {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int min_stock) {
        this.minStock = min_stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int max_stock) {
        this.maxStock = max_stock;
    }

    public ArrayList<setGetProdProv> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<setGetProdProv> proveedores) {
        this.proveedores = proveedores;
    }
    
    int                         ID          ;
    int                         maxStock    = 0;
    int                         minStock    = 0;
    int                         stock       = 0;
    double                      precio      = 0;
    String                      concepto    ;
    String                      tipo        = "Servicio";
    ArrayList<setGetProdProv>   proveedores = new ArrayList();
}