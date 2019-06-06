package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.Pedido;
import utn.frsf.mst.aepad.tp01.repository.PedidoRepository;
import utn.frsf.mst.aepad.tp01.service.PedidoService;

import java.util.List;

@Service
public class PedidoServiceDefault  implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;


    @Override
    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Pedido guardar(Pedido t) {
        return pedidoRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> buscarTodas() {
        return pedidoRepository.findAll();
    }
}
