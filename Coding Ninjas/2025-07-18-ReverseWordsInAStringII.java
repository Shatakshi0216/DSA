import java.util.*;
public class Solution {
	public static void reverse(char arr[],int i,int j)
    {
        while(i<j)
        {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
    }
	public static String reverseOrderWords(String str) {
        // Write your code here
        char charStr[] = str.toCharArray();

        reverse(charStr,0,charStr.length-1);

        int start = 0;
        for(int end=0;end<=str.length();end++)
        {
            if(end==str.length() || charStr[end]==' ')
            {
                reverse(charStr,start,end-1);
                start = end+1;
            }
        }
        return new String(charStr);
    }

}
