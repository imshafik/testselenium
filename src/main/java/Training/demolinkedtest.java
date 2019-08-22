package Training;

import java.nio.file.LinkOption;
import java.util.LinkedList;

public class demolinkedtest {

	public static void main(String[] args) {

		LinkedList<String> ibrahimlist = new LinkedList<String>() ;

		ibrahimlist.add("item1");
		ibrahimlist.add("item3");
		ibrahimlist.add("item2");
		ibrahimlist.add("item4");

		System.out.println("this list include these items " + ibrahimlist);

		ibrahimlist.addFirst("first item");
		ibrahimlist.addLast("last item");

		System.out.println("this list include these itemsafter adding new items  " + ibrahimlist);

		Object getfirstitem = ibrahimlist.get(0);


		System.out.println("first item in list is   " + getfirstitem);

		ibrahimlist.set(0, "the first item in list" );
		
		Object getfirstitemafterchange = ibrahimlist.get(0);
		System.out.println("first item in list is   " + getfirstitemafterchange);



	}

}
