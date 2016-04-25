import static java.lang.System.*;

public class InvertString
{
   public static void main(String[] args)
   {
      for(int i = 0; i < args.length; i++)
         out.println(args[i]+" -> "+invert(args[i]));
   }
   
   public static String invert(String palavra)
   {
     String palInvert="";
     String aux="";
     
     if(palavra.length()==0 || palavra.length()==1)
     {
       return palavra;
     }
     
     else
     {
       do{
       char a = palavra.charAt(palavra.length()-1); //ulima letra
       aux=a+aux;
       palavra=palavra.substring(1, palavra.length()-1);
       palInvert=invert(aux);
       out.println(palavra);
       }while(palavra!="");
     }
     return palInvert;
   }
}

