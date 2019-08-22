package Training;

import org.testng.annotations.Test;

public class testelseif {
	
	@Test
	public void testelseifstatment ()
	{
		int extracustomer =0 ;
		
		if (extracustomer >0) {
			System.out.println("this customer receive a discount ");
		}
		else if (extracustomer <0) {
			System.out.println("this customer not receive a discount ");
		}
		
		else  {
			System.out.println("error in added value ");
		}
		
	}

}
