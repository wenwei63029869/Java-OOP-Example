package com.wei;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WriteToTextFileTest {
    private Receipt receipt = new Receipt();
    private List<String> itemsArray= Arrays.asList("1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85");

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void testProcessItemWithoutExistingFolder() throws Exception {
        receipt.processOrder(itemsArray);
        String destDirectory = this.folder.newFolder().toString();
        String filePath = WriteToTextFile.writeToTextFile(receipt.getLines(), destDirectory);
        File result_file = new File(filePath);

        assertTrue(result_file.exists() && !result_file.isDirectory());
        assertTrue(result_file.getParent().equals(destDirectory));
    }
}