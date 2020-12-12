package com.tuituidan.dbreview.bean.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * IndexInfo.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@Getter
@Setter
@Accessors(chain = true)
public class IndexInfo {

    private String schema;

    private String table;

    private String column;

    private String indexName;

    private String indexDesc;
}
