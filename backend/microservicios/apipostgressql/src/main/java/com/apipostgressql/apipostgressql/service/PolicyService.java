package com.apipostgressql.apipostgressql.service;

import com.apipostgressql.apipostgressql.entity.CreatePolicyEntity;
import com.apipostgressql.apipostgressql.entity.Policy;
import com.apipostgressql.apipostgressql.pojo.DataPolizy;
import com.apipostgressql.apipostgressql.pojo.DeletePolicy;
import com.apipostgressql.apipostgressql.pojo.PoliciesPojo;
import com.apipostgressql.apipostgressql.pojo.UpdatePolicy;
import com.apipostgressql.apipostgressql.repository.PolicyRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class PolicyService {

    private Log LOGGER = LogFactory.getLog(PolicyService.class);
    @Autowired
    private PolicyRepository policyRepository;

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    public List<PoliciesPojo> getPolicies(int tipoQ, int idPolicy){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("policies");
        spq.setParameter("inTipoQuery",tipoQ);
        spq.setParameter("inId_policy",idPolicy);
        spq.execute();
        return spq.getResultList();
    }

    @Transactional
    public List<DataPolizy> createPolicy(CreatePolicyEntity createPolicyEntity){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery(("CreatePolicy"));
        spq.setParameter("inSKU",createPolicyEntity.getSku());
        spq.setParameter("inAmount",createPolicyEntity.getAmout());
        spq.setParameter("inId_employee",createPolicyEntity.getIdEmploye());
        spq.execute();
        return spq.getResultList();
    }

    public List<UpdatePolicy> updatePolicy(com.apipostgressql.apipostgressql.entity.UpdatePolicy updatePolicy, int idPolicy) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("UpdatePolicyData");
        spq.setParameter("inIdPolicy",idPolicy);
        spq.setParameter("inAmount",updatePolicy.getAmount());
        spq.execute();
        return spq.getResultList();
    }

    public List<DeletePolicy> deletePolicy(int id) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("DeletePolicyData");
        spq.setParameter("inIdPolicy",id);
        spq.execute();
        return spq.getResultList();
    }
}
