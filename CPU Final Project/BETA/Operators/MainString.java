/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList; 
import java.lang.String;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author durad3306
 */
public class MainString {
    
    public String MasterString = "";
    public double result = 0;
    private List<String> Immediate = Arrays.asList("1/X","√X", "sin");
    private List<String> Operators = Arrays.asList("×","-","+","÷","^");
    public String masterConverter = "";
    
    
    public void addToMaster(String str){
        
        if(Immediate.contains(str)){
            
            for(int i=0; i>MasterString.length(); i--){
                
                char oneLetter = MasterString.charAt(i);
                String letterString = String.valueOf(oneLetter);
                
                if(Operators.contains(letterString)) break;
                
                else{ 
                    masterConverter += letterString;
                }
            }
            
            new StringBuilder(masterConverter).reverse().toString();
                      
        }
        
        
        
        MasterString += str;
    }
    
    public void clearMaster(){
        MasterString = "";
    }
    
    public void calculate(){
        
        int DoubleCounter = 0;
        int StringCounter = 0;
        
        double tempNumber = 0;      //Todo: parse data to remove excess zeros
        
        boolean pastDecimal = false;
        int beyondDecimalCount = 0;
        
        ArrayList<Double> numbers = new ArrayList<Double>();
        ArrayList<String> operatorStorage = new ArrayList<String>();
        
        
        
        
   
        

        
        for(int i=0; i<MasterString.length(); i++){
            
            
            //look at charAt(i) for symbol
            char oneLetter = MasterString.charAt(i);
            String letterString = String.valueOf(oneLetter);
            int NumCharacter;
            
            try {
                 NumCharacter = Integer.parseInt(letterString);
            } catch (NumberFormatException e){
                 NumCharacter = 10;
            }
            
            
            //System.out.println(oneLetter);
           // System.out.println(NumCharacter);
           // System.out.println(letterString);
           // System.out.println(" ");
            
            
            //check decimal first
            if(letterString.equals(".")){                
                pastDecimal = true;                
            }
            
            
            if(Operators.contains(letterString)){ //check if operator, if so, send the temp number to the array and clear it, add counter, etc..
                
                //todo: fix if user inputs a decimal after operator
                operatorStorage.add(letterString);
                numbers.add(tempNumber);
               // System.out.println(tempNumber);
                tempNumber = 0;
                beyondDecimalCount = 0;
                pastDecimal = false;
                
            }
            
            
            if(NumCharacter>=0 && NumCharacter <=9){                
                
                if(pastDecimal == true){
                    beyondDecimalCount++;
                    tempNumber = ((tempNumber * (Math.pow(10, beyondDecimalCount))) + NumCharacter)/(Math.pow(10, beyondDecimalCount));
                } else{
                    tempNumber = (tempNumber * 10) + NumCharacter; //Add to temp number 
                    
                }
                                      
            }
            //System.out.println(i);
            //System.out.println(tempNumber);    
        }
        
        numbers.add(tempNumber);
        
        //for(int i=0; i<operatorStorage.size(); i++) System.out.println(operatorStorage.get(i));
        //for(int i=0; i<numbers.size(); i++) System.out.println(numbers.get(i));
        
        ArrayBae arrays = new ArrayBae();
        double s = arrays.Bae(numbers, operatorStorage);
        System.out.println(s);
        this.result = s;
    }
    
    public static void main(String[] args) {
        //String str = "abc";
        //System.out.println(str.charAt(0));
        //MainString test = new MainString();
       // test.calculate();
        String test = new StringBuilder("hello").reverse().toString();
        System.out.println(test);
        
    }
    
    
}


//number[1] (operator)[1] number[n+1]