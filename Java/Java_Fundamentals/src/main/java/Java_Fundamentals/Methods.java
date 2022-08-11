package Java_Fundamentals;
public class Methods {
    // Don't fully understand the static or void yet, but I know this is the __init__ in Python
    public static void main(String[] args){
        System.out.println("The Sum is :" + MethodExcercise.addNumbers(7,7));
        System.out.println("The Multiplicaiton is:" MethodExcercise.multiplyNumbers(7,7))
    }

    //Goal: Just add two numbers:
    // Decalring the class, double so all values returned will be garanteed to be a double, Name: addNumbers
    // and accepting two paramaters

    //Goal: Just multiply two numbers:
    public double multiplyNumbers(int x, int y){
        return x*y;
    }

}

