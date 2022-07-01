package com.example.app1;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.example.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author kunple
 */
@Component
@SofaService(bindings = @SofaServiceBinding(bindingType = "bolt"))
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        return "hello " + msg;
    }
}
