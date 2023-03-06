package com.apipostgressql.apipostgressql.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@SqlResultSetMapping(
        name = "UpdatePolicy",
        classes = {
                @ConstructorResult(
                        targetClass = com.apipostgressql.apipostgressql.pojo.UpdatePolicy.class,
                        columns = {
                                @ColumnResult(name = "policy", type = Integer.class)
                        })
        }
)

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name= "UpdatePolicyData",
                procedureName= "fn_lost_inventory_update_policy",
                parameters = {
                        @StoredProcedureParameter( mode = ParameterMode.IN, name = "inIdPolicy", type = Integer.class ),
                        @StoredProcedureParameter( mode = ParameterMode.IN, name = "inAmount", type = Integer.class )
                },
                resultSetMappings = {"UpdatePolicy"}
        )
})
@Getter
@Setter
@NoArgsConstructor
public class UpdatePolicy {
    @Id
    private int idPoliza;
    private int amount;

    public UpdatePolicy(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UpdatePolicy{" +
                "idPoliza=" + idPoliza +
                ", amount=" + amount +
                '}';
    }
}
