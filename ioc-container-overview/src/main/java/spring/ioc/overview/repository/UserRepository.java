package spring.ioc.overview.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import spring.ioc.overview.domain.User;

import java.util.Collection;

public class UserRepository {

    /**
     * 自定义的Bean
     */
    private Collection<User> users;

    /**
     * 注入内部所知道的对象（内建对象），内建的非Bean
     */
    private BeanFactory beanFactory;

    /**
     * 内建依赖
     */
    private ObjectFactory<User> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                ", beanFactory=" + beanFactory +
                ", userObjectFactory=" + userObjectFactory +
                '}';
    }
}
