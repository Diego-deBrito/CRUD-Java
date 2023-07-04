// implementada como sub-classe
package com.devsuperior.userdept.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// mostra que a tabela será mapeada pelo banco de dados
@Entity

// nome da tabela no banco
@Table(name = "tb_department")
public class Departament {
	
	
	// chave primária do banco
	@Id
	
	// geração automática de valores para colunas de chaves primárias
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// Mostra que a classe pode ser instânciada sem nenhum argumento.
	public Departament() {	
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
	
	

}
