package design.strategy.ii;

import design.strategy.i.IStrategy;
import design.strategy.i.IStrategyEnum;

public interface IFlyStrategy<R, P, E extends IStrategyEnum> extends IStrategy<E> {

   R fly(P p);
}
