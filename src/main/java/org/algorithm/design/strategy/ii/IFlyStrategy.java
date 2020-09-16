package org.algorithm.design.strategy.ii;

import org.algorithm.design.strategy.i.IStrategy;
import org.algorithm.design.strategy.i.IStrategyEnum;

public interface IFlyStrategy<R, P, E extends IStrategyEnum> extends IStrategy<E> {

   R fly(P p);
}
