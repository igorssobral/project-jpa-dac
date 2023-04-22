package br.edu.ifpb.dac.igorsobral.projetojpa.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.ConverterService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.SystemRole;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.CursoDTO;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.InstituicaoDTO;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.UserDTO;

@Service
public class ConverterServiceImp implements ConverterService {

	@Override
	public Instituicao dtoToInstituicao(InstituicaoDTO dto) {
		Instituicao entity = new Instituicao();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());


		return entity;
	}

	@Override
	public InstituicaoDTO instituicaoToDTO(Instituicao entity) {
		InstituicaoDTO insDTO = new InstituicaoDTO();
		insDTO.setId(entity.getId());
		insDTO.setNome(entity.getNome());
		insDTO.setEmail(entity.getEmail());
		insDTO.setTelefone(entity.getTelefone());

		return insDTO;
	}

	@Override
	public Curso dtoToCurso(CursoDTO dto) {
		Curso entity = new Curso();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setPeriodos(dto.getPeriodos());
		entity.setCargaHoraria(dto.getCargaHoraria());
		entity.setMensalidade(dto.getMensalidade());

		return entity;
	}

	@Override
	public CursoDTO cursoToDTO(Curso entity) {

		CursoDTO cursoDTO = new CursoDTO();

		cursoDTO.setId(entity.getId());
		cursoDTO.setNome(entity.getNome());
		cursoDTO.setPeriodos(entity.getPeriodos());
		cursoDTO.setCargaHoraria(entity.getCargaHoraria());
		cursoDTO.setMensalidade(entity.getMensalidade());
		cursoDTO.setInstituicaoId(entity.getInstituicao().getId().toString());

		return cursoDTO;
	}

	@Override
	public List<CursoDTO> cursoToDTO(List<Curso> entities) {
		List<CursoDTO> dtos = new ArrayList<>();

		for (Curso curso : entities) {
			CursoDTO dto = cursoToDTO(curso);
			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public List<Curso> dtoToCurso(List<CursoDTO> dtos) {
		List<Curso> entities = new ArrayList<>();

		for (CursoDTO dto : dtos) {
			Curso entity = dtoToCurso(dto);
			entities.add(entity);
		}

		return entities;
	}

	@Override
	public List<InstituicaoDTO> instituicaoToDTO(List<Instituicao> entities) {
		List<InstituicaoDTO> dtos = new ArrayList<>();

		for (Instituicao dto : entities) {
			InstituicaoDTO entity = instituicaoToDTO(dto);
			dtos.add(entity);
		}

		return dtos;
	}

	@Override
	public List<UserDTO> userToDTO(List<User> entities) {
		List<UserDTO> dtos = new ArrayList<>();

		for (User dto : entities) {
			UserDTO entity = userToDTO(dto);
			dtos.add(entity);
		}

		return dtos;
	}

	@Override
	public User dtoToUser(UserDTO dto) {
		User entity = new User();

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());

		return entity;
	}

	@Override
	public UserDTO userToDTO(User entity) {
		UserDTO dto = new UserDTO();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setUsername(entity.getUsername());
		dto.setEmail(entity.getEmail());

		List<String> roles = new ArrayList<>();
		if(entity.getRoles() != null) {
			for (SystemRole role : entity.getRoles()) {
				roles.add(role.getName());
			}
		}

		dto.setRoles(roles.toArray(new String[0]));

		return dto;
	}

}
