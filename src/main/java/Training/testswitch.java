package Training;

public class testswitch {

	public static void main(String[] args) {

		int day = 0;

		switch (day) {
		case 1:	
			System.out.println("sunday is the first day of the week");
			break;
		case 2:
			System.out.println("monday is the second day of the week");
			break;

		case 3:
			System.out.println("tuhrusday is the third day of the week");
			break;

		case 4:
			System.out.println("tuesday is the fourth day of the week");
			break;

		case 5:
			System.out.println("wednedday is the fifth day of the week");
			break;

		case 6:
			System.out.println("friday is the sixet day of the week");
			break;

		case 7:	
			System.out.println("saturday is the seven day of the week");
			break;

		default:
			System.out.println("no valid value");
		}
	}

}
