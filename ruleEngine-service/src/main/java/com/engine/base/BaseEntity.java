package com.engine.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 7065252780144533316L;

    @Override
    public String toString() {
//        ReflectionToStringBuilder.toString(this);
        return ToStringBuilder.reflectionToString(this);
    }
}
