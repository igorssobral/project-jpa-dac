package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.SystemRole;

public interface RoleService {

	public enum AVAILABLE_ROLES { ADMIN, USER }

	void createDefaultValues();
	
	SystemRole findDefault();
}
