package com.example.app1;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.example.UserService;
import org.springframework.stereotype.Component;

/**
 * @author kunple
 */
@Component
@SofaService(bindings = @SofaServiceBinding(bindingType = "bolt"))
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String id) {
        return "uid: " + id;
    }
}
