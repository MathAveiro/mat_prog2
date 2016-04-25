import static java.lang.System.*;

public class p33
{
   public static void main(String[] args)
   {
      Nota33[] notas = new Nota33[args.length / 7]; // argumentos em grupos de sete (data-inicio data-fim texto)
      for(int i = 0; i < notas.length; i++)
      {
         int dia, mes, ano;
         dia = Integer.parseInt(args[i*7]);
         mes = Integer.parseInt(args[i*7+1]);
         ano = Integer.parseInt(args[i*7+2]);
         Data33 inicio = new Data33(dia, mes, ano);
         dia = Integer.parseInt(args[i*7+3]);
         mes = Integer.parseInt(args[i*7+4]);
         ano = Integer.parseInt(args[i*7+5]);
         Data33 fim = new Data33(dia, mes, ano);
         String texto = args[i*7+6];
         notas[i] = new Nota33(inicio, fim, texto);
      }
      for(int i = 0; i < notas.length; i++)
         notas[i].escreve();
   }
}

