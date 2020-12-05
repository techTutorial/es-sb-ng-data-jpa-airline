package es.example.sb.ng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsEmployeeServiceImpl implements EsEmployeeService {

	@Autowired
	private EsEmployeeRepository empRepo;

	@Override
	public List<EsEmployeeEntity> getAllEmployees() {
		return empRepo.findAll();
	}

}
