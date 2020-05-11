# 监听器
-   learn
    自定义监听器
-   learnSpringbootListener
    springboot监听器

## event
事件

## listener
监听器

## multicaster
广播器

# 监听器事件触发机制
-   获取监听器列表
    -   start
    -   getApplicationListeners
    -   是否缓存
    -   retrieveApplicationListeners
    -   遍历监听器
    -   supportsEvent
    -   加入符合条件监听器列表
    -   end
    
# 实现方式
-   方式一
    -   实现ApplicationListener接口
    -   spring.factories内填写接口实现
    -   key值为org.springframework.context.ApplicationListener
-   方式二
    -   实现ApplicationListener接口
    -   SpringApplication类初始后设置进去
-   方式三
    -   实现ApplicationListener接口
    -   application.properties内填写接口实现
    -   key为context.listener.classes
-   方式四
    -   实现SmartApplicationListener接口
    -   重写supportsEventType方法
    -   同前三种注入方式注入框架
    
## tips
-   实现ApplicationListener接口针对单一事件监听
-   实现SmartApplicationListener接口针对多种事件监听
-   Order值越小越先执行
-   application.properties中定义的优先于其他方式