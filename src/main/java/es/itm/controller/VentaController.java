package es.itm.controller;

import es.itm.model.Venta;
import es.itm.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class VentaController {
    @Autowired
    private VentaService ventaService;
    
    @GetMapping("/ventas")
    public List<Venta> listarVentas() {
        return ventaService.listadoVentas();
    }
    
    @GetMapping("/venta/{id}")
    public Venta ventaById(@PathVariable("id") int id) {
        return ventaService.devuelveVenta(id);
    }
    
    @PostMapping("/venta")
    public Venta crearNuevaVenta(@RequestBody Venta v) {
        return ventaService.nuevaVenta(v);
    }
    
    @PutMapping("/venta/{id}")
    public Venta modificarVenta(@RequestBody Venta v, @PathVariable("id") int id) {
        return ventaService.modificarVenta(v);
    }
    
}
