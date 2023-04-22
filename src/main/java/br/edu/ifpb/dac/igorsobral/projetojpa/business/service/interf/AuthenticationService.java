package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;

public interface AuthenticationService {

public String localLogin(String email, String password);
	
	public User getLoggedUser();
}
