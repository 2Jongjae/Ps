import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n*n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i*n + j] = (Integer.parseInt(st.nextToken()));
			}
		}
		
		Arrays.sort(arr);
		bw.append(String.valueOf(arr[(n*n)-n]));
		bw.flush();
		bw.close();
		
	}
}
