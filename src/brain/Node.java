package brain;

import java.util.ArrayList;

/**
 * 
 * @author ����
 *�����������������ģ������ˣ�
 *�ڵ��൱��һ�����
 * @param <T>
 */
public class Node<T> 
{
	T self;
	ArrayList<T> relationship;
	public Node(T node,ArrayList<T> relation) 
	{
		self=node;
		if(relation.contains(node))
			throw new RuntimeException("�ڵ㴴��ʧ�ܣ��ڵ�Ĵ������Լ�Ϊǰ������");
		relationship=relation;
	}
}
