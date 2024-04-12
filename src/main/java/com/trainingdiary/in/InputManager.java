package com.trainingdiary.in;

import java.util.Scanner;

/**
 * Designed for reading various types of data from the input stream.
 */
public class InputManager {
    /**
     * For reading data from the input stream.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Reads a string from the input stream.
     *
     * @return The string read from the input stream.
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer from the input stream.
     *
     * @return The integer read from the input stream.
     */
    public static int readInt() {
        return scanner.nextInt();
    }

    /**
     * Reads a byte from the input stream.
     *
     * @return The byte read from the input stream.
     */
    public static byte readByte() {
        return scanner.nextByte();
    }
}

