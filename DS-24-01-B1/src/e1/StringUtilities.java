package e1;

import java.util.Random;

public class StringUtilities {
    public String a, b, c;
    public static boolean isValidMix ( String a , String b , String c ) {
        if(c.length() > a.length() + b.length ()){
            return false;
        }else{
            StringBuilder a_t=new StringBuilder();
            StringBuilder b_t=new StringBuilder();
            a_t.append(a);
            b_t.append(b);
            StringBuilder c_t=new StringBuilder();
            c_t.append(c);
            int posicionA = 0, posicionB = 0;
            for(int i=0;i<c_t.length(); i++){
                char t=c_t.charAt(i);
                while(posicionA <= a_t.length()){
                    if( a_t.charAt(posicionA) == t){
                        posicionA++;
                    }
                }
                while(posicionB <= b_t.length()){
                    if( b_t.charAt(posicionB) == t){
                        posicionB++;
                    }
                }
            }
            if(posicionA + posicionB == c_t.length()){
                return true;
            }
        }
        return false;
    }
    public static String generateRandomValidMix ( String a , String b) {
        StringBuilder a_t=new StringBuilder();
        StringBuilder b_t=new StringBuilder();
        a_t.append(a);
        b_t.append(b);
        Random x = new Random();
        StringBuilder c = new StringBuilder(a.length()+b.length());
        char t = 0;
        int y=0, z=0;
        for(int i=0;i<c.length();i++){
            int introducido = x.nextInt(2);
            if(introducido==0){
                if(y<=a.length()) {
                    t = a_t.charAt(y);
                    y++;
                }
            }else {
                if(z<=b.length()){
                t=b_t.charAt(z);
                z++;
                }
            }
            c.append(t);
        }
        return c.toString();
    }
}
