package spring.ioc.overview;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.annotation.Super;
import spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * Spring依赖查找的三种方式：
 *  1.通过名称查找
 *  2.通过类型查找
 *  3.通过注解查找
 *
 */
@Slf4j
public class DependencyLookupDemo {

    public static void main(String args[]) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        // 1. 通过名称
        // 1.1. 实时查找
        lookupInRealTime(beanFactory);
        // 1.2. 延迟查找
        lookupInLazy(beanFactory);

        // 2. 通过类型
        // 2.1. 通过类型查找单个实例
        lookupByType(beanFactory);
        // 2.2. 通过类型查找集合实例
        lookupCollectionByType(beanFactory);
        // 2.3. 通过类型和名称混合查找（略）

        // 3. 根据注解查找
        lookupByAnnotationType(beanFactory);
    }

    /**
     * 1.1. 实时查找
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        log.info("通过名称实时查找：{} {}", user.hashCode(), user.toString());
    }

    /**
     * 1.2. 延迟查找
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        log.info("通过名称延迟查找：{} {}", user.hashCode(), user.toString());
    }

    /**
     * 2.1. 通过类型查找单个实例
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);

        log.info("通过类型查找单个实例：{} {}", user.hashCode(), user.toString());
    }

    /**
     * 2.2. 通过类型查找集合实例
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            log.info("通过类型查找集合实例：{}", users.toString());
        }
    }

    /**
     * 3. 根据注解查找
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            log.info("通过注解查找集合实例：{}", users.toString());
        }
    }

}
