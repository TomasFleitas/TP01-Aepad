package utn.frsf.mst.aepad.tp01.MODELO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DetalleOrdenCompra {
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;
    private int cantidad;
    private Double precio;
    private Double total;

    public DetalleOrdenCompra() {
    }

    public DetalleOrdenCompra(Producto producto, int cantidad, Double precio, Double total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
