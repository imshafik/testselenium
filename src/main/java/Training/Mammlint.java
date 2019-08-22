package Training;

public class Mammlint implements iAnimal{


	public void eat() 
	{
		System.out.println("Mammel eats");
	}
	public void travel() 
	{
		System.out.println("Mammel travels");
	}

	public static void main(String[] args) {

		Mammlint M = new Mammlint() ;
		M.eat();
		M.travel();

	}
	

}
