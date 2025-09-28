package com.patterns;

import com.patterns.behavioral.observer.ObserverDemo;
import com.patterns.behavioral.strategy.StrategyDemo;
import com.patterns.creational.singleton.SingletonDemo;
import com.patterns.creational.factory.FactoryDemo;
import com.patterns.structural.adapter.AdapterDemo;
import com.patterns.structural.decorator.DecoratorDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Observer Pattern Demo ---");
        ObserverDemo.runDemo();

        System.out.println("\n--- Strategy Pattern Demo ---");
        StrategyDemo.runDemo();

        System.out.println("\n--- Singleton Pattern Demo ---");
        SingletonDemo.runDemo();

        System.out.println("\n--- Factory Pattern Demo ---");
        FactoryDemo.runDemo();

        System.out.println("\n--- Adapter Pattern Demo ---");
        AdapterDemo.runDemo();

        System.out.println("\n--- Decorator Pattern Demo ---");
        DecoratorDemo.runDemo();
    }
}
