package br.edu.ifpb.dac.igorsobral.projetojpa.entity;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private int cargaHoraria;
	private int periodos;
	private double mensalidade;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getPeriodos() {
		return periodos;
	}

	public void setPeriodos(int periodos) {
		this.periodos = periodos;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	@Override
	public String toString() {
		return "CURSO: " + nome + " - CARGA HORÁRIA: " + cargaHoraria + " - PERIODOS: " + periodos + " - MENSALIDADE: "
				+ mensalidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargaHoraria, mensalidade, nome, periodos);
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
		return cargaHoraria == other.cargaHoraria
				&& Double.doubleToLongBits(mensalidade) == Double.doubleToLongBits(other.mensalidade)
				&& Objects.equals(nome, other.nome) && periodos == other.periodos;
	}

}
