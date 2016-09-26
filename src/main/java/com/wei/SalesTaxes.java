package com.wei;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTaxes {

    private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
    private static final BigDecimal DOMESTIC_TAX_PERCENTAGE = new BigDecimal("10.00");
    private static final BigDecimal IMPORTED_TAX_PERCENTAGE = new BigDecimal("5.00");

    public static BigDecimal calculateTaxPercentage(String type, boolean imported) {
        BigDecimal taxPercentage = new BigDecimal("0.00");
        // Check tax exemptions and change tax rate accordingly
        if (!(type.equals(ItemType.BOOK) || type.equals(ItemType.MEDICINE) || type.equals(ItemType.FOOD))) {
            taxPercentage = taxPercentage.add(DOMESTIC_TAX_PERCENTAGE);
        }
        // Check if the item is imported and change tax rate accordingly
        if (imported) {
            taxPercentage = taxPercentage.add(IMPORTED_TAX_PERCENTAGE);
        }
        return taxPercentage;
    }

    public static BigDecimal calculateTax(Item item) {
        // Get tax percentage with item type and imported type;
        BigDecimal tax_percentage = calculateTaxPercentage(item.getType(), item.getImported());
        // Get tax with resulting percentage
        BigDecimal tax = item.getPrice().multiply(tax_percentage).divide(new BigDecimal("100"));
        // Apply the rounding rule: round up to the nearest of 0.05
        tax = RoundNumber.round(tax, new BigDecimal("0.05"), RoundingMode.UP);
        return tax;
    }
}
