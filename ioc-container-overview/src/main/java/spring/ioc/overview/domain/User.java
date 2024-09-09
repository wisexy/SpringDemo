package spring.ioc.overview.domain;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

@Slf4j
@ToString
public class User implements BeanNameAware,
        BeanClassLoaderAware,
        BeanFactoryAware,
        InitializingBean,
        DisposableBean {

    private Long id;

    private String name;

    @Getter
    private String myBeanName;

    public User() {
        log.info("第1步: 实例化bean: User无参构造函数Constructor()被调用");
    }

    /**
     * Setters
     */
    public void setMyBeanName(String myBeanName) {
        log.info("第2步: User.setMyBeanName()方法被调用, setMyBeanName = [{}]", this.myBeanName);
        this.myBeanName = myBeanName;
    }

    public void setId(Long id) {
        log.info("第2步: User.setId()方法被调用, id = [{}]", id);
        this.id = id;
    }

    public void setName(String name) {
        log.info("第2步: User.setName()方法被调用, name = [{}]", name);
        this.name = name;
    }

    /**
     * Aware functions
     */
    @Override
    public void setBeanName(String beanName) {
        this.myBeanName = beanName;
        log.info("第3.1步: [{}] BeanNameAware接口方法, setBeanName = [{}]", beanName, beanName);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("第3.2步: [{}] BeanClassLoaderAware接口方法, classLoader名称 = [{}]", this.myBeanName, classLoader.getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("第3.3步: [{}] BeanFactoryAware接口方法, beanFactory = [{}]", this.myBeanName, beanFactory.toString());
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("第4步: [{}] BeanPostProcessorSample.postProcessBeforeInitialization()被执行", this.myBeanName);
//        return bean;
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("第5步: [{}] afterPropertiesSet()被执行", this.myBeanName);
    }

    public void init() {
        log.info("第6步: [{}] init()被执行", this.myBeanName);
    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        log.info("第7步: [{}] BeanPostProcessorSample.postProcessAfterInitialization()被执行", this.myBeanName);
//        return bean;
//    }

    @Override
    public void destroy() throws Exception {
        log.info("第9步: [{}] destroy()被执行", this.myBeanName);
    }

}
