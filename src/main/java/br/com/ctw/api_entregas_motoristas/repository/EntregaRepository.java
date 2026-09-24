package br.com.ctw.api_entregas_motoristas.repository;

import br.com.ctw.api_entregas_motoristas.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    @Query(value = "select * from tb_entrega where status = ENTREGUE",
    nativeQuery = true)
    Set<Entrega> findAllByStatusEntregue();
}
