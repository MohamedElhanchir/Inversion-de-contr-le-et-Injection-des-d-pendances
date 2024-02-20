package ma.enset.presentation;

import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringVersXml {
    /*
     * injection de dépendance par spring framework à partir d'un fichier xml
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = ctx.getBean(IMetier.class);
        /*
        * équivalent à : IMetier metier = (IMetier) ctx.getBean("metier");
         */
        System.out.println(metier.calcul());

    }
}
