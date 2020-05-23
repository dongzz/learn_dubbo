package com.dongz.springboot;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author q
 * @date 2020/5/23 22:25
 * @desc 代理
 */
public class ProxyDemo {
    public static void main(String[] args) {
        //静态代理
        System.out.println("静态代理");
        Speaker lawyer = new Lawyer();
        lawyer.speak();

        System.out.println("------");
        //JDK_动态代理， 本体必须实现接口
        System.out.println("jdk_动态代理");
        LawyerProxy proxy = new LawyerProxy(new Zhangs());
        Speaker speaker2 = (Speaker) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{Speaker.class}, proxy);
        speaker2.speak();

        System.out.println("------");
        //CGLIB_动态代理，是jdk动态代理的补充， 不要求本体实现接口
        System.out.println("cglib_动态代理");
        LawyerInterceptor interceptor = new LawyerInterceptor(new Lisi());
        Lisi lisi = (Lisi) Enhancer.create(Lisi.class, interceptor);
        lisi.speak();
    }
}

interface Speaker{
    void speak();
}

class Zhangs implements Speaker{

    @Override
    public void speak() {
        System.out.println("我老婆打我！");
    }
}

/**
 * 静态代理
 */
class Lawyer implements Speaker{
    private Zhangs zhangs = new Zhangs();

    @Override
    public void speak() {
        System.out.println("引用法律条文！");
        zhangs.speak();
        System.out.println("打人是不对的！");
    }
}


/**
 * jdk 提供的动态代理
 * 用来抽象代理对象的行为
 */
class LawyerProxy implements InvocationHandler {

    private Object object;

    public LawyerProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("speak")) {
            System.out.println("引用法律条文！");
            //通过反射
            method.invoke(object, args);
            System.out.println("打人是不对的！");
        }
        return null;
    }
}

/**
 * cglib 动态代理
 * 不实现接口也能代理
 */
class LawyerInterceptor implements MethodInterceptor {
    private Object object;

    public LawyerInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("speak")) {
            System.out.println("引用法律条文！");
            //通过反射
            method.invoke(object, args);
            System.out.println("打人是不对的！");
        }
        return null;
    }
}

class Lisi {
    public void speak() {
        System.out.println("李四有话说！打人是不对的");
    }
}
