import java.util.* ;
import java.io.*; 
public class Solution {
	public static void insertAndSort(Stack<Integer> stack,int element)
	{
		if(stack.isEmpty() || element>stack.peek())
		{
			stack.push(element);
			return;
		}
		int top = stack.pop();
		insertAndSort(stack,element);
		stack.push(top);
	}
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
		if(stack.isEmpty()) return;
		int top = stack.pop();
		sortStack(stack);
		insertAndSort(stack,top);
		
	}

}
