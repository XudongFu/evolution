package test;

import environment.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 付旭东 on 2017/3/16.
 */

//开来我需要加入主动函数才行，待会再加
public class LearnKnowledge
{
    int sum=0;

    public static void main(String[] args)
    {
        LearnKnowledge l=new LearnKnowledge();

        World home=new World("homeTest");

        Thing people=new Thing("xiaoming");

        Thing lamp=new Thing("lamp");

        Thing book=new Thing("book");

       final int sum=0;

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
        book.attachAttri(bright);
        Attri grade=new Attri("grade", new Attriable() {
            @Override
            public void inite(Attri attri) {
                attri.integerMap.put("grade",60);
            }

            @Override
            public void setValue(Attri attri, Object change) {
                int grade=attri.integerMap.get("grade");
                attri.integerMap.put("grade",(int)change+grade);
            }

            @Override
            public Object getValue(Attri attri) {
                return attri.integerMap.get("grade");
            }
        });
        people.attachAttri(grade);

        Negetivefun readBook=new Negetivefun("readBook", new Functional() {
            @Override
            public Map<Attri, Object> function(Negetivefun fun, ArrayList<Attri> desit) {
                HashMap<Attri,Object> res=new HashMap<>();
                for(Attri attri:desit) {
                    res.put(attri,new Integer(10));
                    System.out.println("学习成绩增加十分，现在成绩为："+attri.getValue().toString());
                }
                return  res;
            }
        });

        //readBook

        Address gradeAddress=new Address("xiaoming","grade","",Type.ATTRIBLE);

        readBook.desti.add(gradeAddress);

        readBook.setCheck(new Checkable() {
            @Override
            public boolean check(Negetivefun fun) {
               if(l.sum<5) {
                   l.sum++;
                   return  true;
               }
               else
                   return  false;
            }
        });

        people.attachNegtiveFun(readBook);
        home.attachModleThing(people);
        home.attachModleThing(lamp);
        home.attachModleThing(book);
        home.addIntanceThingFromModel("xiaoming","xiaoming");
        home.addIntanceThingFromModel("lamp","lamp");
        home.addIntanceThingFromModel("book","book");
        System.out.println("学习世界开始运行");
        home.start();

    }

}