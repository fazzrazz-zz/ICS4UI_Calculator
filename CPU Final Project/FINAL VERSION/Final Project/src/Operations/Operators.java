/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

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
    
    public static String root(double x){
        return String.valueOf(Math.sqrt(x));
    }
    
    public static String inverse(double x){
        return String.valueOf(1/x);
    }
    
    public static String sine(double x){
        x = Math.toRadians(x);
        
        return String.valueOf(Math.sin(x));
    }
    public static void main(String[] args) {
        System.out.println(sine(5));
    }
}


//todo, immediate buttons


