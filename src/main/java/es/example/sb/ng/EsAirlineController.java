package es.example.sb.ng;

import java.util.List;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/airline")
public class EsAirlineController {
	
	@Autowired
	EsAirlineService airService;
	
	@GetMapping("/flights")
	public List<EsAirlineEntity> findSpecificFligh() {
		return airService.findSpecificFlight();
	}
	
}
