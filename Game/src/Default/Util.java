package Default;

import java.util.LinkedList;


public class Util {
    private static int lineCount = 0;

    private static LinkedList<String> output = new LinkedList<>();
    private static LinkedList<String> output2 = new LinkedList<>();
    private static LinkedList<String> output3 = new LinkedList<>();

    public static LinkedList<String> getOutput() {
        return output;
    }
    public static LinkedList<String> getOutput2() { return output2;}
    public static LinkedList<String> getOutput3() {
        return output3;
    }

    public static void println(String s){
        lineCount += 1;
        s = lineCount + " - " + s;
        System.out.println(s);
        output.add(s);
    }

    public static void println2(String s){
        lineCount += 1;
        s = lineCount + " - " + s;
        System.out.println(s);
        output2.add(s);
    }

    public static void println3(String s){
        lineCount += 1;
        s = lineCount + " - " + s;
        System.out.println(s);
        output3.add(s);
    }

    public static void println(int s){
        println(Integer.toString(s));
    }

    public static void println2(int s){
        println2(Integer.toString(s));
    }

    public static void println3(int s){
        println3(Integer.toString(s));
    }


}
