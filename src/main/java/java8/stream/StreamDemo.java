package java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    private List<Item> items;


    public List<Item> init() {
        return Arrays.asList(
                new Item("apple", 10, new BigDecimal("19.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
    }

    public StreamDemo() {
        this.items = init();
    }

    public static void main(String[] args) {

        StreamDemo streamDemo = new StreamDemo();
        List<Item> items = streamDemo.items;
        // 按照 名字分组
        Map<String, List<Item>> map = items.stream().collect(Collectors.groupingBy(Item::getName));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
            System.out.println("-----------");
        });

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");

        //名字 单价关系 会重复 但是可以用新值覆盖
        Map<String, BigDecimal> map2 = items.stream().collect(Collectors.toMap(Item::getName, Item::getPrice, (oldValue, newValue) -> newValue));
        map2.forEach((k, v) -> {
            System.out.println(k + " " + v);
            System.out.println("-----------");
        });

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");

        //求某个值的映射
        Map<String, List<BigDecimal>> map3 = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.mapping(Item::getPrice, Collectors.toList())));
        map3.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
            System.out.println("-----------");
        });

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");

        //分组统计
        Map<String, Integer> map4 = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        map4.forEach((k, v) -> {
            System.out.println(k + " " + v);
            System.out.println("-----------");
        });

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");

        //分组统计
        Map<Boolean, Integer> map5 = items.stream().collect(Collectors.partitioningBy(item -> item.name.length() > 5, Collectors.summingInt(Item::getQty)));
        map5.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
            System.out.println("-----------");
        });

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");

        //通过多个条件分组
        Map<List<String>, Integer> map6 = items.stream().collect(
                Collectors.groupingBy(item -> Arrays.asList(item.getName(), item.getPrice().toString()), Collectors.summingInt(Item::getQty)));
        System.out.println(map6);




    }


    class Item {
        private String name;
        private int qty;
        private BigDecimal price;

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", qty=" + qty +
                    ", price=" + price +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        //constructors, getter/setters
    }

}
