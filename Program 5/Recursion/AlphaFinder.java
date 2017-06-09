/**
 * This is my own work: Chris Martin Handling Recursion with Strings 11/4/15
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AlphaFinder {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fin = new Scanner(new File("test.in"));
        int numStrings = 0;
        System.out.println("ALPHAS OUTPUT");
        numStrings = fin.nextInt();
        int i = 0;
        //Check if each string is an Alpha
        while (i < numStrings) {
            i++;
            String s = fin.next();
            isAlpha(s);
            if (isAlpha(s)) {
                System.out.println("YES");
            } 
            //Output no if it is not Alpha
            else {
                System.out.println("NO");
            }

        }

        System.out.println("END OF OUTPUT");
    }

    public static boolean isBravo(String s) {
        //Make sure String meets the length requirement
        if (s.length() < 3) {
            return false;
        }
        //Make sure String begins with B or R
        if (s.charAt(0) != 'B' && s.charAt(0) != 'R') {
            return false;
        }
        //Make sure to not walk off end of string
        int i = 1;
        for (; i < s.length() && s.charAt(i) == 'A'; i++);
        if (i == s.length()) {
            return false;
        }
        if (i == s.length() - 1 && s.charAt(i) == 'V') {
            return true;
        }

        return isBravo(s.substring(i));
    }

    public static boolean isCharley(String s) {
        //Make sure String begins with C
        if (s.charAt(0) != 'C') {
            return false;
        }
        //Make sure if it is a two character 
        if (s.length() == 2 && s.charAt(1) == 'Y') {
            return true;
        } 
        //If length exceeds 2 then 
        else if (s.length() > 2) {
            //Give two options if the length exceeds length 2
            //Chech if second letter is H followed by isCharley then a L
            if (s.charAt(1) == 'H' && isCharley(s.substring(2, s.length() - 1))
                    && s.charAt(s.length() - 1) == 'L') {

                return true;
            } 
            //Check if C followed by isBravo then a L
            else if (s.charAt(0) == 'C'
                    && isBravo(s.substring(1, s.length() - 1))
                    && s.charAt(s.length() - 1) == 'L') {
                return true;

            }
        }//if doesn't meet any of these requirements return false;
        return false;
    }

    public static boolean isAlpha(String s) {
       //Check if String contains isCharley followed by isBravo
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'L' || s.charAt(i) == 'Y') {
                if (isCharley(s.substring(0, i + 1)) == true
                        && isBravo(s.substring(i + 1, s.length())) == true) {
                    return true;

                }

            }
        }
        return false;
    }
}
