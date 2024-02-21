package ma.enset.presentation;

import ma.enset.dao.DaoImpl;
import ma.enset.metier.IMetier;
import ma.enset.metier.MetierImpl;

public class pres1 {
    /*
    * injection de dépendance par instanciation statique
    *
     */
    public static void main(String[] args) {

        //MetierImpl metier=new MetierImpl();

       // System.out.println(metier.calcul());
        /*
        * cela va générer une exception car l'objet dao n'est pas encore initialisé
        *  ou dao n'est pas encore injecté
         */
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl(dao); // injection par le constructeur
        metier.setDao(dao); // injection de dépendance
        System.out.println(metier.calcul());

        /*
        * j'ai des classes alors je suis pas fermé à la modification
        * avec chaque modification, je dois modifier le code source
         */
    }
}
