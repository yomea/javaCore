package ocm.genericity;

import java.util.ArrayList;
import java.util.List;

public class New<E extends Object> {
	E test = null;//为什么泛型只能是类类型，而不能是基本类型，
	//那是因为使用你定义了一个数据，你却不知道它是啥，不好初始化。特別是在局部变量中
	//程序员根本不知道该赋个什么类型的初始值，是null，还是0。
	New() {}
	
	
	@SuppressWarnings("unchecked")
	public <E> New(String className) throws Exception {
		
		Class<E> clazz = (Class<E>) Class.forName(className);
		E test = clazz.newInstance();
		//E test = clazz.getConstructor(String.class).newInstance(className);
		System.out.println(test.getClass().getSimpleName());
	}
	
	public static <T> List<T> get() {
		
		return new ArrayList<T>(); 
		
	}
}
