package ConstructWay;

/**
 * 获取到指定节点的距离
 * @param <T>
 */
public interface IDistance<T> {

   default int GetDistanct(T node ) {
        return  WayNode.infinityDistance;
   }

}
