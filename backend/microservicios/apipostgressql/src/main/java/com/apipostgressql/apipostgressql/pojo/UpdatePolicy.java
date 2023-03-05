package com.apipostgressql.apipostgressql.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePolicy {
    private int idPolicy;

    public UpdatePolicy() {
    }

    public UpdatePolicy(int idPolicy) {
        this.idPolicy = idPolicy;
    }

    @Override
    public String toString() {
        return "UpdatePolicy{" +
                "idPolicy=" + idPolicy +
                '}';
    }
}
