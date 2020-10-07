package java8.functional.lamda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lamda {
    
    public static void main(String[] args) {
        Map<Type, Handler> handlerMap = register();
        List<String> fruits = Arrays.asList("orange", "pear", "apple", "other");
        // 获取随机的水果类型
        int index = (int) (Math.random() * 4);
        String type = fruits.get(index);
        System.out.println(type);
        handlerMap.get(Type.valueOf(type.toUpperCase()));
    }

    private static Map<Type, Handler> register() {
        return new HashMap<Type, Handler>() {{
            putIfAbsent(Type.PEAR, () -> System.out.println("pear"));
            putIfAbsent(Type.ORANGE, () -> System.out.println("orange"));
            putIfAbsent(Type.APPLE, () -> System.out.println("apple"));
            putIfAbsent(Type.OTHER, () -> System.out.println("other"));
        }};
    }

}

enum Type {
    APPLE("apple"),
    ORANGE("orange"),
    PEAR("pear"),
    OTHER("other");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getVal() {
        return type;
    }
}

@FunctionalInterface
interface Handler {
    void handler();
}
