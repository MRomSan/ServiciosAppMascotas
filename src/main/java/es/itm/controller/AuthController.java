package es.itm.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import es.itm.model.ERol;
//import es.itm.model.Rol;
//import es.itm.model.Usuario;
import es.itm.payload.request.LoginRequest;
import es.itm.payload.response.JwtResponse;
import es.itm.payload.response.MessageResponse;
import es.itm.dao.RolRepository;
import es.itm.dao.UsuarioRepository;
import es.itm.security.jwt.JwtUtils;
import es.itm.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuRep;

    @Autowired
    RolRepository rolRep;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        if(usuRep.usuarioEnAlta(loginRequest.getUsername())) {
            return ResponseEntity.ok(new JwtResponse(jwt, 
                    userDetails.getId(), 
                    userDetails.getUsername(), 
                    roles));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Usuario dado de baja"));
        }
        
    }
    
}
