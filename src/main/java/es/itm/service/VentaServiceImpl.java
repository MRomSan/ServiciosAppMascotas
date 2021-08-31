package es.itm.service;

import es.itm.dao.VentaRepository;
import es.itm.model.Venta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaRepository ventaRep;

    @Override
    public List<Venta> listadoVentas() {
        return ventaRep.findAll();
    }

    @Override
    public Venta devuelveVenta(int id) {
        return ventaRep.findById(id);
    }

    @Override
    public Venta nuevaVenta(Venta v) {
        return ventaRep.save(v);
    }

    @Override
    public Venta modificarVenta(Venta v) {
        return ventaRep.save(v);
    }
    
}
