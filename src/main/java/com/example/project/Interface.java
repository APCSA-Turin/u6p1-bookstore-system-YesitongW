package com.example.project;

import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore store = new BookStore(); // Create a new bookstore

        boolean isRunning = true; // Main loop condition

        while (isRunning) {
            System.out.println("\n****** Welcome to the library ******");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add User");
            System.out.println("4. Remove User");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("7. Exit");
            System.out.print("Please select from the options: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) { // Add Book
                boolean addBook = true;
                while (addBook) {
                    System.out.println("\n=== Add Book ===");
                    System.out.print("Enter book title (or type 'exit' to return to main menu): ");
                    String title = scanner.nextLine();
                    addBook = !title.equalsIgnoreCase("exit");

                    if (addBook) {
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter year published: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        store.addBook(new Book(title, author, year, isbn, quantity));
                        System.out.println("Book added successfully!");
                    }
                }
            }

            if (choice == 2) { // Remove Book
                boolean removeBook = true;
                while (removeBook) {
                    System.out.println("\n=== Remove Book ===");
                    System.out.print("Enter ISBN of the book to remove (or type 'exit' to return to main menu): ");
                    String isbn = scanner.nextLine();
                    removeBook = !isbn.equalsIgnoreCase("exit");

                    if (removeBook) {
                        Book[] books = store.getBooks();
                        boolean removed = false;
                        for (Book book : books) {
                            if (book != null && book.getIsbn().equals(isbn)) {
                                store.removeBook(book);
                                removed = true;
                                System.out.println("Book removed successfully!");
                            }
                        }
                        if (!removed) {
                            System.out.println("Book not found!");
                        }
                    }
                }
            }

            if (choice == 3) { // Add User
                boolean addUser = true;
                while (addUser) {
                    System.out.println("\n=== Add User ===");
                    System.out.print("Enter user name (or type 'exit' to return to main menu): ");
                    String name = scanner.nextLine();
                    addUser = !name.equalsIgnoreCase("exit");

                    if (addUser) {
                        System.out.print("Enter user ID: ");
                        String id = scanner.nextLine();
                        store.addUser(new User(name, id));
                        System.out.println("User added successfully!");
                    }
                }
            }

            if (choice == 4) { // Remove User
                boolean removeUser = true;
                while (removeUser) {
                    System.out.println("\n=== Remove User ===");
                    System.out.print("Enter user ID to remove (or type 'exit' to return to main menu): ");
                    String id = scanner.nextLine();
                    removeUser = !id.equalsIgnoreCase("exit");

                    if (removeUser) {
                        User[] users = store.getUsers();
                        boolean removed = false;
                        for (User user : users) {
                            if (user != null && user.getId().equals(id)) {
                                store.removeUser(user);
                                removed = true;
                                System.out.println("User removed successfully!");
                            }
                        }
                        if (!removed) {
                            System.out.println("User not found!");
                        }
                    }
                }
            }

            if (choice == 5) { // View All Books
                boolean viewingBooks = true;
                while (viewingBooks) {
                    System.out.println("\n=== Book List ===");
                    Book[] books = store.getBooks();
                    boolean isEmpty = true;

                    for (Book book : books) {
                        if (book != null) {
                            System.out.println(book.bookInfo());
                            isEmpty = false;
                        }
                    }

                    if (isEmpty) {
                        System.out.println("No books available.");
                    }

                    System.out.println("Type 'exit' to return to main menu.");
                    String input = scanner.nextLine();
                    viewingBooks = !input.equalsIgnoreCase("exit");
                }
            }

            if (choice == 6) { // View All Users
                boolean viewingUsers = true;
                while (viewingUsers) {
                    System.out.println("\n=== User List ===");
                    User[] users = store.getUsers();
                    boolean isEmpty = true;

                    for (User user : users) {
                        if (user != null) {
                            System.out.println(user.userInfo());
                            isEmpty = false;
                        }
                    }

                    if (isEmpty) {
                        System.out.println("No users available.");
                    }

                    System.out.println("Type 'exit' to return to main menu.");
                    String input = scanner.nextLine();
                    viewingUsers = !input.equalsIgnoreCase("exit");
                }
            }

            if (choice == 7) { // Exit
                System.out.println("Exiting program...");
                scanner.close();
                isRunning = false;
            }
        }
    }
}

