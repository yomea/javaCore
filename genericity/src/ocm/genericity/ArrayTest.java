package ocm.genericity;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
	
	
	public static void main(String[] args) {
		
		List<String>[] list = null;
		
		Object[] obj = new Object[1];
		
		obj[0] = new ArrayList<String>(); 
		
		list = (List<String>[]) obj;// java.lang.ClassCastExceptionNew n = (New) new Object();
		

		
		
		
	}

}
