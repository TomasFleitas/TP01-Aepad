package utn.frsf.mst.aepad.tp01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frsf.mst.aepad.tp01.MODELO.Usuario;
import utn.frsf.mst.aepad.tp01.repository.UsuarioRepository;
import utn.frsf.mst.aepad.tp01.service.UsuarioService;


import java.util.List;

@Service
public class UsuarioServiceDefault implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el usuario con ID "+id));
    }

    @Override
    public Usuario guardar(Usuario t) {
        return usuarioRepository.save(t);
    }

    @Override
    public void borrar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarTodas() {
        return usuarioRepository.findAll();
    }
}
