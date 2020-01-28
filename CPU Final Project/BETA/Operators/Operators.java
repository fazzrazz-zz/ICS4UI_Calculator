/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author durad3306
 */
public class Operators {
    
    public static String multiplication(double x, double y){        
        return String.valueOf(x * y);       
    }
    
    public static String addition(double x, double y){
        return String.valueOf(x + y);
    }
    
    public static String subtraction(double x, double y){
        return String.valueOf(x - y);
    }
    
    public static String division(double x, double y){
         if (y!=0) return String.valueOf(x / y);
         else return "error";
    }
    
    public static String power(double x, double y){
        return String.valueOf(Math.pow(x, y));
    }
    
    public static double root(double x){
        return Math.sqrt(x);
    }
    
    public static double inverse(double x){
        return 1/x;
    }
}

//todo, immediate buttons


