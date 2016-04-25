
import static java.lang.System.*;
import java.io.*;


public class TestSocialNetwork
{

   public static void main(String[] args)
   {
      String[] names = { "Joao","Anna","Nuno","Luis","Carlos",
                         "Antonio","Jose","Susana","Rosa","Odete",
                         "Amelia","Mario","Afonso","Leonor",
                         "Irene" };
      String[] professions = 
                       { "medico","engenheiro","professor",
                         "decorador","enfermeiro","juiz", "actor",
                         "carpinteiro","politico","padeiro",
                         "cabeleireiro","pastor","agricultor" };

      SocialNetwork sn = new SocialNetwork ();
      
      if (args.length != 0) {

        int args1 = Integer.parseInt(args[0]);
        int args2 = Integer.parseInt(args[1]);

        sn = new SocialNetwork(args1, args2);

      }

      out.println("sn.numMembers()=" + sn.numMembers());
      for(int i=0; i<names.length; i++) {
         int y = 1995-myRandom(35);
         String prof = professions[myRandom(professions.length)];
         sn.addMember(new Person(names[i],y,prof));
      }
      out.println();
      TypeProfCount [] tiposdeProf = sn.getTypeProfCount(professions);
      out.println("sn.numMembers()=" + sn.numMembers());

      out.printf("\n");

      Person [] a = sn.getPerson();      

      Friends [] fp = new Friends [15];

      fp [0] = new Friends (a[13], a[0]);
      fp [1] = new Friends (a[12], a[14]);
      fp [2] = new Friends (a[11], a[2]);
      fp [3] = new Friends (a[10], a[12]);
      fp [4] = new Friends (a[9], a[4]);
      fp [5] = new Friends (a[8], a[10]);
      fp [6] = new Friends (a[7], a[6]);
      fp [7] = new Friends (a[6], a[8]);
      fp [8] = new Friends (a[5], a[7]);
      fp [9] = new Friends (a[4], a[5]);
      fp [10] = new Friends (a[3], a[11]);
      fp [11] = new Friends (a[2], a[3]);
      fp [12] = new Friends (a[1], a[13]);
      fp [13] = new Friends (a[0], a[1]);
      fp [14] = new Friends (a[11], a[9]);

      for (int v = 0; v < fp.length ; v++) {
        
        out.printf("%s e %s são amigos.\n", fp[v].pessoa1(), fp[v].pessoa2());

      }

      out.println("---------------------------------------------------------------");


      for (int o = 0; o < a.length; o++) {

        out.println(a[o].name() + " " + a[o].birthYear() + " " + a[o].profession());

      }

      int i = myRandom(names.length);

      out.println("---------------------------------------------------------------");

      out.printf("Dado um número aleatório:\n");

      out.printf("%d\t%s\t%d\t%s\n",sn.membersIndexIs(names[i+1]),names[i],sn.getPersonBirth(i),sn.getPersonProf(i));

      out.println("---------------------------------------------------------------");

      out.printf("Tipos de profissão:\n");
      for (int u = 0; u < professions.length ; u++) {
        
        out.printf("%s: %d\n",tiposdeProf[u].prof, tiposdeProf[u].count);

      }

      out.println("---------------------------------------------------------------");

      for (int b = 0; b < fp.length ; b++) {
        
        if (fp[b].trabalhopessoa1().equals(fp[b].trabalhopessoa2())) {

          out.printf ("%s e %s têm o trabalho %s em comum.\n", fp[b].pessoa1(), fp[b].pessoa2(), fp[b].trabalhopessoa1());

        }

      }
   }

   /**
    * Retorna um número aleatório entre 0 e n-1.
    */
   static int myRandom(int n) {
      return (int)(Math.random()*n);
   }
}