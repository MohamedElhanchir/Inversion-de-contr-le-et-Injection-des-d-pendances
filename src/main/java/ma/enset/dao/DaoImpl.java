package ma.enset.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
* pour dire à spring que cette classe est un bean
* on peut utiliser @Component ou @Repository ou @Service ou @Controller
 *Ceci va remplacer ceci <bean id="dao" class="ma.enset.dao.DaoImpl"></bean>
 * dans le fichier config.xml
 */

//@repository est une spécialisation de @Component pour la couche DAO
//@Component("vbdd")
@Repository
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
