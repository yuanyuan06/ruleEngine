package com.engine.entity.recordLog;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author oo
 */
@Data
public class InvokeLog implements Serializable{


    private static final long serialVersionUID = 8856546335856108198L;


    private Long id;

    private Date createTime;

    private String content;

}
