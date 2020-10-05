package design.strategy.iii;

import design.strategy.ii.CommonStrategyFactory;
import design.strategy.ii.IFlyStrategy;
import org.springframework.stereotype.Component;

@Component
public class FlyFactory extends CommonStrategyFactory<IFlyStrategy<String,Integer,FlyEnum>, FlyEnum> {

    public IFlyStrategy<String, Integer,FlyEnum> get(FlyEnum e) {
        return map.get(e);
    }

}
