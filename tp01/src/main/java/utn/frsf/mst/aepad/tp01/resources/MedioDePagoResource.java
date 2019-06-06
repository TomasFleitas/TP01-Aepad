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
    private MedioDePagoService clienteService;

    @GetMapping("mediodepago")
    public ResponseEntity<List<MedioDePago>> buscar() {
        return  new ResponseEntity<List<MedioDePago>>(this.clienteService.buscarTodas(), HttpStatus.OK);
    }


    @GetMapping("mediodepago/{id}")
    public ResponseEntity<MedioDePago> buscar(@RequestParam(value="id") Integer idProyecto) {
        return  new ResponseEntity<MedioDePago>(this.clienteService.buscarPorId(idProyecto), HttpStatus.OK);
    }

    @PostMapping("mediodepago")
    public ResponseEntity<MedioDePago> crear(@RequestBody MedioDePago p, UriComponentsBuilder builder) {
        MedioDePago creado = this.clienteService.guardar(p);
        if (creado == null) {
            return new ResponseEntity<MedioDePago>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/mediodepago/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<MedioDePago>(creado,headers, HttpStatus.CREATED);
    }

    @PutMapping("mediodepago")
    public ResponseEntity<MedioDePago> actualizar(@RequestBody MedioDePago p,UriComponentsBuilder builder) {
        MedioDePago actualizar = this.clienteService.guardar(p);
        return new ResponseEntity<MedioDePago>(actualizar, HttpStatus.OK);
    }

    @DeleteMapping("mediodepago/{id}")
    public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idProyecto) {
        this.clienteService.borrar(idProyecto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
