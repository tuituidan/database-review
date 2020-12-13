package com.tuituidan.dbreview.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ExcludeDbConfig.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/13
 */
@Setter
@Configuration
@ConfigurationProperties(prefix = "exclude-db")
public class ExcludeDbConfig {

    private List<String> schemas;

    private List<String> tables;

    public List<String> getSchemas() {
        if (this.schemas == null) {
            return new ArrayList<>();
        }
        return this.schemas;
    }

    public List<String> getTables() {
        if (this.tables == null) {
            return new ArrayList<>();
        }
        return this.tables;
    }
}
