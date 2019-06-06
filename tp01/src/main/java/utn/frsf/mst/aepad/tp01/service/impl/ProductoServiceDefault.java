package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.Producto;
import utn.frsf.mst.aepad.tp01.repository.ProductoRepository;
import utn.frsf.mst.aepad.tp01.service.ProductoService;

import java.util.List;

@Service
public class ProductoServiceDefault implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    @Override
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Producto guardar(Producto t) {
        return productoRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> buscarTodas() {
        return productoRepository.findAll();
    }
}
