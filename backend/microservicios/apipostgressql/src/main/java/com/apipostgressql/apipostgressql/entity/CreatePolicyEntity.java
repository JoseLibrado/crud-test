package com.apipostgressql.apipostgressql.entity;

import com.apipostgressql.apipostgressql.pojo.DataPolizy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity

@SqlResultSetMapping(
        name = "DataPolizy",
        classes = {
                @ConstructorResult(
                        targetClass = DataPolizy.class,
                        columns = {
                                @ColumnResult(name = "id_policy_data", type = Long.class),
                                @ColumnResult(name = "amount_data", type = Integer.class),
                                @ColumnResult(name = "employee_first_name_data", type = String.class),
                                @ColumnResult(name = "employee_last_name_data", type = String.class),
                                @ColumnResult(name = "sku_data", type = String.class),
                                @ColumnResult(name = "item_name_data", type = String.class),
                                @ColumnResult(name = "status_policy_data", type = String.class),
                                @ColumnResult(name = "policy_date_data", type = LocalDate.class)
                        }
                )
        }
)

@NamedStoredProcedureQuery(
        name = "CreatePolicy",
        procedureName = "fn_lost_inventory_register_policy",
        parameters = {
                @StoredProcedureParameter( mode = ParameterMode.IN, name = "inSKU", type = String.class ),
                @StoredProcedureParameter( mode =  ParameterMode.IN, name = "inAmount", type = Integer.class ),
                @StoredProcedureParameter( mode =  ParameterMode.IN, name = "inId_employee", type = Integer.class )
        }
        ,
        resultSetMappings = {"DataPolizy"}
)

@Getter
@Setter
@NoArgsConstructor
public class CreatePolicyEntity {
    @Id
    private long id;
    private String sku;
    private int amout;
    private int idEmploye;

    public CreatePolicyEntity(String sku, int amout, int idEmploye) {
        this.sku = sku;
        this.amout = amout;
        this.idEmploye = idEmploye;
    }

    @Override
    public String toString() {
        return "CreatePolicyEntity{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", amout=" + amout +
                ", idEmploye=" + idEmploye +
                '}';
    }
}

