
import static java.lang.System.*;

public class Person {

   private String name;
   private String profession;
   private int birthYear;

   /**
    * Construtor de Person.
    * @param name Nome da pessoa
    * @param birthYear Ano de nascimento
    * @param profession Profissao
    */
   public Person(String name,int birthYear,String profession) {
      this.name = name;
      this.birthYear = birthYear;
      this.profession = profession;
   }

   /**
    *  Devolve o nome da pessoa
    */
   public String name() { return name; }

   /**
    *  Devolve o ano de nascimento da pessoa.
    */
   public int birthYear() { return birthYear; }

   /**
    *  Devolve a profissao da pessoa.
    */
   public String profession() { return profession; }

}

