package spring.ioc.overview.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import spring.ioc.overview.domain.User;

public class BeanFactoryAwareSample implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;

        LifeCycleUser lifeCycleUser = this.beanFactory.getBean("lifeCycleUser", LifeCycleUser.class);
        System.out.println("get bean from beanFactory: " + lifeCycleUser);
    }
}
