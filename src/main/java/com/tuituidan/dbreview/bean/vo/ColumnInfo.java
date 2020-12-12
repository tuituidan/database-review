package com.tuituidan.dbreview.bean.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * ColumnInfo.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@Getter
@Setter
@Accessors(chain = true)
public class ColumnInfo {

    private boolean primaryKey;

    private String column;

    private String columnDesc;

    private String columnType;

    private Integer columnLength;

    private Integer columnPoint;

    private String indexName;

    private Integer sort;

    private String message;

    private boolean index;

    private boolean uniqueIndex;
}
