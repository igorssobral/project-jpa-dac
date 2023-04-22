package br.edu.ifpb.dac.igorsobral.projetojpa.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
		
		Optional<User> findByEmail(String email);
		
		Optional<User> findByUsername(String username);
	
}
