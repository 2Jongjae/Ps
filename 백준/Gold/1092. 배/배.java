import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		List<Integer> crain = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) crain.add(Integer.parseInt(st.nextToken()));
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] box = new int[m];
		for(int i = 0 ; i < m ; i ++) box[i] =(Integer.parseInt(st.nextToken()));
		
		Arrays.sort(box);
		Collections.sort(crain);
		Collections.reverse(crain);
		int[] temp = new int[m];
		
		
		int ans = 0;
		int check = 0 ;
		while(true) {
			boolean flag = false;
			for(int i = 0 ; i < n ; i ++) {
				int value = crain.get(i);
				for(int j = m-1 ; j >=0 ; j--) {
					if(box[j] != -1 && box[j] <= value) {
						box[j] = -1 ;
						check++;
						flag = true;
						break;
					}
				}
				
			}
			ans ++;
			if( check == m ) break;
			if(!flag) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(ans);
	}
}