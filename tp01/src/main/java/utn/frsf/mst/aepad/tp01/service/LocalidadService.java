package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.Localidad;

import java.util.List;

public interface LocalidadService {

    Localidad buscarPorId(Integer id);

    Localidad guardar(Localidad t);

    void borrar(Integer id);

    List<Localidad> buscarTodas();
}
