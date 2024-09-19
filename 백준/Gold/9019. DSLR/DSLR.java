import java.util.*;
import java.io.*;
class Position{
	int id;
	String method;
	
	Position( int id, String method){
		this.id =id;
		this.method = method;
	}
}


public class Main {
	static int a,b;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	l: for(int tc = 0 ; tc <T  ; tc++) {
    		boolean[] visit = new boolean[10_001];
    		st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		
    		Queue<Position> qq = new LinkedList<>();
    		qq.add(new Position(a, ""));
    		visit[a] = true;
    		while(!qq.isEmpty()) {
    			int size = qq.size();
    			for( int i = 0 ; i < size ; i ++) {
    			Position ps = qq.poll();
    			int id = ps.id;
    			String method = ps.method;
    			if(id == b )  {
    				sb.append(method + "\n");
    				continue l;
    			}
    			Position psd = dd(id,method);
    			if(!visit[psd.id]) {
    				qq.add(psd);
    				visit[psd.id] = true;
    			}
    			Position pss = ss(id,method);
    			if(!visit[pss.id]) {
    				qq.add(pss);
    				visit[pss.id] = true;
    			}
    			Position psl = ll(id,method);
    			if(!visit[psl.id]) {
    				qq.add(psl);
    				visit[psl.id] = true;
    			}
    			Position psr = rr(id,method);
    			if(!visit[psr.id]) {
    				qq.add(psr);
    				visit[psr.id] = true;
    			}
    			
    			}
    		}
    		
    		
    	}
    	System.out.println(sb);

    }
    
    private static Position rr(int id, String method) {
		String value = String.valueOf(id);
		int gap = 4 - value.length();
		for(int i = 0 ; i < gap ; i++) {
			value = "0" +value;
		}
		String suf = value.charAt(3) + value.substring(0,3);
    	
		return new Position(Integer.parseInt(suf),method+"R");
	}

	private static Position ll(int id, String method) {
		
		String value = String.valueOf(id);
		int gap = 4 - value.length();
		for(int i = 0 ; i < gap ; i++) {
			value = "0" +value;
		}
		String pre = value.substring(1,4) + value.charAt(0);
		
		return new Position(Integer.parseInt(pre),method+"L");
	}

	private static Position ss(int id, String method) {
		int value  = id -1;
		if( value == -1) value = 9999;
		
		return new Position(value,method+"S");
	}

	static Position dd(int id, String method) {
    	int value = (id *2)%10_000;
    	
    	return new Position(value,method+"D");
    }
}
