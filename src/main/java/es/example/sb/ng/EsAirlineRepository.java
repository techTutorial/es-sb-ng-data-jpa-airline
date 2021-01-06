package es.example.sb.ng;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EsAirlineRepository extends JpaRepository<EsAirlineEntity, Long>, JpaSpecificationExecutor<EsAirlineEntity> {	
}