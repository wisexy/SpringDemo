package spring.ioc.overview.domain;

public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        System.out.println("User setId()方法被调用，id=" + id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("User setName()方法被调用，name=" + name);
        this.name = name;
    }

    public User() {
        System.out.println("User 无参构造函数被调用");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
