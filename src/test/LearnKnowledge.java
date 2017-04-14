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

    /*
    *   小明启动主动函数进行学习， 自己变暗了，然后学习失败，
        然后学习函数需要提交自己学习失败的原因（灯变暗了），以及想要的某些状态
        （自己的亮度为亮），（开灯也是一个主动函数，主动函数才是路径搜索过程中，可以
        调用的函数，被动函数不能被调用）。小明这个时候可以启动自己的路径搜索工具，建立到达
        学习提出的目的状态的路径并且执行。
    * */



    public static void main(String[] args)
    {
        LearnKnowledge l=new LearnKnowledge();

        World home=new World("homeTest");

        Thing people=new Thing("xiaoming");

        // 灯需要增加一个开关属性，人可以改变开关属性，开关属性的改变会引发被动函数（灯发光）的启动，
        // 被动函数启动后，会引发书本的亮度改变，亮度改变人才可以进行学习，
        // 学习中不需要自身去实现打开灯光这个目的，而是需要系统进行学习，自己认识到他们之间存在的联系才可以。

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

        people.attachAttri(bright);
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

        /**
         * 学习函数中，其中应该包含一个目的，使得书本的亮度为亮，建立事物的状态，
         */
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

        /**
         * 读书添加源属性，表示要监听书本的亮度变化，当亮度为暗的时候，
         */
        readBook.src.add(new Address("xiaoming","bright","",Type.ATTRIBLE));

        //当书本的亮度发生的时候，需要提交一个灯光异常。事物需要捕获这个异常，



        Negetivefun turnLampOn=new Negetivefun("turnLampOn", new Functional() {
            @Override
            public Map<Attri, Object> function(Negetivefun fun, ArrayList<Attri> desit) {
                return null;
            }
        });

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
        people.attachNegtiveFun(turnLampOn);
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