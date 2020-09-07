package es.example.sb.ng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.example.sb.ng.model.EsEmpConEntity;

@Repository
public interface EsEmpConRepository extends JpaRepository<EsEmpConEntity, Long> {

}
