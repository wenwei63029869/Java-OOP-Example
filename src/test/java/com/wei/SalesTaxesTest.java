package com.wei;

import com.wei.Item;
import com.wei.SalesTaxes;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class SalesTaxesTest {
    private Item item = new Item();

    @Test
    public void testCalculateTaxPercentageWithNoTax() {
        BigDecimal taxPercentage = SalesTaxes.calculateTaxPercentage("book", false);
        assertEquals(taxPercentage, new BigDecimal("0.00"));
    }

    @Test
    public void testCalculateTaxPercentageWithDomesticTax() {
        BigDecimal taxPercentage = SalesTaxes.calculateTaxPercentage("other", false);
        assertEquals(taxPercentage, new BigDecimal("10.00"));
    }

    @Test
    public void testCalculateTaxPercentageWithImportedTax() {
        BigDecimal taxPercentage = SalesTaxes.calculateTaxPercentage("book", true);
        assertEquals(taxPercentage, new BigDecimal("5.00"));
    }

    @Test
    public void testCalculateTaxPercentageWithDomesticAndImportedTax() {
        BigDecimal taxPercentage = SalesTaxes.calculateTaxPercentage("other", true);
        assertEquals(taxPercentage, new BigDecimal("15.00"));
    }

    @Test
    public void testCalculateTaxWithDomesticAndImportedTaxes() throws Exception {
        String itemString = "1 imported bottle of perfume at 27.99";
        item.processItem(itemString);
        BigDecimal tax = SalesTaxes.calculateTax(item);
        assertEquals(tax, new BigDecimal("4.20"));
    }

    @Test
    public void testCalculateTaxWithImportedTaxes() throws Exception {
        String itemString = "1 box of imported chocolates at 11.25";
        item.processItem(itemString);
        BigDecimal tax = SalesTaxes.calculateTax(item);
        assertEquals(tax, new BigDecimal("0.60"));
    }

    @Test
    public void testCalculateTaxWithDomesticTaxes() throws Exception {
        String itemString = "1 music CD at 14.99";
        item.processItem(itemString);
        BigDecimal tax = SalesTaxes.calculateTax(item);
        assertEquals(tax, new BigDecimal("1.50"));
    }

    @Test
    public void testCalculateTaxWithNoTax() throws Exception {
        String itemString = "1 book at 12.49";
        item.processItem(itemString);
        BigDecimal tax = SalesTaxes.calculateTax(item);
        assertEquals(tax, new BigDecimal("0.00"));
    }
}