// Notes:
/*
 * String[] is a Sting Array --> String[] myArray = new String[5] this will give you an empty array.
 * If I wanted to access those elements, I could do myArray[0]
 * One method to populate an array is new String[5]{one, two, three, four, five}
 * Integer.parseInt(array[]) will convert a string into an integer
 */

import java.util.Scanner;
public class Main {
    // Public Main, which is the very first thing that gets ran __init__ like python
    public static void main(String[] args) {


    }

    public String testingInputOutput(String x){
        Scanner newObj = new Scanner(System.in);
        System.out.println("Input what you want:");
        String input1 = newObj.nextLine();
        System.out.println("System, out --> " + input1);
        return input1;
    }
    public void Arrays(){



    }

}
