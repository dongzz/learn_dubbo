### 启动器（dongz-spring-boot-starter）
- 启动器模块是一个空jar文件，仅提供辅助性依赖管理，这个依赖可能用户自动装配或者其他类库

-   命名规约：
    推荐使用以下命名规约;
    -   官方命名空间
        -   前缀："spring-boot-starter-"
        -   模式：spring-boot-starter-模块名
        -   eg.   spring-boot-starter-web
    -   自定义命名空间
        -   后缀："-spring-boot-starter"
        -   模式：模块-spring-boot-starter
        -   eg.   mybatis-spring-boot-starter
        
-   依赖实现工程
```xml
        <dependency>
            <groupId>com.dongz.starter</groupId>
            <artifactId>dongz-spring-boot-starter-autoconfig</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
```
        
### 实现工程（dongz-spring-boot-starter-autoconfig)
具体实现starter功能
-   删除多余依赖工程，只保留 spring-boot-starter： 所有starter都需要引入的基本配置
        结合配置类完成一些相应配置
```xml
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
        </dependencies>
```
-   创建配置 Properties类绑定属性
    -   @ConfigurationProperties
```java
//绑定配置文件中所有以dongz.test开头的配置项
//使用@ConfigurationProperties  必须开启@EnableConfigurationProperties   
@ConfigurationProperties(prefix = "dongz.test")
public class TestProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
```
-   配置类
    -   @Configuration 
        指定这个类是配置类
    -   @ConditionalOnWebApplication 
        @ConditionalOnXXX 在指定条件下自动配置类生效
    -   @EnableConfigurationProperties 让ConfigurationProperties配置类生效
```java
@Configuration //指定这个类是配置类
@ConditionalOnWebApplication // @ConditionalOnXXX 在指定条件下自动配置类生效
//扫码配置类
@EnableConfigurationProperties(TestProperties.class)
public class TestAutoConfiguration {

    @Autowired
    TestProperties testProperties;
    //给ioc容器添加组件
    @Bean
    public TestService testService() {
        TestService testService = new TestService();
        testService.setTestProperties(testProperties);
        return testService;
    }
}
```
 
-   配置自动装配Bean
    -   将标注@Configuration的自动装配类，放在classpath下的 META-INF/spring.factories文件中
    ```factories
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.dongz.starter.TestAutoConfiguration
    ```