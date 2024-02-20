package ma.enset.dao;


import org.springframework.stereotype.Component;

/*
* pour dire à spring que cette classe est un bean
* on peut utiliser @Component ou @Repository ou @Service ou @Controller
 *Ceci va remplacer ceci <bean id="dao" class="ma.enset.dao.DaoImpl"></bean>
 * dans le fichier config.xml
 */
@Component("vbdd")
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        /*
        * connect to the database
         */
        System.out.println("version base de données");
        return 98;
    }
}
