import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class p74
{
   static Scanner sc = new Scanner(System.in);
   
   public static void main(String[] args)
   {
       
       
       double arr [] = new double [10];
       
       for (int i = 0; i < 10; i++) {
           
           arr [i] = Math.random()*(100);
           
       }
       
       double sum = sum (arr, 0, 10);
       
       double sumRec = sumRec (arr, 0);
       
       out.printf("Soma normal: %.2f\nSoma recursiva: %.2f", sum, sumRec);
       
   }
    
    public static double sum( double [ ] arr , int start , int end) { 
        assert arr != null ; 
        assert start >= 0 && start <= end && end <= arr . length ;
        double res = 0; 
        for ( int i = start ; i < end ; i++) 
            res += arr [ i ] ; 
        return res ;
    }

    public static double sumRec (double [] arr, int i) {
        
        double res = 0;
        
        assert arr != null;
        
        assert i < arr.length;
        
        if (i == arr.length) {
            
            return res;
            
        }
        
        else {
            
            res = arr[i];
            
            res += sumRec(arr , i+1);
            
        }
     
        return res; 
        
    }

}