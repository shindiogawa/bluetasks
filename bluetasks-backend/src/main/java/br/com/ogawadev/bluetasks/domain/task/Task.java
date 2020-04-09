package br.com.ogawadev.bluetasks.domain.task;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ogawadev.bluetasks.domain.user.AppUser;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EntityListeners(TaskListener.class)
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty(message = "A descricao da tarefa e obrigatoria")
	@Length(min = 3, max = 60, message = "O tamanho da tarefa e invalido")
	private String description;
	
	@NotNull(message = "A data da tarefa e obrigatoria")
	@FutureOrPresent(message = "A data da tarefa nao pode estar no passado")
	private LocalDate whenToDo;
	
	private Boolean done = false;
	
	@ManyToOne
	@JoinColumn(name = "app_user_id")
	@JsonIgnore
	private AppUser appUser;
	
	public Task() {
		
	}

	public Task(String description, LocalDate whenToDo, Boolean done) {
		this.description = description;
		this.whenToDo = whenToDo;
		this.done = done;
	}
	
}
