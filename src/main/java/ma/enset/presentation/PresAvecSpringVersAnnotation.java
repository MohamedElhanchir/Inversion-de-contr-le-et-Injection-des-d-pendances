package ma.enset.presentation;

import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresAvecSpringVersAnnotation {
    /*
     * injection de dépendance et l'instanciation des objets par spring framework à partir des annotations
     */
    public static void main(String[] args) {
        /*
        * il faut indiquer à Spring le package où il doit chercher les classes
         */
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ma.enset.dao","ma.enset.metier");
        IMetier metier = ctx.getBean(IMetier.class);
        //IMetier metier2 = (IMetier) ctx.getBean("metier");
        System.out.println(metier.calcul());
    }
}
