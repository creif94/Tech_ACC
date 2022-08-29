package model;

import java.util.regex.Pattern;

public class Customer {
    String firstName;
    String lastName;
    String email;


    // 3-arg constructor

    public Customer(String fName, String lName, String email){
        this.firstName = fName; // Setting first and last names based on input
        this.lastName = lName;
        String emailRegEx = "^(.+)@(.+).com$"; // RegEx for EmailAddresses
        Pattern pattern = Pattern.compile(emailRegEx); // Compiling the RegEx
        if (!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, Invalid Email");

        }
    }
    public String getName(){
        StringBuilder builder = null;
        builder.append(this.firstName + " " + this.lastName);
        return builder.toString();
    }
}
