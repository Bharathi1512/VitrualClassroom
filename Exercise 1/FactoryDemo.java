package com.patterns.creational.factory;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        switch (type.toLowerCase()) {
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            case "square": return new Square();
            default: throw new IllegalArgumentException("Unknown shape type");
        }
    }
}

// Demo
public class FactoryDemo {
    public static void runDemo() {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("circle");
        Shape rect = factory.getShape("rectangle");
        Shape square = factory.getShape("square");

        circle.draw();
        rect.draw();
        square.draw();
    }
}
