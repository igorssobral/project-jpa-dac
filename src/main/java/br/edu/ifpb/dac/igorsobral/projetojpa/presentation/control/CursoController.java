package br.edu.ifpb.dac.igorsobral.projetojpa.presentation.control;

import java.util.ArrayList;
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

import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.ConverterService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.CursoService;
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.InstituicaoService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Curso;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.Instituicao;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.CursoDTO;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private ConverterService converterService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private InstituicaoService instituicaoService;

	@PostMapping
	public ResponseEntity save(@RequestBody CursoDTO cursoDTO) {
		try {
			Curso curso = converterService.dtoToCurso(cursoDTO);
			Instituicao instituicao = instituicaoService.findById(Long.parseLong(cursoDTO.getInstituicaoId()));
			
			if(instituicao == null) {
				return new ResponseEntity(instituicao, HttpStatus.valueOf(404));
			}else {
				curso.setInstituicao(instituicao);
			curso = cursoService.save(curso);
			cursoDTO = converterService.cursoToDTO(curso);
			}
			
			
			return new ResponseEntity(cursoDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {

		try {
			cursoService.delete(id);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody CursoDTO cursoDTO) {

		try {
			cursoDTO.setId(id);
			
			Long instituicaoId = Long.parseLong(cursoDTO.getInstituicaoId());
			Instituicao instituicao = instituicaoService.findById(instituicaoId);
			
			if(instituicao == null) {
				throw new IllegalStateException(String.format("Cound not find any user with id=%l", instituicaoId));
			}
			Curso entity = converterService.dtoToCurso(cursoDTO);
			entity.setInstituicao(instituicao);
			
			entity = cursoService.update(entity);
			cursoDTO = converterService.cursoToDTO(entity);

			return ResponseEntity.ok(cursoDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	@GetMapping
	public ResponseEntity find(
				@RequestParam(value = "name", required = false) String nome,
				@RequestParam(value = "insId", required = false) Long insId
			) {
		
		try {
			Curso filter = new Curso();
			List<Curso> entities = new ArrayList<>();
			if(insId != null) {
				filter.setNome(nome);
			
			Instituicao instituicao = instituicaoService.findById(insId);
			
			
			if(instituicao == null) {
				throw new IllegalStateException(String.format("Cound not find any user with id=%l", insId));
			}
			
			filter.setInstituicao(instituicao);
			entities = cursoService.find(filter);
			}else if(nome !=null) {
				entities.add(cursoService.findByName(nome));
			}else {
				entities = cursoService.findAll();
			}
			
			
			
			List<CursoDTO> dtos = converterService.cursoToDTO(entities);
			
			return ResponseEntity.ok(dtos);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
