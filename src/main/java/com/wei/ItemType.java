package com.wei;

public class ItemType {

    public static final String BOOK = "book";
    public static final String MEDICINE = "medicine";
    public static final String FOOD = "food";

    public static String getItemType (String name) {
        // Check tax exemptions and change tax rate accordingly
        if (name.toLowerCase().indexOf("book") != -1) {
            return BOOK;
        } else if (name.toLowerCase().indexOf("pill") != -1) {
            return MEDICINE;
        } else if (name.toLowerCase().indexOf("chocolate") != -1) {
            return FOOD;
        }
        return "other";
    }
}
