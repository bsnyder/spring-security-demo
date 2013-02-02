package org.bsnyder.spring.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private static final long serialVersionUID = 6698231753971757890L;
	
	private String email;
	private String description;

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, 
			String email, String description) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.email = email;
		this.description = description;
	}
	
	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}


}
