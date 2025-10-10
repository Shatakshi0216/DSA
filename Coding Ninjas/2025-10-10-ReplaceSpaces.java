import java.util.*;
import java.io.*;

public class Solution {
    public static StringBuilder replaceSpaces(StringBuilder str) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ans.append("@40");
            } else {
                ans.append(str.charAt(i));
            }
        }

        return ans;
    }
}
