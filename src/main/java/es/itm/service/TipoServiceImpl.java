package es.itm.service;

import es.itm.dao.TipoRepository;
import es.itm.model.Tipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoServiceImpl implements TipoService{
    @Autowired
    private TipoRepository tipoRep;
    
    @Override
    public List<Tipo> listadoTipos() {
        return tipoRep.findAll();
    }

    @Override
    public Tipo devuelveTipo(int id) {
        return tipoRep.findById(id);
    }

    @Override
    public Tipo nuevoTipo(Tipo t) {
        return tipoRep.save(t);
    }

    @Override
    public Tipo eliminarTipo(int id) {
        Tipo t = tipoRep.findById(id);
        tipoRep.deleteById(id);
        return t;
    }

    @Override
    public Tipo modificarTipo(Tipo t) {
        return tipoRep.save(t);
    }

    @Override
    public List<Tipo> listadoTiposEnUso() {
        return tipoRep.findAllInUse();
    }

    @Override
    public long cantidadTipos() {
        return tipoRep.count();
    }

    @Override
    public Boolean existsTipo(String nombreT) {
        return tipoRep.existsByNombre(nombreT);
    }
    
}
