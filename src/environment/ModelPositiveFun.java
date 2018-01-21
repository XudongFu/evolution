package environment;

import java.util.ArrayList;

/**
 * Created by 付旭东 on 2017/5/11.
 */
public abstract class ModelPositiveFun implements Functional {

    public abstract String getName();

    public abstract ArrayList<Address> getSrc();

    public abstract ArrayList<Address> getDesit();
}
