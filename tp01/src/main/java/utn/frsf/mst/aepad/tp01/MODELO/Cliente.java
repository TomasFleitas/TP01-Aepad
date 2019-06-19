package utn.frsf.mst.aepad.tp01.MODELO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ID_LOCALIDAD")
    private Localidad localidad;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidosRealizados = new ArrayList<Pedido>();

    @ManyToOne
    @JoinColumn(name = "ID_MEDIO_DE_PAGO")
    private MedioDePago medioDePago;
    private int pagosRealizados;
    private int puntosAcumulados;

    public Cliente() {
    }

    public Cliente(int id, String nombre, Localidad localidad, ArrayList<Pedido> pedidosRealizados, MedioDePago medioDePago, int pagosRealizados, int puntosAcumulados) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.pedidosRealizados = pedidosRealizados;
        this.medioDePago = medioDePago;
        this.pagosRealizados = pagosRealizados;
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public List<Pedido> getPedidosRealizados() {
        return pedidosRealizados;
    }

    public void setPedidosRealizados(ArrayList<Pedido> pedidosRealizados) {
        this.pedidosRealizados = pedidosRealizados;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public int getPagosRealizados() {
        return pagosRealizados;
    }

    public void setPagosRealizados(int pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }
}
