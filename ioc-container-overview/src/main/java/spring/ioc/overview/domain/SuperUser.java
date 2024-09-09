package spring.ioc.overview.domain;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import spring.ioc.overview.annotation.Super;

@Super
@ToString
@Slf4j
public class SuperUser extends User {
    private String address;

    public void setAddress(String address) {
        log.info("第2步: SuperUser.setAddress()方法被执行, address = {}", address);
        this.address = address;
    }

}
