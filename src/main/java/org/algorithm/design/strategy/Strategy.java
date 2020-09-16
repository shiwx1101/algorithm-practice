/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package org.algorithm.design.strategy;

/**
 * @author shiwenxiang
 * @version : Strategy.java, v0.1 2020/9/16 shiwenxiang Exp $$
 */
public interface Strategy<R, P> {

    R execute(P p);

    Role getRole();

}