import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean isPeriodic(String s) {
        // Write your code here.
        String doubled = s + s;
        String modified = doubled.substring(1,doubled.length()-1);
        return modified.contains(s);
    }
}
