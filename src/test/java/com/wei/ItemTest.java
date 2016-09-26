package com.wei;

import com.wei.Item;
import com.wei.exceptions.NegativeNumberException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by weiwen on 9/21/16.
 */
public class ItemTest {
    @Test
    public void testProcessItem() throws Exception {
        Item item = new Item();
        String testItem = "1 imported bottle of perfume at 27.99";

        item.processItem(testItem);
        assertEquals(item.getName(), "imported bottle of perfume");
        assertEquals(item.getQuantity(), new BigDecimal("1"));
        assertEquals(item.getPrice(), new BigDecimal("27.99"));
        assertEquals(item.getImported(), true);
        assertEquals(item.getSalesTax(), new BigDecimal("4.20"));
    }

    @Test (expected = NegativeNumberException.class)
    public void testNegativeNumberExceptionWithNegativePrice() throws Exception {
        Item item = new Item();
        String testItem = "1 imported bottle of perfume at -27.99";
        item.processItem(testItem);
    }

    @Test (expected = NegativeNumberException.class)
    public void testNegativeNumberExceptionWithNegativeQuantity() throws Exception {
        Item item = new Item();
        String testItem = "-1 imported bottle of perfume at 27.99";
        item.processItem(testItem);
    }
}
