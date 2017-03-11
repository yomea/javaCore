package ocm.genericity;

import java.sql.Date;

public class Test {
	
	public static void main(String[] args) throws Exception {
		//显示类型
		System.out.println(New.<String>get());
		
		New _new = new <New>New("ocm.genericity.New");
		
		
		Object[] a = new String[1];
		
		String[] b = (String[]) a;
		
	}

}
