package com.tuituidan.dbreview.bean.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * RuleDto.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Getter
@Setter
@Accessors(chain = true)
public class RuleDto {

    private Integer id;

    /**
     * 描述.
     */
    private String desc;

    /**
     * 表达式.
     */
    private String exp;


    /**
     * 提示.
     */
    private String msg;
}

