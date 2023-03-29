package br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto;

public class CursoDTO {
	
	private Long id;
	private String nome;
	private Integer cargaHoraria;
	private Integer periodos;
	private Double mensalidade;
	
	private String instituicaoId;
	
	
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
	public String getInstituicaoId() {
		return instituicaoId;
	}
	public void setInstituicaoId(String instituicaoId) {
		this.instituicaoId = instituicaoId;
	}

	
	

	
	
	
}
