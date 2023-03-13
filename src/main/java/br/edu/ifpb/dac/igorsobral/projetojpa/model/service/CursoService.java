package br.edu.ifpb.dac.igorsobral.projetojpa.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.dao.CursoDAORepository;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;

@Service
public class CursoService {

	@Autowired
	private CursoDAORepository cursoDAORepository;

	public Curso salvar(Curso curso) {
		return cursoDAORepository.save(curso);
	}

	public void update(Curso curso, int id) {

		Curso cursos = cursoDAORepository.findById(id).get();
		cursos.setNome(curso.getNome());
		cursos.setPeriodos(curso.getPeriodos());
		cursos.setPeriodos(curso.getCargaHoraria());
		cursos.setMensalidade(curso.getMensalidade());

		cursoDAORepository.save(cursos);
	}

	public void delete(int id) {
		cursoDAORepository.deleteById(id);
	}

	public List<Curso> list() {

		return cursoDAORepository.findAll();
	}
}
