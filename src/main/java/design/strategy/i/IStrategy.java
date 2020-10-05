package design.strategy.i;


public interface IStrategy<E extends IStrategyEnum> {
    E getStrategy();
}
