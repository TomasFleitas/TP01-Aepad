package utn.frsf.mst.aepad.tp01.service;

import utn.frsf.mst.aepad.tp01.MODELO.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario buscarPorId(Integer id);

    Usuario guardar(Usuario t);

    void borrar(Integer id);

    List<Usuario> buscarTodas();
}
