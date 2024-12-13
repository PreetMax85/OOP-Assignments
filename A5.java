import java.util.Scanner;
 class Assignment5 {
    public static void main(String[] args) {
        boolean flag1 = true;
        while (flag1) {
            Scanner v = new Scanner(System.in);
            System.out.println("Choose vehicle\n\t1. Bicycle\n\t2. Car\n\t3. Bike\n\t4. Exit");
            String vehicle = v.nextLine().toLowerCase();
            switch (vehicle) {
                case "1", "bicycle" -> {
                    Bicycle bicycle = new Bicycle();
                    boolean flag2 = true;
                    while (flag2) {
                        Scanner o = new Scanner(System.in);
                        System.out.println("Choose operation\n\t1. Change Gear\n\t2. Speed Up" +
                                "\n\t3. Apply Brakes\n\t4. Display Stats\n\t5. Exit");
                        String operation = o.nextLine().toLowerCase();
                        switch (operation) {
                            case "1", "change gear" -> bicycle.changeGear();
                            case "2", "speed up" -> bicycle.speedUp();
                            case "3", "apply brakes" -> bicycle.applyBrakes();
                            case "4", "display stats" -> bicycle.display();
                            case "5", "exit" -> flag2 = false;
                            default -> System.out.println("Invalid choice. Try again");
                        }
                    }
                }
                case "2", "car" -> {
                    Car car = new Car();
                    boolean flag2 = true;
                    while (flag2) {
                        Scanner o = new Scanner(System.in);
                        System.out.println("Choose operation\n\t1. Change Gear" +
                                "\n\t2. Speed Up\n\t3. Apply Brakes\n\t4. Display Stats" +
                                "\n\t5. Exit");
                        String operation = o.nextLine().toLowerCase();
                        switch (operation) {
                            case "1", "change gear" -> car.changeGear();
                            case "2", "speed up" -> car.speedUp();
                            case "3", "apply brakes" -> car.applyBrakes();
                            case "4", "display stats" -> car.display();
                            case "5", "exit" -> flag2 = false;
                            default -> System.out.println("Invalid choice. Try again");
                        }
                    }
                }
                case "3", "bike" -> {
                    Bike bike = new Bike();
                    boolean flag2 = true;
                    while (flag2) {
                        Scanner o = new Scanner(System.in);
                        System.out.println("Choose operation\n\t1. Change Gear" +
                                "\n\t2. Speed Up\n\t3. Apply Brakes\n\t4. Display Stats" +
                                "\n\t5. Exit");
                        String operation = o.nextLine().toLowerCase();
                        switch (operation) {
                            case "1", "change gear" -> bike.changeGear();
                            case "2", "speed up" -> bike.speedUp();
                            case "3", "apply brakes" -> bike.applyBrakes();
                            case "4", "display stats" -> bike.display();
                            case "5", "exit" -> flag2 = false;
                            default -> System.out.println("Invalid choice. Try again");
                        }
                    }
                }
                case "4", "exit" -> flag1 = false;
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }
}
interface Vehicle {
    public void changeGear(); public void speedUp();
    public void applyBrakes(); public void display();
}
class Bicycle implements Vehicle {
    int gear, speed;
    public Bicycle() {
        gear = 1;
        speed = 10;
        System.out.println("Bicycle started successfully");
    }
    @Override
    public void changeGear() {
        Scanner g = new Scanner(System.in);
        System.out.println("Which gear do you want?");
        int newGear = g.nextInt();
        if ((newGear > 0) && (newGear < 7)) {
            gear = newGear;
            System.out.println("Gear changed successfully");
        } else {
            System.out.println("Invalid gear");
        }
    }
    @Override
    public void speedUp() {
        if ((speed > 0) && (speed <= 50)) {
            speed += 5;
            System.out.println("Speed increased successfully");
        } else if (speed < 50) {
            System.out.println("Max speed");
        }
    }
    @Override
    public void applyBrakes() {
        boolean flag = true;
        while (flag) {
            Scanner c = new Scanner(System.in);
            System.out.println("Enter choice\n\t1. Slow down\n\t2. Stop Bicycle");
            String choice = c.nextLine().toLowerCase();
            switch (choice) {
                case "1", "slow down" -> {
                    if ((speed > 0) && (speed <= 50)) {
                        speed -= 5;
                        System.out.println("Speed decreased successfully");
                    } else if (speed <= 0) {
                        System.out.println("Bicycle stopped");
                    }
                    flag = false;
                }
                case "2", "stop bicycle" -> {
                    speed = 0; gear = 0;
                    System.out.println("Bicycle stopped");
                    flag = false;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }
    @Override
    public void display() {
        System.out.println("Bicycle stats:\nSpeed: " + speed + "\nGear: " + gear);
    }
}
class Car implements Vehicle {
    int gear, speed;
    public Car() {
        gear = 1;
        speed = 10;
        System.out.println("Car started successfully");
    }
    @Override
    public void changeGear() {
        Scanner g = new Scanner(System.in);
        System.out.println("Which gear do you want?");
        int newGear = g.nextInt();
        if ((newGear > 0) && (newGear < 7)) {
            gear = newGear;
            System.out.println("Gear changed successfully");
        } else {
            System.out.println("Invalid gear");
        }
    }
    @Override
    public void speedUp() {
        if ((speed > 0) && (speed <= 50)) {
            speed += 5;
            System.out.println("Speed increased successfully");
        } else if (speed < 50) {
            System.out.println("Max speed");
        }
    }
    @Override
    public void applyBrakes() {
        boolean flag = true;
        while (flag) {
            Scanner c = new Scanner(System.in);
            System.out.println("Enter choice\n\t1. Slow down\n\t2. Stop Car");
            String choice = c.nextLine().toLowerCase();
            switch (choice) {
                case "1", "slow down" -> {
                    if ((speed > 0) && (speed <= 50)) {
                        speed -= 5;
                        System.out.println("Speed decreased successfully");
                    } else if (speed <= 0) {
                        System.out.println("Car stopped");
                    }
                    flag = false;
                }
                case "2", "car bicycle" -> {
                    speed = 0; gear = 0;
                    System.out.println("Car stopped");
                    flag = false;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }
    @Override
    public void display() {
        System.out.println("Car stats:\nSpeed: " + speed + "\nGear: " + gear);
    }
}
class Bike implements Vehicle {
    int gear, speed;
    public Bike() {
        gear = 1;
        speed = 10;
        System.out.println("Bike started successfully");
    }
    @Override
    public void changeGear() {
        Scanner g = new Scanner(System.in);
        System.out.println("Which gear do you want?");
        int newGear = g.nextInt();
        if ((newGear > 0) && (newGear < 7)) {
            gear = newGear;
            System.out.println("Gear changed successfully");
        } else {
            System.out.println("Invalid gear");
        }
    }
    @Override
    public void speedUp() {
        if ((speed > 0) && (speed <= 50)) {
            speed += 5;
            System.out.println("Speed increased successfully");
        } else if (speed < 50) {
            System.out.println("Max speed");
        }
    }
    @Override
    public void applyBrakes() {
        boolean flag = true;
        while (flag) {
            Scanner c = new Scanner(System.in);
            System.out.println("Enter choice\n\t1. Slow down\n\t2. Stop Bike");
            String choice = c.nextLine().toLowerCase();
            switch (choice) {
                case "1", "slow down" -> {
                    if ((speed > 0) && (speed <= 50)) {
                        speed -= 5;
                        System.out.println("Speed decreased successfully");
                    } else if (speed <= 0) {
                        System.out.println("Bike stopped");
                    }
                    flag = false;
                }
                case "2", "stop bike" -> {
                    speed = 0; gear = 0;
                    System.out.println("Bike stopped");
                    flag = false;
                }
                default -> System.out.println("Invalid choice. Try again");
            }
        }
    }
    @Override
    public void display() {
        System.out.println("Bike stats:\nSpeed: " + speed + "\nGear: " + gear);
    }
}
