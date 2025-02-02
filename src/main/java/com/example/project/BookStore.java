package com.example.project;

public class BookStore {

    // Attributes of the BookStore class
    private Book[] books = new Book[5]; // Array to store up to 5 books
    private User[] users = new User[10]; // Array to store up to 10 users
    private static int num = 0; // Tracks the number of users added to the store

    // Default constructor to initialize the BookStore
    public BookStore() {
    }

    // Getter method for the users array
    public User[] getUsers() {
        return users;
    }

    // Setter method for the users array
    public void setUsers(User[] users) {
        this.users = users;
    }

    // Getter method for the books array
    public Book[] getBooks() {
        return books;
    }

    // Adds a new user to the users array
    public void addUser(User user) {
        users[num] = user;
        num++; // Increment the count of users
    }

    // Removes a user from the users array by name
    public void removeUser(User user) {
        String name = user.getName();
        for (int i = 0; i < users.length; i++) { // Iterate through the users array
            if (users[i] != null && users[i].getName().equals(name)) {
                users[i] = null; // Remove the user if the name matches
            }
        }

        User[] temp = new User[users.length]; // Temporary array for cleanup
        int ind = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                temp[ind] = users[i]; // Copy non-null users to the temp array
                ind++;
            }
        }
        users = temp; // Update the users array with the cleaned-up list
    }

    // Consolidates the users array by moving null values to the end
    public void consolidateUsers() {
        User[] temp = new User[users.length];
        int ind = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                temp[ind] = users[i]; // Add non-null users to the temp array
                ind++;
            }
        }
        users = temp; // Update the users array with consolidated data
    }

    // Adds a new book to the books array
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) { // Check for an empty spot in the books array
                books[i] = book; // Add the book to the first available spot
                break;
            }
        }
    }

    // Inserts a book at a specific index in the books array
    public void insertBook(Book book, int index) {
        if (books[index] == null) { // Check if the specified index is empty
            books[index] = book; // Insert the book at the index
        } else { // If the index is already occupied
            Book existingBook = books[index];
            books[index] = book; // Replace the book at the index
            books[index + 1] = existingBook; // Shift the existing book to the next position
        }
    }

    // Removes a book from the books array by title
    public void removeBook(Book book) {
        String title = book.getTitle(); // Get the title of the book to be removed
        for (int i = 0; i < books.length; i++) { // Iterate through the books array
            if (books[i] != null && books[i].getTitle().equals(title)) {
                if (books[i].getQuantity() > 1) { // Decrease quantity if multiple copies exist
                    books[i].setQuantity(books[i].getQuantity() - 1);
                } else {
                    books[i] = null; // Remove the book if only one copy exists
                }
                break;
            }
        }

        for (int i = 0; i < books.length - 1; i++) { // Shift remaining books to fill gaps
            if (books[i] == null && books[i + 1] != null) {
                books[i] = books[i + 1]; // Move books one position forward
                books[i + 1] = null; // Clear the duplicate entry
            }
        }

        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                count++; // Count non-null books
            }
        }
        Book[] newList = new Book[count]; // Create a new array without null values
        for (int i = 0; i < count; i++) {
            newList[i] = books[i];
        }
        books = newList; // Update the books array with the new list
    }


    public String bookStoreBookInfo() {
        return "Books: " + books + " Users: " + users;
    }
}
