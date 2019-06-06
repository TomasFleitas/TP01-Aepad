package utn.frsf.mst.aepad.tp01.MODELO;

import java.util.Date;

public class Aprovisionamiento {

    private String id;
    private int nro;
    private Date fecha;
    private Cliente cliente;
    private DetallePedido detallePedido;

    public Aprovisionamiento() {
    }

    public Aprovisionamiento(String id, int nro, Date fecha, Cliente cliente, DetallePedido detallePedido) {
        this.id = id;
        this.nro = nro;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detallePedido = detallePedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }
}
