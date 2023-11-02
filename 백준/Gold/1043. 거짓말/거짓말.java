import java.io.*;
import java.util.*;
//푸는 로직 
// 진실을 아는 사람들에 대한 배열을 생성한다. 
// 경우를 나눈다.
// 경우 1. 진실을 아는 사람이 있는 경우  => 진실만 하고 그 소속원들도 진실을 알게 됨 
// 경우 2. 진실을 아는 사람이 없는 경우 => 거짓을 말함. 그 사람들은 거짓을 믿음
// 경우 3 .이후 파티에서 만날 때도 그 사람이 있는 걸 파악해야함.
// 파티 순서에 따라서 최대값이 바뀌게 된다. 
// 
// 리스트 값들에서 진실을 아는 사람들의 배열이 있으면 그 원소들은 자동적으로 진실을 아는 사람으로 바뀐다.
// 구현, 시뮬레이션에 가까운 듯?
public class Main {
	static int n,m,truth;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		truth = Integer.parseInt(st.nextToken());
		TreeSet<Integer> ts = new TreeSet<>();		
		if( truth != 0 ) { 
			for ( int i = 0 ; i < truth ; i ++) {
				ts.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		List<Integer>[] arr = new LinkedList[m];
		for (int  i = 0 ; i < m ; i ++) {
			arr[i] = new LinkedList<>();
		}
		
		for ( int i = 0 ; i< m ; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			List<Integer> person = new LinkedList<>();
			for ( int j = 0 ; j < l ; j++) {
				int temp = Integer.parseInt(st.nextToken());
					person.add(temp);
					arr[i].add(temp);
			}
			for(int a : person) {
				if(ts.contains(a)) {
					for(int x : person) {
						ts.add(x);
					}
					break;
				}
			}
		}
		Set<Integer> ss = new LinkedHashSet<>();
		for ( int z  = 0 ; z<50 ; z++) {
		for(int a : ts) {
			for (int i = 0 ; i < m  ; i++) {
				if(arr[i].contains(a)) {
					for( int b  : arr[i]) {
						ss.add(b);
					}
				}
			}
		}
		for( int s : ss) {
			ts.add(s);
		}
	}
		
		
		int cnt = 0;
		l: for( int i = 0 ; i < m ; i++) {
			for ( int a : ts) {
				if( arr[i].contains(a)) {
					continue l;
				}
			}
			cnt++;
		}
		
		
		
		System.out.println(cnt);
		
		
		
		
		
	}
}