 /**
  * This is my own work: Chris Martin
  * 9/28/15
  * Programming a Vending Machine
  */
import java.util.Scanner;

public class Vending{
    
//PROVIDED
    public static void main(String[] args) {
        
        VendingMachine chaChing = new VendingMachine();
        chaChing.run();
          
    }
}

/**********************************************************/
class VendingMachine {

    //PROVIDED
    private Dispenser snackMachine;
    private Coinbox moneyBox;
     
    //PROVIDED
    public VendingMachine() {
        
        snackMachine = new Dispenser();
        moneyBox = new Coinbox(0, 3, 3);
    }

    //PROVIDED
    public void run() {
        Scanner kybd = new Scanner(System.in);
        boolean quit = false;
            
        do {
           
            showUserChoice();
            String choice = kybd.next();
            if (choice.equals("BOSS")) {
                quit = this.bossWork();
            } 
            else if(choice.charAt(0)==('5')){
                quit = true;
            }
         else{
             serviceCustomer(choice.charAt(0));
        }
            
        } while (!quit);
    }
    /**
     * Show choices for user
     */
    private void showUserChoice() {
        //System.out.println(snackMachine.toString());
        moneyBox.displayCoins();
        System.out.println(snackMachine);
        System.out.print("Enter money first and then select a product: ");
        
    }
     /**
      * Give service to customer if they decide to buy a product
      * @param choice 
      */  
    private void serviceCustomer(char choice) {
        System.out.println(snackMachine);
        Scanner input = new Scanner(System.in);
       while(choice == 'Q' || choice == 'D' || choice == 'N'){
           moneyBox.option(choice);
           choice = input.next().charAt(0);
           moneyBox.giveChange(choice);
           
       }
            if(choice == 'R'){
           moneyBox.option(choice);
//         if(snackMachine.dispense(choice)==1){
//                moneyBox.giveChange(moneyBox.getAmount() - (int)(snackMachine.getPrice(choice)*100));
//            }
//           
       }
                
   }   
    /**
     * Gives control of vending machine to BOSS
     * @return 
     */
    private boolean bossWork() {
          int choice;  
        Scanner kybd = new Scanner(System.in);
      do
      {
          //Show the boss's opitions
          System.out.println("WELCOME BOSS");
          System.out.println("1" + "\t" + "Add products");
          System.out.println("2" + "\t" + "Restock products");
          System.out.println("3" + "\t" + "Change price");
          System.out.println("4" + "\t" + "Remove product");
          System.out.println("5" + "\t" + "Shutdown");
          System.out.println("6" + "\t" + "Start Machine");
          System.out.print("BOSS - enter your selection: ");
          choice = kybd.nextInt();
         if(choice == 1){
             //Option 1 lets the BOSS add products
             snackMachine.setUpDispenser();
             
        }
        else if(choice == 2){
            //Option 2 lets the BOSS restock chosen product
            System.out.println(snackMachine.toString());
            snackMachine.restockProduct();
            
        }
        else if(choice == 3){
          //Option 3 lets the BOSS change price of chosen product
            System.out.println(snackMachine.toString());
            snackMachine.changePrice();
          
        }
        else if(choice == 4){
            //Option 4 lets the BOSS remove product from vending machine
            System.out.println(snackMachine.toString());
            snackMachine.deleteProduct();
             
        }
        else if(choice == 6){
            //Option 6 gives the BOSS option to buy product
            System.out.println(snackMachine.toString());
            
            
        }
          if(choice == 5)
              return true;
          else if(choice == 6)
              return false;
      }while(choice < 5);
        return false;
    }

        
}
/**********************************************************/
/**
 * Creating Product Class
 * @author ctmarti2
 */

class Product {
//Creating fields for Product class
private double price;
private String name;
private int quantity;
public Product(){
    this.name = "";
    this.price = 0;
    this.quantity = 0;
}
/**
 * Creating constructor for Product features
 * Initializing each field that is part of Product class
 * @param name
 * @param price
 * @param quantity 
 */
public Product(String name,double price,int quantity){
    this.name = name;
    this.price = price;
    this.quantity = quantity;
}
/**
 * Setter method for price field
 * @param price 
 */
public void setPrice(double price){
    this.price = price;  
}
/**
 * Getter method for price field
 * @return 
 */
public double getPrice(){
    return (this.price);
}
/**
 * Setter for name field
 * @param name 
 */
public void setName(String name){
    this.name = name;
}
/**
 * Getter for name field
 * @return 
 */
public String getName(){
    return this.name;
}
/**
 * Setter for quantity field
 * @param quantity 
 */
public void setQuantity(int quantity){
    this.quantity = quantity;
}
/**
 * Getter method for quantity field
 * @return 
 */
public int getQuantity(){
    return this.quantity;
}
/**
 * Output the name of products, price and quantity of products
 * entered into vending machine 
 * @return 
 */
@Override
public String toString(){
    return getName() + " , " + getPrice() + " , "
            + getQuantity();
}

}

/**********************************************************/
class Coinbox {
    
    //PROVIDED
    private int numQ, numD, numN;
    private int amount;
    
    //PROVIDED
    public Coinbox(int Q, int D, int N){
        this.numQ = Q;
        this.numD = D;
        this.numN = N;
        this.amount = 0;
    }
    
    public void giveChange(int change){
        int Q,D,N;
       Q = change/25;
         D = change/10;
         N = change/5;
        if(change > 0 && !this.correctChange()){
         
        if(Q > numQ){
             Q = numQ;
             change -= Q*25;
            
        }
        
        if(D > numD){
            D = numD;
            change -= D*10;
            
        }
        
        if(N > numN){
            N = numN;
            change -= N*5;
            
        }
       
        amount = 0;
        
      }   
    }
    /**
     * Give the user their correct change
     * @return 
     */
    public boolean correctChange(){
        if(this.numN < 1 || this.numD*10 + this.numN*5 < 20)
        return true;
        else
            return false;
    }
    /**
     * Show the user their options of coins to put into machine
     */
    public void displayCoins(){
        System.out.print("This machine takes quarters, dimes, and nickels."
        + "\n" + "Enter Q,D,N, or R for coin return." + "\n");
        
    }
    /**
     * Get amount entered by user
     * @return 
     */
    public int getAmount(){
       return this.amount;
       
    }
    /**
     * Let the user know if their coin can be taken by machine
     * @param choice
     * @return 
     */
    public boolean option(char choice){
        if(choice == 'Q' || choice == 'N' || choice == 'D'){
            this.takeCoin(choice);
            this.displayAmount();
            return true;
        }
        else if(choice == 'R'){
           this.giveChange(this.amount);
            System.out.println("Now Returning " + numQ + " quarters, "
            + numD + " dimes, " + numN + " nickels");
            return false;
        }
        return false;
    }
    /**
     * Take coin given by the user of the machine
     * @param coin 
     */
    private void takeCoin(char coin){
        if(coin == 'Q'){
            this.numQ++;
            amount+=25;
          
        }
        else if(coin == 'D'){
            this.numD++;
            amount+=10;
           
        }
        else if(coin == 'N'){
            this.numN++;
            amount+=5;
        }
    }
    private void displayAmount(){
        System.out.println("Total deposited: " + getAmount() +  
         " cents." );
    }
    
}

/**********************************************************/
class Dispenser extends Product {
    private Product items[];
    private int numItems;
    public Dispenser(){
        items = new Product[5];
        this.numItems = 4;
        items[0] = new Product("SLURM",.55,6);
        items[1] = new Product("ARACHNO_",1.25,4);
        items[2] = new Product("TWINKIES",1.25,1);
        items[3] = new Product("BACHELOR_CHOW",1.95,2);
    }
    @Override
    public String toString(){
        String result = "";
        for(int i = 0;i<numItems;i++){
            result += i+1 + ")" + items[i] + "\n" ;
    }
     return result;
   }
    /**
     * 
     * @param choice
     * @return 
     */
    public boolean option(char choice){
       if(choice<=numItems && choice>=1){
           return true;
       }
       return false;
    }
    /**
     * Give BOSS the option to enter own product into machine
     */
    public void setUpDispenser(){
        Scanner input = new Scanner(System.in);
        String prodName;
        double price;
        int quantity;
        for(int i = 0;i<items.length;i++){
            if(items[i]==null){
               System.out.print("Enter new product name, price and quantity: ");
                prodName = input.next();
                price = input.nextDouble();
                quantity = input.nextInt();
                items[i] = new Product(prodName,price,quantity);
               i = items.length;
            }
             numItems++;
        }
        
    }
    /**
     * Give BOSS the option to change price of desired product
     */
    public void changePrice(){
        int item;
        double newPrice;
        Scanner choose = new Scanner(System.in);
        System.out.print("Choose your item: ");
        item = choose.nextInt();
        System.out.print("Make your price: ");
        newPrice = choose.nextDouble();
        if(items[item-1]!=null){
           items[item-1] = new Product(items[item-1].getName(),newPrice,
                   items[item-1].getQuantity());  
        }
        
    }
    /**
     * Give BOSS option to restock desired product
     */
    public void restockProduct(){
        int item,newQuantity;
        Scanner choose = new Scanner(System.in);
        System.out.print("Enter item to change stock: ");
        item = choose.nextInt();
        System.out.print("Restock your item: ");
        newQuantity = choose.nextInt();
        if(items[item-1]!=null){
         items[item-1] = new Product(items[item-1].getName(),
            items[item-1].getPrice(),newQuantity + items[item-1].getQuantity());
        }
        
    }
    /**
     * Get price of chosen product from product list
     * @param choice
     * @return 
     */
    public double getPrice(char choice){
        if(option(choice)== true){
            return(items[choice].getPrice());
        }
        else
            return -1;
       
    }
    /**
     * Check if item in the vending machine is in stock
     * @param choice
     * @return 
     */
    public boolean inStock(char choice){
        if(option(choice)==true && choice>0){
            return true;
        }
        return false;
    }
    /**
     * Giving user their product if it is in stock
     * Do not return product if it is not in stock
     * @param choice
     * @return 
     */
    public int dispense(char choice){
        int quantity;
        if(inStock(choice)==true){
            quantity = getQuantity()-1;
            return 1;
               
        }
        return 0;
    }
    /**
     * Give BOSS option to remove desired product
     */
    public void deleteProduct(){
        int item;

        Scanner choose = new Scanner(System.in);
        System.out.println("Choose item to remove.");
        item = choose.nextInt();
        if(items[item-1]!=null){
            numItems -= 1;
            
        }
        items[item-1] = null;
    }
}

    