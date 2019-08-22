package Training;

public class string {
	
static int youngage = 18 ;

public static int age = 5;

	public void methodone ()

	{
		

		System.out.println("How old are you ? " + age );
	}
	public void methodtwo (int agetwo)

	{
		int age =39;
		

		System.out.println("How old are you second question  ? " + age );
		System.out.println("How old are you second question  ? " + agetwo );

	}

	public static void main(String[] args) {
		
		string testlocalvar = new string () ;
		testlocalvar.methodone();
		testlocalvar.methodtwo(396);
		System.out.println("How old are you second question  ? " + string.youngage );

	
	}
	
	
	
}
