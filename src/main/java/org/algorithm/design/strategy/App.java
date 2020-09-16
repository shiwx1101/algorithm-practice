package org.algorithm.design.strategy;

import org.algorithm.design.strategy.ii.CommonStrategyFactory;
import org.algorithm.design.strategy.ii.IFlyEnum;
import org.algorithm.design.strategy.ii.IFlyStrategy;
import org.algorithm.design.strategy.iii.FlyEnum;
import org.algorithm.design.strategy.iii.FlyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    final FlyFactory flyFactory;

    public App(FlyFactory flyFactory) {
        this.flyFactory = flyFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        IFlyStrategy<String, Integer, FlyEnum> fa = flyFactory.get(FlyEnum.PLANE);
//        String fly = fa.fly(1);
//        System.out.println(fly);
        System.out.println("-------");
    }
}
