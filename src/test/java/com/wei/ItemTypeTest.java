package com.wei;

import com.wei.ItemType;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by weiwen on 9/21/16.
 */
public class ItemTypeTest {
    @Test
    public void testItemTypeConstants() {
        assertEquals(ItemType.BOOK, "book");
        assertEquals(ItemType.MEDICINE, "medicine");
        assertEquals(ItemType.FOOD, "food");
    }

    @Test
    public void testGetItemTypeFor() {
        String testingInput1 = "a book";
        String testingInput2 = "several books";
        String testingInput3 = "a pill";
        String testingInput4 = "several pills";
        String testingInput5 = "a chocolate";
        String testingInput6 = "several chocolates";
        String testingInput7 = "other";

        assertEquals(ItemType.getItemType(testingInput1), "book");
        assertEquals(ItemType.getItemType(testingInput2), "book");
        assertEquals(ItemType.getItemType(testingInput3), "medicine");
        assertEquals(ItemType.getItemType(testingInput4), "medicine");
        assertEquals(ItemType.getItemType(testingInput5), "food");
        assertEquals(ItemType.getItemType(testingInput6), "food");
        assertEquals(ItemType.getItemType(testingInput7), "other");
    }
}