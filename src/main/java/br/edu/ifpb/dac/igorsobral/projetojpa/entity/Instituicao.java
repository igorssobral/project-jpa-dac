package br.edu.ifpb.dac.igorsobral.projetojpa.entity;

import java.util.Objects;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instituicao{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

		return "ID: " + id +"INSTITUIÇÃO: " + nome + " - TELEFONE: " + telefone  ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instituicao other = (Instituicao) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	
	
}