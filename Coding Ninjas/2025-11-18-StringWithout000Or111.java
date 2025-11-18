import java.util.* ;
import java.io.*; 
public class Solution
{
    public static String strThree0Three1(int m, int n) 
    {
   		// Write your code here
           int zeros = m;
           int ones = n;
           StringBuilder sb = new StringBuilder();

           while(zeros+ones > 0)
           {
               char ch;

               if(zeros>ones) ch = '0';
               else if(ones>zeros) ch = '1';
               else ch = '0';

               int l = sb.length();

               if(l>=2 && sb.charAt(l-1)==sb.charAt(l-2) && sb.charAt(l-1)==ch)
               {
                    ch = (ch=='0') ? '1' : '0';

               }
               if(ch=='0' && zeros==0) ch='1';
               if(ch=='1' && ones==0) ch='0';

               sb.append(ch);
               if(ch=='0') zeros--;
               else ones--;
           }

           return sb.toString();
    }
}
