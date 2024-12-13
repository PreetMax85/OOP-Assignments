import java.io.*;
import java.util.*;

class FileHandling {

    public void readData() {
        try (Scanner sc = new Scanner(new File("demo.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void writeData(Student obj) {
        try (FileWriter fw = new FileWriter("demo.txt", true)) { // Append mode
            fw.write(obj.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

class Student {
    private int student_id;
    private String student_name;
    private int roll_num;
    private int class_num;
    private float marks;
    private String address;
    private transient Scanner sc = new Scanner(System.in); // Transient to avoid serialization issues

    Student() {
        this("", 0, 0, 0, 0.0f, "");
    }

    Student(String student_name, int student_id, int roll_num, int class_num, float marks, String address) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.roll_num = roll_num;
        this.class_num = class_num;
        this.marks = marks;
        this.address = address;
    }

    public void getData() {
        System.out.print("Enter Your Name: ");
        this.student_name = sc.nextLine();
        System.out.print("Enter Your ID: ");
        this.student_id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Your Roll No: ");
        this.roll_num = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Your Class Number: ");
        this.class_num = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Your Marks: ");
        this.marks = Float.parseFloat(sc.nextLine());
        System.out.print("Enter Your Address: ");
        this.address = sc.nextLine();
    }

    public void displayData() {
        System.out.println("\nStudent Name: " + this.student_name);
        System.out.println("Student ID: " + this.student_id);
        System.out.println("Student Roll No: " + this.roll_num);
        System.out.println("Student Class Number: " + this.class_num);
        System.out.println("Student Marks: " + this.marks);
        System.out.println("Student Address: " + this.address + "\n");
    }

    @Override
    public String toString() {
        return student_id + "," + student_name + "," + roll_num + "," + class_num + "," + marks + "," + address;
    }
}

class Main {
    public static void main(String[] args) {
        FileHandling fileHandler = new FileHandling();
        List<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            Student student = new Student();
            student.getData();
            students.add(student);
            fileHandler.writeData(student);
        }

        System.out.println("\nReading data from file:");
        fileHandler.readData();

        System.out.println("\nDisplaying student data:");
        for (Student student : students) {
            student.displayData();
        }
    }
}
