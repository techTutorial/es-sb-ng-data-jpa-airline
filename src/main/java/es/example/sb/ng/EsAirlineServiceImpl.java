package es.example.sb.ng;

import java.util.List;

import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.domain.*;
import org.springframework.stereotype.*;

@Service
public class EsAirlineServiceImpl implements EsAirlineService {
	
	@Autowired
	EsAirlineRepository airRepo;
	
	@Override
	public List<EsAirlineEntity> findFlights1() {
		return airRepo.findAll();
	}
	

	/*public List<EsAirlineEntity> findFlights5() {
		String colVal="Prod-01";
		Specification<EsAirlineEntity> searchSpec = inExactMatch(colVal);
	    List<EsAirlineEntity> resultList = airRepo.findAll(searchSpec);
	    return resultList;
	}
	public Specification<EsAirlineEntity> inExactMatch(String colVal) {
		return (root, cq, cb) -> {
			Predicate pr = root.get("productName").in(colVal);
			return pr;
		};
	}*/
	
}
