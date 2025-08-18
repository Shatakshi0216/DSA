import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> allocateCycles(ArrayList<ArrayList<Integer>> students, ArrayList<ArrayList<Integer>> cycles)
	{	
		int N = students.size();
		int M = cycles.size();
		// Write your code here
		ArrayList<int[]> pairs = new ArrayList<>();
		for(int i=0;i<N;i++)
		{	
			int sx = students.get(i).get(0);
			int sy = students.get(i).get(1);
			for(int j=0;j<M;j++)
			{
				int cx = cycles.get(j).get(0);
				int cy = cycles.get(j).get(1);

				int dist = Math.abs(sx-cx) + Math.abs(sy-cy);
				pairs.add(new int[] {dist,i,j});
			}
		}

		pairs.sort((a,b)->
			{if(a[0]!=b[0]) return a[0]-b[0];
			if(a[1]!=b[1]) return a[1]-b[1];
			return a[2]-b[2];}
		);
		
		ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(N,-1));
		boolean[] usedStudent = new boolean[N];
		boolean[] usedCycle = new boolean[M];

		for(int[] p : pairs)
		{
			int dist = p[0];
			int student = p[1];
			int cycle = p[2];

			if(!usedStudent[student] && !usedCycle[cycle]) 
			{
				result.set(student,cycle);
				usedStudent[student] = true;
				usedCycle[cycle] = true;
			}
		}
		return result;
	}
}

