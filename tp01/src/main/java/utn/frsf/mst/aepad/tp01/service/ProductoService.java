package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.Producto;

import java.util.List;

public interface ProductoService {

    Producto buscarPorId(Integer id);

    Producto guardar(Producto t);

    void borrar(Integer id);

    List<Producto> buscarTodas();

}
