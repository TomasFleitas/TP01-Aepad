package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.MedioDePago;
import utn.frsf.mst.aepad.tp01.repository.MedioDePagoRepository;
import utn.frsf.mst.aepad.tp01.service.MedioDePagoService;

import java.util.List;

@Service
public class MedioDePagoServiceDefault implements MedioDePagoService {

    @Autowired
    MedioDePagoRepository medioDePagoRepository;


    @Override
    public MedioDePago buscarPorId(Integer id) {
        return medioDePagoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public MedioDePago guardar(MedioDePago t) {
        return medioDePagoRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        medioDePagoRepository.deleteById(id);
    }

    @Override
    public List<MedioDePago> buscarTodas() {
        return medioDePagoRepository.findAll();
    }
}
