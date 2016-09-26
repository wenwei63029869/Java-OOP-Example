package com.wei;

import com.wei.Receipt;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReceiptTest {
    @Test
    public void testGetItemTypeFor() throws Exception {
        Receipt receipt = new Receipt();
        List<String> itemsArray;
        List<String> expectedLines;
        BigDecimal expectedSalesTaxes;
        BigDecimal expectedTotal;

        itemsArray = Arrays.asList("1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85");
        expectedLines = Arrays.asList("1 book: 12.49", "1 music CD: 16.49", "1 chocolate bar: 0.85", "Sales Taxes: 1.50", "Total: 29.83");
        expectedSalesTaxes = new BigDecimal("1.50");
        expectedTotal = new BigDecimal("29.83");
        receipt.processOrder(itemsArray);

        assertEquals(receipt.getLines(), expectedLines);
        assertEquals(receipt.getSales_taxes(), expectedSalesTaxes);
        assertEquals(receipt.getTotal(), expectedTotal);
    }
}