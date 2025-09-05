import java.util.* ;
import java.io.*; 
public class Solution {
	public static String reformDate(String s) {
		// Write your code here
		Map<String, String> monthMap = new HashMap<>();
		monthMap.put("Jan", "01");
		monthMap.put("Feb", "02");
		monthMap.put("Mar", "03");
		monthMap.put("Apr", "04");
		monthMap.put("May", "05");
		monthMap.put("Jun", "06");
		monthMap.put("Jul", "07");
		monthMap.put("Aug", "08");
		monthMap.put("Sep", "09");
		monthMap.put("Oct", "10");
		monthMap.put("Nov", "11");
		monthMap.put("Dec", "12");

		String[] parts = s.split(" ");
		String day = parts[0].substring(0, parts[0].length() - 2);
		String mon = parts[1];
		String year = parts[2];

		if (day.length() == 1){
			day = "0" + day;
		}

		return year + "-" + monthMap.get(mon) + "-" + day;
	}
}
