import java.io.*;
import java.util.*;

class Game{
	int level;
	String name;
		public Game (int x , String name) {
			this.level = x;
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		@Override
		public String toString() {
			return "Game [level=" + level + ", name=" + name + "]";
		}
}


public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      List<Game> li[] = new ArrayList[n];
      for (int i = 0 ; i< n ; i ++)  li[i] = new ArrayList<>(); 
      
      for( int i = 0 ; i < n ; i++) {
    	  st = new StringTokenizer(br.readLine());
    	  int level = Integer.parseInt(st.nextToken());
    	  String nickname = st.nextToken();
    	  Game game = new Game(level,nickname);
    	  
    	  for( int j = 0 ; j < n ; j ++) {
    		  if(li[j].isEmpty()) {
    			  li[j].add(game);
    			  break;
    		  }
    		   if(Math.abs(level-li[j].get(0).level) <=10 && li[j].size()<=m-1) {
    			   li[j].add(game);
    			   break;
    		   }
    	  }
      }
      
      for(List<Game> game : li) {
    	  game.sort(Comparator.comparing(Game::getName));
    	  if(game.size() == m) {
    		  System.out.println("Started!");
    		  for( int i = 0 ; i <m ;i++)System.out.println(game.get(i).level + " " + game.get(i).name);
    	  } else if( game.size()>=1) {
    		  System.out.println("Waiting!");
    		  for( int i = 0 ; i <game.size() ;i++)System.out.println(game.get(i).level + " " + game.get(i).name);
    	  }
    	  else break;
      }
      
    }
}
