package com.kai.wang.spring.data.orm;

import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(name="descricao")
	private String descricao;
	@OneToMany(mappedBy="cargo")
	private List<Funcionario> funcionarios;
	
	public Cargo() {
		
	}
	
	public void setId(Long value) {
		this.Id = value;
	}
	public void setDescricao(String value) {
		this.descricao = value;
	}
	public Long getId() {
		return this.Id;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "{ ID: %d , descricao: %s }", this.getId(), this.getDescricao()  );
	}
}
