import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String input = br.readLine();
    	
    	int aCnt = 0;
    	int min = 1_001;
    	
    	for(int i = 0 ; i < input.length(); i ++) {
    		if(input.charAt(i) =='a') aCnt++;
    	}
    	
    	
    	for(int i = 0 ;  i < input.length(); i++) {
    		int bCnt = 0;
    		for(int j = 0 ; j < aCnt ; j++) {
    			
    			int idx = i + j ;
    			if( i+j >= input.length()) idx -= input.length();
    			
    			if( input.charAt(idx) == 'b') bCnt ++;
    			
    		}
    		
    		min = Math.min(bCnt, min);
    	}
    	
    	System.out.println(min);
    }
}
