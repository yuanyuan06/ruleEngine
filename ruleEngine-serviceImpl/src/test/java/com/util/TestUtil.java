package com.util;

import com.engine.entity.ruleEngine.RuleSnippet;
import org.junit.Test;

import java.util.Optional;

public class TestUtil {

    @Test
    public void getOsType(){
        String property = System.getProperty("os.name");
        System.out.println(property);
        // Windows 10
    }

    @Test
    public void testNull(){

        RuleSnippet ruleSnippet = null;
        Optional<RuleSnippet> optional = Optional.ofNullable(ruleSnippet);
        String string = optional.get().getDocNum();
        System.out.println(string);

    }


}
