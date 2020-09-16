package org.algorithm.design.strategy.i;


public interface IStrategy<E extends IStrategyEnum> {
    E getStrategy();
}
