package com.util;

import com.alibaba.fastjson.JSON;
import com.engine.entity.ruleEngine.RuleSnippet;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.util.List;
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

    @Test
    public void tet(){

    }


}
