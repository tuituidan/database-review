package com.tuituidan.dbreview.bean.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * DbInfo.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@Getter
@Setter
@Accessors(chain = true)
public class DbInfo {

    private String schema;

    private String table;

    private String tableDesc;

    private String column;

    private String columnDesc;

    private String columnType;

    private Integer columnLength;

    private Integer columnPoint;

    private Integer sort;
}
