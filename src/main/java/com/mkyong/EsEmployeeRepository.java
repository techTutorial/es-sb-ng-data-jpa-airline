package com.mkyong;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EsEmployeeRepository extends JpaRepository<EsEmployeeEntity, Long> {
}
