package com.kai.wang.spring.data.orm;

import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String endereco;
	@ManyToMany(mappedBy="unidadeTrabalho", fetch=FetchType.EAGER)
	private List<Funcionario> funcionarios;

	public UnidadeTrabalho() {
	}

	public UnidadeTrabalho(String descricao, String endereco) {
		this.setDescricao(descricao);
		this.setEndereco(endereco);
	}

	public void setId(Long value) {
		this.id = value;
	}

	public Long getId() {
		return this.id;
	}

	public void setDescricao(String value) {
		this.descricao = value;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setEndereco(String value) {
		this.endereco = value;
	}

	public String getEndereco() {
		return this.endereco;
	}
	
	@Override
	public String toString() {
		return String.format(
				new Locale("pt", "BR"),
				"{id: %d, descricao: %s, endereco: %s}",
				this.getId(),this.getDescricao() ,this.getEndereco()
				);
	}
}
