public class CLI_Arguments {
    public static void main(String[] args) {
        if (args.length<1){
            System.out.println("Please Provide an Argument");
        } else{
            System.out.println(String.format("Argument provided %s", args[0]));
        }
    }
}
