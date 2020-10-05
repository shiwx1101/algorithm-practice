package design.ii;

import design.i.IStrategy;
import design.i.IStrategyEnum;

public interface IFlyStrategy<R, P, E extends IStrategyEnum> extends IStrategy<E> {

   R fly(P p);
}
