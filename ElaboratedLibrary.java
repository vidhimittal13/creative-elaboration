import java.util.*;
/**
 * A Library Management System
 *
 * This class allows the user to:
 * 
 *   - Add a new book to the system
 *   - Borrow an available book
 *   - Return a previously borrowed book
 *   - List all books with their current status
 * 
 * 
 * Implementation Details:
 * 
 *   We use a HashMap to store book titles (String) mapped to a Boolean 
 *   indicating availability (true = available, false = checked out).
 * 
 */
public class ElaboratedLibrary 
{
    /**
     * A HashMap storing each book's title as the key 
     * and a Boolean indicating availability as the value.
     * True means available; false means checked out.
     */
    private HashMap<String, Boolean> books;

    /**
     * Constructs a new ElaboratedLibrary object with a few default books.
     */
    public ElaboratedLibrary() 
    {
        books = new HashMap<>();
        // Adding initial sample books
        books.put("The Kite Runner", true);
        books.put("1984", true);
        books.put("The Hunger Games", false);
    }

    /**
     * Adds a book to the system, making it immediately available.
     *
     * @param title The exact title of the book to add.
     *              If this title already exists, it will simply be marked as available.
     */
    public void addBook(String title) 
    {
        books.put(title, true); 
        System.out.println("Book added (or updated): " + title);
    }

    /**
     * Attempts to borrow a book if it is currently available.
     * If the book does not exist or is already checked out, 
     * an appropriate message is displayed.
     *
     * @param title The title of the book the user wishes to borrow.
     */
    public void borrowBook(String title) 
    {
        // First, check if the book is in the system
        if (books.containsKey(title)) 
        {
            // Retrieve availability
            boolean isAvailable = books.get(title);
            if (isAvailable) 
            {
                books.put(title, false);
                System.out.println("You borrowed: " + title);
            } 
            else 
            {
                System.out.println("Not available. The book is already borrowed.");
            }
        } 
        else 
        {
            System.out.println("Book not found in the catalog.");
        }
    }

    /**
     * Returns a previously borrowed book, marking it as available again.
     * If the book doesn't exist in the system, a message is displayed.
     *
     * @param title The title of the book being returned.
     */
    public void returnBook(String title) 
    {
        if (books.containsKey(title)) 
        {
            books.put(title, true);
            System.out.println("You returned: " + title);
        } 
        else 
        {
            System.out.println("Book not found in the catalog.");
        }
    }

    /**
     * Prints out the entire book collection with each title's availability status.
     * The listing includes every known title in the system.
     */
    public void listBooks() 
    {
        System.out.println("\n========== Library Catalog ==========");
        for (String title : books.keySet()) 
        {
            boolean isAvailable = books.get(title);
            String status = isAvailable ? "Available" : "Checked Out";
            System.out.println("• " + title + " - " + status);
        }
        System.out.println("=====================================");
    }

    /**
     * Runs a loop that presents menu options to the user for 
     * adding, borrowing, returning, or listing books. 
     * Entering '5' exits the program.
     */
    public void run() 
    {
        Scanner sc = new Scanner(System.in);
        while (true) 
        {
            System.out.println(
                "\nPlease select an action: \n" +
                "1 - Add a Book\n" +
                "2 - Borrow a Book\n" +
                "3 - Return a Book\n" +
                "4 - List All Books\n" +
                "5 - Exit the Program"
            );
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the title of the book to add:");
                    String addTitle = sc.nextLine();
                    addBook(addTitle);
                    break;
                case 2:
                    System.out.println("Enter the title of the book to borrow:");
                    String borrowTitle = sc.nextLine();
                    borrowBook(borrowTitle);
                    break;
                case 3:
                    System.out.println("Enter the title of the book to return:");
                    String returnTitle = sc.nextLine();
                    returnBook(returnTitle);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Exiting the Library System. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * The main entry point. Creates an instance of the ElaboratedLibrary
     * class and starts the interactive menu.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) 
    {
        ElaboratedLibrary library = new ElaboratedLibrary();
        library.run();
    }
}