package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;


public interface PasswordEncoderService extends PasswordEncoder{

	void encryptPassword(User user);
	
}
