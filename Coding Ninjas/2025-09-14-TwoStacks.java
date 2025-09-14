import java.util.* ;
import java.io.*; 
public class TwoStack {
    int[] arr;
    int top1, top2, n;

    public TwoStack(int s) {
        n=s;
        arr=new int[n];
        top1=-1;
        top2=n;
    }

    public void push1(int x) {
        if(top1+1<top2) {
            arr[++top1]=x;
        }
    }

    public void push2(int x) {
        if(top1+1<top2) {
            arr[--top2]=x;
        }
    }

    public int pop1() {
        if(top1==-1) return -1;
        return arr[top1--];
    }

    public int pop2() {
        if(top2==n) return -1;
        return arr[top2++];
    }
}
