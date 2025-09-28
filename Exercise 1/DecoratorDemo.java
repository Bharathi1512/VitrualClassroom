package com.patterns.structural.decorator;

// Component
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }
    public double cost() {
        return 5.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete Decorators
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }
    public double cost() {
        return decoratedCoffee.cost() + 1.5;
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }
    public double cost() {
        return decoratedCoffee.cost() + 0.5;
    }
}

class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }
    public double cost() {
        return decoratedCoffee.cost() + 2.0;
    }
}

// Demo
public class DecoratorDemo {
    public static void runDemo() {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new Milk(coffee);
        coffee = new Sugar(coffee);
        coffee = new WhippedCream(coffee);

        System.out.println(coffee.getDescription() + " $" + coffee.cost());
    }
}
