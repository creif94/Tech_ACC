package Galvanized;

public class Conditional_Statments {
    public static void main(String[] args) {
        //Conditional if-else, for loop, while loop:

        int age = 21;
        // If Else Statments
        if (age >= 21) {
            System.out.println("You can drink");
        }
        // If I wanted both of these conditions checked, you could add another if before the else-if, or nest it in the first if
        else if (age > 16) { // Being that the previous one is True, it will break and won't run this block of code
            System.out.println("You can drink outside of america");
        } else {
            System.out.println("Cannot drink");
        }

        // Switch Statements: You're looking for a certain value, you provide conditional statments
        String groceryItems = "apple";

        switch (groceryItems) {
            case "apple":
                System.out.println("You are buying an apple");
                break;
            // You need to provide a break between each switch statement
            case "bannana":
                System.out.println("You are buying a bannana");
                break;
            case Default:
                System.out.println("You are buying an Item");
        }

        // Itterations: Your For Loops, or While Loops
        // Start, Stop, Step, just like range() in python
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        // While the value inside of the () is true, the loop will continue:
        int i = 1;
        while (i > 10) {
            System.out.println(i); // Printing out I
            i++; // Adding 1 each pass so that it'll eventually stop running
        }

// Did not work
//        String grade(int input){
//            if (input <=59){
//                char grades = 'F';
//                System.out.println("F");
//                if (input <=69){
//                    System.out.println("D");
//                    if (input <= 79){
//                        System.out.println("C");
//                        if (input <= 89){
//                            System.out.println("B");
//                        }
//                    }
//                }
//            }  else {
//                System.out.println("A");
//            }
//        }

        String grade ( int input){
            if (input >= 90) {
                return "A";
            } else if ((input >= 80) && (input <= 89)) {
                return "B";
            } else if ((input >= 70) && (input <= 79)) {
                return "C";
            } else if ((input >= 60) && (input <= 69)) {
                return "D";
            } else {
                return "F";
            }
        }


    }
