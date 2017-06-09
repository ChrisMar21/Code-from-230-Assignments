/**
 * This is my own work: Chris Martin
 * Finding weakness in the Castle's Defenses using 2D arrays
 * 9/8/15
 */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
public class CastleDefense{
    private double [][] grid;
    /**
     * Create constructor to pass one dimensional array items to 2d array
     * Pass the number of rows and columns to CastleDefense's 2d array
     * Have grid read from left to right in even rows
     * Have grid read from right to left in odd rows
     * 
     * @param numRows
     * @param numCols
     * @param scan 
     */
    public CastleDefense(int numRows,int numCols,double[] scan){
        this.grid = new double[numRows][numCols];
        int index = 0;
        for(int r =0;r<numRows;r++){
           if(r%2==0){
            for(int c =0;c<numCols;c++){
               this.grid[r][c] = scan[index++];  
           }   
        }
           else if(r%2!=0){
               for(int c = numCols-1;c>=0;c--){
                   this.grid[r][c] = scan[index++];
               }
           }    
   }
  } 
    /**
     * Find average of designated rows and columns in array
     * Add each 2d array element and find the average of the total or sum
     * @param startRow
     * @param endRow
     * @param startCol
     * @param endCol
     * @return 
     */
   public double getAverage(int startRow,int endRow,int startCol,int endCol){
      double total = 0;
       double count = 0;
       for(int r = startRow;r<=endRow;r++){
           for(int c = startCol;c<=endCol;c++){
            total+=grid[r][c];
               count++;
           }
       }
       return total/count; 
   }
    @Override
    /**
     * Output the grid using toString method
     */
    public String toString(){
        String result = "";
        for(int r =0;r<grid.length;r++){
            for(int c =0;c<grid[0].length;c++){
                result+= grid[r][c] + "\t";
                
            }
           result+= "\n";
        }
        return result;
    }
    /**
     * Collect the average of every 2 X 2 section in the grid
     * Find the weakest of the averages collected by every 2 X 2 section of grid
     */
    public void findWeakest(){
        double weakestAve = getAverage(0,1,0,1);
        
        int weakestRow = 0,weakestCol = 0;
     
        for(int r =0;r<grid.length-1;r++){
            for(int c =0;c<grid[r].length-1;c++){
              if(getAverage(r,r+1,c,c+1)<weakestAve){
                  weakestAve = getAverage(r,r+1,c,c+1);
                  weakestRow = r;
                  weakestCol = c;
                  
              }     
        }   
      }
        //Output the weakest average found in the grid 
        System.out.println("The weakest 2 X 2 on the castle begins at "
        + "(" + weakestRow + "," + weakestCol + ")" + " with an average of "
        + weakestAve);
   }   
   /**
    * Use main method to read each item from the text file
    * @param args
    * @throws FileNotFoundException 
    */
    public static void main(String[] args) throws FileNotFoundException{
       Scanner fin = new Scanner(new File("data.in"));
       ArrayList <Double> list = new ArrayList<>();
       Double element;
       while(fin.hasNext()){
          //Create a variable to hold each value being read from the file
           element = fin.nextDouble();
           //Assign each file from text file to ArrayList
           list.add(element);
          
       }
       //Close file after being read into ArrayList
       fin.close();
        //Rereading items from text file after closing
        Scanner scan = new Scanner(new File("data.in"));
        //Calculate how many rows and columns needed for the 2d array
        int rows = 0, columns = 0;
        for(int i = 1;i<Math.sqrt(list.size());i++){
            if(list.size()%i==0){
                rows = i;
                columns = list.size()/i;
        }
      }
       
     //Create one dimensional array to pass items to 2 dimensional array object  
       double array [] = new double[list.size()];
       for(int r =0;r<array.length;r++){
               array[r] = scan.nextDouble();
          
       }
       //Creating CastleDefense object
       CastleDefense objArray = new CastleDefense(rows,columns,array);
        objArray.findWeakest();
             
    }
 
  }
