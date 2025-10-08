// // Base class Shape
// abstract class Shape {
//     // Abstract method to be implemented by subclasses
//     abstract void printArea();
// }

// // Rectangle class extending Shape
// class Rectangle extends Shape {
//     private double width;
//     private double height;

//     // Constructor
//     public Rectangle(double width, double height) {
//         this.width = width;
//         this.height = height;
//     }

//     // Implementing the printArea method
//     @Override
//     void printArea() {
//         double area = width * height;
//         System.out.println("Area of Rectangle: " + area);
//     }
// }

// // Triangle class extending Shape
// class Triangle extends Shape {
//     private double base;
//     private double height;

//     // Constructor
//     public Triangle(double base, double height) {
//         this.base = base;
//         this.height = height;
//     }

//     // Implementing the printArea method
//     @Override
//     void printArea() {
//         double area = 0.5 * base * height;
//         System.out.println("Area of Triangle: " + area);
//     }
// }

// // Circle class extending Shape
// class Circle extends Shape {
//     private double radius;

//     // Constructor
//     public Circle(double radius) {
//         this.radius = radius;
//     }

//     // Implementing the printArea method
//     @Override
//     void printArea() {
//         double area = Math.PI * radius * radius;
//         System.out.println("Area of Circle: " + area);
//     }
// }

// // Example usage
// public class Main {
//     public static void main(String[] args) {
//         Shape rectangle = new Rectangle(5, 10);
//         rectangle.printArea(); // Output: Area of Rectangle: 50.0

//         Shape triangle = new Triangle(5, 10);
//         triangle.printArea(); // Output: Area of Triangle: 25.0

//         Shape circle = new Circle(7);
//         circle.printArea(); // Output: Area of Circle: 153.93804002589985
//     }
// }



