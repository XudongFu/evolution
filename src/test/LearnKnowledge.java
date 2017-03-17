package test;

import environment.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 付旭东 on 2017/3/16.
 */

//开来我需要加入主动函数才行，待会再加
public class LearnKnowledge {

    public static void main(String[] args)
    {
        World home=new World("homeTest");

        Thing people=new Thing("xiaoming");

        Thing lamp=new Thing("lamp");

        Thing book=new Thing("book");


        Attri bright=new Attri("bright", new Attriable() {
            @Override
            public void inite(Attri attri) {
                attri.booleanMap.put("bright",true);
            }

            @Override
            public void setValue(Attri attri, Object change) {
                attri.booleanMap.put("bright",(Boolean)change);
            }

            @Override
            public Object getValue(Attri attri) {
              return   attri.booleanMap.get("bright");
            }
        });

        Attri grade=new Attri("grade", new Attriable() {
            @Override
            public void inite(Attri attri) {

            }

            @Override
            public void setValue(Attri attri, Object change) {

            }

            @Override
            public Object getValue(Attri attri) {
                return null;
            }
        });

        people.attachAttri(grade);

        Negetivefun readBook=new Negetivefun("readBook", new Functional() {
            @Override
            public Map<Attri, Object> function(Negetivefun fun, ArrayList<Attri> desit) {
                TreeMap<Attri,Object> res=new TreeMap<>();
                for(Attri attri:desit)
                {


                }
                return  res;
            }
        });



        book.attachAttri(bright);



    }





}
