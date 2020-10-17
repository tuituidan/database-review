package com.tuituidan.dbreview.bean.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Setting.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "T_SETTINGS")
public class Setting implements Serializable {

    private static final long serialVersionUID = 3984695012956151702L;
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "AUTO")
    private Boolean auto;

    @Column(name = "CRON")
    private String cron;

    @Column(name = "SCHEMAS")
    private String schemas;

}
