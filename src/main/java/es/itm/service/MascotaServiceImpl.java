package es.itm.service;

import es.itm.dao.MascotaRepository;
import es.itm.model.Mascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServiceImpl implements MascotaService{
    @Autowired
    private MascotaRepository mascRep;
    
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
        return mascRep.save(m);
    }

    @Override
    public Mascota modificarMascota(Mascota m) {
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
