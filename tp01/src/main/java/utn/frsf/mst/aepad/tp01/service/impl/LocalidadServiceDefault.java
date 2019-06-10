package utn.frsf.mst.aepad.tp01.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.Localidad;
import utn.frsf.mst.aepad.tp01.repository.LocalidadRepository;
import utn.frsf.mst.aepad.tp01.service.LocalidadService;

import java.util.List;

@Service
public class LocalidadServiceDefault implements LocalidadService {

    @Autowired
    LocalidadRepository localidadRepository;


    @Override
    public Localidad buscarPorId(Integer id) {
        return localidadRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la localidad con ID "+id));
    }

    @Override
    public Localidad guardar(Localidad t) {
        return localidadRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        localidadRepository.deleteById(id);
    }

    @Override
    public List<Localidad> buscarTodas() {
        return localidadRepository.findAll();
    }
}
