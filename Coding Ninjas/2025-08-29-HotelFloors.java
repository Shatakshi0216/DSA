import java.util.* ;
import java.io.*; 
public class Solution {
  public static int hotelBookings(List<String> queries)
  {
      // Write your code here.
      int coins = 0;
      for(int i=0;i<queries.size();i++)
      {
        String s = queries.get(i);
        String sign = "";
        sign = String.valueOf(s.charAt(0));
        if(sign.equals("+"))
        {
          coins++;
        }
      }
      return coins;
  }
}
