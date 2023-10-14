package com.joaocarlos.aulasimple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task>buscarPeloIdentificador(Long id);

	void saveAll(List<com.joaocarlos.aulasimple.model.Task> tasks);
	

}
