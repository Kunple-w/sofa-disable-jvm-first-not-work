package com.example.app2;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.example.HelloService;
import com.example.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kunple
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private HelloService helloService;

//    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
//    private UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam String msg) {
        return ResponseEntity.ok(helloService.hello(msg));
    }
//    @GetMapping("/getUser")
//    public ResponseEntity<String> getUser(@RequestParam String id) {
//        return ResponseEntity.ok(userService.getUser(id));
//    }
}
