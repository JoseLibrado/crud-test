package com.apipostgressql.apipostgressql.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PoliciesPojo {
    private Long id_policy_data;
    private int amount_data;
    private String employee_first_name_data;
    private String employee_last_name_data;
    private String sku_data;
    private String item_name_data;
    private String status_policy_data;
    private LocalDate policy_date_data;

    public PoliciesPojo() {
    }

    public PoliciesPojo(Long id_policy_data, int amount_data, String employee_first_name_data, String employee_last_name_data, String sku_data, String item_name_data, String status_policy_data, LocalDate policy_date_data) {
        this.id_policy_data = id_policy_data;
        this.amount_data = amount_data;
        this.employee_first_name_data = employee_first_name_data;
        this.employee_last_name_data = employee_last_name_data;
        this.sku_data = sku_data;
        this.item_name_data = item_name_data;
        this.status_policy_data = status_policy_data;
        this.policy_date_data = policy_date_data;
    }

    @Override
    public String toString() {
        return "PoliciesPojo{" +
                "id_policy_data=" + id_policy_data +
                ", amount_data=" + amount_data +
                ", employee_first_name_data='" + employee_first_name_data + '\'' +
                ", employee_last_name_data='" + employee_last_name_data + '\'' +
                ", sku_data='" + sku_data + '\'' +
                ", item_name_data='" + item_name_data + '\'' +
                ", status_policy_data='" + status_policy_data + '\'' +
                ", policy_date_data=" + policy_date_data +
                '}';
    }
}
