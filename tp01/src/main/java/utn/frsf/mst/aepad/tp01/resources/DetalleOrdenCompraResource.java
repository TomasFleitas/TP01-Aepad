package utn.frsf.mst.aepad.tp01.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Cliente;
import utn.frsf.mst.aepad.tp01.MODELO.DetalleOrdenCompra;
import utn.frsf.mst.aepad.tp01.service.DetalleOrdenCompraService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetalleOrdenCompraResource {


    @Autowired
    private DetalleOrdenCompraService detalleOrdenCompraService;

    @GetMapping("detalleOrdenCompra")
    public ResponseEntity<List<DetalleOrdenCompra>> buscar() {
        return  new ResponseEntity<List<DetalleOrdenCompra>>(this.detalleOrdenCompraService.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("detalleOrdenCompra/{id}")
    public ResponseEntity<DetalleOrdenCompra> buscar(@PathVariable(required = false) Integer id) {
        return  new ResponseEntity<DetalleOrdenCompra>(this.detalleOrdenCompraService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("detalleOrdenCompra")
    public ResponseEntity<DetalleOrdenCompra> crear(@RequestBody DetalleOrdenCompra p, UriComponentsBuilder builder) {
        DetalleOrdenCompra creado = this.detalleOrdenCompraService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<DetalleOrdenCompra>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/detalleOrdenCompra/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<DetalleOrdenCompra>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("detalleOrdenCompra")
    public ResponseEntity<DetalleOrdenCompra> actualizar(@RequestBody DetalleOrdenCompra p,UriComponentsBuilder builder) {
        DetalleOrdenCompra actualizar = this.detalleOrdenCompraService.guardar(p);
        return new ResponseEntity<DetalleOrdenCompra>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("detalleOrdenCompra/{id}")
    public ResponseEntity<Void> borrar(@PathVariable(required = false) Integer id) {
        this.detalleOrdenCompraService.borrar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
