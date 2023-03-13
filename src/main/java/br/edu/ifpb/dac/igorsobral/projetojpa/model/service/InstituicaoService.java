package br.edu.ifpb.dac.igorsobral.projetojpa.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.igorsobral.projetojpa.dao.InstituicaoDAORepository;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Instituicao;


@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoDAORepository instituicaoDAORepository;

	public void salvar(Instituicao instituicao) {
		instituicaoDAORepository.save(instituicao);

	}

	public void update(Instituicao instituicao, int id) {

		Instituicao inst = instituicaoDAORepository.findById(id).get();
		inst.setNome(instituicao.getNome());
		inst.setTelefone(instituicao.getTelefone());
		inst.setCursos(inst.getCursos());
		inst.setEmail(instituicao.getEmail());

		instituicaoDAORepository.save(inst);

	}

	public void delete(int id) {
		instituicaoDAORepository.deleteById(id);
	}

	public List<Instituicao> list() {

		return instituicaoDAORepository.findAll();
	}
}
