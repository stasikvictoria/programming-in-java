package agh.ii.prinjava.lab01.lst01_03;

import java.util.List;

/**
 * There are different kinds of polymorphism. During the course we will cover:
 * <ul>
 *     <li>ad-hoc polymorphism (overloading of operators, functions, or - as in Java - methods)</li>
 *     <li>subtype/inclusion polymorphism (in this example)</li>
 *     <li>parametric polymorphism</li>
 * </ul>
 */
public class Main {
    /**
     * Subtype polymorphism - ability of a reference variable to take different forms
     */
    private static double totalArea(List<Shape> shapes) {
        double totArea = 0;

        // s is polymorphic - it can refer to instances of the whole family of types derived from 'Shape'
        for (Shape s : shapes) {
            totArea += s.area();
        }

        return totArea;
    }

    private static double totalPerimetr(List<Shape> shapes){
        double totPerimetr = 0;
        for (Shape p : shapes){
            totPerimetr += p.perimeter();
        }
        return totPerimetr;
    }

    public static void main(String[] args) {
        double totArea = totalArea(List.of(
                new Circle(5),
                new Rectangle(2, 5),
                new Circle(10),
                new Rectangle(10, 20)));

        double totPerimetr = totalPerimetr(List.of(
                new Circle(5),
                new Rectangle(2, 5),
                new Circle(10),
                new Rectangle(10, 20)));

        System.out.printf("totalArea = %.2f\n", totArea);
        System.out.printf("totalPerimetr = %.2f\n", totPerimetr);
    }
}
