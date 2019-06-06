package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente buscarPorId(Integer id);

    Cliente guardar(Cliente t);

    void borrar(Integer id);

    List<Cliente> buscarTodas();
}
