package com.trainingdiary.adapters;

import com.trainingdiary.adapters.out.OutputManager;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class OutputManagerTest {
    @Test
    public void testPrint() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "test message\n";
        OutputManager.print("test message");

        assertEquals(expectedOutput, outContent.toString());
    }
}
