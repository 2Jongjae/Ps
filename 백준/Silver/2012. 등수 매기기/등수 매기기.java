import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	
	PriorityQueue<Integer> li = new PriorityQueue<>();
	for (int i = 0 ; i< n ; i ++) {
		li.add(Integer.parseInt(br.readLine()));
	}
	long sum = 0;

	
	for ( int i = 0 ; i< n ; i++) {
		int temp = li.poll();
		sum += Math.abs( temp - (i+1));
	}
	
	System.out.println(sum);
	}
}
