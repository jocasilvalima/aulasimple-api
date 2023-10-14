package com.joaocarlos.aulasimple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaocarlos.aulasimple.model.User;
import com.joaocarlos.aulasimple.repository.TaskRepository;
import com.joaocarlos.aulasimple.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	public User  buscarPeloIdentificador(Long id) {
		
		Optional<User> user = this.userRepository.findById(id);
		return user.orElseThrow(() -> new RuntimeException(
				"Usuário não encontrado ! Id: " + id + "Tipo: " + User.class.getName()));
		
	}
	
	
	@Transactional
	public User criarUsuario(User obj) {
		
		obj = this.userRepository.save(obj);
		this.taskRepository.saveAll(obj.getTasks());
		return obj;
	}
	
	
	@Transactional
	public User updateUsuario(User obj) {
		 User newObj = buscarPeloIdentificador(obj.getId());
		 newObj.setPassword(obj.getPassword());
		 return this.userRepository.save(newObj);
	}
	
	public void delete(Long id) {
		
		buscarPeloIdentificador(id);
		
		try {
			this.userRepository.deleteById(id);
		}catch(Exception e) {
			throw new RuntimeException("Não é possivel excluir pois há tarefas relacionadas!")
		}
		
		
		
	}

}
