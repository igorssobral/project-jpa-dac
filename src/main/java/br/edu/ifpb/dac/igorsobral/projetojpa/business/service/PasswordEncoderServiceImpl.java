package br.edu.ifpb.dac.igorsobral.projetojpa.business.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.PasswordEncoderService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;

@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEncoderService{

	@Override
	public void encryptPassword(User user) {
		if(user.getPassword() != null) {
			String passwordEncrypted = encode(user.getPassword());
			
			user.setPassword(passwordEncrypted);
		}
	}

}
