package com.apipostgressql.apipostgressql.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "DeletePolicy",
        classes = {
                @ConstructorResult(
                        targetClass = com.apipostgressql.apipostgressql.pojo.DeletePolicy.class,
                        columns = {
                                @ColumnResult(name = "policy_deleted", type = Integer.class)
                        })
        }
)

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name= "DeletePolicyData",
                procedureName= "fn_lost_inventory_delete_policy",
                parameters = {
                        @StoredProcedureParameter( mode = ParameterMode.IN, name = "inIdPolicy", type = Integer.class )
                },
                resultSetMappings = {"DeletePolicy"}
        )
})
@Getter
@Setter
@NoArgsConstructor
public class DeletePolicy {
    @Id
    private int idPoliza;

    public DeletePolicy(int idPoliza) {
        this.idPoliza = idPoliza;
    }

    @Override
    public String toString() {
        return "DeletePolicy{" +
                "idPoliza=" + idPoliza +
                '}';
    }
}
