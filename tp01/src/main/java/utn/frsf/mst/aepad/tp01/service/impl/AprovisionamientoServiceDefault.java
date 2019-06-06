package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.Aprovisionamiento;
import utn.frsf.mst.aepad.tp01.repository.AprovisionamientoRepository;
import utn.frsf.mst.aepad.tp01.service.AprovisionamientoService;

import java.util.List;

@Service
public class AprovisionamientoServiceDefault implements AprovisionamientoService {

    @Autowired
    AprovisionamientoRepository aprovisionamientoRepository;


    @Override
    public Aprovisionamiento buscarPorId(Integer id) {
        return aprovisionamientoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el aprovisionamiento con ID "+id));
    }

    @Override
    public Aprovisionamiento guardar(Aprovisionamiento t) {
        return aprovisionamientoRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        aprovisionamientoRepository.deleteById(id);
    }

    @Override
    public List<Aprovisionamiento> buscarTodas() {
        return aprovisionamientoRepository.findAll();
    }

}
