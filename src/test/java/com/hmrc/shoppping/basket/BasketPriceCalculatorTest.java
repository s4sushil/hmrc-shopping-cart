package com.hmrc.shoppping.basket;

import org.junit.Test;

import com.hmrc.shoppping.model.ItemEnum;

import rx.observables.BlockingObservable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketPriceCalculatorTest {

	@Test
	public void testActualPriceOfEmptyItemsInBasket() {
		List<String> basket = Arrays.asList();
		BasketPriceCalculator calc = new BasketPriceCalculator(basket);
		assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(0));
	}

	@Test
	public void testActualPriceOfBasketFullOfApples() {
		List<String> basketOfApples = Arrays.asList(ItemEnum.APPLE.name(), ItemEnum.APPLE.name(),
				ItemEnum.APPLE.name());
		BasketPriceCalculator calc = new BasketPriceCalculator(basketOfApples);
		assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(180));
	}

	@Test
	public void testActualPriceOfBasketFullOfOranges() {
		List<String> basketOfOranges = Arrays.asList(ItemEnum.ORANGE.name(), ItemEnum.ORANGE.name(),
				ItemEnum.ORANGE.name());
		BasketPriceCalculator calc = new BasketPriceCalculator(basketOfOranges);
		assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(75));
	}

	@Test
	public void testActualPriceOfBasketOfMultipleItems() {
		List<String> basket = Arrays.asList(ItemEnum.ORANGE.name(), ItemEnum.ORANGE.name(), ItemEnum.APPLE.name(),
				ItemEnum.APPLE.name());
		BasketPriceCalculator calc = new BasketPriceCalculator(basket);
		assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(170));
	}

	@Test
	public void testActualPriceOfBasketOfMultipleMixedItems() {
		List<String> basket = Arrays.asList(ItemEnum.ORANGE.name(), ItemEnum.ORANGE.name(), ItemEnum.ORANGE.name(),
				ItemEnum.ORANGE.name(), ItemEnum.APPLE.name(), ItemEnum.APPLE.name(), ItemEnum.APPLE.name());
		BasketPriceCalculator calc = new BasketPriceCalculator(basket);
		assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(280));
	}
	
	@Test
	public void testPromotionalPriceOfEmptyItemsInBasket() {
		List<String> basket = Arrays.asList();
		BasketPriceCalculator calc = new BasketPriceCalculator(basket);
		assertThat(BlockingObservable.from(calc.totalPromotionalActualPrice()).last(), is(0));
	}

	@Test
	public void testPromotionalPriceOfBasketFullOfApples() {
		List<String> basketOfApples = Arrays.asList(ItemEnum.APPLE.name(), ItemEnum.APPLE.name(),
				ItemEnum.APPLE.name());
		BasketPriceCalculator calc = new BasketPriceCalculator(basketOfApples);
		assertThat(BlockingObservable.from(calc.totalPromotionalActualPrice()).last(), is(120));
	}

	@Test
	public void testPromotionalPriceOfBasketFullOfOranges() {
		List<String> basketOfOranges = Arrays.asList(ItemEnum.ORANGE.name(), ItemEnum.ORANGE.name(),
				ItemEnum.ORANGE.name());
		BasketPriceCalculator calc = new BasketPriceCalculator(basketOfOranges);
		assertThat(BlockingObservable.from(calc.totalPromotionalActualPrice()).last(), is(50));
	}

}