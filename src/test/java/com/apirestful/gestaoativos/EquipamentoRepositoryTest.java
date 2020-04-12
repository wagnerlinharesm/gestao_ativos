package com.apirestful.gestaoativos;

import com.apirestful.gestaoativos.models.Equipamento;
import com.apirestful.gestaoativos.repository.EquipamentoRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
//Testes do Equipamento, são testes para persistencia e delete de dados
@RunWith(SpringRunner.class)
@DataJpaTest
public class EquipamentoRepositoryTest {

	@Autowired
	private EquipamentoRepository equipamentoRepository;

	@Test
	public void createShouldPersistData() {
		Equipamento equipamento = new Equipamento("Celular");
		this.equipamentoRepository.save(equipamento);
		Assertions.assertThat(equipamento.getId()).isNotNull();
		Assertions.assertThat(equipamento.getNome()).isEqualTo("Celular");
	}

	@Test
	public void deleteShouldRemoveData() {
		Equipamento equipamento = new Equipamento("Celular");
		this.equipamentoRepository.save(equipamento);
		this.equipamentoRepository.delete((equipamento));
		Assertions.assertThat(equipamentoRepository.findById(equipamento.getId())).isNull();
	}
}
