import java.util.* ;
import java.io.*; 


public class Solution {
  public static int getFloor(int[]a , int n , int x)
  {
    int left = 0;
    int right = n-1;
    int mid = 0;
    int floor = -1;
    while(left<=right)
    { 
      mid = left+(right-left)/2;
      if(a[mid]<=x)
      { 
        floor = a[mid];
        left = mid+1;
      }
      else
      {
        right = mid-1;
      }
    }
    return floor;
  }
  public static int getCeil(int[]a , int n , int x)
  {
    int left = 0;
    int right = n-1;
    int mid = 0;
    int ceil = -1;
    while(left<=right)
    { 
      mid = left+(right-left)/2;
      if(a[mid]>=x)
      {
        ceil =a[mid];
        right = mid-1;
      }
      else
      {
        left = mid+1;
      }
    }
    return ceil;
    
  }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {

      // Wriute your code here.
      int arr[] = {getFloor(a,n,x),getCeil(a,n,x)};
      return arr;
      

       
    }
    
}
