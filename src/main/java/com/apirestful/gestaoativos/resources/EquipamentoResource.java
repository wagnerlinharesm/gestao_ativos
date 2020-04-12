package com.apirestful.gestaoativos.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestful.gestaoativos.error.ResourceNotFoundException;
import com.apirestful.gestaoativos.models.Equipamento;
import com.apirestful.gestaoativos.repository.EquipamentoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value="/api")
@Api(value= "API REST Equipamento")
@CrossOrigin(origins="*")
public class EquipamentoResource {

	@Autowired
	EquipamentoRepository equipamentoRepository;
	
	@GetMapping("/equipamentos")
	@ApiOperation(value="Retorna uma lista de equipamentos")
	public List<Equipamento> listaEquipamentos(){
		return equipamentoRepository.findAll();	
	}

	@ApiOperation(value="Retorna um único equipamento")
	@GetMapping("/equipamento/{id}")
	public Equipamento listaEquipamento(@PathVariable(value = "id") long id){
		verificaEquipamentoExistente(id);
		return equipamentoRepository.findById(id);
	}
	
	@PostMapping("/equipamento")
	@ApiOperation(value="Salva um equipamento")
	@Transactional
	public Equipamento salvaEquipamento(@Valid @RequestBody Equipamento equipamento) {
		return equipamentoRepository.save(equipamento);
	}
	
	@DeleteMapping("/equipamento/{id}")
	@ApiOperation(value="Deleta um equipamento")
    public void deleteEquipamentoById(@PathVariable(value = "id") long id) {
		verificaEquipamentoExistente(id);
        Equipamento equipamento = equipamentoRepository.getOne(id);
        equipamentoRepository.delete(equipamento);
    }
	
	@PutMapping("/equipamento")
	@ApiOperation(value="Atualiza um equipamento")
	public Equipamento atualizaProduto(@RequestBody Equipamento equipamento) {
		verificaEquipamentoExistente(equipamento.getId());
		return equipamentoRepository.save(equipamento);
	}
	
	private void verificaEquipamentoExistente(long id) {
		if (equipamentoRepository.findById(id) == null) {
			throw new ResourceNotFoundException("Equipamento não encontrado para ID:" + id);
		}
	}
}
