package e2;

import e1.StringUtilities;

import java.util.regex.Pattern;

public class Code {
    /**
     * Determines whether a keypad is valid . To do this , it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated . If the array
     * (or any of its subarrays ) is null it will be returned false .
     * @param keypad The keypad to be analyzed .
     * @return true if it is valid , false otherwise .
     */

    public static boolean isKeypadValid ( char [][] keypad ) {
        if(keypad !=null) {
            if (keypad[0][0] == '1'){

                for (int i = 1; i < keypad.length; i++) {
                    if(keypad[i]==null){
                        return false;
                    }
                    for (int j = 1; j < keypad[i].length; j++) {
                        if (keypad[i][j] < keypad[i][j - 1] || keypad[i][j] < keypad[i - 1][j]) {
                            return false;
                        }
                    }
                    }
                }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad .
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false .
     * @param movements Array of Strings representing movements .
     * @return true if it is valid , false otherwise .
     */


    public static boolean areMovementsValid ( String [] movements ) {

        if(movements == null)
            return false;

        for (String movement : movements) {
            if (movement == null)
                return false;
            else {
                for (int i = 0; i < movement.length(); i++)
                    if ((movement.charAt(i) != 'U') && (movement.charAt(i) != 'D') && (movement.charAt(i) != 'L') && (movement.charAt(i) != 'R'))
                        return false;
            }
        }
        return true;
    }


    /**
     * Given a keypad and an array of movements , it returns a String with the code
     * resulting from applying the movements on the keypad .
     * @param keypad alphanumeric keypad .
     * @param movements Array with the different movements to be made for each
    number of the key .
     * @return Resulting code .
     * @throws IllegalArgumentException if the keypad of the movements are invalid .
     */
    public static String obtainCode ( char [][] keypad , String [] movements ) {
        StringBuilder aux= new StringBuilder(movements.length);
        int c=0, f=0;

        for (String movement : movements) {
            for (int i = 0; i < movement.length(); i++) {
                switch (movement.charAt(i)) {
                    case 'U':
                        if(f>0) {
                            f--;
                        }
                        break;
                    case 'D':
                        if(f<(keypad.length-1)) {
                            f++;
                        }
                        break;
                    case 'R':
                        if(c<(keypad[0].length-1)) {
                            c++;
                        }
                        break;
                    case 'L':
                        if(c>0) {
                            c--;
                        }
                        break;
                }
            }
            aux.append(keypad[f][c]);
        }
        return aux.toString();
    }
}
