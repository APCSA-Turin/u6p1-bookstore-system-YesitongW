package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
     private static int num = 99;  
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentId;
    // //requires one empty constructor
    public IdGenerate(){
             
    }

    //returns the most recent id 
    public static String getCurrentId(){
        return currentId; 
    }

    public static void reset(){   // Reset the numeric value to its starting point.
        num = 99;
        currentId = "" + num;
    } 

  // Converts the numeric value of num to a String for currentId.
    public static String generateID(){ //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
        num++;  //increments the id by 1 
        currentId = "" + num; // Update currentId with the new value.
        return currentId;
    }
}
