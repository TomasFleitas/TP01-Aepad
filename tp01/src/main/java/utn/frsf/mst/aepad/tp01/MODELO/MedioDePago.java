package utn.frsf.mst.aepad.tp01.MODELO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedioDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String descripcion;

    public MedioDePago() {
    }

    public MedioDePago(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
}
