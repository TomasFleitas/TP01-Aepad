package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.MedioDePago;

import java.util.List;

public interface MedioDePagoService {

    MedioDePago buscarPorId(Integer id);

    MedioDePago guardar(MedioDePago t);

    void borrar(Integer id);

    List<MedioDePago> buscarTodas();
}
