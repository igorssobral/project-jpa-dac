package br.edu.ifpb.dac.igorsobral.projetojpa.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.SystemRole;

public interface RoleRepository extends JpaRepository<SystemRole, Long> {

	Optional<SystemRole> findByName(String name);
		
	
		
	
	
}
