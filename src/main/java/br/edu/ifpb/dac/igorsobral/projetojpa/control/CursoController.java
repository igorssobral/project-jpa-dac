package br.edu.ifpb.dac.igorsobral.projetojpa.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;

	public Curso create(String nome, int cargaH, int Periodo, double mensalidade) {
		Curso curso = new Curso();

		curso.setNome(nome);
		curso.setPeriodos(Periodo);
		curso.setCargaHoraria(cargaH);
		curso.setMensalidade(mensalidade);

		return cursoService.salvar(curso);

	}

	public void delete(int id) {
		cursoService.delete(id);
	}

	public void update(String nome, int cargaH, int Periodo, double mensalidade, int id) {
		Curso curso = new Curso();

		curso.setNome(nome);
		curso.setPeriodos(Periodo);
		curso.setCargaHoraria(cargaH);
		curso.setMensalidade(mensalidade);

		cursoService.update(curso, id);
	}

	public List<Curso> read() {
		return cursoService.list();

	}
}
