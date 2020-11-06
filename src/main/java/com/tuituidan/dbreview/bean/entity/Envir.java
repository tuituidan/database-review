package com.tuituidan.dbreview.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Envir.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/23
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "T_ENVIR")
public class Envir implements Serializable {

    private static final long serialVersionUID = -8020408504008314770L;
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * 名称.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * jdbcUrl.
     */
    @Column(name = "JDBC_URL")
    private String jdbcUrl;

    /**
     * 用户名.
     */
    @Column(name = "USER_NAME")
    private String username;

    /**
     * 密码.
     */
    @Column(name = "PASSWORD")
    private String password;

}
