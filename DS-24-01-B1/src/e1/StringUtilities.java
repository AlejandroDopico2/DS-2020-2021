package e1;
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
        return "si";
    }

}
