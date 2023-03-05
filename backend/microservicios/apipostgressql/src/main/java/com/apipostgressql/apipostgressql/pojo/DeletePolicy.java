package com.apipostgressql.apipostgressql.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeletePolicy {
    private int idPolicy;

    public DeletePolicy() {
    }

    public DeletePolicy(int idPolicy) {
        this.idPolicy = idPolicy;
    }

    @Override
    public String toString() {
        return "UpdatePolicy{" +
                "idPolicy=" + idPolicy +
                '}';
    }
}
