package ocm.genericity.bound;

public class Interfaceimpl<T> implements Interface_1<T>, Interface_2<T> {
	//这里的方法定义的T似乎和类上面定义的T没有了任何关系
	public <T extends Interface_1> void test_1(T if_1) {
		System.out.println("public <T extends Interface_1> void test_1(T if_1)");
	}

	public <T extends Interface_2> void test_2(T if_2) {
		System.out.println("public <T extends Interface_2> void test_2(T if_2)");
	}

	public static void main(String[] args) {
		Interfaceimpl<String> interfaceImpl = new Interfaceimpl<String>();
		
		interfaceImpl.test_1(new Interface_1_impl());
		
		interfaceImpl.test_2(new Interface_2_impl());
	}
	
}
