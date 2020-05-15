package amazon;

public class HammingDistance {
    public static void main(String[] args) {
        
    }

    public int getHammingDistance(int x,int y){
        int result = 0;
        while(x>0 || y>0){
            result += (x%2)^(y%2);
            x >>=1;
            y >>=1;
        }

        return result;
    }
    
}