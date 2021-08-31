package es.itm.service;

import es.itm.model.Tipo;
import java.util.List;

public interface TipoService {
    List<Tipo> listadoTipos();
    Tipo devuelveTipo(int id);
    Tipo nuevoTipo(Tipo t);
    Tipo eliminarTipo(int id);
    Tipo modificarTipo(Tipo t);
    List<Tipo> listadoTiposEnUso();
    long cantidadTipos();
    Boolean existsTipo(String nombreT);
}
