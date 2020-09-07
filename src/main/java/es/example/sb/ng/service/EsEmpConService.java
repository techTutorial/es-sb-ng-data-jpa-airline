package es.example.sb.ng.service;

import java.util.List;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsEmpConEntity;

public interface EsEmpConService {

	List<EsEmpConEntity> getAllConEmps();

	EsEmpConEntity getConEmpById(Long eId) throws ResourceNotFoundException;

	EsEmpConEntity createConEmp(EsEmpConEntity emp);

}
