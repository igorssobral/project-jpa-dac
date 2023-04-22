package br.edu.ifpb.dac.igorsobral.projetojpa.business.service;





import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.RoleService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.SystemRole;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public void createDefaultValues() {
		for(AVAILABLE_ROLES availableRole : AVAILABLE_ROLES.values()) {
			SystemRole role = findByName(availableRole.name()) ;
			
			if(role == null) {
				role = new SystemRole();
				role.setName(availableRole.name());
				repository.save(role);
			}
		}
		
	}
	private SystemRole findByName(String name) {
			
		if(name == null) {
			throw new IllegalStateException("Name cannot be null");
		}
		
		Optional<SystemRole> optional = repository.findByName(name);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public SystemRole findDefault() {
		return findByName(AVAILABLE_ROLES.USER.name());
	}

}
