package com.apirestful.gestaoativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirestful.gestaoativos.models.OrdemManutencao;
//Interface para o Repositorio OrdemManutencao
@Repository
public interface OrdemManutencaoRepository extends JpaRepository<OrdemManutencao, Long>{
	
	OrdemManutencao findById(long id);

}