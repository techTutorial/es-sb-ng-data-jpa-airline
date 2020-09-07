package es.example.sb.ng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsEmpConEntity;
import es.example.sb.ng.repository.EsEmpConRepository;
import es.example.sb.ng.service.EsEmpConService;

@Service
public class EsEmpConServiceImpl implements EsEmpConService {

	@Autowired
	private EsEmpConRepository eConRepo;

	@Override
	public List<EsEmpConEntity> getAllConEmps() {
		List<EsEmpConEntity> empList = eConRepo.findAll();
		empList.stream().forEach(e -> System.out.println(e));
		return eConRepo.findAll();
	}

	@Override
	public EsEmpConEntity getConEmpById(Long eConId) throws ResourceNotFoundException {
		return eConRepo.findById(eConId)
				.orElseThrow(() -> new ResourceNotFoundException("Contract Employee not found for id:: " + eConId));
	}

	@Override
	public EsEmpConEntity createConEmp(EsEmpConEntity emp) {
		return eConRepo.save(emp);
	}

}
