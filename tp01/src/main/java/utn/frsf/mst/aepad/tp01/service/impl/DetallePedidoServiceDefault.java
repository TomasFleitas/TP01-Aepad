package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.DetallePedido;
import utn.frsf.mst.aepad.tp01.repository.DetallePedidoRepository;
import utn.frsf.mst.aepad.tp01.service.DetallePedidoService;

import java.util.List;

@Service
public class DetallePedidoServiceDefault implements DetallePedidoService {
    @Autowired
    DetallePedidoRepository detallePedidoRepository;


    @Override
    public DetallePedido buscarPorId(Integer id) {
        return detallePedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el detallePedido con ID "+id));
    }

    @Override
    public DetallePedido guardar(DetallePedido t) {
        return detallePedidoRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        detallePedidoRepository.deleteById(id);
    }

    @Override
    public List<DetallePedido> buscarTodas() {
        return detallePedidoRepository.findAll();
    }

}
