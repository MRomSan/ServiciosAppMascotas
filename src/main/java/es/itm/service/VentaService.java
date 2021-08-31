package es.itm.service;

import es.itm.model.Venta;
import java.util.List;

public interface VentaService {
    List<Venta> listadoVentas();
    Venta devuelveVenta(int id);
    Venta nuevaVenta(Venta v);
    Venta modificarVenta(Venta v);
}
