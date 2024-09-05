package spring.ioc.overview.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareSample implements BeanNameAware {

    @Override
    public void setBeanName(String beanName) {
        System.out.println("beanName = " + beanName);
    }

}
