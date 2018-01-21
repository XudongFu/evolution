package testthings;

import environment.ModelThing;
import environment.PositiveFunInterface;

/**
 * Created by 付旭东 on 2017/5/11.
 */
public class People extends ModelThing{
    @Override
    public String getName() {
        return "People";
    }

    @PositiveFunInterface
   public final String turnLampOn="turnLampOn";




}
