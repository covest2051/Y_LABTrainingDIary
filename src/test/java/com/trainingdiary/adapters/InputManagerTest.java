package com.trainingdiary.adapters;

import com.trainingdiary.adapters.in.InputManager;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class InputManagerTest {
    @Test
    public void testReadString() {
        String input = "test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(input, InputManager.readString());
    }

    @Test
    public void testReadInt() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(123, InputManager.readInt());
    }
}
