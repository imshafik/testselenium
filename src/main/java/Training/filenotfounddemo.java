package Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class filenotfounddemo {

	public static void main(String[] args) throws FileNotFoundException {

		//File fi = new File ("c://file.text");
		//FileReader fr = new FileReader(fi);
	// 	System.out.println("hello");
		
		
		filenotfounddemo demo = new filenotfounddemo();
		demo.testarry();
	}
	public void testarry()
	{
		try {
			
		
		int[] num = {1,2,3,4};
		System.out.println("printh tis array" + num[6]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("error   " + e);

		}
		System.out.println("out of block data");

	}
	

		
	}

