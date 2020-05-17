package amazon;

//import java.util.*;

public class DecodeMessage {
    public static void main(String[] args) {
        String data = "01";
        System.out.println(noOfWaysDecode(data));
        
    }

    static int noOfWaysDecode(String data){
        int[] dp = new int[data.length()+1];
        
        dp[0] = 1;
        dp[1] = data.charAt(0) == '0' ? 0 : 1;
        
        for(int i=2;i<=data.length();i++){
            int oneDigit = Integer.valueOf(data.substring(i-1, i));
            int twoDigits = Integer.valueOf(data.substring(i-2,i));
            if(oneDigit>=1){
                dp[i]+=dp[i-1];
            }
            if(twoDigits>=10 && twoDigits<=26){
                dp[i]+=dp[i-2];
            }


        }
        return dp[data.length()];

    }
    
}