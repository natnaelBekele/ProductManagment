//package com.binary.projectManager;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ProjectManagerApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ProjectManagerApplication.class, args);
//	}
//
//}
package com.binary.projectManager;

import com.binary.projectManager.entities.Project;
import com.binary.projectManager.entities.Task;
import com.binary.projectManager.repositories.ProjectRepository;
import com.binary.projectManager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagerApplication implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create and save projects
		Project project1 = new Project();
		project1.setName("Project Alpha");
		project1.setDescription("Description for Project Alpha");
		projectRepository.save(project1);

		Project project2 = new Project();
		project2.setName("Project Beta");
		project2.setDescription("Description for Project Beta");
		projectRepository.save(project2);

		// Create and save tasks for Project Alpha
		Task task1 = new Task();
		task1.setName("Task 1 for Project Alpha");
		task1.setDescription("Description for Task 1");
		task1.setStatus("Pending");
		task1.setProject(project1);
		taskRepository.save(task1);

		Task task2 = new Task();
		task2.setName("Task 2 for Project Alpha");
		task2.setDescription("Description for Task 2");
		task2.setStatus("Completed");
		task2.setProject(project1);
		taskRepository.save(task2);

		// Create and save tasks for Project Beta
		Task task3 = new Task();
		task3.setName("Task 1 for Project Beta");
		task3.setDescription("Description for Task 1");
		task3.setStatus("Pending");
		task3.setProject(project2);
		taskRepository.save(task3);

		Task task4 = new Task();
		task4.setName("Task 2 for Project Beta");
		task4.setDescription("Description for Task 2");
		task4.setStatus("In Progress");
		task4.setProject(project2);
		taskRepository.save(task4);

		System.out.println("Projects and tasks have been initialized.");
	}
}
