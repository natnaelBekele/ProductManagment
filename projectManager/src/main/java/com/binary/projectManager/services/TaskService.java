package com.binary.projectManager.services;


import com.binary.projectManager.dtos.TaskDto;
import com.binary.projectManager.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task createTask(TaskDto taskDto);
    Task updateTask(Long id, TaskDto taskDto);
    void deleteTask(Long id);
    Task getTaskById(Long id);
}
