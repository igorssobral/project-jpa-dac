package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;

import java.util.List;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.CursoDTO;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.InstituicaoDTO;

public interface ConverterService {

	Curso dtoToCurso(CursoDTO dto);

	CursoDTO cursoToDTO(Curso entity);

	List<CursoDTO> cursoToDTO(List<Curso> entities);

	List<Curso> dtoToCurso(List<CursoDTO> dtos);

	List<InstituicaoDTO> instituicaoToDTO(List<Instituicao> entities);

	Instituicao dtoToInstituicao(InstituicaoDTO dto);

	InstituicaoDTO instituicaoToDTO(Instituicao entity);
}
