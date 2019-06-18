package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.DetalleOrdenCompra;
import utn.frsf.mst.aepad.tp01.repository.DetalleOrdenCompraRepository;
import utn.frsf.mst.aepad.tp01.service.DetalleOrdenCompraService;

import java.util.List;

@Service
public class DetalleOrdenCompraServiceDefault implements DetalleOrdenCompraService {
    @Autowired
    DetalleOrdenCompraRepository detalleOrdenCompraRepository;


    @Override
    public DetalleOrdenCompra buscarPorId(Integer id) {
        return detalleOrdenCompraRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el detalleOrdenCompra con ID "+id));
    }

    @Override
    public DetalleOrdenCompra guardar(DetalleOrdenCompra t) {
        return detalleOrdenCompraRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        detalleOrdenCompraRepository.deleteById(id);
    }

    @Override
    public List<DetalleOrdenCompra> buscarTodas() {
        return detalleOrdenCompraRepository.findAll();
    }

}
