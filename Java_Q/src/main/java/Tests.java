import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("wheels");
        ArrayList<String> items2 = items;
        items.add("on screen display");
        System.out.println( items2.get(1) );

    }
}
