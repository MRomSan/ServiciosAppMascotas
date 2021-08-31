package es.itm.service;

import es.itm.dao.ClienteRepository;
import es.itm.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository cliRep;
    
    @Override
    public List<Cliente> listadoClientes() {
        return cliRep.findAll();
    }

    @Override
    public Cliente devuelveCliente(String id) {
        return cliRep.findById(id);
    }

    @Override
    public Cliente nuevoCliente(Cliente c) {
        return cliRep.save(c);
    }

    @Override
    public Cliente modificarCliente(Cliente c) {
        return cliRep.save(c);
    }
    
}
