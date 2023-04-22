package br.edu.ifpb.dac.igorsobral.projetojpa.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.PasswordEncoderService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.RoleService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.UserService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.SystemRole;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoderService passwordEnconderService;
	
	@Override
	public User save(User user) {
		if(user.getId() != null) {
			throw new IllegalStateException("User is already in the database. Maybe you can try update it.");
		}
		
		passwordEnconderService.encryptPassword(user);
	
		List<SystemRole> roles = new ArrayList<>();
		roles.add(roleService.findDefault());
		user.setRoles(roles);
		
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		if(user.getId() == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		
		passwordEnconderService.encryptPassword(user);
		
		return repository.save(user);
	}

	@Override
	public void delete(Long id) {
		if(id == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		
		User systemUser = findById(id);
		
		if(systemUser == null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
		}
		
		repository.delete(systemUser);
	}

	@Override
	public User findById(Long id) {
		if(id == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		
		Optional<User> optional = repository.findById(id);
		
		return optional.isPresent() ? optional.get() : null;
	}
	

	@Override
	public User findByEmail(String email) {
		if(email == null) {
			throw new IllegalStateException("Email cannot be null");
		}
		
		Optional<User> optional = repository.findByEmail(email); 
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	@Override
	public User findByUsername(String username) {
		if(username == null) {
			throw new IllegalStateException("Username cannot be null");
		}
		
		Optional<User> optional = repository.findByUsername(username); 
		
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Iterable<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<User> find(User filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(String.format("Could not find any user with username %s", username));
		}
		
		return (UserDetails) user;
	}
}
