package es.example.sb.ng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.exception.ResourceUnSupportedFieldPatchException;
import es.example.sb.ng.model.EsEmployeeEntity;
import es.example.sb.ng.repository.EsEmployeeRepository;
import es.example.sb.ng.service.EsEmployeeService;

@Service
public class EsEmployeeServiceImpl implements EsEmployeeService {

	@Autowired
	private EsEmployeeRepository empRepo;

	@Override
	public List<EsEmployeeEntity> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public EsEmployeeEntity getEmployeeById(Long eId) throws ResourceNotFoundException {
		return empRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:: " + eId));
	}

	@Override
	public EsEmployeeEntity createEmployee(EsEmployeeEntity emp) {
		return empRepo.save(emp);
	}

	public EsEmployeeEntity updateEmployee(Long eId, EsEmployeeEntity emp) throws ResourceNotFoundException {
		EsEmployeeEntity emp1 = empRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:: " + eId));
		emp1.setEmpEmailId(emp.getEmpEmailId());
		emp1.setEmpLastName(emp.getEmpLastName());
		emp1.setEmpFirstName(emp.getEmpFirstName());
		return empRepo.save(emp1);
	}

	public EsEmployeeEntity saveOrUpdate(Long eId, EsEmployeeEntity newEmp) {
		return empRepo.findById(eId).map(emp -> {
			emp.setEmpFirstName(newEmp.getEmpFirstName());
			emp.setEmpChineseName(newEmp.getEmpChineseName());
			emp.setEmpWalletBalance(newEmp.getEmpWalletBalance());
			return empRepo.save(emp);
		}).orElseGet(() -> {
			newEmp.setEmpId(eId);
			return empRepo.save(newEmp);
		});
	}

	public EsEmployeeEntity patch(Map<String, String> updatedEmpMap, Long id) {
		return empRepo.findById(id).map(emp -> {
			String updatedChName = updatedEmpMap.get("empChineseName");
			if (!StringUtils.isEmpty(updatedChName)) {
				emp.setEmpChineseName(updatedChName);
				return empRepo.save(emp);
			} else {
				throw new ResourceUnSupportedFieldPatchException(updatedEmpMap.keySet());
			}
		}).orElseGet(() -> {
			throw new ResourceNotFoundException(id);
		});
	}

	public Map<String, Boolean> deleteEmployee(Long eId) throws ResourceNotFoundException {
		empRepo.deleteById(eId);
		// OR
		EsEmployeeEntity emp = empRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for id:: " + eId));
		empRepo.delete(emp);

		Map<String, Boolean> responseMap = new HashMap<>();
		responseMap.put("deleted", Boolean.TRUE);
		return responseMap;
	}

}
