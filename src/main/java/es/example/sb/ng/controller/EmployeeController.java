package es.example.sb.ng.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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

import es.example.sb.ng.error.ResourceUnSupportedFieldPatchException;
import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsEmployeeEntity;
import es.example.sb.ng.repository.EsEmployeeRepository;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class EmployeeController {
	
	@Autowired
	private EsEmployeeRepository empRepo;

	
	@GetMapping("/employees")
	public List<EsEmployeeEntity> getAllEmployees() {
		return empRepo.findAll();
	}

	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EsEmployeeEntity> getEmployeeById(@PathVariable(value = "id") @Min(1) Long eId)
			throws ResourceNotFoundException {
		EsEmployeeEntity emp = empRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + eId));
		return ResponseEntity.ok().body(emp);
	}

	
	@PostMapping("/employee")
	public EsEmployeeEntity createEmployee(@Valid @RequestBody EsEmployeeEntity emp) {
		return empRepo.save(emp);
	}

	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EsEmployeeEntity> updateEmployee(@PathVariable(value = "id") Long eId,
			@Valid @RequestBody EsEmployeeEntity emp) throws ResourceNotFoundException {
		
		EsEmployeeEntity emp1 = empRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + eId));
		emp1.setEmpEmailId(emp.getEmpEmailId());
		emp1.setEmpLastName(emp.getEmpLastName());
		emp1.setEmpFirstName(emp.getEmpFirstName());
		final EsEmployeeEntity updatedEmployee = empRepo.save(emp1);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
    
    @PutMapping("/employee2/{id}")
    public EsEmployeeEntity saveOrUpdate(@PathVariable Long eId, @RequestBody EsEmployeeEntity emp) {

        return empRepo.findById(eId)
                .map(x -> {
                    x.setEmpFirstName(emp.getEmpFirstName());
                    x.setEmpChineseName(emp.getEmpChineseName());
                    x.setEmpWalletBalance(emp.getEmpWalletBalance());
                    return empRepo.save(x);
                })
                .orElseGet(() -> {
                    emp.setEmpId(eId);
                    return empRepo.save(emp);
                });
    }
    
    
    // update only employee Chinese name
    @PatchMapping("/employee/{id}")
    public EsEmployeeEntity patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return empRepo.findById(id)
                .map(x -> {

                    String chName = update.get("employeeChineseName");
                    if (!StringUtils.isEmpty(chName)) {
                        x.setEmpChineseName(chName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return empRepo.save(x);
                    } else {
                        throw new ResourceUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new ResourceNotFoundException(id);
                });

    }
    
    
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long eId)
			throws ResourceNotFoundException {
		empRepo.deleteById(eId);
		// OR
		EsEmployeeEntity emp = empRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + eId));
		empRepo.delete(emp);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
