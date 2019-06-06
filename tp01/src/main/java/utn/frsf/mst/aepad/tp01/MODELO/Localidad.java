package utn.frsf.mst.aepad.tp01.MODELO;

public class Localidad {
    private String id;
    private String descripcion;

    public Localidad() {
    }

    public Localidad(String id, String descripcion) {
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
