package environment;

/**
 * Created by 付旭东 on 2017/4/13.
 * 还需要描述很多东西，暂时想不到，错误发生之后有很多需要处理的，不一定就这一种情况。
 * */
public class BaseExcepton extends  RuntimeException
{
        /**
         * 想要达到的状态
         */
        Condition desire;

        /**
         * 导致情况发生的目前的状态
         */
        Condition current;

        /**
         * 导致情况发生的属性或者是函数，
         * 有可能之后会被废除。
         */
        Address cause;

        /**
         * 错误记录来自哪里？
         */
        Address from;


        public  BaseExcepton(Condition desire,Condition current,Address cause)
        {
                this.desire=desire;
                this.current=current;
                this.cause=cause;
        }



}
