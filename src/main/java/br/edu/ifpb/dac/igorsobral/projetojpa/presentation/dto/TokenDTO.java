package br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto;


public class TokenDTO {

	private String token;
	private UserDTO user;
	
	public TokenDTO() {
	}
	public TokenDTO(String token, UserDTO user) {
		super();
		this.token = token;
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}