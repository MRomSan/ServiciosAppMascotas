package es.itm.security.service;

import es.itm.dao.UsuarioRepository;
import es.itm.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UsuarioRepository usuRep;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuRep.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con 'Nombre de Usuario': " + username));
        
        return UserDetailsImpl.build(usuario);
    }
    
}
