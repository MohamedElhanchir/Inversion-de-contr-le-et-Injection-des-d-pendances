# TP Inversion de Contrôle et Injection des dépendances
 _Ce travail a été réalisé par ELHANCHIR Mohamed GLSID2 sous la supervision de M. Mohamed Youssfi._
 
## Introduction à l'Inversion de Contrôle (IoC) et à l'Injection de Dépendances (DI)
* Bienvenue dans ce guide d'introduction à l'Inversion de Contrôle (IoC) et à l'Injection de Dépendances (DI). Ces concepts fondamentaux en développement logiciel jouent un rôle essentiel dans la création d'applications flexibles, maintenables et évolutives.

* L'Inversion de Contrôle (IoC) représente un changement de perspective par rapport à la manière traditionnelle de concevoir des applications. Plutôt que d'avoir le contrôle direct sur le flux d'exécution, l'IoC délègue ce contrôle à un conteneur ou un framework. Cela permet une meilleure modularité et facilite la gestion des composants logiciels.

* L'Injection de Dépendances (DI) est un sous-ensemble de l'IoC qui se concentre sur la manière dont les composants d'une application obtiennent leurs dépendances. Plutôt que de créer ces dépendances localement, elles sont injectées depuis l'extérieur. Cela favorise la séparation des préoccupations, rendant les composants plus autonomes et réutilisables.

## Objectif du TP : Exploration des Concepts d'IoC et de DI avec Spring

Dans le cadre de ce TP, l'objectif est de se familiariser avec les concepts d'Inversion de Contrôle (IoC) et d'Injection de Dépendances (DI) en mettant en œuvre différentes approches de couplage faible via Spring. on aura l'occasion d'explorer quatre méthodes indépendantes d'injection de dépendances :

1. **Injection de Dépendance par Instanciation Statique**
2. **Injection de Dépendance par Instanciation Dynamique à Partir d'un Fichier TXT**
3. **Injection de Dépendance par Instanciation Dynamique à Partir du Clavier**
4. **Injection de Dépendance par Spring Framework à Partir des Annotations**
5. **Injection de Dépendance par Spring Framework à Partir d'un Fichier XML**

## Conception
![Diagramme](https://private-user-images.githubusercontent.com/102546164/306460917-297a95e9-0c01-4655-850c-4b13009f89f3.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDg0NzgzMzUsIm5iZiI6MTcwODQ3ODAzNSwicGF0aCI6Ii8xMDI1NDYxNjQvMzA2NDYwOTE3LTI5N2E5NWU5LTBjMDEtNDY1NS04NTBjLTRiMTMwMDlmODlmMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjIxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIyMVQwMTEzNTVaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01YWU5YmFjODMyNWM0ODBhOTc1NzM0NTFiMWNkYTljNmU2NTZiM2I5NWYwNDcxMzY5MzMwMjY3NWQ3NGEwMWYyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.RFc2zF1TsSTiolb0qbC78mZ15fwUxt97RNwY4-CK12c)

## Code Source et Captures d'Écran
1. **Injection de Dépendance par Instanciation Statique**
```java
package ma.enset.presentation;
import ma.enset.dao.DaoImpl;
import ma.enset.metier.IMetier;
import ma.enset.metier.MetierImpl;
public class pres1 {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl(dao); // injection par le constructeur
      //  metier.setDao(dao); // injection de dépendance
        System.out.println(metier.calcul());
    }
}
```
- ###### `Exécution` :
![Instanction Statique](https://private-user-images.githubusercontent.com/102546164/306464532-79851a22-6032-4d10-b0c1-ae026e5a8877.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDg0Nzk4MzYsIm5iZiI6MTcwODQ3OTUzNiwicGF0aCI6Ii8xMDI1NDYxNjQvMzA2NDY0NTMyLTc5ODUxYTIyLTYwMzItNGQxMC1iMGMxLWFlMDI2ZTVhODg3Ny5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjIxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIyMVQwMTM4NTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1lOGM1Yjc2MGY2NjcyNmIyZjNkYTcwNDEwMTMyM2Q5NDNkMzhmN2EzZTM1ZThmOWM1NGUyZGZlN2Y0ZTVhMmQ1JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.6cmVg-OZFKXPPhVhJYywSkyOd0-Nz9xHhfwCZByJKtg)

2. **Injection de Dépendance par Instanciation Dynamique à Partir d'un Fichier TXT**
```java
package ma.enset.presentation;
import ma.enset.dao.*;
import ma.enset.metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
import static java.lang.Class.forName;
public class pres2 {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
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
```
- `Config.txt`
```txt
ma.enset.dao.DaoImplV2
ma.enset.metier.MetierImpl
```
- ###### `Exécution` :
![Instanction Statique](https://private-user-images.githubusercontent.com/102546164/306464816-c449f25b-7f2d-49e4-9f07-4d65d1eb47e4.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDg0Nzk4MzYsIm5iZiI6MTcwODQ3OTUzNiwicGF0aCI6Ii8xMDI1NDYxNjQvMzA2NDY0ODE2LWM0NDlmMjViLTdmMmQtNDllNC05ZjA3LTRkNjVkMWViNDdlNC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjIxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIyMVQwMTM4NTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03NzkxYTUyNTdkZjZlODg1MGZmNDNlYjk2MTlhMzc1OTJkZThkNDhiYzllNzE4MTQxNGFiMDI3MjI0NjE2MWVkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.GBbeBD9XelsT-ZpntRC9xjfVLk3tR9V2BIsryK_z6ew)

3. **Injection de Dépendance par Instanciation Dynamique à Partir du Clavier**
```java
package ma.enset.presentation;
import ma.enset.dao.IDao;
import ma.enset.metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
public class pres3 {
    /*
     * injection de dépendance par instanciation dynamique à partir de clavier
     */
    /*
    * instanciation dynamique + couplage faible
    * ==> fermeture de l'application à la modification et ouverture à l'extension
     */
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);

            System.out.println("donner le nom de la classe Dao: ");
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            

           System.out.println("donner le nom de la classe Metier: ");
           String metierClassName = scanner.nextLine();
           Class cMetier = Class.forName(metierClassName);
           
           IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            System.out.println(dao.getData());
    }
}
```
- ###### `Exécution` :
 ![Instanction Dynamique fichier txt](https://private-user-images.githubusercontent.com/102546164/306467533-48ee684d-e644-42c3-adef-17f737a7b533.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDg0ODA3NzIsIm5iZiI6MTcwODQ4MDQ3MiwicGF0aCI6Ii8xMDI1NDYxNjQvMzA2NDY3NTMzLTQ4ZWU2ODRkLWU2NDQtNDJjMy1hZGVmLTE3ZjczN2E3YjUzMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjIxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIyMVQwMTU0MzJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05Y2QxMGE4ZDY2MzEyMGM3MzY2MzRjMWI5MDA4ZDkwZmI1ZWY5ZTUwMmRjYTE2NDkwNzgzZDM2ZTU5YTQ5NDQyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.QmpNwmtA-vLM7m8cAzkIrr7bnhKG0CUV5e-fYVNhUWo)

4. **Injection de Dépendance par Spring Framework à Partir des Annotations**
```java
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
```
- ###### `Exécution` :
 ![spring annotation](https://private-user-images.githubusercontent.com/102546164/306467614-43e3a747-f5c1-41d7-8503-4097dca585e5.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDg0ODA3NzIsIm5iZiI6MTcwODQ4MDQ3MiwicGF0aCI6Ii8xMDI1NDYxNjQvMzA2NDY3NjE0LTQzZTNhNzQ3LWY1YzEtNDFkNy04NTAzLTQwOTdkY2E1ODVlNS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjIxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIyMVQwMTU0MzJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT02NGZlMDdhNTIyZGNjNDYyODViM2Y3MjA0ZGJiN2E1M2FhNTU1NzUxM2QwYjU2ZDVkMmI2Zjg5MGE0NTM0NDg2JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.bFsbNkcQVv742Q72Dt6hbJewiK-3Pad6FTYx_n67SbE)

5. **Injection de Dépendance par Spring Framework à Partir d'un Fichier XML**
```java
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
```
- `config.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dao" class="ma.enset.dao.DaoImpl"></bean>
    <bean id="metier" class="ma.enset.metier.MetierImpl">
        <!-- ceci utilise le constructeur par défaut
         maintenat le constructeur par déf est annulé-->
<!--    <property name="dao" ref="dao"></property>-->
        <constructor-arg ref="dao"></constructor-arg>
    </bean>
</beans>
```

- ###### `Exécution` :
 ![spring xml](https://private-user-images.githubusercontent.com/102546164/306467661-2d6f7f72-7b6b-4762-9e30-ca50f31b3b7d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDg0ODA3NzIsIm5iZiI6MTcwODQ4MDQ3MiwicGF0aCI6Ii8xMDI1NDYxNjQvMzA2NDY3NjYxLTJkNmY3ZjcyLTdiNmItNDc2Mi05ZTMwLWNhNTBmMzFiM2I3ZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjIxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIyMVQwMTU0MzJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yMzkzZDc1NjAyMzVmMjczMjY3NmFkM2EwZWRhMzhhYjQ4OGFhNzhkYzU3ODRmMGMyNWIwZWFlYzVlZjA1ZDJmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.JlblBfLUUO04gGj4EMiP-5cMNtJlQKjuvfbH7lV8ihc)

## Conclusion
En synthèse, ce TP a fourni une base solide pour la compréhension et l'application efficace de l'IoC et de la DI dans des projets Spring, encourageant ainsi l'adoption de pratiques de développement favorisant la flexibilité et la robustesse des applications.







