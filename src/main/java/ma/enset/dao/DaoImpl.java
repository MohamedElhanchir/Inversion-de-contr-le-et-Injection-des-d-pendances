package ma.enset.dao;

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
