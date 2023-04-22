package br.edu.ifpb.dac.igorsobral.projetojpa.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.AuthenticationService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.ConverterService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.TokenService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.UserService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;


@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	

	public String localLogin(String username, String password) {	
		//Excecao sera lancada em caso de falha
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password));
		
		User user = userService.findByUsername(username);
		System.out.println(user);
		return tokenService.generate(user);
	}
	
	

	@Override
	public User getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
		return  (User) authentication.getPrincipal();
	}
	
}
