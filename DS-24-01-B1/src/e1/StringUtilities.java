package e1;


public class StringUtilities {
    public static boolean isValidMix ( String a , String b , String c ) { //este vai bien refacherito
        int p = 0, q = 0,  i=0;
       if(c.length() != a.length()+b.length()){
           return false;
       }else {
            do {
                if (p < a.length()&&a.charAt(p) == c.charAt(i)) {
                    p++;
                }
                if (q < b.length()&&b.charAt(q) == c.charAt(i)) {
                    q++;
                }
                i++;
            } while (i < c.length());
       }
       return c.length()==p+q;
    }
    public static String generateRandomValidMix ( String a , String b) {
        StringBuilder c = new StringBuilder(a.length()+b.length());
        int y=0, z=0, i=0;
        int x;
        while(c.length()<((a.length()+b.length()))){
            x = (int) (Math.random()*(2))+1;
            if(x==1 && y<a.length()){
                    c.append(a.charAt(y));
                    y++;

            }
            if(x==2 && z<b.length()){
                    c.append(b.charAt(z));
                    z++;
            }
            i++;
        }
        return c.toString();
    }
}
