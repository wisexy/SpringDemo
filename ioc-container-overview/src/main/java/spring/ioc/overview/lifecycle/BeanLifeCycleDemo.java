package spring.ioc.overview.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.domain.User;

public class BeanLifeCycleDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        LifeCycleUser lifeCycleUser = applicationContext.getBean("lifeCycleUser", LifeCycleUser.class);
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第四步：使用Bean" + lifeCycleUser);
        System.out.println("第四步：使用Bean" + user);

        // 需要手动关闭Spring容器
        applicationContext.close();
    }

}
