package br.com.ctw.api_entregas_motoristas.repository;

import br.com.ctw.api_entregas_motoristas.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Motorista findByCnh(Long cnh);


}
