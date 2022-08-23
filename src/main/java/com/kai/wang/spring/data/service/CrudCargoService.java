package com.kai.wang.spring.data.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.kai.wang.spring.data.orm.Cargo;
import com.kai.wang.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	private final CargoRepository repository;
	private Boolean systemOP = true;

	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {
		while (systemOP) {
			System.out.println("----------------------------------------------");
			System.out.println("---------------ROTA CARGOS--------------------");
			System.out.println("---------------ESCOLHA UMA ACAO---------------");
			System.out.println("------------+******************+--------------");
			System.out.println("------------|  [0] - SAIR      |--------------");
			System.out.println("------------|  [1] - CADASTRAR |--------------");
			System.out.println("------------|  [2] - ATUALIZAR |--------------");
			System.out.println("------------|  [3] - BUSCAR    |--------------");
			System.out.println("------------|  [4] - REMOVER   |--------------");
			System.out.println("------------+******************+--------------");
			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3: 
				buscar();
				break;
			case 4: 
				deletar(scanner);
				break;
			default:
				systemOP = false;
				break;
			}
		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("----------------------------------------------");
		System.out.println("---------------ROTA PARA CREATE---------------");
		System.out.println("----------------------------------------------");

		System.out.println("Insira a DESCRICAO do CARGO: ");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);
		System.out.println("----------------------------------------------");
		System.out.println("|| NOVO CARGO - " + descricao + " - salvo com sucesso ||");
		System.out.println("----------------------------------------------");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("----------------------------------------------");
		System.out.println("---------------ROTA PARA UPDATE---------------");
		System.out.println("----------------------------------------------");

		System.out.println("Qual o ID que será atualizado? ");
		Long id = (long) scanner.nextInt();
		System.out.println("Qual o novo valor para Descriação?");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		repository.save(cargo);

		System.out.println("----------------------------------------------");
		System.out.println("----REGISTRO DE ID " + id + "ATUALIZADO PARA DESCRICAO: " + descricao + "------");
		System.out.println("----------------------------------------------");
	}
	
	private void buscar() {
		System.out.println("----------------------------------------------");
		System.out.println("---------------ROTA LOCALIZAR  ---------------");
		System.out.println("----------------------------------------------");
		
		ArrayList<Cargo> cargos = (ArrayList<Cargo>) repository.findAll();
		cargos.stream().forEach(c -> System.out.println(c));
		
		System.out.println("----------------------------------------------");
		System.out.println("---------------FIM----------------------------");
		System.out.println("----------------------------------------------");
	}
	
	private void deletar(Scanner scanner) {
		
		System.out.println("----------------------------------------------");
		System.out.println("---------------ROTA DELETAR  ---------------");
		System.out.println("----------------------------------------------");
		
		System.out.println("------QUAL RESITRO DESEJA DELETAR?------------");
		
		Long id = (long) scanner.nextInt();
		repository.deleteById(id);
		
		System.out.println("----------------------------------------------");
		System.out.println("---------------REGISTRO ID " + id + " DELETADO ----------------------");
		System.out.println("----------------------------------------------");
		
	}
}
