package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.Aprovisionamiento;

import java.util.List;

public interface AprovisionamientoService {
    Aprovisionamiento buscarPorId(Integer id);

    Aprovisionamiento guardar(Aprovisionamiento t);

    void borrar(Integer id);

    List<Aprovisionamiento> buscarTodas();
}
