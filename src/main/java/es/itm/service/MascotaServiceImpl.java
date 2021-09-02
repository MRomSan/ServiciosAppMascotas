package es.itm.service;

import es.itm.dao.MascotaRepository;
import es.itm.dao.VentaRepository;
import es.itm.model.Mascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServiceImpl implements MascotaService{
    @Autowired
    private MascotaRepository mascRep;
    @Autowired
    private VentaRepository ventaRep;
    
    @Override
    public List<Mascota> listadoMascotas() {
        return mascRep.findAll();
    }

    @Override
    public Mascota devuelveMascota(int id) {
        return mascRep.findById(id);
    }
    
    @Override
    public Mascota nuevaMascota(Mascota m) {
        m.setVenta(null);
        return mascRep.save(m);
    }

    @Override
    public Mascota modificarMascota(Mascota m) {
        return mascRep.save(m);
    }
    
    @Override
    public Mascota agregarVentaAMascota(Mascota m) {
        m.setVenta(ventaRep.findById(m.getVenta().getId_venta()));
        return mascRep.save(m);
    }

    @Override
    public Mascota eliminarMascota(int id) {
        Mascota m = mascRep.findById(id);
        if(m!=null) {
            mascRep.deleteById(id);
        }
        return m;
    }

    @Override
    public List<Mascota> listadoMascotasNoVendidas() {
        return mascRep.findAllNotSold();
    }

}
