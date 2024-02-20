package ma.enset.metier;

import ma.enset.dao.IDao;

public class MetierImpl implements IMetier{

    /*
    * couplage faible
     */
    private IDao dao;

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
