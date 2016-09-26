package com.wei;

import com.wei.ReadTextFile;
import com.wei.exceptions.EmptyFileException;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;

public class ReadTextFileTest {
    @Test
    public void testReadTextFile() throws Exception {
        //create a temp file
        File temp = File.createTempFile("textile", ".txt");
        //write it
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
        bw.write("This is a text file");
        String filePath = temp.getAbsolutePath();
        bw.close();

        List<String> expect_result = Arrays.asList("This is a text file");
        List<String> result = ReadTextFile.readTextFile(filePath);

        assertThat(result, CoreMatchers.is(expect_result));
    }

    @Test (expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws Exception {
        String filePath = "donotexist";
        ReadTextFile.readTextFile(filePath);
    }

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test (expected = EmptyFileException.class)
    public void testEmptyFileException() throws Exception {
        String destDirectory = folder.newFolder().toString();
        String EmptyInputFile = WriteToTextFile.writeToTextFile(Arrays.asList(), destDirectory);
        ReadTextFile.readTextFile(EmptyInputFile);
    }

}
