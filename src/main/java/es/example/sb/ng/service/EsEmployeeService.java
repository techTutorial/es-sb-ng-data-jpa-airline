package es.example.sb.ng.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import es.example.sb.ng.model.EsEmployeeEntity;

public interface EsEmployeeService {

	List<EsEmployeeEntity> getAllEmployees();

	EsEmployeeEntity getEmployeeById(Long eId);

	EsEmployeeEntity createEmployee(EsEmployeeEntity emp);

	EsEmployeeEntity updateEmployee(Long eId, @Valid EsEmployeeEntity emp);

	EsEmployeeEntity saveOrUpdate(Long eId, EsEmployeeEntity newEmp);

	EsEmployeeEntity patch(Map<String, String> updatedEmpMap, Long id);

	Map<String, Boolean> deleteEmployee(Long eId);

}
