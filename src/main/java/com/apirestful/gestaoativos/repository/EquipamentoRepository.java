package com.apirestful.gestaoativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestful.gestaoativos.models.Equipamento;
//Interface para o Repositorio Equipamento
public interface EquipamentoRepository  extends JpaRepository<Equipamento, Long> {
	
	Equipamento findById(long id);

}
