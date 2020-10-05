package design.strategy;

import design.strategy.ii.IFlyStrategy;
import design.strategy.iii.FlyEnum;
import design.strategy.iii.FlyFactory;
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
        IFlyStrategy<String, Integer, FlyEnum> fa = flyFactory.get(FlyEnum.PLANE);
        String fly = fa.fly(1);
        System.out.println(fly);
        System.out.println("-------");
    }
}
