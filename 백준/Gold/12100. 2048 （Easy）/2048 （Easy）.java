import java.io.*;
import java.util.*;

public class Main {
	static int n,max;
	static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        
        for( int i = 0 ; i < n ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < n ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
    	
        int[][] arr2 = arr;
        dfs(0, arr2);
        System.out.println(max);
        
    }
    
    static void dfs(int depth, int[][] arr2) {
//    	if(depth>=2 ) return;
//    	System.out.println("------------기준-----------------");
//    	for(int i = 0 ; i < n ; i++) {
//    		System.out.println(Arrays.toString(arr2[i]));
//    	}
//    	System.out.println("------------기준-----------------");
    	
    	
    	
    	if( depth == 5 ) {
    		for(int i = 0 ; i < n ; i ++) {
    			for(int j = 0 ; j < n ; j++) {
    				max = Math.max(arr2[i][j], max);
    			}
    		}
    		return;
    	}
    	
    	
    	List<Deque<Integer>> qq = new ArrayList<>();
    	for(int i = 0 ; i < n ; i++) {
    		qq.add(new ArrayDeque<>());
    	}
    	
    	
    	
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			if(arr2[i][j] != 0 )qq.get(i).add(arr2[i][j]);
    		}
    	}
    	
    	qqmethod(qq);


    	int[][] temp = new int[n][n];
    	for( int i = 0 ; i < n ; i++) {
    		int size = qq.get(i).size();
    		for(int j = 0 ; j <size ;j++){
    			temp[i][j] = qq.get(i).pollFirst();
    		}
    	}
    	
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = n-1 ; j >= 0 ; j--) {
    			if(arr2[i][j] != 0 )qq.get(i).add(arr2[i][j]);
    		}
    	}
    	
    	qqmethod(qq);
    	
    	int[][] temp1 = new int[n][n];
    	for( int i = 0 ; i < n ; i++) {
    		int size = qq.get(i).size();
    		for(int j = n-1 ; j >= 0;j--){
    			if( size == 0 )break;
    			temp1[i][j] = qq.get(i).pollFirst();
    			size --;
    			if( size == 0) break;
    		}
    	}

    	
    	
    	
    	
    	
    	
    	
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			if(arr2[j][i] != 0 )qq.get(i).add(arr2[j][i]);
    		}
    	}    	
    	qqmethod(qq);
    	
    	
    	
    	int[][] temp11 = new int[n][n];
    	for( int i = 0 ; i < n ; i++) {
    		int size = qq.get(i).size();
    		for(int j = 0 ; j < size ; j++){
    			temp11[j][i] = qq.get(i).pollFirst();
    		}
    	}
    	
    	
    	
    	
    	
    	
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = n-1 ; j >= 0 ; j--) {
    			if(arr2[j][i] != 0 )qq.get(i).add(arr2[j][i]);
    		}
    	}
    	
    	qqmethod(qq);
    	
    	
    	
    	
    	int[][] temp111 = new int[n][n];
    	for( int i = 0 ; i < n ; i++) {
    		int size = qq.get(i).size();
    		for(int j = n-1 ; j >= 0;j--){
    			if( size == 0 )break;
    			temp111[j][i] = qq.get(i).pollFirst();
    			size --;
    			if( size == 0) break;
    		}
    	}
//    	
//    	System.out.println("------왼쪽------");
//    	for(int i = 0 ; i < n ; i ++) {
//    		System.out.println(Arrays.toString(temp[i]));
//    	}
//    	System.out.println("------왼쪽------");
//    	System.out.println("------오른쪽------");
//    	for(int i = 0 ; i < n ; i ++) {
//    		System.out.println(Arrays.toString(temp1[i]));
//    	}
//    	System.out.println("------오른쪽------");
//    	System.out.println("------위------");
//    	for(int i = 0 ; i < n ; i ++) {
//    		System.out.println(Arrays.toString(temp11[i]));
//    	}
//    	System.out.println("------위------");
//    	System.out.println("------아래------");
//    	for(int i = 0 ; i < n ; i ++) {
//    		System.out.println(Arrays.toString(temp111[i]));
//    	}
//    	System.out.println("------아래------");
//    	System.out.println();
    	dfs(depth+1,temp);
    	dfs(depth+1,temp1);
    	dfs(depth+1,temp11);
    	dfs(depth+1,temp111);
    	
    }

	private static void qqmethod(List<Deque<Integer>> qq) {
    	for(int i = 0 ; i < n ; i++) {
    		int size = qq.get(i).size();
    		for( int j = 0 ; j < size ; j++) {
    			int temp = qq.get(i).poll();
    			if( j != size-1 && temp == qq.get(i).peekFirst()) {
    				qq.get(i).poll();
    				temp *=2;
    				j++;
    			}
    			qq.get(i).addLast(temp);
     		}
    	}
		
	} 
    
    
}