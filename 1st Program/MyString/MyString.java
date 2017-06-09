//package assignedHomework;

/**
 * A class wrapping an array of char to form a representation of strings
 * somewhat a light version of String in standard Java API. Like those String
 * objects, these objects should be IMMUTABLE: once created their data values do
 * not change.
 * This is my own work: Chris Martin
 *ctmarti2@uncg.edu
 * @author JDOLDHAM
 */
public class MyString {

    private char[] data;
    private int offset;
    private int count;

    /**
     * QUESTION 1: If MyString is immutable does this constructor have a
     * purpose?
     * <P>
     * ANSWER: Yes. This constructor initializes its own data fields.
     * </P>
     * creates empty string, length will be 0
     */
    public MyString() {
        data = null;
        offset = 0;
        count = 0;
    }

    /**
     * QUESTION 2: MyString objects are immutable. Is it necessary to copy seq
     * to data, or is it OK to just assign it?
     * <P>
     * ANSWER: Yes it is necessary to copy seq to data because
     * constructor must help any MyString object contain the 
     * characters of the array that is passed through the parameters
     * </P>
     *
     * @param seq the sequence of characters represented by MyString
     */
    public MyString(char seq[]) {
        this.count = seq.length;
        this.offset = 0;
        data = new char[count];
        //Assigned each of char array seq's character to data field data
        for(int i = offset;i < count;i++){
            data[i] = seq[i];
            
        }
    }

    /**
     * QUESTION 3: Is it necessary to copy the offset, count, and data fields of
     * the other MyString object or can we just assign them?
     * <P>
     * ANSWER: We must copy other to MyString object.
     * </P>
     *
     * @param other the MyString we are duplicating
     */
    public MyString(MyString other){
        this.offset = other.offset;
        this.count = other.count;
        data = new char[count];
        //Assigned each of MyString other's characters are assigned to
        //left side MyString's array
        for(int i = this.offset;i < count;i++){
            data[i] = other.data[i];
            
        } 
    }
    /**
     * @return number of character in the MyString object
     */
     public int length() {
         return this.count;   
     }
    /**
     * CAUTION: Don't forget offset is not always 0. </BR>
     * Please use StringBuilder to implement this
     * @return java.lang.String representation of the characters in the MyString
     */
    @Override
    public String toString(){
        if(this.data != null){
            StringBuilder sb = new StringBuilder();
        String temp = "";
       for(int i = 0;i < count;i++){
           temp += this.data[i];
       }
           sb.append(temp);
        return sb.toString();
            
        }
        return "_null_";
    } 
    /**
     * @param from position in this MyString where the substring (new MyString)
     * begins
     * @param to one past the position in this MyString where the substring (new
     * MyString) ends
     * @return a new MyString from this MyString at index from to this MyString
     * at index to-1. So the new MyString has length to - from
     */
    public MyString substring(int from, int to) {
       if(this.data != null){
           //Create a StringBuilder to take characters from data
       StringBuilder temp = new StringBuilder();
        //Create a string called sub that will take characters from StringBuilder
        String sub = "";
        for(int i = 0;i < count;i++){
            temp.append(this.data[i]);
        }
        for(int i = from;i < to;i++){
            sub += temp.charAt(i);
        }
        //Create an array to have the substring of the string sub
        //the new Mystring will return with substring placed inside array holder
        char [] holder = new char[sub.length()];
        for(int i = 0;i < sub.length();i++){
            holder[i] = sub.charAt(i);
        }
        
        MyString output = new MyString(holder);
        return output;    
       }
       return null;
    }
    /**
     * @param j position of the character to get
     * @return the character at position j
     */
     public char charAt(int j){//Originally named get wasn't matching in main
         if(data == null){
             return 0;
         }

    //This will make sure the index selected isn't one that doesn't exist
         if(j < 0){
             return 0;
         }
         //This will make sure the index selected won't be bigger than string's
         //length
         if(j >= count){
             return 0;
         }
         //Otherwise return the charAt selected
         return data[j];  
     }  
    /**
     * @param c a character that may appear in the MyString
     * @return the left-most index of c in the MyString, or -1 if no c appears
     */
     public int indexOf(char c){
         if(this.data != null){
             //Loop through the data array to find index and return it.
         for(int i = 0;i < count;i++){
             if(data[i] == c){
                 return i;
             } 
         }   
         }
         return -1;
     } 
    /**
     * QUESTION 4: This is to test for value-equality. How would you test a
     * MyString for identity?
     * <P>
     * ANSWER 4: You would use a compareTo method that compares the left
     * and right MyString objects alphabetically.
     * </P><P>
     * QUESTION 5: Does String.equals test for value equality or identity?
     * </P><P>
     * Answer 5: The .equals method tests for value equality
     * </P><P>
     * QUESTION 6: Suppose other is null. How should that be handled?
     * </P><P>
     * ANSWER 6: this.data should be set to null
     * </P><P>
     * QUESTION 7: Why is this NOT an override of equals as defined in Object?
     * Is Java's String.equals an override of Object.equals?
     * </P><P>
     * ANSWER 7: It is not a override because this .equals compares objects that
     * are not of type String therefore the method doesn't override because of 
     * its parameters
     * </P>
     *
     * @param other the other MyString to check for equality
     * @return true iff the two MyStrings have the same underlying sequence of
     * character values, false otherwise
     */
     public boolean equals( MyString other) {
         if(count == other.data.length){
             for(int i = 0;i < count;i++){
             if(data[i] == other.data[i]){
                 return true;
             }
         }
             
         }
         return false;  
     }
    /**
     * QUESTION 8: Since we implement int compareTo can we or can we not change
     * the first line of the class to public class MyString implements
     * Comparable {?
     * ++
     * <P>
     * ANSWER 8: No we can not change the first line of the class to public
     * class MyString implements Comparable because the method has already 
     * defined in MyString class. Making the class implement Comparable with 
     * cause java to complain.
     * (Say YES or NO and tell me how you reached this conclusion)
     *
     * </P>
     *
     * @param that another MyString object to compare to, or...
     * @return -1 if this < other, +1 if this > other, 0 if this == other,
     * anything else is a failed compareTo
     */
    public int compareTo(MyString that){
        //first check if each MyString is the same length
        if(count == that.data.length){
            for(int i = 0;i < count;i++){
                //Once the first character is proven to be less than the right
                //side character return -1
                if(data[i] < that.data[i]){
                    return -1;
                }
               //Once the first character is proven to be greater than the right
                //side character return 1
                else if(data[i] > that.data[i]){
                    return 1;
                }
            }
            //Otherwise they are same
            return 0; 
        }
        //Checking if each MyString is not the same length
        else if(count != that.data.length){
            for(int i = 0;i < data.length;i++){
                for(int j = 0;j < that.data.length;j++){
                    //Once the first character is proven to be less than the left
                    // side return -1
                    if(data[i] < that.data[j]){
                        return -1;
                    }
                    //Once the first character is proven to be greater than 
                    //the left side return 1
                    else if(data[i] > that.data[j]){
                        return 1;
                    }
                    
                }  
            }
        }
        return 0;
    }
    /**
     * @param other another MyString
     * @return A new MyString consisting of this MyString followed by that other
     * MyString
     */
     public MyString cat(MyString other){
         //Create a StringBuilder, variable concat, and a copy array
         StringBuilder sb = new StringBuilder();
         String concat = "";
         //StringBuilder adds the characters from data field data
         for(int i = 0;i < count;i++){
             sb.append(data[i]);
         }
         //StringBuilder adds the characters from other MyString's data
         for(int i = 0;i < other.length();i++){
             sb.append(other.data[i]);
         }
         //Variable concat holds the concatenation of the left and right side
         //MyString objects
         for(int i = 0;i < sb.length();i++){
             concat += sb.charAt(i);
             
         }
         //Create a holder to put in returning MyString
         char holder [] = new char[concat.length()];
         //holder adds characters from 
         for(int i =0;i < holder.length;i++){
             holder[i] = concat.charAt(i);
          
         }
         //The holder will now hold data from concat and be able to return
         //concatenation in return MyStrin object
         MyString output = new MyString(holder);
         return output;
     } 
    public static void main(String[] args) {
        char[] ca1 = {'A', 'B', 'Y', 'Z'};
      MyString empty = new MyString(new char[0]);
        MyString s1 = new MyString();
       MyString s4 = new MyString(ca1);
  System.out.println("testing constructors. Expect: [] [_null_] [ABYZ] [ABYZ]");
        MyString[] msa = {empty, s1, s4, new MyString(s4)};
        for( MyString ms : msa ) {
          System.out.print( "[" + ms + "] ");
      }
        System.out.println("\n");
        
        
        System.out.println("testing length. Expect: 0 4");
        System.out.println( s1.length() + " " + s4.length() );
        System.out.println();
        
        System.out.println("testing indexOf. Expect: 0 1 3 -1");
        System.out.print(s4.indexOf( 'A' ) + " ");
        System.out.print(s4.indexOf( 'B' ) + " ");
        System.out.print(s4.indexOf('Z') + " ");
        System.out.print(s4.indexOf('m') + " ");
        System.out.println("\n");

        System.out.println("testing charAt(). Expect: A Z [] [] []");
        System.out.print(s4.charAt(0) + " " + s4.charAt(3));
        System.out.print("[" + s4.charAt(-1) + "] [" + s4.charAt(4) + "] [" 
                + s1.charAt(0) + "]" );
        System.out.println("\n");

        System.out.println("testing equals() and ==. Expect: True True False True");
        MyString s5 = new MyString(s4);
        MyString s6 = s4;
        System.out.println(s5.equals(s4) + " " + s6.equals(s4) + " "
                +(s5==s4) + " " + (s4 == s6));
        System.out.println();

        System.out.println("testing comparetTo. Expect: 0 1 -1");
        System.out.print(s4.compareTo(s5) + " ");
        char[] ca2 = { 'A', 'B', 'C', 'D' };
        MyString s7 = new MyString(ca2);
        char[] ca3 = { 'X', 'B', 'C', 'D' };
        MyString s8 = new MyString(ca3);
      System.out.println(s4.compareTo(s7) + " " + s4.compareTo(s8) + " ");
        System.out.println();

        System.out.println("testing cat. Expect: ABYZ + XBCD -> ABYZXBCD, XYZ, ABYZXBCD");
          MyString s9 = s4.cat(s8);
          System.out.print( s4 + " + " + s8 + " -> " + s9 + ", ");
          
          System.out.println("\n");
          
          System.out.println("testing substr. Expect: , XYZ, ABYZXBCD");
          MyString s10 = s9.substring(2,5);
          System.out.print( s10 + ", ");
          System.out.println( s9.substring(0, s9.length()) + "\n");
      
          
    }
}
