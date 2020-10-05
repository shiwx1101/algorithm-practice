package design.i;


public interface IStrategy<E extends IStrategyEnum> {
    E getStrategy();
}
