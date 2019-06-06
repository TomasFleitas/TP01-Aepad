package utn.frsf.mst.aepad.tp01.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Cliente;
import utn.frsf.mst.aepad.tp01.service.ClienteService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("cliente")
    public ResponseEntity<List<Cliente>> buscar() {
        return  new ResponseEntity<List<Cliente>>(this.clienteService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("cliente/{id}")
    public ResponseEntity<Cliente> buscar(@RequestParam(value="id") Integer idProyecto) {
        return  new ResponseEntity<Cliente>(this.clienteService.buscarPorId(idProyecto), HttpStatus.OK);
    }

    @PostMapping("cliente")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente p, UriComponentsBuilder builder) {
        Cliente creado = this.clienteService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/cliente/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Cliente>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("cliente")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente p,UriComponentsBuilder builder) {
        Cliente actualizar = this.clienteService.guardar(p);
        return new ResponseEntity<Cliente>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("proyecto/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idProyecto) {
        this.clienteService.borrar(idProyecto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
