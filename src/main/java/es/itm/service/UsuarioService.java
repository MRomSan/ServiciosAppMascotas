package es.itm.service;

import es.itm.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listadoEmpleados();
    Usuario devuelveEmpleado(Long id);
    Usuario nuevoEmpleado(Usuario e);
    List<Usuario> bajaEmpleado(String ids);
    Usuario modificarEmpleado(Usuario e);
    Boolean existsEmpleado(String username);
    List<Usuario> listadoEmpleadosDeAlta();
    Usuario newPassword(String newPassword, Long id);
}
