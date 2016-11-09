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
    public void testPriceOfEmptyItemsInBasket() {
        List<String> basket = Arrays.asList();
        BasketPriceCalculator calc = new BasketPriceCalculator(basket);
        assertThat(BlockingObservable.from(calc.totalActualPrice()).last(), is(0));
    }

}