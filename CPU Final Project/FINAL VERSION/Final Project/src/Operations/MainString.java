/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;


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
            
            for(int i=MasterString.length(); i>0; i--){
                
                char oneLetter = MasterString.charAt(i-1);
                String letterString = String.valueOf(oneLetter);
                
                if(Operators.contains(letterString)) break;
                
                else{ 
                    masterConverter += letterString;
                }
            }
            
            masterConverter = new StringBuilder(masterConverter).reverse().toString();
            
           
            
            MasterString = MasterString.substring(0, Math.min(MasterString.length(), MasterString.length())-masterConverter.length());
                       
            double previousDouble = Double.valueOf(masterConverter);
            
            String immediateResult = ArrayBae.useOperators(previousDouble, str);
            
            MasterString += immediateResult;
            masterConverter = "";

        }
        
        
        
        MasterString += str;
    }
    
 
    
    public void clearMaster(){
        MasterString = "";
    }
    
    public void calculate(){
        

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
            
            

            if(letterString.equals(".")){                
                pastDecimal = true;                
            }
            
            
            if(Operators.contains(letterString)){ //check if operator, if so, send the temp number to the array and clear it, add counter, etc..

                operatorStorage.add(letterString);
                numbers.add(tempNumber);

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

        }
        
        numbers.add(tempNumber);

        
        ArrayBae arrays = new ArrayBae();
        double s = arrays.Bae(numbers, operatorStorage);
        System.out.println(s);
        this.result = s;
    }
    

    }
    
    
}


