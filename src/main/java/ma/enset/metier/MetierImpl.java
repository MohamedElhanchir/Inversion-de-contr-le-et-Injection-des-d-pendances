package ma.enset.metier;

import ma.enset.dao.IDao;

public class MetierImpl implements IMetier{

    /*
    * couplage faible
     */
    private IDao dao;

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
