package com.tuituidan.dbreview.bean.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * TableInfo.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@Getter
@Setter
@Accessors(chain = true)
public class TableInfo {

    private String table;

    private String tableDesc;

    List<ColumnInfo> columns;
}
