package com.hmrc.shoppping.basket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rx.observables.BlockingObservable;

public class BasketPriceCalculatorTest {

    @Test
    public void testPriceOfEmptyItemsInBasket() {
        List<String> basket = Arrays.asList();
        BasketPriceCalculator calc = new BasketPriceCalculator(basket);
        assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(0));
    }

}