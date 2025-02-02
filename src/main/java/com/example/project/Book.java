package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String title; 
    private String author; 
    private int yearPublished; 
    private String isbn; 
    private int quantity; 

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    public Book (String title, String author, int yearPublished, String isbn, int quantity){
        this.title = title;
        this.author = author; 
        this.yearPublished = yearPublished; 
        this.isbn = isbn; 
        this.quantity = quantity; 
    }

    //returns the title of the book
    public String getTitle(){
        return title; 
    }

    //sets the title to the new title in parameter
    public void setTitle(String newTitle) {
        title = newTitle; 
    }

    //returns the author of the book
    public String getAuthor(){
        return author; 
    }
    
    //sets the author to the new author in the parameter
    public void setAuthor(String newAuthor){
        author = newAuthor; 
    }

    //returns the year that the book was published
    public int getYearPublished(){
        return yearPublished; 
    }

    //sets the year the book was published to the year in the parameter
    public void setYearPublished(int year){
        yearPublished = year; 
    }

    //returns the book's isbn
    public String getIsbn(){
        return isbn; 
    }

    //sets the isbn to the one in the parameter
    public void setIsbn(String newIsbn){
        isbn = newIsbn; 
    }

    //returns how many copies of the book there are 
    public int getQuantity(){
        return quantity; 
    }

    //sets the book quantity to the number in the parameter 
    public void setQuantity(int quant){
        quantity = quant; 
    }

    //returns all the info of the book
    public String bookInfo(){  //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity; 
    } 
       
}