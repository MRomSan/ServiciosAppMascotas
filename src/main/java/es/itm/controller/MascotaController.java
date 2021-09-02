package es.itm.controller;

import es.itm.model.Mascota;
import es.itm.service.MascotaService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
public class MascotaController {
    @Autowired
    MascotaService mascService;
    
    @GetMapping("/mascotas")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Mascota> listarMascotas() {
        return mascService.listadoMascotas();
    }
    
    @GetMapping("/mascota/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Mascota mascotaById(@PathVariable("id") int id) {
        return mascService.devuelveMascota(id);
    }
    
    @PostMapping("/mascota")
    @PreAuthorize("hasRole('ADMIN')")
    public Mascota crearNuevaMascota(@RequestBody Mascota m) {
        return mascService.nuevaMascota(m);
    }
    
    @PutMapping("/mascota/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Mascota modificarMascota(@RequestBody Mascota m, @PathVariable("id") int id) {
        m.setId_mascota(id);
        return mascService.modificarMascota(m);
    }
    
    @PutMapping("/mascotas/{ids}")
    @PreAuthorize("hasRole('USER')")
    public List<Mascota> modificarMascota(@RequestBody Mascota[] m, @PathVariable("ids") int[] ids) {
        List<Mascota> mascotas = new ArrayList<>();
        for(int i = 0; i<m.length; i++){
            Mascota masc = m[i];
            masc.setId_mascota(ids[i]);
            mascotas.add(mascService.agregarVentaAMascota(masc));
        }
        return mascotas;
    }
    
    @DeleteMapping("/mascota/{ids}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Mascota> eliminarMascota(@PathVariable("ids") String ids) {
        List<String> idsList = Arrays.asList(ids.split("\\s*,\\s*"));
        List<Mascota> mascotas = new ArrayList<>();
        for (Iterator<String> iterator = idsList.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            mascotas.add(mascService.eliminarMascota(Integer.parseInt(next)));
        }
        return mascotas;
    }
    
    @GetMapping("/mascotas/novendidas")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Mascota> listarMascotasNoVendidas() {
        return mascService.listadoMascotasNoVendidas();
    }
    
}
