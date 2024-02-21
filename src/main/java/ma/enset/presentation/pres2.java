package ma.enset.presentation;

import ma.enset.dao.*;
import ma.enset.metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.Class.forName;

public class pres2 {
    /*
     * injection de dépendance par instanciation dynamique
     */

    /*
    * instanciation dynamique + couplage faible
    * ==> fermeture de l'application à la modification et ouverture à l'extension
     */
    public static void main(String[] args) throws Exception {

            Scanner scanner = new Scanner(new File("config.txt"));


            String daoClassName = scanner.nextLine();
            //System.out.println(daoClassName);

            //chargement dynamique de la classe en mémoire à partir de son nom
            Class cDao = Class.forName(daoClassName);
            //Object dao = cDao.newInstance(); // car newInstance() est retourné par Object
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            //il faut ajouter throws Exception car on peut ne pas trouver le constructeur
            /*
            *les trois lignes ci-dessus sont équivalentes à:
            * IDao dao = new DaoImpl();
             */


           String metierClassName = scanner.nextLine();
           Class cMetier = Class.forName(metierClassName);
           //getConestructor('type de paramètre')
           IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
           /*
           * spring framework fait la même chose que les 3 lignes ci-dessus
            */
        //l'injection de dépendance par instanciation dynamique

         // metier.setDao(dao);
        // ceci génere un problème car Imetier ne contient pas de méthode setDao
        // pour résoudre ce problème, on va utiliser la réflexion pour injecter la dépendance dynamiquement

        // injection de dépendance par réflexion
             //Method m = cMetier.getMethod("setDao", IDao.class);
        //IDao.class c'est le type de paramètre de la méthode setDao
             //m.invoke(metier, dao); //appel de la méthode setDao de l'objet metier
        /*
        MetierImpl metier=new MetierImpl();

       // System.out.println(metier.calcul());
        /*
        *équivalent à:
        MetierImpl metier=new MetierImpl();
        DaoImpl dao=new DaoImpl();
        metier.setDao(dao);
         */
        

            System.out.println(dao.getData());




    }
}
