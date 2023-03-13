package br.edu.ifpb.dac.igorsobral.projetojpa.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.service.InstituicaoService;


@Controller
public class InstituicaoController {

	@Autowired
	private InstituicaoService instituicaoService;

	public void create(String nome, String telefone, String email, Curso curso) {

		Instituicao instituicao = new Instituicao();

		instituicao.setNome(nome);
		instituicao.setTelefone(telefone);
		instituicao.setEmail(email);
		instituicao.setCursos(curso);

		instituicaoService.salvar(instituicao);
	}

	public void delete(int id) {
		instituicaoService.delete(id);

	}

	public void update(String nome, String telefone, String email, int id) {
		Instituicao instituicao = new Instituicao();

		instituicao.setNome(nome);
		instituicao.setTelefone(telefone);
		instituicao.setEmail(email);

		instituicaoService.update(instituicao, id);
	}

	public List<Instituicao> read() throws Exception {
		if (instituicaoService.list().isEmpty()) {
			System.out.println("ERROR: NENHUM REGISTRO ENCONTRADO!");
		}
		return instituicaoService.list();

	}

}
