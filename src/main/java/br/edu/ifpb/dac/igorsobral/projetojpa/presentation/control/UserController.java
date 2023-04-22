package br.edu.ifpb.dac.igorsobral.projetojpa.presentation.control;

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
import br.edu.ifpb.dac.igorsobral.projetojpa.business.service.interf.UserService;
import br.edu.ifpb.dac.igorsobral.projetojpa.model.entity.User;
import br.edu.ifpb.dac.igorsobral.projetojpa.presentation.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ConverterService converterService;
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity save(@RequestBody UserDTO dto) {
		try {
			User entity = converterService.dtoToUser(dto);
			entity = service.save(entity);
			dto = converterService.userToDTO(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody UserDTO dto) {
		try {
			dto.setId(id);
			User entity = converterService.dtoToUser(dto);
			entity = service.update(entity);
			dto = converterService.userToDTO(entity);
			
			return ResponseEntity.ok(dto);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity find(
				@RequestParam(value = "name", required = false) String name,
				@RequestParam(value = "email", required = false) String email,
				@RequestParam(value = "id", required = false) Long id
			) {
		try {
			User filter = new User();
			filter.setId(id);
			filter.setName(name);
			filter.setEmail(email);
			
			List<User> entities = service.find(filter);
			List<UserDTO> dtos = converterService.userToDTO(entities);
			
			return ResponseEntity.ok(dtos);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
