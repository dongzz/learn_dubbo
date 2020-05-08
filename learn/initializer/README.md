# 系统初始化器
-   类名
```
ApplicationContextInitializer
```
-   介绍
```
Spring容器刷新之前执行的一个回调函数
```
-   作用
```
向SpringBoot容器中注册属性
```
-   使用
```
继承接口自定义实现
```

## 实现
### 方法一
-   实现ApplicationContextInitializer接口
    -   @Order 排序
```java
@Order(1)
public class FirstInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 获取环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        MapPropertySource mapPropertySource = new MapPropertySource("firstInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("run firstInitializer");
    }
}

```
-   实现ApplicationContextAware接口，并重写setApplicationContext方法
    -   ApplicationContextAware
```java
@Service
public class DemoService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String test() {
        return applicationContext.getEnvironment().getProperty("key1");
    }
}
```
-   创建 META-INF/spring.factories 文件
```properties
org.springframework.context.ApplicationContextInitializer=com.dongz.springboot.learn.initializer.FirstInitializer
```

### 方法二
-   实现ApplicationContextInitializer接口
    同上
-   实现ApplicationContextAware接口，并重写setApplicationContext方法
    同上
-   application
```java
public class LearnApplication {
    public static void main(String[] args) {
    //        SpringApplication.run(LearnApplication.class, args);
        SpringApplication springApplication = new SpringApplication(LearnApplication.class);
        springApplication.addInitializers(new SecondInitializer());
        springApplication.run(args);
    }     
}
```