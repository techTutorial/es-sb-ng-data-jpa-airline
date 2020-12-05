package es.example.sb.ng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class EsEmployeeController {
	
	@Autowired
	private EsEmployeeService empService;

	
	@GetMapping("/employees")
	public List<EsEmployeeEntity> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
}
