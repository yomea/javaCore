package ocm.genericity.cast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		Object obj = new ArrayList<String>();//泛型被主动擦除
		
		List<Date> list = (List<Date>) obj;
		//咋一看，为什么一个String的容器，最后转型成了Date的容器，而且还可以向里面放不是String的对象，
		//实际上泛型只是用于编译器进行类型检查的，编译器在编译（翻译成java的字节码）是会
		//进行泛型的擦除，所用用到泛型的地方都会替换成边界类型，编译器只会将需要转型的地方插入强制
		//转型就可以了。为了看得更加容易理解，可以使用javap进行反编译。
		
		
		list.add(new Date()); 
		
		Date date = list.get(0);
		
		System.out.println(date);//Tue Dec 27 16:16:48 CST 2016
		List<String> list_1 = (List) obj;
		
		List<String>[] ls;
		
		List[] lss = new List[1];
		
		ls = lss;
		
		
		
		Class<?>[] clazz = List.class.getClasses();
		
		for (Class<?> class1 : clazz) {
			System.out.println(class1.getSimpleName());
		}
		
		ls = (List<String>[])lss;
		
		Integer[] b = new Integer[1];
		
		Object[] a = b;
		
		List<String> l = new ArrayList(new ArrayList<>()) {
			
			
		};
		
		System.out.println(a.getClass().getComponentType());
		
	}

}
