package ex03;

import java.util.Vector;

class Product {
	int price; // 제품의 가격
	int bonusPoint;// 재품구매 시 제공하는 보너수 점수

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0); // 보너스점수는 제품가격의 10%
	}

	Product() {
		price = 0;
		bonusPoint = 0;
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
	int bonusPoint = 0; // 보너스점수
	Vector item = new Vector();//구입한 제품을 저장하는데 사용될 Vector객체

//	Product[] item = new Product[10];//구입한 제품을 저장하기 위한 배열
	int i = 0; //Product배열에 사용될 카운터

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;// 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;// 제품의 보너스 점수를 추가한다.
		//item[i++] = p;//제품을 Product[] item에 저장한다.
		item.add(p);//구입한 제품을 Vector에 저장한다
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void refund(Product p) {//구입한 제품을 환불한다.
		if(item.remove(p)) {//제품을 Vector에서 제거한다
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		}else {//제거 실패할경우
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}

	void summary() {//구매한 물품에 대한 정보를 요약해서 보여준다.
		int sum = 0;//구입한 물품의 가격합계
		String itemList = "";//구입한 물품목록
		
		if(item.isEmpty()) {//Vectro가 비어있는지 확인한다.
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		
		for (int i = 0; i < item.size(); i++) {//Vector의 i번재에 있는 객체를 얻어온다
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		
		//반복문을 이용해서 구입한 물품의 총 가격의 목록을 만든다.
//		for (int i = 0; i < item.length; i++) {
//			if (item[i] == null)
//				break;
//			sum += item[i].price;
//			itemList += item[i] + ", ";
//		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

public class PolyArgumentTest {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio audio = new Audio();

//		b.buy(new Tv());
//		b.buy(new Computer());
//		b.buy(new Audio());
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();

		// System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		// System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
	}
}
