package com.hmrc.shoppping.basket;

import java.util.List;

import rx.Observable;

public class BasketPriceCalculator {

	private Observable<Integer> totalPriceObservable;

	public BasketPriceCalculator(List<String> basket) {
		// TODO Auto-generated constructor stub
	}

	public Observable<Integer> totalActualPrice() {
		// TODO Auto-generated method stub
		return totalPriceObservable;
	}

}
