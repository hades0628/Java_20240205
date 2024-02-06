package ex05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception04 {

	public static void main(String[] args) {

		int sum = 0;
		
		try {
			sum = func1();
		}catch(InputMismatchException e){
			e.printStackTrace();
		}
		
		//fun2()에서 예외를 던지기 때문에 2가지 방법으로 예외처리 가능
		//내부처리 외부 던지기
		System.out.println("두 수 합은 : " + sum);
	}

	static int func1() {
		return func2();
	}

	static int func2() throws InputMismatchException{//try catch문을 안쓰고 한번에 오류 추출

		Scanner s = new Scanner(System.in);
		System.out.println("두 정수 입력 >>");
		int num1 = 0, num2 = 0;

		num1 = s.nextInt();
		num2 = s.nextInt();

		return num1 + num2;
	}
}
