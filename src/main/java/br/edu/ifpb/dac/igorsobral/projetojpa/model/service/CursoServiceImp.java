package br.edu.ifpb.dac.igorsobral.projetojpa.model.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.dao.CursoDAORepository;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.service.interf.CursoService;


@Service
public class CursoServiceImp implements CursoService{

	@Autowired
	private CursoDAORepository cursoRepository;

	
	public Curso save(Curso curso) {
		if(curso.getId() != null) {
			throw new IllegalStateException("The user already exists in the database.");
		}
		return cursoRepository.save(curso);

	}

	public Curso update(Curso curso) {
		if(curso.getId() == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		

		return cursoRepository.save(curso);

	}

	public void delete(Long id) {
		
		if(id == null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
		}
		Curso curso = findById(id);

	if(curso == null) {
		throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
	}
	
	cursoRepository.delete(curso);
}
	
	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}
	
	@Override
	public List<Curso> find(Curso filter){
		
		Example<Curso> example = Example.of(filter,
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING));
		
		return cursoRepository.findAll(example);
	}

	public Curso findById(Long id) {
		if(id == null) {
			throw new IllegalStateException("Id cannot be null!");
		}
		
		Optional<Curso> optional = cursoRepository.findById(id);
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	public Curso findByName(String nome) {
		if(nome == null) {
			throw new IllegalStateException("Nome cannot be null!");
		}
		
		Curso curso = null;
		List<Curso> cursos = cursoRepository.findAll();
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getNome().equals(nome)) {
				curso = cursos.get(i);
			}	
		}

		return curso;
	}

	


	

	
	

	
}
