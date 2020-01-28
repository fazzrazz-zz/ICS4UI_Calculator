/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author durad3306
 */
public class ArrayBae extends MainString {
    
    public double Bae(ArrayList<Double> numbers, ArrayList<String> operators){
        
        //loop for the length of the longest array
        
       /* int biggerArray;
        if(numbers.size() > operators.size()){
            biggerArray = numbers.size();
        } else biggerArray = operators.size(); */
        
        
        for(int i=0; i<=operators.size(); i++){ //Do I only need to loop for the length of the operators? can't loop for more variations than there are operators(?)
            //System.out.println(i);
            int position = 100;
            String symbol = "E";
            
            int powerPosition = operators.indexOf("^");
            if(powerPosition != -1){
                symbol = "^";
                position = powerPosition;               
           } else if(operators.indexOf("×") != -1 || operators.indexOf("÷") != -1){
              
               if(operators.indexOf("×") > operators.indexOf("÷")){
                   symbol = "×";
                   position = operators.indexOf("×");
               } else{ 
                   symbol = "÷";
                   position = operators.indexOf("÷");
               }             
           } else if(operators.indexOf("+") != -1 || operators.indexOf("-") != -1){
              
               if(operators.indexOf("+") > operators.indexOf("-")){
                   symbol = "+";
                   position = operators.indexOf("+");
               } else{ 
                   symbol = "-";
                   position = operators.indexOf("-");
               } 
                                                       
           }
            
           // System.out.println(symbol);
           // String symbol = operators.get(i);
          
            double firstAdjacent = numbers.get(position);
            double secondAdjacent = numbers.get(position+1);
            
            String result = useOperators(firstAdjacent, secondAdjacent, symbol);
            double dresult = 0;
            if(result.equals("error")){
                 
            } else {
                 dresult = Double.valueOf(result);
            }
            
            operators.set(position, null);
            numbers.set(position, dresult);
            numbers.set(position + 1, null);
            
            while (operators.remove(null)) {}
            while (numbers.remove(null)) {}
            //set operator in that position to null
            //set numbers at [i] to result, set numbers[i+1] to null
            //delete all the null from arraylist
            
            //ORDER OF OPERATIONS???
            //What happens when inverse or sqrt button is pressed? modify string on ethans side?
            
        }
               
        //set num[+1] to null
        //search through for null to delete obj
        
        return numbers.get(0);
        
    }
    
    
    public static String useOperators(double firstAdjacent, double secondAdjacent, String symbol){
        
        if(symbol.equals("×")) return Operators.multiplication(firstAdjacent, secondAdjacent);
        
        if(symbol.equals("+")) return Operators.addition(firstAdjacent, secondAdjacent);
        
        if(symbol.equals("-")) return Operators.subtraction(firstAdjacent, secondAdjacent);
        
        if(symbol.equals("÷")) return (Operators.division(firstAdjacent, secondAdjacent));
        
      
        
        return "error";
    }
    
    
       
    
    
    
}
