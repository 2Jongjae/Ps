import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
	int id;
	int ability;
	public Person(int id, int ability) {
		super();
		this.id = id;
		this.ability = ability;
	}
	

	@Override
	public String toString() {
		return "Person [id=" + id + ", ability=" + ability + "]";
	}
	@Override
	public int compareTo(Person o) {
		if( this.ability == o.ability) return o.id - this.id;
		return this.ability-o.ability;
	}
	
}

class League {
	int leagueId;
	TreeSet<Person> maxpeople = new TreeSet<Person>();
	TreeSet<Person> minpeople = new TreeSet<Person>() ;
	public League() {
	}
	
	public League(int leagueId, TreeSet<Person> maxpeople, TreeSet<Person> minpeople) {
		super();
		this.leagueId = leagueId;
		this.maxpeople = maxpeople;
		this.minpeople = minpeople;
	}

	@Override
	public String toString() {
		return  "max=" + maxpeople + ", min=" + minpeople + "]";
	}
	
}


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n =  Integer.parseInt(br.readLine());
		League lg = new League();
		
		for (int i = 0 ; i < n ; i ++) {
			Person ps = new Person(i,Integer.parseInt(br.readLine()));
			searchMid(ps, lg.maxpeople, lg.minpeople);
			sb.append(lg.maxpeople.last().ability).append("\n");
		}
		
		System.out.println(sb);
    }
	
	
    private  static void searchMid(Person person, TreeSet<Person> maxpeople, TreeSet<Person> minpeople) {
    	
    	//맥스는 끝 값 
    	
    	if( maxpeople.size() == minpeople.size()) maxpeople.add(person);
    	else minpeople.add(person);
    	
    	if( !maxpeople.isEmpty() && !minpeople.isEmpty()) {
    		Person maxPerson = maxpeople.last();
    		int maxId = maxPerson.id;
    		int maxAbility = maxPerson.ability;
    		
    		Person minPerson = minpeople.first();
    		int minId = minPerson.id;
    		int minAbility = minPerson.ability;
    		
    		if( maxAbility > minAbility) {
    			Person temp = maxpeople.pollLast();
    			maxpeople.add(minpeople.pollFirst());
    			minpeople.add(temp);
    		}
    		if( maxAbility == minAbility && maxId < minId) {
    			Person temp = maxpeople.pollLast();
    			maxpeople.add(minpeople.pollFirst());
    			minpeople.add(temp);
    		}
    		

    		
    	};
	}
}
