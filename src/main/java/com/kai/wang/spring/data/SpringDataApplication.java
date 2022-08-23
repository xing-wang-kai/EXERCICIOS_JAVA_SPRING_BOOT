package com.kai.wang.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kai.wang.spring.data.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;
	private CrudCargoService CrudCargoService;

	public SpringDataApplication(CrudCargoService CrudCargoService) {
		this.CrudCargoService = CrudCargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acction você deseja realizar? ");
			System.out.println("0 - SAIR");
			System.out.println("1 - CARGOS");
			int acction = scanner.nextInt();
			if(acction == 1) {
				this.CrudCargoService.inicial(scanner);
			}else {
				this.system = false;
			}
		}
	}
	
}
