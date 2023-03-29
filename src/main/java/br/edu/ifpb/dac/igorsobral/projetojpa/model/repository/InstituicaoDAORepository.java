package br.edu.ifpb.dac.igorsobral.projetojpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Instituicao;


public interface InstituicaoDAORepository extends JpaRepository<Instituicao, Long>{

}
