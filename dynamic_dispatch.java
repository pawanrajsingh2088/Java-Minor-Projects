// Abstract superclass defining common behavior for all shapes
abstract class Shape {
    // Abstract method to be overridden by each specific shape subclass
    public abstract double calculateArea();

    // Method to display area, uses dynamic dispatch to call the correct calculateArea
    public void displayArea() {
        System.out.println("The area is: " + calculateArea());
    }
}

// Circle class extends Shape and overrides calculateArea
class Circle extends Shape {
    private double radius;

    // Constructor to initialize the radius of the circle
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of calculateArea specific to Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Square class extends Shape and overrides calculateArea
class Square extends Shape {
    private double side;

    // Constructor to initialize the side of the square
    public Square(double side) {
        this.side = side;
    }

    // Implementation of calculateArea specific to Square
    @Override
    public double calculateArea() {
        return side * side;
    }
}

// Triangle class extends Shape and overrides calculateArea
class Triangle extends Shape {
    private double base;
    private double height;

    // Constructor to initialize the base and height of the triangle
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Implementation of calculateArea specific to Triangle
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to demonstrate dynamic dispatch
public class dynamic_dispatch{
    public static void main(String[] args) {
        // Create an array of Shape references pointing to different shape objects
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);         // Circle with radius 5
        shapes[1] = new Square(4);         // Square with side length 4
        shapes[2] = new Triangle(6, 3);    // Triangle with base 6 and height 3

        // Iterate through the array, invoking displayArea on each shape
        for (Shape shape : shapes) {
            shape.displayArea();
            // Dynamic dispatch ensures the correct calculateArea method is called
        }
    }
}
