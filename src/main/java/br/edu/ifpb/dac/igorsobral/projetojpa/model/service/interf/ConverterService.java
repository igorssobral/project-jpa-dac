package br.edu.ifpb.dac.igorsobral.projetojpa.model.service.interf;

import java.util.List;

import br.edu.ifpb.dac.igorsobral.projetojpa.dto.CursoDTO;
import br.edu.ifpb.dac.igorsobral.projetojpa.dto.InstituicaoDTO;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Instituicao;

public interface ConverterService {

	Curso dtoToCurso(CursoDTO dto);

	CursoDTO cursoToDTO(Curso entity);

	List<CursoDTO> cursoToDTO(List<Curso> entities);

	List<Curso> dtoToCurso(List<CursoDTO> dtos);

	List<InstituicaoDTO> instituicaoToDTO(List<Instituicao> entities);

	Instituicao dtoToInstituicao(InstituicaoDTO dto);

	InstituicaoDTO instituicaoToDTO(Instituicao entity);
}
