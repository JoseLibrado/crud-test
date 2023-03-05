package com.apipostgressql.apipostgressql.entity;


import com.apipostgressql.apipostgressql.pojo.PoliciesPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity

@SqlResultSetMapping(
        name = "PoliciesPojo",
        classes = {
                @ConstructorResult(
                        targetClass = PoliciesPojo.class,
                        columns = {
                                @ColumnResult(name = "id_policy_data", type = Long.class),
                                @ColumnResult(name = "amount_data", type = Integer.class),
                                @ColumnResult(name = "employee_first_name_data", type = String.class),
                                @ColumnResult(name = "employee_last_name_data", type = String.class),
                                @ColumnResult(name = "sku_data", type = String.class),
                                @ColumnResult(name = "item_name_data", type = String.class),
                                @ColumnResult(name = "status_policy_data", type = String.class),
                                @ColumnResult(name = "policy_date_data", type = LocalDate.class)
                        })
        }
)

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name= "policies",
                procedureName= "fn_lost_inventory_retrieve_data",
                parameters = {
                        @StoredProcedureParameter( mode = ParameterMode.IN, name = "inTipoQuery", type = Integer.class ),
                        @StoredProcedureParameter( mode = ParameterMode.IN, name = "inId_policy", type = Integer.class )
                },
                resultSetMappings = {"PoliciesPojo"}
        )
})
@Getter
@Setter
@NoArgsConstructor
public class Policy {
    @Id
    private Long id_policy_data;
    private String sku_data;
    private int amount_data;
    private LocalDate policy_date_data;
    private String employee_data;
    private String status_policy_data;

    @Override
    public String toString() {
        return "PolicyEntity{" +
                "id_policy_data=" + id_policy_data +
                ", sku_data='" + sku_data + '\'' +
                ", amount_data=" + amount_data +
                ", policy_date_data=" + policy_date_data +
                ", employee_data='" + employee_data + '\'' +
                ", status_policy_data='" + status_policy_data + '\'' +
                '}';
    }
}
