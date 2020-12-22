package java8.optional;

import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {

        User user = new User(1, "swx", 28);
        //输出用户的id
        Optional.ofNullable(user).map(User::getId).ifPresent(System.out::println);

        //当用户没有年龄时，使用默认值20岁
        Optional.ofNullable(user).map(User::getAge).orElse(20);
        //当用户的姓名为空时，抛出异常
        Optional.ofNullable(user).map(User::getName).orElseThrow(RuntimeException::new);
        //当用户的年龄大于18岁时，输出一个其大写形式的姓名，当姓名不存在时，输出Unknown
        Optional.ofNullable(user).filter(it -> it.getAge() > 18).map(User::getName).map(String::toUpperCase).orElse("Unknow");
    }

}

class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
