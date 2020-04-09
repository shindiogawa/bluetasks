package br.com.ogawadev.bluetasks.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter

public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O nome de usuario e obrigatorio")
	private String username;
	
	@NotEmpty(message = "A senha e obrigatorio")
	private String password;
	
	@NotEmpty(message = "O nome de exibicao e obrigatorio")
	private String displayName;
	
	public AppUser() {
		
	}

	public AppUser(String username, String password, String displayName) {
		this.username = username;
		this.password = password;
		this.displayName = displayName;
	}
	
	
}
