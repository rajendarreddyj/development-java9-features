package com.rajendarreddyj.java9test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * Unit Test for Try with Resources enhancements
 * https://blogs.oracle.com/darcy/more-concise-try-with-resources-statements-in-jdk-9
 * 
 * @author rajendarreddy.jagapathi
 */
public class Java9TryWithResourcesTest {
    @Test
    public void tryWithResourceTestPriorJava9() throws IOException {
        File appConfig = new File("src/test/resources/application-backup.properties");
        File appConfigProd = new File("src/test/resources/application-prod.properties");
        try (BufferedReader prodBr = new BufferedReader(new FileReader(appConfigProd));
                BufferedWriter backupBw = new BufferedWriter(new FileWriter(appConfig))) {
            String line;
            while (null != (line = prodBr.readLine())) {
                String prodLine = "prod." + line;
                backupBw.write(prodLine);
            }
        }
    }

    @Test
    public void tryWithResourceTest() throws IOException {
        File appConfig = new File("src/test/resources/application-backup.properties");
        BufferedWriter backupBw = new BufferedWriter(new FileWriter(appConfig));
        File appConfigProd = new File("src/test/resources/application-prod.properties");
        try (BufferedReader prodBr = new BufferedReader(new FileReader(appConfigProd))) {
            String line;
            while (null != (line = prodBr.readLine())) {
                String prodLine = "prod." + line;
                backupBw.write(prodLine);
            }
        }

        File appConfigQa = new File("src/test/resources/application-qa.properties");
        try (backupBw; BufferedReader brQA = new BufferedReader(new FileReader(appConfigQa))) {
            String line;
            while (null != (line = brQA.readLine())) {
                String qaLine = "qa." + line;
                backupBw.write(qaLine);
                backupBw.newLine();
            }
        }

    }
}
