package CityHop;

/**
 *
 * I assert this is my own work: Chris Martin Any help I received beyond the
 * text, the instructor, and the departmental tutors, is listed immediately
 * following, including classmates, other students, other people, and online or
 * print resources. Other help received: OTHER HELP IN LIST FORM HERE, write
 * NONE if I received help from tutors with the names of Chase and Thomas.
 *
 * @author YOUR EMAIL HERE ctmarti2@uncg.edu ANYTHING YOU WANT THE GRADER OR
 * OLDHAM TO KNOW: Answer these Questions in place. 5 points each. "I don't
 * know" is worth 3 points.
 *
 * CAVEATS: ANYTHING you want the grader of Oldham to know: if nothing write 
 * "nothing" 
 *
 * Answer this question here(10 points)
 * QUESTION 1: Suppose we wanted to know how many miles from one city to the
 * next, or how many miles long each two-hop route was. What could we do?
 *  
 * ANSWER: I don't know.
 * 
 */
import java.util.Scanner;

public class CityHop {

  private static final String cities[] = {"Reykjavik", "Oslo", "Helsinki", "London",
                                      "Copenhagen", "Moscow", "Paris", "Berlin",
                                      "Prague", "Bern", "Vienna", "Kiev",
                                      "Madrid", "Monaco", "Rome", "Athens",};

  

    public static int[][] cityMap = {
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //Reykjavik
    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //Oslo
    {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //Helsinki
    {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //London
    {0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},  //Copenhagen
    {0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},  //Moscow
    {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0},  //Paris
    {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},  //Berlin
    {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0},  //Prague
    {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0},  //Bern 
    {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0},  //Vienna
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  // Kiev
    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},  //Madrid
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0},  //Monaco
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},  //Rome
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}}; //Athens

    @Override
    public String toString() {

        String output = "";
        for (int r = 0; r < cityMap.length; r++) {
            output += cities[r] + ": " + "  ";
            for (int c = 0; c < cityMap[0].length; c++) {
                output += "\t" + cityMap[r][c];
            }
            output += "\n";
        }

        return output;
    }
    
    public static boolean isACity(String input) {
  
        for (int i = 0; i < cities.length; i++) {
            if (input.equalsIgnoreCase(cities[i])) {
                return true;
                
            }
        }

        return false;
    }
    
    
    public static String[] hop(String origin) throws BadCityException {
        int count = 0;
        //Checking if origin is a valid city
        if (isACity(origin.substring(0, origin.length())) == false) {
           throw new BadCityException("Invalid city, please enter valid city.");
        } 
     
            int index = 0;
            for (int i = 0; i < cities.length; i++) {
                if (origin.equalsIgnoreCase(cities[i])) {
                    for (int c = 0; c < cityMap[0].length; c++) {
                        //Finding single hop connections from origin
                        if (cityMap[i][c] == 1) { 
                           count++;
                          
                        } 
                        
                    } 
                    
                    String[] singleHops = new String[count];
                    for(int j = 0;j < cities.length;j++){
                        if(origin.equalsIgnoreCase(cities[i])){
                            for(int c = 0;c < cityMap[0].length;c++){
                                //Adding single hops from origin to returning
                                //array
                                if(cityMap[i][c] == 1){
                                    singleHops[index] = cities[c];
                                    index++;
                                     
                                }
                                
                                
                            }
                            
                            return singleHops;
                        }
                         
                    }  
                        
                }
         
          }
                 
       String []empty = {};
       return empty;
    }
    
 public String printSingleHop(String origin, String[] connectionsMade){
    
     
     if(noConnections(origin) == false){
         String outputSingleHop = "";
    for(int i = 0;i < connectionsMade.length;i++){
       outputSingleHop += origin + " => " + connectionsMade[i] + "\n";
        
    }
       return outputSingleHop;    
    }
     
    else if(noConnections(origin) == true){
        String output = "";
        output += "cannot hop anywhere from city " + origin;
        return output;  
    }
    
     return "";
}
 
    public boolean noConnections(String origin){
        for(int i = 0;i < cities.length;i++){
            if(origin.equalsIgnoreCase(cities[i])){
                for(int c = 0;c < cityMap.length;c++){
                    if(cityMap[i][c] != 0){
                        return false;
                        
                    }  
                    
                } 
            } 
        }
        
        return true;
        
    }
    
 public void printDoubleHop(String origin,String[] connections,String next) throws BadCityException{
     
     int index = 0;
   if(noConnections(origin) == false){
       String[] nextHop;
       while(index < connections.length){
           //Getting single hops from origin's single hop city
           nextHop = hop(connections[index]);
           for(int i = 0;i < nextHop.length;i++){
               //Printing all double hops without pointing back to origin
               if(!origin.equalsIgnoreCase(nextHop[i])){
                System.out.println(origin + " => " + connections[index] + " => "
                + nextHop[i]);
               
               }
               
           }
           index++;
       }
              
      }
        
        else if(noConnections(origin) == true){
            System.out.println("cannot hop anywhere from city: " + origin);
            
        }
        
    }

    public static void main(String[] args) throws BadCityException {
        CityHop city = new CityHop();
        System.out.println(city);
        String prompt = "hopping from> ";
        String stop = "QUIT";

        Scanner input = new Scanner(System.in);
        String cityChosen = "";
        
        while (!stop.equals(cityChosen)) {

            try {
                System.out.print(prompt);
                cityChosen = input.next().toUpperCase();
                if(cityChosen.charAt(cityChosen.length()-1) != '^'){
                    
      System.out.println(city.printSingleHop(cityChosen, city.hop(cityChosen)));
                }
                
               else if(cityChosen.charAt(cityChosen.length()-1) == '^'){
           cityChosen = cityChosen.substring(0,cityChosen.length()-1);  
  city.printDoubleHop(cityChosen, hop(cityChosen),hop(cityChosen)[0]);
                    
                }
//                

            } catch (BadCityException ex) {
                System.out.println(ex);
                System.err.println(", Please enter a valid city...");
                
            }

        }

    }

}
