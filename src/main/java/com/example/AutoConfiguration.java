package com.example;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo 在这里使用自动配置类，会导致
 * @author kunple
 */
@Configuration(proxyBeanMethods = false)
public class AutoConfiguration {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private UserService userService;

    @Bean
    @SofaService(bindings = @SofaServiceBinding(bindingType = "bolt"))
    public HelloService helloService() {
        return new HelloService() {
            @Override
            public String hello(String msg) {
                return "hello" + userService.getUser("admin") + msg;
            }
        };
    }
}
