package es.example.sb.ng;

import java.util.List;
import javax.persistence.criteria.*;

import org.springframework.stereotype.*;
import org.springframework.data.jpa.domain.*;

import org.springframework.beans.factory.annotation.*;

@Service
public class EsAirlineServiceImpl implements EsAirlineService {
	
	@Autowired
	EsAirlineRepository repo;
	
	@Override
	public List<EsAirlineEntity> findSpecificFlight() {
		//return repo.findAll();
		Specification<EsAirlineEntity> spec = findFlightSpec();
		List<EsAirlineEntity> list = repo.findAll(spec);
		return list;
	}
	
	Specification<EsAirlineEntity> findFlightSpec() {
		return (root, cq, cb) -> {
			Predicate pre = root.get("airName").in("air1");
			return pre;
		};
	}
	
}
