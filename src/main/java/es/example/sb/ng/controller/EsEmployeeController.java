package es.example.sb.ng.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsEmployeeEntity;
import es.example.sb.ng.service.EsEmployeeService;

@Validated
@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/user")
public class EsEmployeeController {
	
	@Autowired
	private EsEmployeeService empService;

	
	@GetMapping("/employees")
	public List<EsEmployeeEntity> getAllEmployees() {
		return empService.getAllEmployees();
	}

	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EsEmployeeEntity> getEmployeeById(@PathVariable(value = "id") @Min(1) Long eId)
			throws ResourceNotFoundException {
		EsEmployeeEntity emp = empService.getEmployeeById(eId);
		return ResponseEntity.ok().body(emp);
	}

	
	@PostMapping("/employee")
	public EsEmployeeEntity createEmployee(@Valid @RequestBody EsEmployeeEntity emp) {
		return empService.createEmployee(emp);
	}

	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EsEmployeeEntity> updateEmployee(@PathVariable(value = "id") Long eId,
			@Valid @RequestBody EsEmployeeEntity emp) throws ResourceNotFoundException {		
		final EsEmployeeEntity updatedEmployee = empService.updateEmployee(eId, emp);
		return ResponseEntity.ok(updatedEmployee);
	}
	
    
	@PutMapping("/employee2/{id}")
	public EsEmployeeEntity saveOrUpdate(@PathVariable Long eId, @RequestBody EsEmployeeEntity newEmp) {
		return empService.saveOrUpdate(eId, newEmp);
	}
    
    
    // update only employee Chinese name
	@PatchMapping("/employee/{id}")
	public EsEmployeeEntity patch(@RequestBody Map<String, String> updatedEmpMap, @PathVariable Long id) {
		return empService.patch(updatedEmpMap, id);
	}
    
    
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long eId) throws ResourceNotFoundException {
		return empService.deleteEmployee(eId);
	}
	
}
