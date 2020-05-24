# bean
-   IOC思想介绍
-   xml方式配置bean介绍
-   注解方式配置bean介绍
-   refresh方法解析
-   bean实例化解析

## 使用注解配置bean方式
-   @Component
-   配置类中使用@Bean
-   实现FactoryBean
-   实现BeanDefinitionRegistryPostProcessor
-   实现ImportBeanDefinitionRegistrar

## 使用XML的有点
-   低耦合
-   对象关系清晰
-   集中管理
## 使用XML的缺点
-   配置繁琐
-   开发效率稍低
-   文件解析耗时

## 使用注解的优点
-   使用简单
-   开发效率高
-   高内聚
## 使用注解的缺点
-   配置分散
-   对象关系不清晰
-   配置修改需要重新编译工程

# refresh方法
-   bean配置读取加载入口
-   spring框架启动流程