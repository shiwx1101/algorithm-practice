/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package org.algorithm.design.strategy;

/**
 * @author shiwenxiang
 * @version : AdminStrategy.java, v0.1 2020/9/16 shiwenxiang Exp $$
 */
public class AdminStrategy<String, Integer> implements Strategy<String, Integer>  {


    @Override
    public String execute(Integer integer) {
        return (String) ("admin"+integer).toString();
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }
}
