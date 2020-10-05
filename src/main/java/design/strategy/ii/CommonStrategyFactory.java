package design.strategy.ii;


import design.strategy.i.IStrategy;
import design.strategy.i.IStrategyEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public abstract class CommonStrategyFactory<S extends IStrategy<E>, E extends IStrategyEnum> implements ApplicationContextAware {

    protected final Map<E, S> map = new HashMap<E, S>();

    public abstract S get(E e);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        ParameterizedType actualTypeArgument = (ParameterizedType)genericSuperclass.getActualTypeArguments()[0];
        Class<?> clazz = (Class<?>)actualTypeArgument.getRawType();
        Map<String, ?> beansOfType = applicationContext.getBeansOfType(clazz);
        beansOfType.forEach((k, v) -> {
            S s = (S) v;
            E strategy = s.getStrategy();
            map.put(strategy, s);
        });
    }


}
