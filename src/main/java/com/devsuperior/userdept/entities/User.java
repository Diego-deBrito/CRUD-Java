package com.devsuperior.userdept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// mostra que a tabela será mapeada pelo banco de dados
@Entity

// nome da tabela no banco
@Table(name = "tb_user")
public class User {
	
	// chave primária do banco
		@Id
		
	// geração automática de valores para colunas de chaves primárias
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;

	
	// muitos para um
	@ManyToOne
	// configurando nome da chave 
	@JoinColumn(name = "department_id")
	
	// referência de memória 
	private Departament departament;

	
	public User() {
	}

	
	// método get/set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
