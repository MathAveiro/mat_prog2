import static java.lang.System.*;

public class exercicio34
{
   public static void main(String[] args)
   {
      Agenda34 agenda = new Agenda34();
      agenda.novaNota(new Nota34(new Data34(14,6,2012), new Data34(27,6,2012), "Prog2: APF"));
      agenda.novaNota(new Nota34(new Data34(2,7,2012), new Data34(13,7,2012), "Prog2: Recurso"));
      agenda.novaNota(new Nota34(new Data34(6,6,2012), new Data34(6,6,2012), "Prog2: ACITP2"));
      agenda.novaNota(new Nota34(new Data34(9,5,2012), new Data34(9,5,2012), "Prog2: AIP"));
      agenda.novaNota(new Nota34(new Data34(22,3,2012), new Data34(27,3,2012), "Prog2: ACITP1"));
      agenda.funcaoEscrever();
      out.println();
      Data34 d1 = new Data34(27,3,2012);
      Data34 d2 = new Data34(15,6,2012);
      Nota34[] todo = agenda.compromissos(d1, d2);
      out.print("Compromissos de ");
      d1.funcaoEscrever();
      out.print(" a ");
      d2.funcaoEscrever();
      out.println(":");
      for(int i = 0; i < todo.length; i++)
        todo[i].funcaoEscrever();
   }
}