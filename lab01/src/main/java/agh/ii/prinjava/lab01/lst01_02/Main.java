package agh.ii.prinjava.lab01.lst01_02;

import java.math.BigDecimal;
import java.util.List;

/**
 * Inheritance demo
 */
public class Main {
    public static void main(String[] args) {
        RichDad richDad = new RichDad("R", "Doe", BigDecimal.valueOf(1), List.of("School Mate"));
        richDad.increaseWealth();
        //...

        RichDadsKid richDadsKid =
                new RichDadsKid("Mike", richDad.surname, richDad.getFortune(), richDad.getContacts());
        //...
        richDadsKid.setUpSuccessfulCompany();
        richDadsKid.increaseWealth();
        System.out.println("RichDad\nName : " + richDad.getName() + "\nSurname : " + richDad.getSurname() + "\nFortune : " + richDad.getFortune() + "\nContacts : " + richDad.getContacts());
        System.out.println("\nRichDadKid\nName : " + richDadsKid.getName() + "\nSurname : " + richDadsKid.getSurname() + "\nFortune : " + richDadsKid.getFortune() + "\nContacts : " + richDadsKid.getContacts());
    }
}
