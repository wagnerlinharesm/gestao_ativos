package com.apirestful.gestaoativos;

import com.apirestful.gestaoativos.models.Equipamento;
import com.apirestful.gestaoativos.models.OrdemManutencao;
import com.apirestful.gestaoativos.repository.OrdemManutencaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
//Testes do Ordem de Manutencao, são testes para persistencia e delete de dados
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrdemManutencaoRepositoryTest {

	@Autowired
	private OrdemManutencaoRepository ordemManutencaoRepository;

	@Test
	public void createShouldPersistData() {
		Equipamento equipamento = new Equipamento("Celular");
		OrdemManutencao ordemManutencao = new OrdemManutencao(Date.valueOf(java.time.LocalDate.now()), equipamento);
		this.ordemManutencaoRepository.save(ordemManutencao);
		Assertions.assertThat(ordemManutencao.getId()).isNotNull();
	}

	@Test
	public void deleteShouldRemoveData() {
		Equipamento equipamento = new Equipamento("Celular");
		OrdemManutencao ordemManutencao = new OrdemManutencao(Date.valueOf(java.time.LocalDate.now()), equipamento);
		this.ordemManutencaoRepository.save(ordemManutencao);
		this.ordemManutencaoRepository.delete((ordemManutencao));
		Assertions.assertThat(ordemManutencaoRepository.findById(ordemManutencao.getId())).isNull();
	}
}
