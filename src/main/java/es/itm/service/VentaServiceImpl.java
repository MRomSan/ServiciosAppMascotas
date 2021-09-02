package es.itm.service;

import es.itm.dao.ClienteRepository;
import es.itm.dao.UsuarioRepository;
import es.itm.dao.VentaRepository;
import es.itm.model.Venta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaRepository ventaRep;
    @Autowired
    private UsuarioRepository usuRep;
    @Autowired
    private ClienteRepository clienteRep;

    @Override
    public List<Venta> listadoVentas() {
        return ventaRep.findAll();
    }

    @Override
    public Venta devuelveVenta(String id) {
        return ventaRep.findById(id);
    }

    @Override
    public Venta guardarNuevaVenta(Venta v) {
        v.setId_venta(v.getId_venta());
        v.setCliente(clienteRep.findById(v.getCliente().getDni()));
        v.setUsuario(usuRep.findById(v.getUsuario().getId_usuario()));
        return ventaRep.save(v);
    }

    @Override
    public Venta devuelveIDVenta() {
        String ultimoID = ventaRep.getMaxID();
        String nextID;
        Venta venta = new Venta();
        if(ultimoID == null) nextID = "FCT00001";
        else nextID = ultimoID.substring(0, 4) + String.format("%04d", Integer.parseInt(ultimoID.substring(4, ultimoID.length())) + 1);
        venta.setId_venta(nextID);
        return venta;
    }
    
}
