package com.apipostgressql.apipostgressql.repository;

import com.apipostgressql.apipostgressql.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Procedure(name ="policies")
    List<Policy> getPolicies();

    @Procedure(name = "CreatePolicy")
    void createPolicy(String sku, int amout, int idEmployee);
}
