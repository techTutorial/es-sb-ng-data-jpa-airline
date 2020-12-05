package es.example.sb.ng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class EsAirlineController {
	
	@Autowired
	EsAirlineService airService;

	// http://localhost:9191/easystep/airline/flights
	@GetMapping("/flights")
	public List<EsAirlineEntity> findFlights1() {
		return airService.findFlights1();
	}

}
