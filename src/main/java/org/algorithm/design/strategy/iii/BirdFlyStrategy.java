package org.algorithm.design.strategy.iii;

import org.algorithm.design.strategy.i.IStrategyEnum;
import org.algorithm.design.strategy.ii.IFlyEnum;
import org.algorithm.design.strategy.ii.IFlyStrategy;
import org.springframework.stereotype.Component;

@Component
public class BirdFlyStrategy implements IFlyStrategy<String, Integer,FlyEnum> {

    @Override
    public String fly(Integer integer) {
        return "bird fly";
    }

    @Override
    public FlyEnum getStrategy() {
        return FlyEnum.BIRD;
    }
}
