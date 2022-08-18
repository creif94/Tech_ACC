import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class toSentence {
    public static void main(String[] args) {
        // Create Array List of Names;
//        List<String> Names = new ArrayList<String>();
        String[] Names = new String[]{"Chris", "Alice", "James"};
        String Test = toSentence(Names);
//        System.out.println("What is Returned "+Test);
    }


    public static String toSentence(String[] names){ //List<String> names
        String HolderValue = "";
        if ((names.length == 0) || (names[0] == "")){ //names.size() == 0
            System.out.println("Entering Condition 1");
            System.out.println("\"\"");
            HolderValue = "";
            System.out.println("Condition 1: Combined "+ HolderValue);
            return HolderValue;
        }else{
            // !!!Works, but not what they wanted
//            String holdervalue = Arrays.toString(names);
//            holdervalue = holdervalue.substring(1, holdervalue.length() -1); // couldn't get to work: substring(1 ,holdervalue.length() -1);
////            holdervalue = holdervalue.replace("]","").replace("[","");
//            System.out.println("\""+ holdervalue + "\"");
            String CombinedString = "";
            if (names.length == 2){ // Checking to see if there are two items in the array, should be 0&1
                System.out.println(names.length);
                System.out.println("Entering condition 2:");
                for (int i = 0; i < names.length ; i++) {
                    System.out.println("Condition 2 Before i<name.length"+i);
                    if (i < names.length) {
                        System.out.println(i);
                        CombinedString += names[i];
                        if (i == names.length-2){
                            CombinedString += " and ";
                        }
                    }
                }
                System.out.println("Condition 2: Combined "+ CombinedString);
                System.out.println(HolderValue);

            } else {
                System.out.println(names.length);
                for (int i = 0; i < names.length; i++) {
                    if (i < names.length) { //If names.length, will add to string along with a ,
                        CombinedString += names[i];
                        if (i != names.length-2){
                        if ((i != names.length - 1)) {
                            CombinedString += ", ";
                        }}else{
                        if (i == names.length - 2) {
                            CombinedString += " and ";
                        }}
                    }
                }
                System.out.println("Condition 3: Combined "+ CombinedString);
                System.out.println(HolderValue);
            }
//            System.out.println("\""+ CombinedString + "\"");
            HolderValue = CombinedString ;
//            HolderValue = HolderValue.replace(",,,", "and " );
        }
        System.out.println("This is the Holder Value that'd be returned: " + HolderValue);
    return HolderValue;



    }
}
