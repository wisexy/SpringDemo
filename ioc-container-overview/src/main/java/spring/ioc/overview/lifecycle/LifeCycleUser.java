package spring.ioc.overview.lifecycle;

import lombok.ToString;

@ToString
public class LifeCycleUser {

    private String name;

    private int id;

    public LifeCycleUser() {
        System.out.println("LifeCycleUser无参构造函数被调用");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("LifeCycleUser setter: name = " + name);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("LifeCycleUser setter: age = " + id);
        this.id = id;
    }
}
