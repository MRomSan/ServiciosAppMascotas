package es.itm.service;

import es.itm.model.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listadoClientes();
    Cliente devuelveCliente(String id);
    Cliente nuevoCliente(Cliente c);
    Cliente modificarCliente(Cliente c);
}
