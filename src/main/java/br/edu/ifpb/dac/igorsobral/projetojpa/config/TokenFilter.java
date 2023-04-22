package br.edu.ifpb.dac.igorsobral.projetojpa.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.TokenService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.UserService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;


public class TokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UserService userService;
	
	public TokenFilter(TokenService tokenService, UserService userService) {
		super();
		this.tokenService = tokenService;
		this.userService = userService;
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = tokenService.get(request);
		boolean valid = tokenService.isValid(token);
	
		if(valid) {
			authenticate(token);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private void authenticate(String token) {
		Long userid = Long.parseLong(tokenService.getUserId(token));
		User user = userService.findById(userid);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

}
