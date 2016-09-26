package com.wei;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class WriteToTextFile {

    public static String writeToTextFile(List<String> lines, String destDirectory) throws IOException {
        String filePath = null;
        File destDir = new File(destDirectory);

        // create the destination directory if it does not yet exist
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        BufferedWriter writer = null;
        // Create a temp file
        String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File outputFile = new File(destDirectory + File.separator + timeLog + ".txt");
        filePath = outputFile.getPath();

        // Write receipt line to the temp file
        writer = new BufferedWriter(new FileWriter(outputFile));
        for (String line: lines) {
            writer.write(line);
            writer.newLine();
        }
        // Close the file
        writer.close();

        return filePath;
    }
}
