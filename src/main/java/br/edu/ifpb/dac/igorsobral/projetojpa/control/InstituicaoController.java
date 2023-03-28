package br.edu.ifpb.dac.igorsobral.projetojpa.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.igorsobral.projetojpa.dto.InstituicaoDTO;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.service.interf.ConverterService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.service.interf.CursoService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.service.interf.InstituicaoService;


@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

	
	@Autowired
	private InstituicaoService instituicaoService;
	@Autowired
	private ConverterService converterService;
	
	

	@PostMapping
	public ResponseEntity save(@RequestBody InstituicaoDTO instituicaoDTO) {
		try {
			Instituicao entity = converterService.dtoToInstituicao(instituicaoDTO);
			entity = instituicaoService.save(entity);
			instituicaoDTO = converterService.instituicaoToDTO(entity);

			return new ResponseEntity(instituicaoDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {

		try {
			instituicaoService.delete(id);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody InstituicaoDTO instituicaoDTO) {

		try {
			instituicaoDTO.setId(id);
			Instituicao instituicao = converterService.dtoToInstituicao(instituicaoDTO);
			instituicao = instituicaoService.update(instituicao);

			instituicaoDTO = converterService.instituicaoToDTO(instituicao);
			return ResponseEntity.ok(instituicaoDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	@GetMapping
	public ResponseEntity find(
				@RequestParam(value = "name", required = false) String name,
				@RequestParam(value = "email", required = false) String email,
				@RequestParam(value = "id", required = false) Long id,
				@RequestParam(value = "telefone", required = false) String telefone
				
				
			) {
		try {
			Instituicao filter = new Instituicao();
			
			filter.setId(id);
			filter.setNome(name);
			filter.setEmail(email);
			filter.setTelefone(telefone);
					
			List<Instituicao> entities = instituicaoService.find(filter);
			List<InstituicaoDTO> dtos =  converterService.instituicaoToDTO(entities);
			
			return ResponseEntity.ok(dtos);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

}
}
