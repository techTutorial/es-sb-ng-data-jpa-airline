package es.example.sb.ng.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsUserEntity;
import es.example.sb.ng.service.EsUserService;

@Validated
@CrossOrigin(origins = "http://localhost:4201")
@RestController
public class EsUserController {

	@Autowired
	private EsUserService userService;

	@GetMapping("/users")
	public List<EsUserEntity> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<EsUserEntity> getUserById(@PathVariable(value = "id") @Min(1) Long eId)
			throws ResourceNotFoundException {
		EsUserEntity emp = userService.getUserById(eId);
		return ResponseEntity.ok().body(emp);
	}

	@PostMapping("/user")
	public EsUserEntity createUser(@Valid @RequestBody EsUserEntity emp) {
		return userService.createUser(emp);
	}

}
