import java.util.*;
import java.lang.Math;

public class randy2 {
    public static double mrforty =  0.0;
        
    public static void main(String[] args) {
        for(int p = 0; p < 11; p++){
        double x = initialRandy(0L);
        System.out.println(nextRandy(x, p));
        }
    }
    public static double initialRandy(Long s) { //finding initial value using seed (modulo 2 +) a (mod 2^48)
        double m = Math.pow(2, 48); //constant 2^48
        double z = (s ^ 25214903917L); //result of modulo 2 addition seed + a
        double init = z%m; 
        return init;
    }

public static double nextRandy(double initialValue, int j){
   for(int i = 0; i < j; i++){
    double m = Math.pow(2,48);
    double pq = ((25214903917L*initialValue)+11);
    initialValue = pq%m;
   }
    
    //so z should be the 48 bit number that gets resrusively plugged back into nextRandy
    double w = Math.pow(2,16); //finding quotient of w / 2^16, using modulus to find remainder, then w-remainder/2^16 = quotient
    double r = initialValue%w; //r = remainder
    double qq = initialValue-r;
    double rightbits = qq/w;
    double check = Math.pow(2, 31);
    if( rightbits < check){ //returning signed #
         return rightbits;
    }else{
        return (rightbits%check - check);
    }
}
}


