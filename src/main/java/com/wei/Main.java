package com.wei;

import com.wei.exceptions.EmptyFileException;
import com.wei.exceptions.MissingArgumentsException;
import com.wei.exceptions.NegativeNumberException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    // The first argument for command line will be
    public static void main(String[] args) {
        try {
            processReceipt(args);
        }
        catch(MissingArgumentsException ex) {
            System.out.println(ex.getMessage());
        }
        catch(NegativeNumberException ex) {
            System.out.println(ex.getMessage());
        }
        catch(EmptyFileException ex) {
            System.out.println(ex.getMessage());
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("There is something wrong that we didn't catch. Debug it with the stack trace!");
            ex.printStackTrace();
        }
    }

    public static String processReceipt(String[] args) throws IOException, NegativeNumberException, MissingArgumentsException, EmptyFileException {
        if (args.length < 2) {
            throw new MissingArgumentsException("You don't have enough arguments. The first one is input file path and the second one is output folder path");
        }
        String filePath = args[0];
        String output_file_path = null;
        // Get content out of input file
        List<String> order = ReadTextFile.readTextFile(filePath);
        Receipt receipt = new Receipt();
        // Process the order and convert into a receipt
        receipt.processOrder(order);
        receipt.getLines().forEach(System.out::println);
        System.out.println("\n");
        // Write the receipt content to a specified file
        output_file_path = WriteToTextFile.writeToTextFile(receipt.getLines(), args[1]);
        return output_file_path;
    }
}
