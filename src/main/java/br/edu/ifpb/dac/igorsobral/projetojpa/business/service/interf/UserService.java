package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;

public interface UserService  extends UserDetailsService{


	public User save(User user);
	
	public User update(User user);
	
	public void delete(Long id);
	
	public User findById(Long id);
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
	public Iterable<User> findAll();
	
	public List<User> find(User filter);
}
