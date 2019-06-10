package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.DetalleOrdenCompra;

import java.util.List;

public interface DetalleOrdenCompraService {
    DetalleOrdenCompra buscarPorId(Integer id);

    DetalleOrdenCompra guardar(DetalleOrdenCompra t);

    void borrar(Integer id);

    List<DetalleOrdenCompra> buscarTodas();
}
