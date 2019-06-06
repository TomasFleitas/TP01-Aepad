package utn.frsf.mst.aepad.tp01.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.Aprovisionamiento;
import utn.frsf.mst.aepad.tp01.service.AprovisionamientoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AprovisionamientoResource {



    @Autowired
    private AprovisionamientoService aprovisionamientoService;

    @GetMapping("aprovisionamiento")
    public ResponseEntity<List<Aprovisionamiento>> buscar() {
        return  new ResponseEntity<List<Aprovisionamiento>>(this.aprovisionamientoService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("aprovisionamiento/{id}")
    public ResponseEntity<Aprovisionamiento> buscar(@RequestParam(value="id") Integer idProyecto) {
        return  new ResponseEntity<Aprovisionamiento>(this.aprovisionamientoService.buscarPorId(idProyecto), HttpStatus.OK);
    }

    @PostMapping("aprovisionamiento")
    public ResponseEntity<Aprovisionamiento> crear(@RequestBody Aprovisionamiento p, UriComponentsBuilder builder) {
        Aprovisionamiento creado = this.aprovisionamientoService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<Aprovisionamiento>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/aprovisionamiento/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Aprovisionamiento>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("aprovisionamiento")
    public ResponseEntity<Aprovisionamiento> actualizar(@RequestBody Aprovisionamiento p,UriComponentsBuilder builder) {
        Aprovisionamiento actualizar = this.aprovisionamientoService.guardar(p);
        return new ResponseEntity<Aprovisionamiento>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("proyecto/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idProyecto) {
        this.aprovisionamientoService.borrar(idProyecto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }





}
