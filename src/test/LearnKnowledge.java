package test;

import environment.*;
import java.util.ArrayList;
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
        代码好像写的差不多了，

        我可以写一写代码来测试一下了，试一下构建代码的能力

    * */

    public static void main(String[] args)
    {
        LearnKnowledge l=new LearnKnowledge();

        World home=new World("homeTest");

        Thing xiaoming=new Thing("xiaoming");

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

        xiaoming.attachAttri(bright);
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

        xiaoming.attachAttri(grade);


        // 需要先检查源属性，自己的亮度，如果亮度为暗，那么就返回一个错误， 继承自baseException，
        PositiveFun learn=new PositiveFun("readBook", new Functional() {
            @Override
            public Map<Attri, Object> function(BaseFunction fun, ArrayList<Attri> desit) {

                return null;
            }
            @Override
            public Tentacle getTentacle() {
                return null;
            }
        });

        learn.desti.add(grade.getAddress());
        xiaoming.attachPositiveFun(learn);


        PositiveFun turnLampOn=new PositiveFun("turnLampOn", new Functional() {
            @Override
            public Map<Attri, Object> function(BaseFunction fun, ArrayList<Attri> desit) {
                return null;
            }

            public Tentacle getTentacle() {return  null;}

        });



        xiaoming.attachPositiveFun(learn);
        xiaoming.attachPositiveFun(turnLampOn);
        home.attachModleThing(xiaoming);
        home.attachModleThing(lamp);
        home.attachModleThing(book);
        home.addIntanceThingFromModel("xiaoming","xiaoming");
        home.addIntanceThingFromModel("lamp","lamp");
        home.addIntanceThingFromModel("book","book");
        System.out.println("学习世界开始运行");
        home.start();

        xiaoming.invokePositiveFun("learn");
        xiaoming.invokePositiveFun("learn");
        xiaoming.invokePositiveFun("learn");
        xiaoming.invokePositiveFun("learn");
        xiaoming.invokePositiveFun("learn");

    }

}