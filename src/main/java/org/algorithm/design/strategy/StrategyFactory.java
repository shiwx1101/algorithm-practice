/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package org.algorithm.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiwenxiang
 * @version : StrategyFactory.java, v0.1 2020/9/16 shiwenxiang Exp $$
 */
public class StrategyFactory<R, P> {

    private final Map<Role, Strategy<R,P>> map = new HashMap<>();

     {
        map.put(Role.ADMIN, new AdminStrategy<>());
        map.put(Role.WORKER, new WorkerStrategy());
    }

    public Strategy getStrategy(Role r) {
        return map.get(r);
    }

    public static void main(String[] args) {
        new StrategyFactory<String, Integer>().getStrategy(Role.ADMIN).execute()
        System.out.println(execute);
    }

}
