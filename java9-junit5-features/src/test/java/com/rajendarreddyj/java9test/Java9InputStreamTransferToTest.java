package com.rajendarreddyj.java9test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Copy Streams In Java 9 With The InputStream.transferTo() Method
 * https://docs.oracle.com/javase/9/docs/api/java/io/InputStream.html#transferTo-java.io.OutputStream-
 * 
 * @author rajendarreddy.jagapathi
 */
public class Java9InputStreamTransferToTest {

    /*
        syntax of the InputStream.transferTo(OutputStream) method which reads all bytes from this input stream and writes the bytes
        to the given output stream in the order that they are read:
        public long transferTo(OutputStream out) throws IOException
        Parameters:
        out – the output stream, non-null
        Returns:
        The number of bytes transferred
        Throws:
        IOException – if an I/O error occurs when reading or writing.
        NullPointerException – if out is null.
    */

    @Test
    public void testTransferToJava9Syntax() throws IOException {
        byte[] inBytes = "Hello Java 9".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(inBytes);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (bis; bos) {
            bis.transferTo(bos);
            byte[] outBytes = bos.toByteArray();
            assertTrue(Arrays.equals(inBytes, outBytes));
        }
    }

    @Test
    public void testTransferTo() throws IOException {
        byte[] inBytes = "Hello Java 9".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(inBytes);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            bis.transferTo(bos);
            byte[] outBytes = bos.toByteArray();
            assertTrue(Arrays.equals(inBytes, outBytes));
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
