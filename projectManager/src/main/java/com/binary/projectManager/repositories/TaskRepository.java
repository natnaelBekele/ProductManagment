package com.binary.projectManager.repositories;


import com.binary.projectManager.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
