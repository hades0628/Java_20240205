package ex05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception03 {

	public static void main(String[] args) {

		int sum = func1();
		System.out.println("두 수 합은 : " + sum);
	}

	static int func1() {
		return func2();
	}

	static int func2() {

		Scanner s = new Scanner(System.in);
		System.out.println("두 정수 입력 >>");
		int num1=0, num2 = 0;
		try {
			num1 = s.nextInt();
			num2 = s.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num1 + num2;
	}
}
