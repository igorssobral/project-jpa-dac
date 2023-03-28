package br.edu.ifpb.dac.igorsobral.projetojpa.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Integer cargaHoraria;
	@Column(nullable = false)
	private Integer periodos;
	@Column(nullable = false)
	private Double mensalidade;
	
	@ManyToOne(optional = false)
	private Instituicao instituicao;
	
	


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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getPeriodos() {
		return periodos;
	}

	public void setPeriodos(Integer periodos) {
		this.periodos = periodos;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicaoId) {
		this.instituicao = instituicaoId;
	}

	@Override
	public String toString() {
		return "ID: "+ id + "CURSO: " + nome + " - CARGA HORÁRIA: " + cargaHoraria + " - PERIODOS: " + periodos + " - MENSALIDADE: "
				+ mensalidade + "INSTITUIÇÃO: " + instituicao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargaHoraria, id, mensalidade, nome, periodos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(cargaHoraria, other.cargaHoraria) && Objects.equals(id, other.id)
				&& Objects.equals(mensalidade, other.mensalidade) && Objects.equals(nome, other.nome)
				&& Objects.equals(periodos, other.periodos);
	}






}
