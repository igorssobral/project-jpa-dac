package br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf;



import java.util.List;

import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Instituicao;

public interface InstituicaoService {

	public Instituicao save(Instituicao instituicao);
	
	public Instituicao update(Instituicao instituicao);
	
	public List<Instituicao> find(Instituicao instituicao);
	
	public Instituicao findById(Long id);
	
	public void delete(Long Id);
}
