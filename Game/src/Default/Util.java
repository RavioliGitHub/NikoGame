package Default;

import java.util.LinkedList;

public class Util {

    private static LinkedList<String> output = new LinkedList<>();

    public static LinkedList<String> getOutput() {
        return output;
    }

    public static void println(String s){
        System.out.println(s);
        output.add(s);
    }

    public static void print(String s){
        System.out.print(s);
        output.add(s);
    }

}
