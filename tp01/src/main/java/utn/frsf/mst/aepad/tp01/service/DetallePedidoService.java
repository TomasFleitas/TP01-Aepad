package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.DetallePedido;

import java.util.List;

public interface DetallePedidoService {

    DetallePedido buscarPorId(Integer id);

    DetallePedido guardar(DetallePedido t);

    void borrar(Integer id);

    List<DetallePedido> buscarTodas();
}
