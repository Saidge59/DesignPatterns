package structural_patterns.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlyweightApp {

    public static void main(String[] args) {

        FactoryShape factoryShape = new FactoryShape();

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(factoryShape.getShapeByName("point"));
        shapes.add(factoryShape.getShapeByName("point"));
        shapes.add(factoryShape.getShapeByName("square"));
        shapes.add(factoryShape.getShapeByName("circle"));
        shapes.add(factoryShape.getShapeByName("circle"));
        shapes.add(factoryShape.getShapeByName("circle"));
        shapes.add(factoryShape.getShapeByName("point"));
        shapes.add(factoryShape.getShapeByName("circle"));
        shapes.add(factoryShape.getShapeByName("square"));

        for(Shape shape:shapes) {
            shape.drawShape((int)(Math.random()*10), (int)(Math.random()*10));
        }
    }
}

class FactoryShape {
    Map<String, Shape> shapes = new HashMap<>();

    Shape getShapeByName (String name) {
        Shape shape = shapes.get(name);

        if(shape == null) {
            switch (name) {
                case "point":
                    System.out.println("Create new object Point");
                    shape = new Point();
                    break;
                case "circle":
                    System.out.println("Create new object Circle");
                    shape = new Circle();
                    break;
                case "square":
                    System.out.println("Create new object Square");
                    shape = new Square();
                    break;
                default:
                    throw new RuntimeException("Name is absent in shapes");
            }
            shapes.put(name, shape);
        }
        return shape;
    }
}

interface Shape {
    void drawShape(int x, int y);
}

class Point implements Shape {
    @Override public void drawShape(int x, int y) { System.out.println("("+x+", "+y+") shape is point"); }
}

class Circle implements Shape {
    int r = 5;
    @Override public void drawShape(int x, int y) { System.out.println("("+x+", "+y+") shape is circle with radius " + r); }
}

class Square implements Shape {
    int a = 10;
    @Override public void drawShape(int x, int y) { System.out.println("("+x+", "+y+") shape is square with side " + a); }
}