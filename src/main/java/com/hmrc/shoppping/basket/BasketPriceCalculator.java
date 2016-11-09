package com.hmrc.shoppping.basket;

import java.util.List;

import com.hmrc.shoppping.model.ItemEnum;
import com.hmrc.shoppping.model.PriceConstants;

import rx.Observable;

/**
 * Calculates the prices of items in basket.
 * 
 * @author sushil.a.choudhary
 *
 */
public class BasketPriceCalculator {

	private Observable<Integer> totalPriceObservable;
	private Observable<String> basketObservable;

	public BasketPriceCalculator(List<String> basketItems) {
		basketObservable = Observable.from(basketItems);
		totalPriceObservable = Observable.merge(getApplePrice(), getOrangePrice()).scan(0, this::sum);
	}

	public Observable<Integer> totalActualPrice() {
		return totalPriceObservable;
	}

	private Observable<Integer> getApplePrice() {
		return basketObservable.filter(ItemEnum.APPLE.name()::equals).map((eachOffer) -> PriceConstants.APPLE_RATE);
	}

	private Observable<Integer> getOrangePrice() {
		return basketObservable.filter(ItemEnum.ORANGE.name()::equals).map((eachOffer) -> PriceConstants.ORANGE_RATE);
	}

	private Integer sum(Integer acc, Integer next) {
		return acc + next;
	}
}
