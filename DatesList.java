
//package assigned;
import java.util.Calendar;

/**
 * 
 * I assert this is my own work: Chris Martin 
 * Any help I received beyond the text, the
 * instructor, and the departmental tutors, is listed immediately following,
 * including classmates, other students, other people, and online or print
 * resources. Other help received: OTHER HELP IN LIST FORM HERE, write NONE if
 * I received help from tutors with the names of Chase and Thomas.
 *
 * @author YOUR EMAIL HERE ctmarti2@uncg.edu 
 * ANYTHING YOU WANT THE GRADER OR OLDHAM TO KNOW: Tutor Chase, Tutor Thomas,
 * all helped with insert and delete method.
 *
 * Answer these Questions in place. 5 points each. "I don't know" is worth 3
 * points.
 *
 * Q1: For the setYr, setMo, and setDy methods in ADate, what errors could
 * happen? How could you handle those errors (ignoring "printing a message to
 * the user".) 
 * 
 * ANSWER Q1: The errors that could occur are users inputting negative
 * integers or integers that exceed the number of months or days of a year
 * Check if the month or day given is too big or too small. Set month to 1 if
 * month input is smaller than 1 and if month input is bigger than 12 set
 * month to 12. If day input is less than 1 set day to 1 and if day input is
 * more than associated month's day set day to last day in that month. If 
 * there is an integer less than 1 put in for year then set year to 1.
 * 
 * Q2: In standard java compareTo(ADate other) and equals(ADate other) would
 * be written as compareTo(Object other) and equals(Object other). As best
 * you can explain the complication if other is an Object rather than ADate.
 * ANSWER Q2: The Object other can't can be compared to an ADate object
 * Java will complain about two objects being of different data types.
 *
 * Q3: Try to describe a scheme where compareTo could indicate the most
 * significant field on which this and other differ: year being most significant
 * and day being least. 
 * ANSWER Q3: The first two comparisons that must be made is this.yr and 
 * other.yr If the years are the same then the the most significance value is 
 * this and other's month and if they are equal then the days are the most 
 * significant.
 *
 * Q4: Could other be null in compareTo or equals? If so what should we do?
 * ANSWER Q4: In compareTo if other is null return a positive number if this has
 * a value. If this and other are both null then it should return 0; In equals
 * method 
 * 
 *
 * Q5: In DatesList.get(int k) we assume k is a valid index into dates.
 * Suppose in a DatesList capacity = 5 and size = 3. What is the problem with
 * each of the following values of k: 
 * 5: The index of an array starts at 0 so the last index is really 4
 * ANSWER Q5 -1: return null because that index doesn't exist in the list
 * ANSWER Q5 4: return null because that index goes past the size of the list
 * ANSWER Q5: None of the indices given hold a valid value
 *
 * Q6: If we did not assume k was valid in DatesList.get(int k) how would the
 * get code change? 
 * ANSWER Q6: Check if the k is less than or greater the the size of the list
 *
 * Q7: Suppose DatesList.get(int k) is implemented like this: return dates[k].
 * Assume dates[k].getDy() returns 17. Now the caller assigns the result to
 * ADate tmp and then calls tmp.setDy(20) Is dates[k] changed by the call to
 * tmp.setDy()? If the answer is YES then how do we keep outside code from
 * changing the value of ADate objects stored in dates? 
 * ANSWER Q7: NO
 * 
 * Q8: Suppose in insert(ADate d) we do not assume sufficient capacity. If
 * someone tried to assert into a full dates array what should we do? (Please do
 * not say "print a message on screen.") 
 * ANSWER Q8: Anytime the size is equal to capacity don't add anymore dates to 
 * list.
 * 
 * Q9: Suppose in delete(ADAte d) d is not present in dates. What should we
 * do. (Please do not say "print a message on the screen") 
 * ANSWER Q9: Return size without decrementing
 *
 */
class ADate {

    private int yr;
    private int mo;
    private int dy;

    public ADate() {
        Calendar cal = Calendar.getInstance();
        yr = cal.get(Calendar.YEAR);
        mo = cal.get(Calendar.MONTH) + 1; // +1 because in Calendar January is 0
        dy = cal.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        if(this == null){
            return "_null_";
        }
        //Create a StringBuilder to output the date as a string
        StringBuilder date = new StringBuilder("");
        date.append(mo + "/" + dy + "/" + yr);
        //return the StringBuilder representation of dates
        return date.toString();
    }

    public int getYr() {
        //return the year that is associated with ADate object
        return yr;
    }

    public int getMo() {
        //return the month that is associated with ADate object
        return mo;
    }

    public int getDy() {
        //return the day that is associated with ADate object
        return dy;
    }

    public void setYr(int yr) {
        //Associated ADate object's year will become year in parameters
        this.yr = yr;
    }

    public void setMo(int mo) {
        //Associated ADate object's month will become the month in parameters
        this.mo = mo;
    }

    public void setDy(int dy) {
        //Associated ADate object's day will become the day in parameters
        this.dy = dy;
    }

    public int compareTo(ADate other) {
       //Had to add these special cases to get rid of NullPointerException
        if(this == null && other == null){
           return 0;
       }
       if(this == null && other != null){
           return -2;
       }
       else if(this != null && other == null){
           return -2;
       }
       
        //Check years first
        //if this's year is less than other's year return -1 
       //or  if this's year is greater than other's year return 1
        if (yr < other.yr) {
            return -1;
        } else if (yr > other.yr) {
            return 1;
        } //Assumed the year's are the same
            //Compare months then days
            if (mo < other.mo) {
                return -1;
                
            } else if (mo > other.mo) {
                return 1;
            } else{
                if(dy < other.dy){
                    return -1;
                }
                else if(dy > other.dy){
                    return 1;
                }
                return 0;
            }
        
    }

    public boolean equals(ADate other) {
        //Had to add these special cases to get rid of NullPointerException
        if(this == null && other != null){
            return false;
        }
        else if(this != null && other == null){
            return false;
        }
        if (this.compareTo(other) == 0) {
            return true;
        }
        return false;
    }

    public static void testMe() {
        ADate d1 = new ADate();
        System.out.println(d1.toString()); 
        // JO: needs toString() defined to work right
        // until then expect something like assigned.ADate@7d76a8c8
    }
}

public class DatesList {

    private ADate dates[];
    private int size;
    private int capacity;

    public DatesList(int cap) {
        capacity = cap;
        dates = new ADate[capacity];
        size = 0;

    }

    @Override
    public String toString() {
        if(dates == null){
            return "_null_";
        }
        StringBuilder toString = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            toString.append(dates[i] + ", ");
        }
        return toString.toString();
    }
    public int getSize(){
        return size;
    }
    
    public int insert(ADate d) {
        //If no dates have been added then d will be first date in DatesList
        if(size == 0 || dates == null){
            dates[0] = d;
            return ++size;
        }
        int index = 0;
            //Every date that is less than d keeps their spot.
            while(d.compareTo(dates[index]) == 1){
               ++index;
               
           }
            //Every date after d shifts to the right
          for(int j = size;j > index;j--){
              dates[j] = dates[j - 1];
          }
          dates[index] = d;
      
        //increment size
        return ++size;      
    }
    public ADate get(int k) {
        //As long as input in get's parameters isn't less than 0 or greater
        //then or equal to size return date at DatesList's index.
        if (k < 0) {
           return null;
       } else if (k >= size) {
           return null;
        }
        return dates[k];
    }
    public int delete(ADate d) {
        //If no dates have been added to DatesList return 0
        if (size == 0 || dates == null) {
            return 0;
        } 
        int index = 0;
            //If d hasn't been found then keep iterating through list
            while(!d.equals(dates[index])){
                ++index;
                
            }
            //Everydate after d shifts to the left
         for(int j = index;j < size - 1;j++){
             dates[j] = dates[j + 1];
             
         }   
             
//        
        //decrement size
        return --size;
    }
    public static void main(String[] args) {
       
     //create some date
     ADate fiveDates[] = new ADate[5];
     int year[] = {2016,2017,2015,2016,2016};
     int month[] = {2,2,2,1,4};
     int day[] = {12,10,14,4,1};
     for(int k = 0;k < 5;++k){
         fiveDates[k] = new ADate();
         fiveDates[k].setYr(year[k]);
         fiveDates[k].setMo(month[k]);
         fiveDates[k].setDy(day[k]);
        
    }
     DatesList dList = new DatesList(5);
     
     System.out.println("Testing DatesList");
        System.out.println("Test insert " + java.util.Arrays.toString(fiveDates)
              +  " to a DatesList(5).");
       System.out.println("Also tests toString(), compareTo()");
        
       System.out.println("Expect  []");
       System.out.println( "\t[" + dList + "]" );
        dList.insert(fiveDates[0]);
        System.out.println("Expect: " + fiveDates[0] );
       System.out.println( "\t" + dList );
        dList.insert(fiveDates[1]);
        System.out.println("Expect: " + fiveDates[0] + ", " + fiveDates[1]);
        System.out.println( "\t" + dList );
        dList.insert( fiveDates[2] );
        System.out.println("Expect: " + fiveDates[2] + ", " + fiveDates[0]
                + ", "  + fiveDates[1]);
        
        System.out.println( "\t" + dList );
        dList.insert( fiveDates[3] );
        System.out.println("Expect: " + fiveDates[2] + ", " + fiveDates[3] + 
                ", " + fiveDates[0] + ", " + fiveDates[1]);
        System.out.println( "\t" + dList );
        dList.insert( fiveDates[4] );
        System.out.println("Expect: " + fiveDates[2] + ", " + fiveDates[3] + 
             ", " + fiveDates[0] + ", " + fiveDates[4] + ", "+ fiveDates[1]);
        System.out.println( "\t" + dList );
//        
        System.out.println("\nTest getSize(), get(k), ADate getters");
        System.out.println("Expect: 5, 2, 12, 2017");
      System.out.println( "\t" + dList.getSize() + ", " + dList.get(0).getMo() 
      + ", " + dList.get(2).getDy() + ", " + dList.get(4).getYr());
        
        System.out.println("\nTest get(k) and equals()");
        ADate tmp = dList.get(0);
         System.out.println(tmp);
        System.out.println("Expect: false, true");
        System.out.println( "\t" + (tmp == dList.dates[0]) + ", " + 
                                    tmp.equals(dList.dates[0]));
        
        System.out.println("\nTest get(k), delete() and getSize()");
        dList.delete(tmp);
        System.out.println("Expect: " + fiveDates[3] + ", " + fiveDates[0] + 
                ", " + fiveDates[4] + ", "+ fiveDates[1] + " size = 4");
        System.out.println( "\t" + dList + " size = " + dList.getSize());
        
        tmp = dList.get(3);
        dList.delete(tmp);
        System.out.println("Expect: " + fiveDates[3] + ", " 
                + fiveDates[0] + ", " + fiveDates[4] + " size = 3");
        System.out.println( "\t" + dList + " size = " + dList.getSize());
        
        tmp = dList.get(1);
        dList.delete(tmp);
        System.out.println("Expect: " + fiveDates[3] + ", " + fiveDates[4] 
                                      + " size = 2" );
        System.out.println( "\t" + dList + " size = " + dList.getSize());
        
        tmp = dList.get(1);
        dList.delete(tmp);
        System.out.println("Expect: " + fiveDates[3] + " size = 1" );
        System.out.println( "\t" + dList + " size = " + dList.getSize());
        
        tmp = dList.get(0);
        dList.delete(tmp);
        System.out.println("Expect:  size = 0"  );
        System.out.println( "\t" + dList + " size = " + dList.getSize());
        
        System.out.println("\nEnd DatesList testing, prove "
                               + "ADate.testMe() runs:");
        ADate.testMe();
        
        
        
   }
        
}
    


    
  

