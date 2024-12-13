import java.util.*;
import java.util.Scanner;
abstract class Shape{
    double val1, val2;
    void input(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the value1 : ");
        val1 = sc.nextDouble();
        System.out.println("Enter the value2 : ");
        val2 = sc.nextDouble();

    }
    abstract void compute_area();
}

class Triangle extends Shape{
    void compute_area(){
        double area;
        area = 1.0f/2.0f * val1 * val2;
        System.out.println("Triangle Area : " + area);

    }

}
class Rectangle extends Shape{
    void compute_area(){
        double area;
        area = val1 * val2;
        System.out.println("Rectangle Area : " + area);

    }

}

 class Dynamic {
    public static void main(String[] args) {
        Shape s; //reference variable
        Triangle t = new Triangle();
        Rectangle r = new Rectangle();

        s = t;
        s.input();
        s.compute_area();

        s = r;
        s.input();
        s.compute_area();

    }


}