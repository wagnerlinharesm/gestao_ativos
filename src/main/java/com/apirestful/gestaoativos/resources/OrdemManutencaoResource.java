package com.apirestful.gestaoativos.resources;

import java.util.List;

import com.apirestful.gestaoativos.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirestful.gestaoativos.models.OrdemManutencao;
import com.apirestful.gestaoativos.repository.OrdemManutencaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value="/api")
@Api(value= "API REST Ordem Manutenção")
@CrossOrigin(origins="*")
public class OrdemManutencaoResource {

	@Autowired
	OrdemManutencaoRepository ordemManutencaoRepository;
	
	@GetMapping("/ordem-manutencao")
	@ApiOperation(value="Retorna uma lista de ordem de mautenção")
	public List<OrdemManutencao> listaOrdemManutencao(){
		return ordemManutencaoRepository.findAll(Sort.by(Sort.Direction.ASC, "dataManutencao"));
	}
	@ApiOperation(value="Retorna uma única ordem")
	@GetMapping("/ordem-manutencao/{id}")
	public OrdemManutencao listaOrdemManutencao(@PathVariable(value = "id") long id) {
		verificaOrdemManutencao(id);
		return ordemManutencaoRepository.findById(id);	
	}
	
	@PostMapping("/ordem-manutencao")
	@ApiOperation(value="Salva uma ordem")
	@Transactional
	public OrdemManutencao salvaOrdem(@RequestBody OrdemManutencao ordemManutencao) {
		return ordemManutencaoRepository.save(ordemManutencao);
	}
	
	@DeleteMapping("/ordem-manutencao/{id}")
	@ApiOperation(value="Deleta uma ordem")
    public void deleteOrdemById(@PathVariable(value = "id") long id) {
		verificaOrdemManutencao(id);
        OrdemManutencao ordemManutencao= ordemManutencaoRepository.getOne(id);
        ordemManutencaoRepository.delete(ordemManutencao);
    }
	
	@PutMapping("/ordem-manutencao")
	@ApiOperation(value="Atualiza uma ordem")
	public OrdemManutencao atualizaProduto(@RequestBody OrdemManutencao ordemManutencao) {
		verificaOrdemManutencao(ordemManutencao.getId());
		return ordemManutencaoRepository.save(ordemManutencao);
	}

	private void verificaOrdemManutencao(long id) {
		if (ordemManutencaoRepository.findById(id) == null) {
			throw new ResourceNotFoundException("Ordem de Manutenção não encontrada para ID:" + id);
		}
	}
}
