package org.algorithm.design.strategy.iii;

import jdk.nashorn.internal.ir.IfNode;
import org.algorithm.design.strategy.i.IStrategy;
import org.algorithm.design.strategy.i.IStrategyEnum;
import org.algorithm.design.strategy.ii.CommonStrategyFactory;
import org.algorithm.design.strategy.ii.IFlyEnum;
import org.algorithm.design.strategy.ii.IFlyStrategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FlyFactory<S,E> extends CommonStrategyFactory<IFlyStrategy<String, Integer,FlyEnum>, FlyEnum> {

    public IFlyStrategy<String, Integer,FlyEnum> get(FlyEnum e) {
        return map.get(e);
    }

}
