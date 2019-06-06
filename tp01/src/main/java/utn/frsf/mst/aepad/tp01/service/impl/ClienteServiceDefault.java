package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.Cliente;
import utn.frsf.mst.aepad.tp01.repository.ClienteRepository;
import utn.frsf.mst.aepad.tp01.service.ClienteService;

import java.util.List;

@Service
public class ClienteServiceDefault implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente con ID "+id));
    }

    @Override
    public Cliente guardar(Cliente t) {
        return clienteRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> buscarTodas() {
        return clienteRepository.findAll();
    }
}
