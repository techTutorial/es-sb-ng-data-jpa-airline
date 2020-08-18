package es.example.sb.ng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.example.sb.ng.model.EsUserEntity;

@Repository
public interface EsUserRepository extends JpaRepository<EsUserEntity, Long> {

}
