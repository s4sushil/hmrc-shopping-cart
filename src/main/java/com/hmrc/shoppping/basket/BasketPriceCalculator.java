package com.hmrc.shoppping.basket;

import java.util.List;

import com.hmrc.shoppping.model.ItemEnum;

import rx.Observable;

/**
 * Calculates the prices of items in basket.
 * 
 * @author sushil.a.choudhary
 *
 */
public class BasketPriceCalculator {

	private Observable<String> basketObservable;
	private Observable<Double> totalPriceObservable;
	private Observable<Double> totalPromotionalPriceObservable;

	public BasketPriceCalculator(List<String> basketItems) {
		basketObservable = Observable.from(basketItems);
		totalPriceObservable = Observable.merge(getApplePrice(), getOrangePrice()).reduce(0.0, Double::sum);
		totalPromotionalPriceObservable = Observable.merge(getPromotionalApplePrice(), getPromotionalOrangePrice())
				.reduce(0.0, Double::sum);
	}

	public Observable<Double> totalActualPrice() {
		return totalPriceObservable;
	}

	public Observable<Double> totalPromotionalActualPrice() {
		return totalPromotionalPriceObservable;
	}

	private Observable<Double> getApplePrice() {
		return basketObservable.filter(ItemEnum.APPLE.name()::equals).map((eachOffer) -> ItemEnum.APPLE.getPrice());
	}

	private Observable<Double> getOrangePrice() {
		return basketObservable.filter(ItemEnum.ORANGE.name()::equals).map((eachOffer) -> ItemEnum.ORANGE.getPrice());
	}

	private Observable<Double> getPromotionalApplePrice() {
		return basketObservable.filter(ItemEnum.APPLE.name()::equals).buffer(2)
				.map((eachOffer) -> ItemEnum.APPLE.getPrice());
	}

	private Observable<Double> getPromotionalOrangePrice() {
		return basketObservable.filter(ItemEnum.ORANGE.name()::equals).buffer(3)
				.map((eachOffer) -> eachOffer.size() == 3 ? ItemEnum.ORANGE.getPrice() * 2
						: ItemEnum.ORANGE.getPrice() * eachOffer.size());
	}

}
