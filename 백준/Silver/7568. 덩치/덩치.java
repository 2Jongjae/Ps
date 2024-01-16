import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

class Position {
    int kg, cm, rank;
    public Position(int kg, int cm) {
        this.kg = kg;
        this.cm = cm;
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      
      Position[] people = new Position[n];

        for (int i = 0; i < n; i++) {
          int kg ,cm;
          st = new StringTokenizer(br.readLine());
          kg = Integer.parseInt(st.nextToken());
          cm = Integer.parseInt(st.nextToken());
          people[i] = new Position(kg, cm);        	
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && people[i].kg < people[j].kg && people[i].cm < people[j].cm) {
                    rank++;
                }
            }
            people[i].rank = rank;
        }

        for (Position a : people) {
            System.out.print(a.rank + " ");
        }
    }
}
