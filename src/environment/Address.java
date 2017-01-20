package environment;


/**
 * 对一个事物的属性进行标识
 * @author 付旭东
 *
 */
public class Address 
{
	public final String name;
	public final String type;
	public final String id;
	
	public Address(String name,String type,String id) {
		this.name=name;
		this.type=type;
		this.id=id;
	}
	
	
	@Override
	public boolean equals(Object obj) {

		Address temp = (Address) obj;
		if (id.equals("")) {
			if (name.equals(temp.name) && type.equals(temp.type)) {
				return true;
			}
			return false;
		} else {
			if (name.equals(temp.name) && type.equals(temp.type)
					&& id.equals(temp.id)) {
				return true;
			}
			return false;
		}
	}
	
	

}
