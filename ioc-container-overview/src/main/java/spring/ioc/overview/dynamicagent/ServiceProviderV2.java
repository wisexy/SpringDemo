package spring.ioc.overview.dynamicagent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceProviderV2 implements MyService {

    @Override
    public void doJob1() {
        log.info("Service provider V2 do job1");
    }

    @Override
    public void doJob2() {
        log.info("Service provider V2 do job2");
    }

}
