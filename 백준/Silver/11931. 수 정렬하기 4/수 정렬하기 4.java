import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> li = new ArrayList<Integer>();
        for( int i = 0 ; i<t;i++) {
        	li.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(li);
        Collections.reverse(li);
        
        StringBuilder sb =new StringBuilder();
        
        for( int a : li) {
        	sb.append(a + "\n");
        }
        System.out.println(sb);
    }
}