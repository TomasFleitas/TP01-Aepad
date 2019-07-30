package utn.frsf.mst.aepad.tp01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Pedido;
import utn.frsf.mst.aepad.tp01.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoResource {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("pedido")
    public ResponseEntity<List<Pedido>> buscar() {
        return  new ResponseEntity<List<Pedido>>(this.pedidoService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("pedido/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable(required = false) Integer id) {
        return  new ResponseEntity<Pedido>(this.pedidoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("pedido")
    public ResponseEntity<Pedido> crear(@RequestBody Pedido p, UriComponentsBuilder builder) {
        Pedido creado = this.pedidoService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<Pedido>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/pedido/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Pedido>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("pedido")
    public ResponseEntity<Pedido> actualizar(@RequestBody Pedido p,UriComponentsBuilder builder) {
        Pedido actualizar = this.pedidoService.guardar(p);
        return new ResponseEntity<Pedido>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("pedido/{id}")
    public ResponseEntity<Void> borrar(@PathVariable(required = false) Integer id) {
        this.pedidoService.borrar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
