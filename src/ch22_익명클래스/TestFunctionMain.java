package ch22_익명클래스;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionMain {
	public static void main(String[] args) {
		
		// 생성과 메소드 정의가 동시에 실행
//		TestFunction1 function1 = () -> {
//			System.out.println("매개변수 x, 리턴 x");
//		};
		
		// 명령문이 하나인 경우에는 중괄호{} 를 생략할수 있다.
		TestFunction1 function1 = () -> System.out.println("매개변수 x, 리턴 x");
			
		function1.test();
		
//		=====================================================================================	
		
//		TestFunction2 function2 = (int num) -> {
//			System.out.println("매개변수 1개, 리턴 x");
//			System.out.println("num : " + num);
//		};
		
		// 매개변수는 타입을 생략 할수 있다. 그리고 매개변수가 하나인 경우에는 괄호()도 생략 가능하다.
		TestFunction2 function2 = num -> {
		System.out.println("매개변수 1개, 리턴 x");
		System.out.println("num : " + num);
	};
		
		function2.test(100);
		
//		=====================================================================================
		
		// 매개변수가 없거나 두개 이상일 경우에는 매개변수의 괄호를 생략 할 수 없다.
		TestFunction3 function3 = (age, name) -> {
			System.out.println("매개변수 2개, 리턴 x");
			System.out.println("나이 : " + age);
			System.out.println("이름 : " + name);
		};
		
		function3.test(30, "김준일");

//		=====================================================================================
		
//		TestFunction4 function4 = (age, name) -> {
//			System.out.println("매개변수 2개, 리턴");
//			return "나이" + age + ", 이름 : " + name; 
//		};
		
		// 명령이 한줄인 경우 중광호를 생략 할 수 있으며 중괄호를 생략한 경우
		TestFunction4 function4 = (age, name) -> "나이 : " + age + ", 이름 : " + name;
			
		String result1 = function4.test(30, "김준일");
		
		System.out.println(result1);
		
//		=====================================================================================	
		
		//	Runnable 예시 (매개변수 x, 리턴 x)
		Runnable runnable = () -> {
			System.out.println("매개변수 x, 리턴x");
		};
		
		runnable.run();
		
//		=====================================================================================
		
		//	Consumer 예시 (매개변수 1, 리턴 x)
		Consumer<String> consumerStr = name -> {
			System.out.println(name);
		};
		
		consumerStr.accept("김준일");
		
//		=====================================================================================	
		
		//	BiConsumer 예시 (매개변수 2, 리턴 x)
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
		};
		
		biConsumer.accept("김준일", 30);
		
//		=====================================================================================
		
		//	Supplier 예시 (매개변수 x, 리턴 o)
		Supplier<Integer> supplier = () -> 100;
		
		System.out.println(supplier.get());
		
//		=====================================================================================
		
		// Function 예시 (매개변수 o , 리턴 o)
		Function<Integer, String> function = year -> "생일 : " + year;
		
		System.out.println(function.apply(1994));
		
//		=====================================================================================
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		System.out.println(numbers);
		
		// Predicate 예시 (매개변수를 받아 조건 필터 후 삭제)
		numbers.removeIf(num -> num % 2 == 0);
		System.out.println(numbers);
		
		// forEach 예시 (매개변수를 받아(대입) 하나씩 반복하여 출력)
		numbers.forEach(num -> System.out.println("출력 : " + num + num));
		
	}
}
