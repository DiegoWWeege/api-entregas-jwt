package br.com.ctw.api_entregas_motoristas.service;

import br.com.ctw.api_entregas_motoristas.entity.Motorista;
import br.com.ctw.api_entregas_motoristas.repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public List<Motorista> findAllMotoristas(){
        return motoristaRepository.findAll();
    }
}
