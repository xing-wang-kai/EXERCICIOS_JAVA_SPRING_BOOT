package com.kai.wang.spring.data.orm;

import java.time.LocalDate;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private double salario;
	@Column(name = "data-contratacao")
	private LocalDate dataContratacao;
	@ManyToOne
	@JoinColumn(name="cargo_id", nullable= false)
	private Cargo cargo;
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER )
	@JoinTable(name = "funcionario_unidade", 
				joinColumns = {@JoinColumn(name="fk_funcionario")},
				inverseJoinColumns = {
					@JoinColumn(name="fk_funcionario")}
	)
	private UnidadeTrabalho unidadeTrabalho;

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, double salario, LocalDate data) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setSalario(salario);
		this.setDataContratacao(data);
		
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public double getSalario() {
		return this.salario;
	}

	public LocalDate getDataContratacao() {
		return this.dataContratacao;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public void setNome(String value) {
		this.nome = value;
	}

	public void setCpf(String value) {
		this.cpf = value;
	}

	public void setSalario(double value) {
		this.salario = value;
	}

	public void setDataContratacao(LocalDate value) {
		this.dataContratacao = value;
	}

	@Override
	public String toString() {
		return String.format(
				new Locale("pt", "BR"), 
				"{id: %d, nome: %s, CPF: %s, salario %2.f, data contratacao: %s}",
				this.getId(), this.getNome(), this.getSalario(), this.getDataContratacao());
	}
}
