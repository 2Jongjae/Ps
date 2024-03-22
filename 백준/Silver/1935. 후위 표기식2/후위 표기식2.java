import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String prefix = br.readLine();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)  arr[i] = Integer.parseInt(br.readLine());

		Stack<Double> ss = new Stack<>();
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if ('A' <= ch && ch <= 'Z') { 
				double d = arr[ch - 'A'];
				ss.push(d);
			} else {
				double d1 = ss.pop();
				double d2 = ss.pop();
				double d3 = 0.0;
				if(ch == '+') d3 = d2 + d1;
				if(ch == '-') d3 = d2 - d1;
				if(ch == '*') d3 = d2 * d1;
				if(ch == '/') d3 = d2 / d1;
				ss.push(d3);
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");
		double ans = ss.pop();
		System.out.println(df.format(ans));
	}
}
