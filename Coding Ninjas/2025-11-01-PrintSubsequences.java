import java.util.*;

class solution {

    public static void subsequence(int idx, StringBuilder helper, String input) {
        // Base case: when we reach the end of the string
        if (idx == input.length()) {
            // Print the subsequence as a plain string (not list)
            if (helper.length() > 0)
                System.out.println(helper.toString());
            else
                System.out.println(); // print empty line for empty subsequence
            return;
        }

        // Include current character
        helper.append(input.charAt(idx));
        subsequence(idx + 1, helper, input);

        // Exclude current character
        helper.deleteCharAt(helper.length() - 1);
        subsequence(idx + 1, helper, input);
    }

    public static void printSubsequences(String input) {
        StringBuilder helper = new StringBuilder();
        subsequence(0, helper, input);
    }
}
