package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido buscarPorId(Integer id);

    Pedido guardar(Pedido t);

    void borrar(Integer id);

    List<Pedido> buscarTodas();

}
