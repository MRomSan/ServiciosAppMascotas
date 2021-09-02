package es.itm.service;

import es.itm.model.Venta;
import java.util.List;

public interface VentaService {
    List<Venta> listadoVentas();
    Venta devuelveVenta(String id);
    Venta guardarNuevaVenta(Venta v);
    Venta devuelveIDVenta();
}
