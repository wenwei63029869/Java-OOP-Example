package com.wei;

import com.wei.exceptions.EmptyFileException;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ReadTextFile {
    // This class is used to read input text file with order
    public static List<String> readTextFile(String textFilePath) throws IOException, EmptyFileException {

        List<String> lines = new ArrayList();
        List<String> order = new ArrayList();

        String line = null;
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(textFilePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        // closing files.
        bufferedReader.close();

        order.addAll(lines);

        // Throw exception if the file is empty
        if (order.isEmpty()) {
            throw new EmptyFileException(textFilePath + " is empty, please check again.");
        }

        return order;
    }

}
