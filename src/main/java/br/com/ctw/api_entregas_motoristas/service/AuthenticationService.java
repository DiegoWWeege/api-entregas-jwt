package br.com.ctw.api_entregas_motoristas.service;

import br.com.ctw.api_entregas_motoristas.dto.UsuarioLoginDto;
import br.com.ctw.api_entregas_motoristas.dto.UsuarioRegisterDto;
import br.com.ctw.api_entregas_motoristas.entity.Usuario;
import br.com.ctw.api_entregas_motoristas.enumerated.RoleEnum;
import br.com.ctw.api_entregas_motoristas.repository.UsuarioRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public Usuario signup(UsuarioRegisterDto input){
        Usuario usuario = new Usuario();

        usuario.setUsername(input.username());
        usuario.setPassword(passwordEncoder.encode(input.password()));
        usuario.setRole(RoleEnum.valueOf(input.role().toString().toUpperCase()));

        return usuarioRepository.save(usuario);

    }

    public Usuario authenticate(UsuarioLoginDto dto){
        authenticationManager.authenticate(
                 UsernamePasswordAuthenticationToken.unauthenticated(dto.username(), dto.password())
        );

        return usuarioRepository.findByUsername(dto.username()).orElseThrow();
    }
}
