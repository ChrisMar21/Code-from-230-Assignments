public class Recursion{
    public static void main(String[] args) {
        System.out.println(f(3));
        
        
        
    }
    public static int f(int count){
        if(count == 1)
            return 2;
        else if(count == 2)
            return -1;
        else
            return -1*f(count-1)+ 6*f(count-2);
        
    }
    
    
    
    
}
