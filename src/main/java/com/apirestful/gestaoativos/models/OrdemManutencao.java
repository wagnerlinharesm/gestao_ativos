package com.apirestful.gestaoativos.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
// Entidade para Tabela tb_ordem_manutencao
@Entity
@Table(name="TB_ORDEM_MANUTENCAO")
@TypeDef(
		name = "jsonb",
		typeClass = JsonBinaryType.class
)

public class OrdemManutencao implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // Cria automaticamente os ids
	private long id;

	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataManutencao;	
	
    @OneToOne
    @JoinColumn(name = "equipamento_id", unique = true)
    private Equipamento equipamento;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private String anotacoes;

	public OrdemManutencao() {

	}
	public OrdemManutencao(Date dataManutencao, Equipamento equipamento) {
		this.dataManutencao = dataManutencao;
		this.equipamento = equipamento;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
		
	
}
