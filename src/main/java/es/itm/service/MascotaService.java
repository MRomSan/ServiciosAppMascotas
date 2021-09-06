package es.itm.service;

import es.itm.model.Mascota;
import java.util.List;

public interface MascotaService {
    List<Mascota> listadoMascotas();
    Mascota devuelveMascota(int id);
    Mascota nuevaMascota(Mascota m);
    Mascota modificarMascota(Mascota m);
    Mascota agregarVentaAMascota(Mascota m, String id_venta);
    Mascota eliminarMascota(int id);
    
    List<Mascota> listadoMascotasNoVendidas();
    List<Mascota> listadoMascotasVendidas();
}
