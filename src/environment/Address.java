package environment;


/**
 * 对一个事物的属性进行标识
 * @author 付旭东
 *
 */
public class Address 
{
	/**
	 *作用于事物，为一类事物的统称，
	 */
	public final String name;
	/**
	 * 作用于事物，区分单个事物
	 */
	public final String id;
	/**
	 * 如果 type 为ATTRIABLE,则此属性为属性的名称
	 */
	public final String attriName;

	/**
	 * 标识元素的类型
	 */
	public  Type type;

	/**
	 * 如果 type 为FUNCTION,则此属性为函数的名称
	 *
	 * */
	public String  functionName;

	public Address(String name, String attriName, String id,Type type) {
		this.name=name;
		this.attriName = attriName;
		this.id=id;
		this.type=type;
	}


	/**
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		Address temp = (Address) obj;
		if (id.equals("")) {
			if (name.equals(temp.name) && attriName.equals(temp.attriName)) {
				return true;
			}
			return false;
		} else {
			if (name.equals(temp.name) && attriName.equals(temp.attriName)
					&& id.equals(temp.id) && type==temp.type) {
				return true;
			}
			return false;
		}
	}

}

