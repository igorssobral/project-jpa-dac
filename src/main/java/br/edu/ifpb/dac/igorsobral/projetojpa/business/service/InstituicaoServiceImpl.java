




package br.edu.ifpb.dac.igorsobral.projetojpa.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.InstituicaoService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.repository.InstituicaoDAORepository;


@Service
public class InstituicaoServiceImpl implements InstituicaoService{

	@Autowired
	private InstituicaoDAORepository instituicaoRepository;

	public Instituicao save(Instituicao instituicao) {
		if(instituicao.getId() != null) {
			throw new IllegalStateException("The user already exists in the database.");
		}
		return instituicaoRepository.save(instituicao);

	}

	public Instituicao update(Instituicao instituicao) {
		if(instituicao.getId() == null){
			throw new IllegalStateException("Id cannot be null");
		}
		

		return instituicaoRepository.save(instituicao);

	}

	public void delete(Long id) {
		
		if(id == null) {
			throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
		}
		Instituicao instituicao = findById(id);
	

	if(instituicao == null) {
		throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
	}
	
	instituicaoRepository.delete(instituicao);
}
	
	

	@Override
	public List<Instituicao> find(Instituicao instituicao) {
		Example example = Example.of(instituicao,
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING));
		
		return instituicaoRepository.findAll(example);
	}
	

	public Instituicao findById(Long id) {
		
		if(id == null) {
			throw new IllegalStateException("Id cannot be null");
		}
		
		Optional<Instituicao> optional = instituicaoRepository.findById(id);
		
		return optional.isPresent() ? optional.get() : null;
	}

	

	
	

}