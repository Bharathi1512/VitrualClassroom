package com.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// Subject
class Stock {
    private String symbol;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void addObserver(Investor investor) {
        investors.add(investor);
    }

    public void removeObserver(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Investor investor : investors) {
            investor.update(symbol, price);
        }
    }
}

// Observer
interface Investor {
    void update(String stockSymbol, double newPrice);
}

// Concrete Observer
class ConcreteInvestor implements Investor {
    private String name;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    public void update(String stockSymbol, double newPrice) {
        System.out.println(name + " notified: " + stockSymbol + " new price = " + newPrice);
    }
}

// Demo
public class ObserverDemo {
    public static void runDemo() {
        Stock google = new Stock("GOOG", 1000);
        Investor inv1 = new ConcreteInvestor("Alice");
        Investor inv2 = new ConcreteInvestor("Bob");

        google.addObserver(inv1);
        google.addObserver(inv2);

        google.setPrice(1200);
        google.setPrice(1400);
    }
}
