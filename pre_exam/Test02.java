package pre_exam;
public class Test02 {	 

	public static void main(String[] args) {			
		ProMmanager p = new ProMmanager("jon",50,'��',"CEO",2222222222l); //�����������캯�� ------------#1 (5��)��
        System.out.println(p.toString());        
	}
}

class ProMmanager{  //ְҵ������
	
	private String name ;
	private int age ;
	private char gender; //�Ա�
	private String profession; //ְҵ
	private  long wealth ; //�Ƹ�
	
	public ProMmanager(String name, int age, char gender, String profession,
			long wealth) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender; //�Ա�
		this.profession = profession;//ְҵ
		this.wealth = wealth;  //�Ƹ�
	}

	@Override
	public String toString() {
		return  "ְҵ������[����="+name+"������="+age+"���Ա�="+gender+"��ְҵ="+profession;//������ɣ�����ʱ���ض�����������ԡ�  ---------------------#2  (5��)
	}
	
	
	}

