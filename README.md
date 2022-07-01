复现步骤:
1. 配置文件中设置disable-jvm-first=true,只保留rpc
2. 运行App2, profile=app2
2. 启动时，看输出日志，HelloService的In Binding有2个协议: bolt和jvm，但是UserService的In Binding只有1个协议: bolt

这2个注入的差异是：HelloService是常见的写法，但是disable-jvm-first失效了，而UserService是在自动配置类中注入, disable-jvm-first生效了。


```log 
2022-07-01 21:46:33.162  INFO 30094 --- [           main] com.alipay.sofa                          : SOFABoot Runtime Starting!
2022-07-01 21:46:33.258  INFO 30094 --- [           main] com.example.app2.App2                    : Starting App2 on wangyongxudeMacBook-Pro.local with PID 30094 (/Users/hugh/jvm-first-not-work/target/classes started by hugh in /Users/hugh/jvm-first-not-work)
2022-07-01 21:46:33.264  INFO 30094 --- [           main] com.example.app2.App2                    : The following profiles are active: app2
2022-07-01 21:46:36.803  INFO 30094 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8088 (http)
2022-07-01 21:46:36.826  INFO 30094 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-07-01 21:46:36.826  INFO 30094 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.46]
2022-07-01 21:46:36.951  INFO 30094 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-07-01 21:46:36.952  INFO 30094 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3392 ms
2022-07-01 21:46:37.494  INFO 30094 --- [           main] com.alipay.sofa                          : Registering component: reference:com.example.HelloService:#-553021857
2022-07-01 21:46:37.495  INFO 30094 --- [           main] com.alipay.sofa                          :  >>In Binding [bolt] Begins - com.example.HelloService.
2022-07-01 21:46:38.748  INFO 30094 --- [           main] com.alipay.sofa                          :  >>In Binding [bolt] Ends - com.example.HelloService.
2022-07-01 21:46:38.748  INFO 30094 --- [           main] com.alipay.sofa                          :  >>In Binding [jvm] Begins - com.example.HelloService.
2022-07-01 21:46:38.756  INFO 30094 --- [           main] com.alipay.sofa                          :  >>In Binding [jvm] Ends - com.example.HelloService.
2022-07-01 21:46:38.984  INFO 30094 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-07-01 21:46:39.353  INFO 30094 --- [           main] com.alipay.sofa                          : Registering component: reference:com.example.UserService:#798921798
2022-07-01 21:46:39.354  INFO 30094 --- [           main] com.alipay.sofa                          :  >>In Binding [bolt] Begins - com.example.UserService.
2022-07-01 21:46:39.372  INFO 30094 --- [           main] com.alipay.sofa                          :  >>In Binding [bolt] Ends - com.example.UserService.
2022-07-01 21:46:39.763  INFO 30094 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 4 endpoint(s) beneath base path '/actuator'
2022-07-01 21:46:39.793  INFO 30094 --- [           main] com.alipay.sofa                          : Registering component: service:com.example.HelloService
2022-07-01 21:46:39.793  INFO 30094 --- [           main] com.alipay.sofa                          :  <<PreOut Binding [bolt] Begins - com.example.HelloService.
2022-07-01 21:46:39.802  INFO 30094 --- [           main] com.alipay.sofa                          :  <<PreOut Binding [bolt] Ends - com.example.HelloService.
2022-07-01 21:46:39.803  INFO 30094 --- [           main] com.alipay.sofa                          :  <<Out Binding [bolt] Begins - com.example.HelloService.
2022-07-01 21:46:39.825  INFO 30094 --- [           main] com.alipay.sofa                          :  <<Out Binding [bolt] Ends - com.example.HelloService.
2022-07-01 21:46:39.825  INFO 30094 --- [           main] com.alipay.sofa                          : Register Service - com.example.HelloService
2022-07-01 21:46:39.916  INFO 30094 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8088 (http) with context path ''
2022-07-01 21:46:40.811  INFO 30094 --- [           main] com.example.app2.App2                    : Started App2 in 9.409 seconds (JVM running for 11.705)
2022-07-01 21:46:41.048  INFO 30094 --- [(5)-192.168.3.4] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-07-01 21:46:41.048  INFO 30094 --- [(5)-192.168.3.4] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-07-01 21:46:41.060  INFO 30094 --- [(5)-192.168.3.4] o.s.web.servlet.DispatcherServlet        : Completed initialization in 12 ms
```
