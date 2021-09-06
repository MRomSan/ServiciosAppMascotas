package es.itm.controller;

import es.itm.model.Cliente;
import es.itm.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ClienteController {
    @Autowired
    ClienteService cliService;
    
    @GetMapping("/clientes")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Cliente> listarClientes() {
        return cliService.listadoClientes();
    }
    
    @GetMapping("/cliente/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Cliente clienteById(@PathVariable("id") String id) {
        return cliService.devuelveCliente(id);
    }
    
    @PostMapping("/cliente")
    @PreAuthorize("hasRole('USER')")
    public Cliente crearNuevoCliente(@RequestBody Cliente c) {
        return cliService.nuevoCliente(c);
    }
    
    @PutMapping("/cliente/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Cliente modificarCliente(@RequestBody Cliente c, @PathVariable("id") String id) {
        c.setDni(id);
        return cliService.modificarCliente(c);
    }
}
