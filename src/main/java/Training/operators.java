package Training;


public class operators {

	public static void main(String[] args) {

		
		boolean  x= 99 > 100 ; boolean y=100 >99; boolean v =200 > 99 ;
		
		System.out.println("what is the result for 99>100 and 100>99  ? " + (x&&y));
		
		System.out.println("what is the result for 99>100 and 100>99  ? " + (x || y));

		System.out.println("what is the result for 99>100 and 100>99  ? " + (v ^ y));

		System.out.println("what is the result of not  99>100  ? " + (! y));

		
	}

}
