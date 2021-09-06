package es.itm.controller;

import es.itm.model.Venta;
import es.itm.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping
public class VentaController {
    @Autowired
    VentaService ventaService;
    
    @GetMapping("/ventas")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Venta> listarVentas() {
        return ventaService.listadoVentas();
    }
    
    /*@GetMapping("/venta/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Venta ventaById(@PathVariable("id") String id) {
        return ventaService.devuelveVenta(id);
    }*/
    
    @PostMapping("/venta")
    @PreAuthorize("hasRole('USER')")
    public Venta guardarNuevaVenta(@RequestBody Venta v) {
        return ventaService.guardarNuevaVenta(v);
    }
    
    @GetMapping("/venta/nextID")
    @PreAuthorize("hasRole('USER')")
    public Venta crearIDVenta() {
        return ventaService.devuelveIDVenta();
    }
}
