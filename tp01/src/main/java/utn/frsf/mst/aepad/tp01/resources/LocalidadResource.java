package utn.frsf.mst.aepad.tp01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Localidad;
import utn.frsf.mst.aepad.tp01.service.LocalidadService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocalidadResource {

    @Autowired
    private LocalidadService localidadService;

    @GetMapping("localidad")
    public ResponseEntity<List<Localidad>> buscar() {
        return  new ResponseEntity<List<Localidad>>(this.localidadService.buscarTodas(), HttpStatus.OK);
    }

    @GetMapping("localidad/{id}")
    public ResponseEntity<Localidad> buscar(@PathVariable(required = false) Integer id) {
        return  new ResponseEntity<Localidad>(this.localidadService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("localidad")
    public ResponseEntity<Localidad> crear(@RequestBody Localidad p, UriComponentsBuilder builder) {
        Localidad creado = this.localidadService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<Localidad>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/localidad/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Localidad>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("localidad")
    public ResponseEntity<Localidad> actualizar(@RequestBody Localidad p,UriComponentsBuilder builder) {
        Localidad actualizar = this.localidadService.guardar(p);
        return new ResponseEntity<Localidad>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("localidad/{id}")
    public ResponseEntity<Void> borrar(@PathVariable(required = false) Integer id) {
        this.localidadService.borrar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
