import java.util.* ;
import java.io.*; 
public class Solution {
    public static double calculateArea(int n, int points[][]) {
        // Write your code here.
        double max_area = 0.0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    double area = Math.abs(
                        points[i][0] * (points[j][1] - points[k][1]) +
                        points[j][0] * (points[k][1] - points[i][1]) +
                        points[k][0] * (points[i][1] - points[j][1])
                    ) / 2.0;

                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }
}
