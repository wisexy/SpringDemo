package spring.ioc.overview.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class BeanPostProcessorSample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("第4步: [{}] postProcessBeforeInitialization()被执行, bean class = [{}]", beanName, bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("第7步: [{}] postProcessAfterInitialization()被执行, bean class = [{}]", beanName, bean.getClass());
        return bean;
    }

}
