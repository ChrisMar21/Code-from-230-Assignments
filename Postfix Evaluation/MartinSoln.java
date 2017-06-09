import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * I assert this is my own work: Chris Martin 
 * Any help I received beyond the text, the
 * instructor, and the departmental tutors, is listed immediately following,
 * including classmates, other students, other people, and online or print
 * resources. Other help received: OTHER HELP IN LIST FORM HERE, write NONE if
 * NONE
 * ANYTHING YOU WANT THE GRADER OR OLDHAM TO KNOW: NONE
 * @author ctmarti2@uncg.edu
 * 
 * 
 **/

public class MartinSoln{
    /**
     * Call on this method to check if the operator is a / or *.
     * If the operator is * or / then the operator has the highest priority
     * in the order of operations
     * @param operator
     * @return 
     */
    
    public static boolean MultOrDiv(String operator){
        switch(operator){
            case "*":
                return true;
            case "/":
                return true;   
            default:
                return false;
        
        }
    
    }
    
   public static void main(String[] args) {
       //infixFinder reads the infix text file
        Scanner infixFinder;
        String output = "";
        String tok;
        String operator;
        int val;
        Stack<String> stack = new Stack<>();
        //PrintWriter object will print the output of postfix expressions 
        //to the file
        PrintWriter postfixPrinter;
        try{
            infixFinder = new Scanner(new File("infix.txt"));
            postfixPrinter = new PrintWriter(("postfix.txt"));
             while(infixFinder.hasNext()){
            try{
                //String infix will take value of the current infix expresssion
                String infix = infixFinder.nextLine();
                System.out.println("Infix: " + infix);
                Scanner tokens = new Scanner(infix);
                 while(tokens.hasNext()){
                 tok = tokens.next();
                try{
                  //If tokens finds a integer converter from string to int
                    val = Integer.parseInt(tok);
                    output += val;
                
                }catch(NumberFormatException b){
                  //If tokens finds an operator NumberFormatException is thrown
                    operator = tok;
                    while(!stack.isEmpty() && MultOrDiv(stack.peek())){
                        output += stack.peek();
                        stack.pop();
                        
                    }
                    
                    stack.push(operator);
                }
            
            }
             //Once the expression is done being read the output will add the
             //remaining operators in the stack.
            while(!stack.isEmpty()){
                
                output += stack.pop();
                
                
                
                
            }
            
            postfixPrinter.println(output);
            System.out.println("Infix to Postfix: " +  output);
             //Once the infix expression is converted the output is emptied
             output = "";
            }catch(NoSuchElementException a){
            
                System.out.println("No Such Element Exception exist. " + a);
            
            }
               
        }
        
       infixFinder.close();
       postfixPrinter.close();
       
        }catch(FileNotFoundException ex){
            System.out.println("File is not found..." + ex);
        
        }
           
    }

}

