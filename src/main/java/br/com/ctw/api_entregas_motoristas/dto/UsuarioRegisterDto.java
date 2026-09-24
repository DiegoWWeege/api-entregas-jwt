package br.com.ctw.api_entregas_motoristas.dto;

import br.com.ctw.api_entregas_motoristas.enumerated.RoleEnum;

public record UsuarioRegisterDto(String username, String password, RoleEnum role) {
}
