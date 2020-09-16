package org.algorithm.design.strategy.ii;


import org.algorithm.design.strategy.i.IStrategy;
import org.algorithm.design.strategy.i.IStrategyEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public abstract class CommonStrategyFactory<S extends IStrategy<E>, E extends IStrategyEnum> implements ApplicationContextAware {

    protected Map<E, S> map = new HashMap<E, S>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Class<?> clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Map<String, ?> beansOfType = applicationContext.getBeansOfType(clazz);
        beansOfType.forEach((k, v) -> {
            S s = (S) v;
            E strategy = s.getStrategy();
            map.put(strategy, s);
        });
    }


}
