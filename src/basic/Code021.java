package basic;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape {
    protected String type;

    public abstract double area();
    public String getType() {
        return this.type;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.type = "Rectangle";
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.type = "Circle";
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}

public class Code021 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> list = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            String[] ops = input.split(" ");
            if (ops[0].equals("rectangle")) {
                int width = Integer.parseInt(ops[1]);
                int height = Integer.parseInt(ops[2]);
                list.add(new Rectangle(width, height));
            } else if (ops[0].equals("circle")) {
                int radius = Integer.parseInt(ops[1]);
                list.add(new Circle(radius));
            } else if (ops[0].equals("end")) {
                break;
            }
        }

        for (Shape e: list) {
            System.out.printf("%s area: %.2f\n", e.getType(), e.area());
        }

        sc.close();
    }
}
