package spring.ioc.overview.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.domain.User;

@Slf4j
public class BeanLifeCycleDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        User user = applicationContext.getBean("user", User.class);
        log.info("第8步: [{}] 使用Bean = {}", user.getMyBeanName(), user);

        // 需要手动关闭Spring容器
        applicationContext.close();
    }

}
