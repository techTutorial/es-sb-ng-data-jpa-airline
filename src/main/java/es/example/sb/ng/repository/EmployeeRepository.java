package es.example.sb.ng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.example.sb.ng.model.EsEmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EsEmployeeEntity, Long>{

}
