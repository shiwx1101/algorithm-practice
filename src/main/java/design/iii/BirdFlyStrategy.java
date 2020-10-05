package design.iii;

import design.ii.IFlyStrategy;
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