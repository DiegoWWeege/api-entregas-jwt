package br.com.ctw.api_entregas_motoristas.service;

import br.com.ctw.api_entregas_motoristas.entity.Usuario;
import br.com.ctw.api_entregas_motoristas.exception.UserNotFoundException;
import br.com.ctw.api_entregas_motoristas.repository.UsuarioRepository;

import org.springframework.context.annotation.Bean;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("O usuário com o nome: " + username + " não foi encontrado!"));

        return User.builder()
                .username(usuario.getUsername())
                .password(passwordEncoder.encode(usuario.getPassword()))
                .authorities(usuario.getAuthorities())
                .accountLocked(false)
                .disabled(false)
                .accountExpired(false)
                .credentialsExpired(false)
                .build();
    }

}
