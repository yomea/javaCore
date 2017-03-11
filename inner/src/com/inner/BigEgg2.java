package com.inner;

/**
 * 好好研究这个执行的顺序。
 * Egg2.Yolk() 
 * New Egg2() 
 * Egg2.Yolk() 
 * BigEgg2.Yolk() 
 * BigEgg2.Yolk.f()
 * 
 * @author may
 *
 */

class Test {
	
	static {
		
		System.out.println("asdygfsiehgsdghdfoghjdlkfhjdho;sdjhrstjdh");
	}
	
}

class Egg2 {

	protected class Yolk {

		public Yolk() {
			System.out.println("Egg2.Yolk()");
		};

		public void f() {
			System.out.println("Egg2.Yolk.f()");
		}

	}

	private Yolk y = new Yolk();

	public Egg2() {
		System.out.println("New Egg2()");
	}

	public void insertYolk(Yolk yy) {
		y = yy;
	}

	public void g() {
		
		y.f();
	};

}

public class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			System.out.println("BigEgg2.Yolk()");
		}

		public void f() {
			System.out.println("BigEgg2.Yolk.f()");
		}
	}

	public BigEgg2() {
		insertYolk(new Yolk());
	}
	Test test = null;//类会加载，但不会发生静态初始化
	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
	}
}
