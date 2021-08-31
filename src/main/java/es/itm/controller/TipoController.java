package es.itm.controller;

import es.itm.model.Tipo;
import es.itm.service.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping
public class TipoController {
    @Autowired
    TipoService tipoService;
    
    @GetMapping("/tipos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Tipo> listarTipos() {
        return tipoService.listadoTipos();
    }
    
    @GetMapping("/tipos/enuso")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Tipo> listarTiposEnUso() {
        return tipoService.listadoTiposEnUso();
    }
    
    @GetMapping("/tipo/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Tipo tipoById(@PathVariable("id") int id) {
        return tipoService.devuelveTipo(id);
    }
    
    @PostMapping("/tipo")
    @PreAuthorize("hasRole('ADMIN')")
    public Tipo crearNuevoTipo(@RequestBody Tipo t) {
        return tipoService.nuevoTipo(t);
    }
    
    @PutMapping("/tipo/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Tipo modificarTipo(@RequestBody Tipo t, @PathVariable("id") int id) {
        t.setId_tipo(id);
        return tipoService.modificarTipo(t);
    }
    
    @DeleteMapping("/tipo/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Tipo eliminarTipo(@PathVariable("id") int id) {
        return tipoService.eliminarTipo(id);
    }
    
    @GetMapping("/tipos/count")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public long cantidadTipos() {
        return tipoService.cantidadTipos();
    }
    
    @GetMapping("/tipo/nombre/{nombre}")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean existeTipo(@PathVariable("nombre") String nombreT) {
        return tipoService.existsTipo(nombreT);
    }
}
