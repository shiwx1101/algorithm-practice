package org.algorithm.design.strategy;

/**
 * @author shiwenxiang
 * @version : Role.java, v0.1 2020/9/16 shiwenxiang Exp $$
 */
public enum Role {

    ADMIN("管理员", 1),
    WORKER("员工", 2);

    private String name;

    private Integer code;

    Role(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}
