package testthings;

import environment.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 付旭东 on 2017/5/11.
 */
public class TurnLampOn extends ModelPositiveFun {
    @Override
    public String getName() {
        return "TurnLampOn";
    }

    @Override
    public ArrayList<Address> getSrc() {
        return null;
    }

    @Override
    public ArrayList<Address> getDesit() {
        return null;
    }

    @Override
    public Map<Attri, Object> function(BaseFunction fun, ArrayList<Attri> desit) {
        return null;
    }

    @Override
    public Tentacle getTentacle(BaseFunction fun) {
        return null;
    }
}
