package com.apipostgressql.apipostgressql.repository;

import com.apipostgressql.apipostgressql.entity.WebserviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebserviceRepository extends JpaRepository<WebserviceEntity, Integer> {

    Optional<WebserviceEntity> findByName(String name);
}
