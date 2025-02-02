package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name; 
    private String Id; 
    private Book[] book; 

    //requires 1 contructor with two parameters that will initialize the name and id
    public User (String name, String Id){
        this.name = name;        
        this.Id = Id; 
        this.book = new Book[5];
    }
 
    public String getName(){     // returns the name 
        return name; 
    }

    public void setName(String newName){ //sets the name as the name in the parameter 
        name = newName; 
    }

    public String getId(){ //returns the Id
        return Id; 
    }

    public void setId(String newId){  //sets the Id as the one in the parameter 
        Id = newId; 
    }

    public Book[] getBooks(){  //returns book
        return book; 
    }

    public void setBooks(Book[] book){  //sets book to the parameter 
        this.book = book; 
    }

    public String bookListInfo(){ //returns a booklist for the user, if empty, output "empty"
        String str = "Books: \n"; 
        for (Book book : book){
            if (book == null){
                str += "empty\n"; //if empty, it will say empty 
            } else {
                str+=book.bookInfo() + "\n";  //if not empty, it will list the book info 
            }
        }
        return str; 
    } 

    public String userInfo(){ //returns  "Name: []\nID: []\nBooks:\n[]"
        return "Name: "  + name + "\nId: " + Id + "\n" + bookListInfo(); 
    } 
       
}