package ocm.genericity._super;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static <E> void test(List<E> list, E fruit) {

	}

	public static void main(String[] args) {

		List<Apple> apples = new ArrayList<Apple>();

		List<Fruit> fruit = new ArrayList<Fruit>();
		
		List list = new ArrayList();
		
		test(list, new Apple());
		

		test(apples, new Apple());

		// test(fruit, new
		// Apple());为什么会出错呢，因为list中的E与fruit参数指定的不是相同的类型，第一个指定的是fruit，第二个指定是Apple，E无法确定是Fruit还是Apple
		//改成这样就对了public static <E> void test(List<? super E> list, E fruit) {}

	
	}

}
