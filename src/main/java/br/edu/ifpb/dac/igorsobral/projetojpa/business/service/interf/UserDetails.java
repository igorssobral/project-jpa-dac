package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetails extends Serializable{


	Collection<? extends GrantedAuthority> getAuthorities();


	String getPassword();

	boolean isAccountNonExpired();

	boolean isAccountNonLocked();
	
	boolean isCredentialsNonExpired();

	boolean isEnabled();
	
	
	
	
	

}
