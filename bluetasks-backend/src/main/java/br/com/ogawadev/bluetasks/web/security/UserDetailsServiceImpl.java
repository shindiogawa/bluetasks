package br.com.ogawadev.bluetasks.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ogawadev.bluetasks.domain.user.AppUser;
import br.com.ogawadev.bluetasks.domain.user.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private AppUserRepository appUserRepository;
	
	@Autowired
	public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser = appUserRepository.findByUsername(username);
		
		if( appUser == null) {
			
			throw new UsernameNotFoundException(username);
			
		}
		
		return new UserDetailsImpl(appUser);
		
	}

}
