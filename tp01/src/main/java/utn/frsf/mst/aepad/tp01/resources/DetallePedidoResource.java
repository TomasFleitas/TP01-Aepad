package utn.frsf.mst.aepad.tp01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.DetalleOrdenCompra;
import utn.frsf.mst.aepad.tp01.MODELO.DetallePedido;
import utn.frsf.mst.aepad.tp01.service.DetallePedidoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetallePedidoResource {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("detallePedido")
    public ResponseEntity<List<DetallePedido>> buscar() {
        return  new ResponseEntity<List<DetallePedido>>(this.detallePedidoService.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("detallePedido/{id}")
    public ResponseEntity<DetallePedido> buscar(@PathVariable(required = false) Integer id) {
        return  new ResponseEntity<DetallePedido>(this.detallePedidoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("detallePedido")
    public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedido p, UriComponentsBuilder builder) {
        DetallePedido creado = this.detallePedidoService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<DetallePedido>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/detallePedido/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<DetallePedido>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("detallePedido")
    public ResponseEntity<DetallePedido> actualizar(@RequestBody DetallePedido p,UriComponentsBuilder builder) {
        DetallePedido actualizar = this.detallePedidoService.guardar(p);
        return new ResponseEntity<DetallePedido>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("detallePedido/{id}")
    public ResponseEntity<Void> borrar(@PathVariable(required = false) Integer id) {
        this.detallePedidoService.borrar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
