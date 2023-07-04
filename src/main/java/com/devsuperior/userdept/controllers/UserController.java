package com.devsuperior.userdept.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

import jakarta.persistence.EntityManager;


// determina controlador e faz requisições
@RestController

// caminho do controlador
@RequestMapping(value = "/users")
public class UserController {
	
	// injeção de dependências, evita instância new
	@Autowired
	// composição de componentes
	private UserRepository repository;

	// para requisição web
	@GetMapping
	// busca todos os usuários no banco de dados
	public List<User> findAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id){
		User result = repository.findById(id).get();
		return result;
	}
	
	// salvar novo usuário
	@PostMapping
	// Objeto tipo user como argumento, recebe corpo da requisição
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}
	
	// busca o usuário com o ID fornecido
	private EntityManager entittyManager;
	// usamos o EntityManager para buscar o usuário com o ID fornecido
	public void deleteUser(Long id) {
		User user = entittyManager.find(User.class, id);
		if(user != null) {
			entittyManager.remove(user);
		}
	}
	
	
}
