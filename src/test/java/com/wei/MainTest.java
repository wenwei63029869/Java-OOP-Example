package com.wei;

import com.wei.Main;
import com.wei.ReadTextFile;
import com.wei.Receipt;
import com.wei.WriteToTextFile;
import com.wei.exceptions.MissingArgumentsException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by weiwen on 9/22/16.
 */
public class MainTest {
    private Receipt receipt = new Receipt();
    private List<String> input_0= Arrays.asList("1 book at 12.49");
    private List<String> input_1= Arrays.asList("1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85");
    private List<String> input_2= Arrays.asList("1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50");
    private List<String> input_3= Arrays.asList("1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75", "1 imported box of chocolates at 11.25");

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void testProcessReceiptWithRightInputFile() throws Exception {
        String destDirectory = folder.newFolder().toString();
        String testingInputFile = WriteToTextFile.writeToTextFile(input_0, destDirectory);
        String[] testingArgs = {testingInputFile, destDirectory};
        String resultFilePath = Main.processReceipt(testingArgs);
        File resultFile = new File(resultFilePath);

        assertTrue(resultFile.exists() && !resultFile.isDirectory());
        assertTrue(resultFile.getParent().equals(destDirectory));
    }

    @Test
    public void testProcessReceiptReturnRightContentsOne() throws Exception {
        String destDirectory = folder.newFolder().toString();
        String testingInputFile1 = WriteToTextFile.writeToTextFile(input_1, destDirectory);
        String[] testingArgs1 = {testingInputFile1, destDirectory};
        System.out.println("Output1");
        String outputFilePath1 = Main.processReceipt(testingArgs1);
        List<String> output1 = ReadTextFile.readTextFile(outputFilePath1);
        List<String> expectedOutput1 = Arrays.asList("1 book: 12.49", "1 music CD: 16.49", "1 chocolate bar: 0.85", "Sales Taxes: 1.50", "Total: 29.83");

        assertEquals(output1, expectedOutput1);
    }

    @Test
    public void testProcessReceiptReturnRightContentsTwo() throws Exception {
        String destDirectory = folder.newFolder().toString();
        String testing_input_file_2 = WriteToTextFile.writeToTextFile(input_2, destDirectory);
        String[] testingArgs2 = {testing_input_file_2, destDirectory};
        System.out.println("Output2");
        String outputFilePath2 = Main.processReceipt(testingArgs2);
        List<String> output2 = ReadTextFile.readTextFile(outputFilePath2);
        List<String> expectedOutput2 = Arrays.asList("1 imported box of chocolates: 10.50", "1 imported bottle of perfume: 54.65", "Sales Taxes: 7.65", "Total: 65.15");

        assertEquals(output2, expectedOutput2);
    }

    @Test
    public void testProcessReceiptReturnRightContentsThree() throws Exception {
        String destDirectory = folder.newFolder().toString();
        String testing_input_file_3 = WriteToTextFile.writeToTextFile(input_3, destDirectory);
        String[] testingArgs3 = {testing_input_file_3, destDirectory};
        System.out.println("Output3");
        String outputFilePath3 = Main.processReceipt(testingArgs3);
        List<String> output3 = ReadTextFile.readTextFile(outputFilePath3);
        List<String> expectedOutput3 = Arrays.asList("1 imported bottle of perfume: 32.19", "1 bottle of perfume: 20.89", "1 packet of headache pills: 9.75", "1 imported box of chocolates: 11.85", "Sales Taxes: 6.70", "Total: 74.68");

        assertEquals(output3, expectedOutput3);
    }

    @Test(expected = MissingArgumentsException.class)
    public void testProcessReceiptWithEmptyArguments() throws Exception {
        String destDirectory = folder.toString();
        String[] testingArgs = {};
        Main.processReceipt(testingArgs);
    }

    @Test(expected = FileNotFoundException.class)
    public void testProcessReceiptWithWrongInputFile() throws Exception {
        String destDirectory = folder.toString();
        String[] testingArgs = {"Wrong File Path", destDirectory};
        Main.processReceipt(testingArgs);
    }

}