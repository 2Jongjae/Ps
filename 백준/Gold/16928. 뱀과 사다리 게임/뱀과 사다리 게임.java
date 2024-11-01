import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ladder = new int[101];
        int[] snake = new int[101];
        int[] arr = new int[101];
        
        Queue<Integer> qq = new LinkedList<>();
        
        for(int i = 0 ; i < n ; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder[start] =  end;
        }
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake[start] =  end;
        }
        
        qq.add(1);
        int cnt = 1;
        arr[1] =1;
        while(!qq.isEmpty()) {
        	if( arr[100] != 0 ) break ;
            int size = qq.size();
            for(int t = 0 ; t < size ; t++) {
            	int temp = qq.poll();
            	for(int i = 1 ; i <=6 ; i++) {
            		int value = temp + i;
            		if( value > 100 ) continue;
            		if( ladder[value] > 0 ) value = ladder[value];
            		if( snake[value] > 0 ) value = snake[value];
            		if( arr[value] != 0 ) continue;
            		arr[value] = cnt;
            		qq.add(value);
            		
            	}
            }
            cnt++;
            
        }
        
        System.out.println(arr[100]);

    }
}