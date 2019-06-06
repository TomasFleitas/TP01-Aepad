package utn.frsf.mst.aepad.tp01.MODELO;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Eager
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String descripcion;
    private Double precio;
    private int stock;

    public Producto() {
    }

    public Producto(String id, String descripcion, Double precio, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
