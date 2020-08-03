package com.techstore.web.config.security;

import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        for (Usuario usuario : usuarioRepository.findAll()) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return new UsernamePasswordAuthenticationToken(username, password, usuario.getAuthorities());
            }
        }

        throw new BadCredentialsException("External system authentication failed");
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}