package br.com.ctw.api_entregas_motoristas.controller;

import br.com.ctw.api_entregas_motoristas.entity.Motorista;
import br.com.ctw.api_entregas_motoristas.service.MotoristaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/motoristas")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> findAllMotoristas(){
        return ResponseEntity.ok(motoristaService.findAllMotoristas());
    }
}
