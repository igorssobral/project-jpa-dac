package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import javax.servlet.http.HttpServletRequest;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

public interface TokenService {

String generate(User user);
	
	Claims getClaims(String token) throws ExpiredJwtException;
	
	boolean isValid(String token);
	
	String getUsername(String token);
	
	String getUserId(String token);
	
	String get(HttpServletRequest request);
}
