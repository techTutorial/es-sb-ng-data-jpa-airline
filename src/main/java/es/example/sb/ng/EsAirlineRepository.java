package es.example.sb.ng;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EsAirlineRepository extends JpaRepository<EsAirlineEntity, Long> {
//public interface EsAirlineRepository extends JpaRepository<EsAirlineEntity, Integer>, JpaSpecificationExecutor<EsAirlineEntity> {

}
