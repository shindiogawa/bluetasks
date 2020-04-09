package br.com.ogawadev.bluetasks.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Task.class)
public class TaskRepositoryEventHandler {
	
	private TaskRepository taskRepository;
	
	@Autowired
	public TaskRepositoryEventHandler(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@HandleBeforeSave
	@HandleBeforeCreate
	public void handle(Task task) throws DuplicatedTaskException{
		
		Task taskDb = taskRepository.findByDescription(task.getDescription());
		boolean isDuplicated = false;
		
		if(taskDb != null) {
			
			if((task.getId() == null || task.getId() == 0) && task.getDescription().equals(taskDb.getDescription())) {
				isDuplicated = true;
			}
			
			if((task.getId() != null && task.getId() > 0) && !task.getId().equals(taskDb.getId())) {
				isDuplicated = true;
			}
		}
		
		if(isDuplicated) {
			throw new DuplicatedTaskException("Ja existe uma tarefa com esta descricao");
		}
	}
}
