###启动器（dongz-spring-boot-starter）
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
    ~~~~
        引入 spring-boot-starter： 所有starter都需要引入的基本配置
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
        </dependencies>
    ~~~~
    
    ~~~~
    @ConfigurationProperties(prefix="dongz.test")
    绑定配置文件中所有以dongz.test开头的配置项
    ~~~~
    