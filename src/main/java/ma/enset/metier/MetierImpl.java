package ma.enset.metier;

import ma.enset.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service est une spécialisation de @Component pour la couche métier
//@Component("metier")
@Service("metier")
public class MetierImpl implements IMetier{

    /*
    * couplage faible
     */
    /*@Autowired est une annotation qui permet d'injecter une dépendance
    * dans ce cas on injecte un objet de type IDao
    * Spring va chercher un objet de type IDao dans le contexte de l'application
    * et l'injecter dans la variable dao
    * mais cette annotation est dépréciée alors on peut faire l'injection par le constructeur
     */
    /*
    * il faut ajouter @qualifier pour dire à spring quel bean il doit injecter
     */


    //@Autowired
    //@Qualifier("vws")
    private IDao dao;

    /*
    * injection de dépendance par le constructeur
     */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    /*
    * Pour permettre dans le variable dao de recevoir un objet de type IDao
    * on peut utiliser le constructeur ou la méthode setDao pour injecter la dépendance
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double d=dao.getData();
        double res=d*23;
        return res;
    }
}
