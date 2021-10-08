package spring.bean.definition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import spring.ioc.overview.domain.User;

/**
 * Spring BeanDefinition构建示例
 *
 */
@Slf4j
@Configuration
public class BeanAliasDemo {

    public static void main(String args[]) {
        // 1. 通过BeanDefinitionBuilder构建
        // 1.1. 创建Bean类的BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        // 1.2. 通过BeanDefinitionBuilder给Bean置值（类似于前面Xml方式）
        beanDefinitionBuilder.addPropertyValue("id", 1L);
        beanDefinitionBuilder.addPropertyValue("name", "通过BeanDefinitionBuilder创建的Bean");

        // 1.3. 获取BeanDefinition
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 1.4. 至此，还不是Bean的最终状态，还可以修改
        //beanDefinition.setLazyInit(true); // 还可以修改Bean的定义（举例）

        // 2. 通过AbstractBeanDefinition以及派生类
        // 2.1. 实例化一个AbstractBeanDefinition的实现类AbstractBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        // 2.2. 设置Bean类
        genericBeanDefinition.setBeanClass(User.class);

        // 2.3. 通过MutablePropertyValues设置Bean属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id", 2L);
        mutablePropertyValues.addPropertyValue("name", "通过AbstractBeanDefinition派生类创建的Bean");

        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

        // 创建BeanFactory容器，进行测试
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("user1", beanDefinition);

        User user = beanFactory.getBean(User.class);

        log.info("通过BeanDefinitionBuilder构建的Bean = {}", user.toString());
    }

}
