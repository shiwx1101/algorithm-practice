package design.strategy.iii;

import design.strategy.ii.IFlyStrategy;
import org.springframework.stereotype.Component;

@Component
public class PlaneStrategy implements IFlyStrategy<String, Integer, FlyEnum> {
    @Override
    public String fly(Integer integer) {
        return "plane fly";
    }

    @Override
    public FlyEnum getStrategy() {
        return FlyEnum.PLANE;
    }
}
