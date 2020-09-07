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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsEmpConEntity;
import es.example.sb.ng.service.EsEmpConService;

@Validated
@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/user/emp")
public class EsEmpConController {

	@Autowired
	private EsEmpConService eConService;

	@GetMapping("/cons")
	public List<EsEmpConEntity> getAllUsers() {
		return eConService.getAllConEmps();
	}

	@GetMapping("/con/{id}")
	public ResponseEntity<EsEmpConEntity> getUserById(@PathVariable(value = "id") @Min(1) Long eId)
			throws ResourceNotFoundException {
		EsEmpConEntity emp = eConService.getConEmpById(eId);
		return ResponseEntity.ok().body(emp);
	}

	@PostMapping("/con")
	public EsEmpConEntity createUser(@Valid @RequestBody EsEmpConEntity emp) {
		return eConService.createConEmp(emp);
	}

}
