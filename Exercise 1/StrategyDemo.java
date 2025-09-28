package com.patterns.behavioral.strategy;

// Strategy
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

// Context
class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(int amount) {
        strategy.pay(amount);
    }
}

// Demo
public class StrategyDemo {
    public static void runDemo() {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.payAmount(500);

        context.setStrategy(new PayPalPayment());
        context.payAmount(1000);

        context.setStrategy(new UpiPayment());
        context.payAmount(200);
    }
}
