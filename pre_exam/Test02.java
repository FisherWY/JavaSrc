package pre_exam;
public class Test02 {	 

	public static void main(String[] args) {			
		ProMmanager p = new ProMmanager("jon",50,'男',"CEO",2222222222l); //补充完整构造函数 ------------#1 (5分)；
        System.out.println(p.toString());        
	}
}

class ProMmanager{  //职业经理人
	
	private String name ;
	private int age ;
	private char gender; //性别
	private String profession; //职业
	private  long wealth ; //财富
	
	public ProMmanager(String name, int age, char gender, String profession,
			long wealth) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender; //性别
		this.profession = profession;//职业
		this.wealth = wealth;  //财富
	}

	@Override
	public String toString() {
		return  "职业经理人[姓名="+name+"，年龄="+age+"，性别="+gender+"，职业="+profession;//补充完成，调用时返回对象的所有属性。  ---------------------#2  (5分)
	}
	
	
	}

