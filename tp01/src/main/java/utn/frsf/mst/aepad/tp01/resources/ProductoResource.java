package utn.frsf.mst.aepad.tp01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Producto;
import utn.frsf.mst.aepad.tp01.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoResource {

    @Autowired
    private ProductoService productoService;

    @GetMapping("producto")
    public ResponseEntity<List<Producto>> buscar() {
        return  new ResponseEntity<List<Producto>>(this.productoService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("producto/{id}")
    public ResponseEntity<Producto> buscar(@RequestParam(defaultValue="id") Integer idProyecto) {
        return  new ResponseEntity<Producto>(this.productoService.buscarPorId(idProyecto), HttpStatus.OK);
    }

    @PostMapping("producto")
    public ResponseEntity<Producto> crear(@RequestBody Producto p, UriComponentsBuilder builder) {
        Producto creado = this.productoService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/producto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Producto>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("producto")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto p,UriComponentsBuilder builder) {
        Producto actualizar = this.productoService.guardar(p);
        return new ResponseEntity<Producto>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("producto/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idProyecto) {
        this.productoService.borrar(idProyecto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
