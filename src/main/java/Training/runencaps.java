package Training;

public class runencaps {

	public static void main(String[] args) {

		encaps encapsulate = new encaps() ;
		encapsulate.setFname("ibrahim");
		encapsulate.setIdnum("123hasa");
		encapsulate.setAge(40);
		
		System.out.println("name = "+ encapsulate.getFname());
		System.out.println("idnum = "+ encapsulate.getIdnum());
		System.out.println("age = "+ encapsulate.getAge());
		
		encaps enca = new encaps() ;

		enca.setFname("mohamed");
		enca.setIdnum("5678434");
		enca.setAge(50);
		
		System.out.println("name = "+ enca.getFname());
		System.out.println("idnum = "+ enca.getIdnum());
		System.out.println("age = "+ enca.getAge());
	}
	
	public void addotherdata()
	{
		encaps enca = new encaps() ;

		enca.setFname("mohamed");
		enca.setIdnum("5678434");
		enca.setAge(50);
		
		System.out.println("name = "+ enca.getFname());
		System.out.println("idnum = "+ enca.getIdnum());
		System.out.println("age = "+ enca.getAge());
	}
}
