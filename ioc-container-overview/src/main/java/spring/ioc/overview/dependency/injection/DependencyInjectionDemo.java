package spring.ioc.overview.dependency.injection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import spring.ioc.overview.repository.UserRepository;

/**
 * Spring依赖注入：
 *  1. 通过名称注入
 *  2. 通过类型注入
 *      2.1. 单个Bean对象
 *      2.2. 集合Bean对象
 *  3. 注入容器内建Bean对象
 *  4. 注入非Bean对象
 *
 */
@Slf4j
public class DependencyInjectionDemo {

    public static void main(String args[]) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        UserRepository repository = (UserRepository) beanFactory.getBean("userRepository");

        // 来源一：自定义的bean
        log.info("注入自定义的Bean：{}", repository.getUsers());

        // 来源二：内建的Bean
        Environment environment = beanFactory.getBean(Environment.class);
        log.info("注入内建的Bean：{}", environment.toString());

        // 来源三：内建的依赖
        log.info("注入内建的依赖：{}", repository.getBeanFactory());
        repository.getBeanFactory();
    }

}
