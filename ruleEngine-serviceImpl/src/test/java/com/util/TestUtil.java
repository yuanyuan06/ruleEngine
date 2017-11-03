package com.util;

import org.junit.Test;
import org.springframework.test.annotation.Repeat;

public class TestUtil {

    @Test
    public void getOsType(){
        String property = System.getProperty("os.name");
        System.out.println(property);
        // Windows 10
    }


}
