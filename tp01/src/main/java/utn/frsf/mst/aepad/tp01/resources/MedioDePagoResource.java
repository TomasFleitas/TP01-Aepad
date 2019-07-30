package utn.frsf.mst.aepad.tp01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import utn.frsf.mst.aepad.tp01.MODELO.MedioDePago;
import utn.frsf.mst.aepad.tp01.service.MedioDePagoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedioDePagoResource {

    @Autowired
    private MedioDePagoService medioDePagoService;

    @GetMapping("medioDePago")
    public ResponseEntity<List<MedioDePago>> buscar() {
        return  new ResponseEntity<List<MedioDePago>>(this.medioDePagoService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("medioDePago/{id}")
    public ResponseEntity<MedioDePago> buscar(@PathVariable(required = false) Integer id) {
        return  new ResponseEntity<MedioDePago>(this.medioDePagoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("medioDePago")
    public ResponseEntity<MedioDePago> crear(@RequestBody MedioDePago p, UriComponentsBuilder builder) {
        MedioDePago creado = this.medioDePagoService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<MedioDePago>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/medioDePago/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<MedioDePago>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("medioDePago")
    public ResponseEntity<MedioDePago> actualizar(@RequestBody MedioDePago p,UriComponentsBuilder builder) {
        MedioDePago actualizar = this.medioDePagoService.guardar(p);
        return new ResponseEntity<MedioDePago>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("medioDePago/{id}")
    public ResponseEntity<Void> borrar(@PathVariable(required = false) Integer id) {
        this.medioDePagoService.borrar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
