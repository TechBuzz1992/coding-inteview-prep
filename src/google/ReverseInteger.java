package google;

public class ReverseInteger {
    public static void main(String[] args) {
        int n = -236432;
        ReverseInteger obj = new ReverseInteger();
        System.out.println(obj.reverseInteger(n));

    }

    public int reverseInteger(int n) {
        int sign = 1;
        
        if (n < 1) {
            sign = -1;
            n *= -1;
        }
        
        int ans = 0;
        while(n>0){
            ans = ans*10 + n%10;
            n = n/10;
        }

        return ans*sign;

    }

}