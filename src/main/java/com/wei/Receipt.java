package com.wei;

import com.wei.exceptions.NegativeNumberException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.ArrayList;

public class Receipt {
    // This class is used to create a receipt for an order

    private ArrayList<String> lines = new ArrayList<>();
    private BigDecimal salesTaxes = new BigDecimal("0");
    private BigDecimal total = new BigDecimal("0");

    // Taking in a list of item strings and iterate through the list. During each iteration, an item will be created
    // and increment sales_taxes and total
    public void processOrder(List<String> order) throws NegativeNumberException {
        for (String item_string: order) {
            // Create a Item object
            Item item = new Item();
            BigDecimal itemSalesTax;
            BigDecimal afterTaxPrice;
            String receiptItem;

            item.processItem(item_string);
            itemSalesTax = item.getSalesTax();
            // Incrementing total sales taxes
            this.salesTaxes = this.salesTaxes.add(itemSalesTax);
            // Incrementing total
            afterTaxPrice = item.getPrice().add(itemSalesTax).multiply(item.getQuantity());
            // Add the formatted line to the receipt lines list
            receiptItem = item.getQuantity() + " " + item.getName() + ": " + afterTaxPrice.setScale(2, RoundingMode.UP);
            this.lines.add(receiptItem);
            this.total = this.total.add(afterTaxPrice);
        }
        this.salesTaxes = this.salesTaxes.setScale(2, RoundingMode.UP);
        this.lines.add("Sales Taxes: " + this.salesTaxes);
        this.total = this.total.setScale(2, RoundingMode.UP);
        this.lines.add("Total: " + this.total);
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public BigDecimal getSales_taxes() {
        return salesTaxes;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
