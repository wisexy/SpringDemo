package spring.ioc.overview.dynamicagent;

import org.springframework.stereotype.Service;
import spring.ioc.overview.annotation.dynamicagent.RoutingInjected;

@Service
public class DynamicAgentBySpringDemo {

    @RoutingInjected
    private MyService myService;

    public void doJob1() {
        this.myService.doJob1();
    }

    public void doJob2() {
        this.myService.doJob2();
    }

}
