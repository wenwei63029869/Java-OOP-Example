package com.wei;

import com.wei.exceptions.NegativeNumberException;

import java.math.BigDecimal;
import java.util.Arrays;

public class Item {
    // This class is used to store item information

    // Should I always use constructors to initialize member variables??????????????????????
    private String name;
    private String type;
    private boolean imported = false;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal salesTax;

    // This method takes a list that contain information of an item and populate the member variables.
    // Item
    public void processItem(String itemString) throws NegativeNumberException {
        // converting item string into an array for extracting item information
        String[] itemArray = itemString.split(" ");
        // Extract item name from item array
        int itemLength = itemArray.length;
        String[] nameArray = Arrays.copyOfRange(itemArray,1, itemLength - 2);
        this.name = String.join(" ", nameArray);

        // Get quantity from item array
        this.quantity = new BigDecimal(itemArray[0]);
        // Raise an exception for negative quantity number
        if (this.quantity.signum() == -1) {
            throw new NegativeNumberException("The price for " + this.name + " should not be negative. Please check the input file again.");
        }
        // Get price from item array
        this.price = new BigDecimal(itemArray[itemLength - 1]);
        // Raise an exception for negative price number
        if (this.price.signum() == -1) {
            throw new NegativeNumberException("The quantity for " + this.name + " should not be negative. Please check the input file again.");
        }
        // Set type for item; With limited information, I use simple string matching to determine item type. However, since I put the item type defining mechanism in a separate class, I can just make changes itemType class without affecting other classes if there are more information for me to redesign the mechanism.
        this.type = ItemType.getItemType(this.name);
        // Set imported for item
        if (this.name.toLowerCase().indexOf("imported") != -1) {
            this.imported = true;
        }
        // Calculate the sales tax for this item
        this.salesTax = SalesTaxes.calculateTax(this);
    }

    // Getter methods

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean getImported() {
        return imported;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }
}
