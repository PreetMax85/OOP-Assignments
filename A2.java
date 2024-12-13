class Publication {
    private String title;
    private double price;
    private int copies;
    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public int getCopies() {
        return copies;
    }
    public void sellCopies(int qty) {
        System.out.println("Total Publication sell: $" + (qty*getPrice()));
    }
}
class Book extends Publication {
    private String author;
    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void orderCopies(int qty) {
            System.out.println("Copies ordered: " + qty);
            System.out.println("Total copies of books available: " + (qty + getCopies()));
    }

    @Override
    public void sellCopies(int qty) {
        System.out.println("Total Book sell: $" + (qty*getPrice()));
    }
}
class Magazine extends Publication {
    private int orderQty;
    private String currentIssue;
    public Magazine(String title, double price, int copies, int orderQty, String currentIssue) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }
    public int getOrderQty() {
        return orderQty;
    }
    public String getCurrentIssue() {
        return currentIssue;
    }
    public void adjustQty(int qty) {
            System.out.println("Copies ordered: " + qty);
            System.out.println("Total copies available: " + (qty + getOrderQty()));
    }
    public void recvNewIssue(String newIssue) {
        System.out.println("Current Issue: " + getCurrentIssue());
        System.out.println("New Issue: " + newIssue);
    }

    @Override
    public void sellCopies(int qty) {
        System.out.println("Total Magazine sell: $" + (qty*getPrice()));
    }
}

class Assignment2 {
    public static void main(String[] args) {
        Book book1 = new Book("Fahrenheit 451", 351, 4, "Ray Bradbury");
        book1.orderCopies(5);
        Magazine magazine1 = new Magazine("Vogue", 190, 8, 3, "Summer 2024");
        magazine1.sellCopies(7);
        Publication publication1 = new Publication("Puffin Publications", 430, 6);
        publication1.sellCopies(8);
    }
}

