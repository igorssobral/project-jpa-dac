package br.edu.ifpb.dac.igorsobral.projetojpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Curso;


public interface  CursoDAORepository extends JpaRepository<Curso, Long>{

	
}
