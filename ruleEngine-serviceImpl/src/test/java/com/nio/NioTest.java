package com.nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NioTest {

    private Path path = Paths.get("F:\\ideaSpace\\ruleEngine\\ruleEngine-serviceImpl\\src\\main\\resources\\groovy\\demoHaHa.groovy");

    @Test
    public void testPath() throws IOException {

        System.out.println(path.getFileName());
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
    }

    @Test
    public void testReadLine() throws IOException {
        long size = Files.size(path);
        System.out.println(size);
        List<String> strings = Files.readAllLines(path);
        for(String s: strings){
            System.out.println(s);
        }
    }
}
