package br.com.ctw.api_entregas_motoristas.controller;

import br.com.ctw.api_entregas_motoristas.dto.LoginResponseDto;
import br.com.ctw.api_entregas_motoristas.dto.UsuarioLoginDto;
import br.com.ctw.api_entregas_motoristas.dto.UsuarioRegisterDto;
import br.com.ctw.api_entregas_motoristas.entity.Usuario;
import br.com.ctw.api_entregas_motoristas.service.AuthenticationService;
import br.com.ctw.api_entregas_motoristas.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioRegisterDto register){
        Usuario usuarioRegistrado = authenticationService.signup(register);

        return ResponseEntity.ok(usuarioRegistrado);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody UsuarioLoginDto loginUserDto){
        Usuario authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);


    }
}
