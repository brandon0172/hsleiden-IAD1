import java.io.*;
import java.util.Arrays;


public class Heapsort 
{
    private  int[] array;
    private  int n;
    private  int left;
    private  int right;
    private  int largest;

    // Build-Heap Function
    public void buildheap(int []a){
    	n=a.length-1;
    	for(int i=n/2;i>=0;i--){
    		maxheap(a,i);
    	}
    }
    
    public void maxheap(int[] a){
		maxheap(a, 0);
    }

    
    // Max-Heap Function
    public void maxheap(int[] a, int i){
    	left=2*i;
    	right=2*i+1;
    	
    	if(left <= n && a[left] > a[i]){
    		largest=left;
    	}
    	else{
    		largest=i;
    	}
    	
    	if(right <= n && a[right] > a[largest]){
    		largest=right;
    	}
    	if(largest!=i){
    		exchange(i,largest);
    		maxheap(a, largest);
    	}
    }
    
    // Exchange Function
    public void exchange(int i, int j){
    	int t=array[i];
    	array[i]=array[j];
    	array[j]=t; 
    	}
    
    public int getMax(){
    	if(array.length > 0){
    		return array[0];
    	} else {
    		return -1;
    	}
    	
    }
    
    public void sort(int []a0){
    	array=a0;
    	
    	//build maximum heap
    	buildheap(array);

    	
    	
    	//Schrijf hier je sorteer implementatie
    	
    
    
    }
    
    public static void main(String[] args) {
		Heapsort hs = new Heapsort();
    	int []a1={3,5,8,1,2,4};
    	hs.sort(a1);

    	System.out.print(Arrays.toString(a1));
    	
	}
} 