package utn.frsf.mst.aepad.tp01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Usuario;
import utn.frsf.mst.aepad.tp01.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("usuario")
    public ResponseEntity<List<Usuario>> buscar() {
        return  new ResponseEntity<List<Usuario>>(this.usuarioService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("usuario/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable(required = false) Integer id) {
        return  new ResponseEntity<Usuario>(this.usuarioService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("usuario")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario p, UriComponentsBuilder builder) {
        Usuario creado = this.usuarioService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/usuario/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Usuario>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("usuario")
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario p,UriComponentsBuilder builder) {
        Usuario actualizar = this.usuarioService.guardar(p);
        return new ResponseEntity<Usuario>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<Void> borrar(@PathVariable(required = false) Integer id) {
        this.usuarioService.borrar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
