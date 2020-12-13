package com.tuituidan.dbreview.consts;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.activation.UnsupportedDataTypeException;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StreamUtils;

/**
 * 读取classpath的下的配置，支持string和properties两种<br/>
 * 只需要配置classpath路径和返回类型即可<br/>
 * 如果不经常使用的还是不要放这里，常驻内存.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@Getter
public enum ResourceEnum {
    /**
     * 查询模式的sql.
     */
    SCHEMA_SQL("sql/get-schema.sql", String.class),

    /**
     * 查询字段的sql.
     */
    COLUMN_SQL("sql/get-column.sql", String.class),

    /**
     * 查询索引的sql.
     */
    INDEX_SQL("sql/get-index.sql", String.class),

    /**
     * 查询类型映射.
     */
    TYPE_MAPPING("config/type-mapping.properties", Properties.class);

    private Properties properties;

    private String str;

    @SneakyThrows
    ResourceEnum(String path, Class<?> cls) {
        ClassPathResource classPathResource = new ClassPathResource(path);
        if (String.class.equals(cls)) {
            str = StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
            return;
        }
        if (Properties.class.equals(cls)) {
            properties = PropertiesLoaderUtils
                    .loadProperties(new EncodedResource(classPathResource, StandardCharsets.UTF_8));
            return;
        }
        throw new UnsupportedDataTypeException("不支持的类型");
    }
}
