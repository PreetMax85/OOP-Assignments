import java.util.*;

 class GenericCollectionPropertyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many elements they want to store
        System.out.print("Enter the number of elements you want to store: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create a list to store elements (Strings or Integers)
        List<String> elements = new ArrayList<>();

        System.out.println("Enter the elements (Integers or Strings):");
        for (int i = 0; i < n; i++) {
            elements.add(scanner.nextLine());
        }

        boolean flag = true;
        while (flag) {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Find even and odd numbers");
            System.out.println("2. Find palindromes");
            System.out.println("3. Find prime numbers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Even and Odd Numbers:");
                    for (String element : elements) {
                        classifyEvenOrOdd(element);
                    }
                    break;
                case 2:
                    System.out.println("Palindromes:");
                    for (String element : elements) {
                        if (element.matches("[a-zA-Z]+")) {
                            palindrome(element);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Prime Numbers:");
                    for (String element : elements) {
                        primeNumber(element);
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    public static void palindrome(String element) {
        String reversed = new StringBuilder(element).reverse().toString();
        if (element.equalsIgnoreCase(reversed)) {
            System.out.println(element + " is a palindrome");
        } else {
            System.out.println(element + " is not a palindrome");
        }
    }

    public static void classifyEvenOrOdd(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num % 2 == 0) {
                System.out.println(num + " is even");
            } else {
                System.out.println(num + " is odd");
            }
        } catch (NumberFormatException e) {
            // Ignore non-numeric elements for even/odd check
        }
    }

    public static void primeNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num <= 1) {
                System.out.println(num + " is not a prime number");
                return;
            }
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num + " is a prime number");
            } else {
                System.out.println(num + " is not a prime number");
            }
        } catch (NumberFormatException e) {
            // Ignore non-numeric elements for prime check
        }
    }
}
