package ConstructWay;

import java.util.ArrayList;

public class WayNode {

    public IDistance node;
    public int Distance;

    public WayNode(IDistance node , int distance)
    {
        this.node=node;
        this.Distance=distance;
    }

    /**
     * 代表两个节点的距离是无限距离
     */
    public static final  int infinityDistance = -1;
}
