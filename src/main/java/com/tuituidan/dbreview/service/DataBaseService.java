package com.tuituidan.dbreview.service;

import com.tuituidan.dbreview.bean.vo.ColumnInfo;
import com.tuituidan.dbreview.bean.vo.DbInfo;
import com.tuituidan.dbreview.bean.vo.IndexInfo;
import com.tuituidan.dbreview.bean.vo.TableInfo;
import com.tuituidan.dbreview.consts.ResourceEnum;
import com.tuituidan.dbreview.util.BeanExtUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * DataBaseService.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@Service
public class DataBaseService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<String> selectSchemas() {
        return jdbcTemplate.queryForList(ResourceEnum.SCHEMA_SQL.getStr(), String.class);
    }


    public Collection<TableInfo> selectList(String schema) {
        List<DbInfo> dbInfoList = jdbcTemplate.query(ResourceEnum.COLUMN_SQL.getStr(),
                new BeanPropertyRowMapper<>(DbInfo.class), schema);
        List<IndexInfo> indexInfoList = jdbcTemplate.query(ResourceEnum.INDEX_SQL.getStr(),
                new BeanPropertyRowMapper<>(IndexInfo.class), schema);
        if (CollectionUtils.isEmpty(indexInfoList)) {
            indexInfoList = new ArrayList<>();
        }
        Map<String, List<IndexInfo>> indexMap = indexInfoList.stream().collect(Collectors.groupingBy(item -> item.getTable() + item.getColumn()));

        return dbInfoList.stream().reduce(new HashMap<String, TableInfo>(dbInfoList.size()), (acc, item) -> {
            TableInfo tableInfo = acc.get(item.getTable());
            List<IndexInfo> indexs = indexMap.get(item.getTable() + item.getColumn());
            if (tableInfo != null) {

                tableInfo.getColumns().add(toColumnInfo(item, indexs));
                return acc;
            }
            tableInfo = toTableInfo(item, indexs);
            acc.put(item.getTable(), tableInfo);
            return acc;
        }, (acc, item) -> null).values();
    }

    private TableInfo toTableInfo(DbInfo dbInfo, List<IndexInfo> indexInfoList) {
        return new TableInfo().setTable(dbInfo.getTable())
                .setTableDesc(dbInfo.getTableDesc())
                .setColumns(new ArrayList<>(Collections.singleton(toColumnInfo(dbInfo, indexInfoList))));
    }

    private ColumnInfo toColumnInfo(DbInfo dbInfo, List<IndexInfo> indexInfoList) {

        ColumnInfo columnInfo = BeanExtUtils.convert(dbInfo, ColumnInfo.class);
        columnInfo.setColumnType(ResourceEnum.TYPE_MAPPING.getProperties()
                .getProperty(StringUtils.replace(columnInfo.getColumnType(), " ", "-")));
        if (CollectionUtils.isEmpty(indexInfoList)) {
            return columnInfo;
        }
        indexInfoList.forEach(item -> {
            //以前的数据主键生成不规范，先试试通过索引名包含pk且不以i_开头来判断，
            // 不行再通过information_schema.key_column_usage来判断.
            if (StringUtils.contains(item.getIndexDesc(), "pk")
                    && !StringUtils.startsWith(item.getIndexDesc(), "i_")) {
                columnInfo.setPrimaryKey(true);
                // 是主键就不标记索引了
                return;
            }
            if (StringUtils.contains(item.getIndexDesc(), "UNIQUE")) {
                columnInfo.setUniqueIndex(true);
            }
        });
        // 既不是主键，也不是唯一索引，则肯定是普通索引
        columnInfo.setIndex(!(columnInfo.isPrimaryKey() || columnInfo.isUniqueIndex()));
        columnInfo.setIndexName(indexInfoList.stream()
                .map(IndexInfo::getIndexName).collect(Collectors.joining(",")));
        return columnInfo;
    }


}
