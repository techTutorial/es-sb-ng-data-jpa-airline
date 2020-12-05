package es.example.sb.ng;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsEmployeeRepository extends JpaRepository<EsEmployeeEntity, Long> {

}
