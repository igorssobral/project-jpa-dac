package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import java.util.List;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Curso;

public interface CursoService{
	
	public Curso save(Curso curso);
	
	public Curso update(Curso curso);
	
	public List<Curso> find(Curso curso);
		
	public void delete(Long Id);

	public Curso findById(Long cursoId);

	List<Curso> findAll();
	
	public Curso findByName(String nome);
}
