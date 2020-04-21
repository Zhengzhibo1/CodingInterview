//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题2：实现Singleton模式
// 题目：设计一个类，我们只能生成该类的一个实例。
//==================================================================
//单线程下
public class Singleton1 {

	private static Singleton1 instance = null;
	private Singleton1() {
		System.out.println("An instance of Singleton1 is created.");
	};
	public static Singleton1 getInstance() {
		if(instance == null) {
			instance = new Singleton1();
		}else {
			System.out.println("An instance of Singleton1 is existed.");
		}
		return instance;
	}
}

//多线程下同步锁，未创建实例时上锁
public class Singleton2 {

	private static volatile Singleton2 instance =  null;
	private Singleton2() {
		System.out.println("An instance of Singleton2 is created.");
	};
	public static Singleton2 getInstance() {
		if(instance == null) {
			synchronized(Singleton2.class) {
				if(instance == null) {
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}
}

//利用静态构造函数,不上锁的情况下解决多线程问题
//在第一次用到Singleton3时创建单例对象
public class Singleton3 {

	private Singleton3() {
		System.out.println("An instance of Singleton3 is created.");
	};
	private static Singleton3 instance = new Singleton3();
	public static Singleton3 getInstance() {
		return instance;
	}
}

//测试代码
public class SingletonTest {

	public static void main(String[] args) {
		Singleton1 instance1 = Singleton1.getInstance(); 
		Singleton2 instance2 = Singleton2.getInstance(); 
		Singleton3 instance3 = Singleton3.getInstance(); 
		Singleton1 instance4 = Singleton1.getInstance(); 

	}

}
