package com.dongz.learn.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auth dz
 * @time 2020/6/23 21:58
 * @desc 很多时候， 观察者需要根据事件的情况来处理
 *       大多数时候， 我们处理事件需要事件的源对象
 */
public class Child {
    private boolean cry;
    List<Observers> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        // 函数式编程
        observers.add((e) -> System.out.println("ppp" + e.getPlace()));
    }

    public void wakeUp() {
        cry = true;
        WakeUpEvent event = new WakeUpEvent(11, "bed", this);

        observers.forEach(e -> e.actionOnWakeUp(event));
    }

    @Data
    @AllArgsConstructor
    public class WakeUpEvent {
        private long time;
        private String place;
        // 事件源对象
        private Child source;
    }


    @FunctionalInterface
    public interface Observers{
        void actionOnWakeUp(WakeUpEvent event);
    }

    public class Dad implements Observers{
        @Override
        public void actionOnWakeUp(WakeUpEvent event) {
            if (event.getTime() > 10) {
                System.out.println("爸爸喂奶");
            }
        }
    }

    public class Mom implements Observers {
        @Override
        public void actionOnWakeUp(WakeUpEvent event) {
            System.out.println("妈妈抱抱");
        }
    }
}
