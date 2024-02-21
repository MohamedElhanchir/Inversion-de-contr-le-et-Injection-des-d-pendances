package ma.enset.dao;

import org.springframework.stereotype.Component;

//@Component("vws")
public class DaoImplV2 implements IDao{
    @Override
    public double getData() {

        System.out.println("version web service");
        return 45;
    }
}
