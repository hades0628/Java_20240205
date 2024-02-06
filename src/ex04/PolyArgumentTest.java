package ex04;

import java.util.Vector;



class Product {
	int price; 
	
	Product(int price) {
		this.price = price;
		
	}
}

class Tv extends Product {
	Tv() {
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100);// Tv의 가격을 100만원으로 지정한다.

	}

	// Object클래스의 toString()을 오버라이딩한다.
	public String toString() {
		return "Tv";
	}

}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}

}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}

class Buyer { // 고객, 물건을 사는 사람
	int money = 1000; // 소유금액
	Product[] cart = new Product[3];
	int i = 0; //Product배열에 사용될 카운터
	
	

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 " + p +"를 살 수 없습니다.");
			return;
		}
		money -= p.price;// 가진 돈에서 구입한 제품의 가격을 뺀다.
		add(p);
	}
	
	void add(Product p) {//구입한 제품을 환불한다.
		if(i >= cart.length) {
			Product[] tmp = new Product[cart.length * 2];
			//System.arraycopy(cart, 0, tmp, 0, cart.length);
			for(int i=0; i<cart.length; i++) {
				tmp[i] = cart[i];
			}
			
			
			cart = tmp;
		}
		cart[i++] = p;
	}

	void summary() {//구매한 물품에 대한 정보를 요약해서 보여준다.
		int sum = 0;//구입한 물품의 가격합계
		String itemList = "";//구입한 물품목록
		for(int i=0; i<cart.length; i++) {
			if(cart[i] == null) {
				break;
			}
			itemList += cart[i] + ", ";
			sum += cart[i].price;
			
		}
		System.out.println("구입하신 제품은 " + itemList);
		System.out.println("총금액은 " + sum);
		System.out.println("남은 금액은 " + money);
		
		
	}
}

public class PolyArgumentTest {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();

	}
}
