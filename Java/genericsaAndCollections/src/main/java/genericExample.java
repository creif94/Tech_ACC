import java.util.ArrayList;

public class genericExample {
    public static void main(String[] args) {
        ArrayList<Object> variables = new ArrayList<Object>();
        Double doubleNumber = 1.5;
        variables.add(doubleNumber);
        String name = "Sally";
        variables.add(name);
        Integer intNumber = 1;
        variables.add(intNumber);
        Character letter ='a';
        variables.add(letter);
        for(Object variable : variables){
            genericExample.displayClassName(variable);

        }
    }
    // <T> specifically stands for Generic Type.
    static <T> void displayClassName(T variable){
        System.out.println(variable.getClass().getName());
    }

}
