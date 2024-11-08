import java.util.*;

class Solution {
    static HashMap<String,String> hs;
    static HashMap<String,Integer> hsv;
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        //그래프 만들기
        init(enroll,referral);
        logic(seller,amount);

        int[] answer = new int[enroll.length];
        for(int i = 0 ; i < enroll.length ; i ++){
            answer[i] = hsv.get(enroll[i]);
        }        
        
        return answer;
    }
    static void init(String[] enroll, String[] referral){
        hs = new HashMap<>();
        hsv = new HashMap<>();
        
       for(int i = 0 ; i < enroll.length ; i++){
            String a = enroll[i];
            String b = referral[i];
            hsv.put(a,0);
            hs.put(a,b);
        }
    }
    static void logic(String[] seller, int[] amount){
        
        for(int i = 0 ; i < seller.length ; i ++){
            String name = seller[i];
            int value = amount[i] * 100;
            calc(name,value);
        }
        
    }
    static void calc(String name, int value){
        if(name.equals("-")) {
            return;
        }
        int temp = value / 10;
        
        if( temp == 0 ) {
            hsv.put(name,hsv.get(name) + value);
            return;
        }
        
        
        String parent = hs.get(name);
        hsv.put(name,hsv.get(name) + (value-temp));
        calc(parent,temp);
        
        
        
    }
    
}