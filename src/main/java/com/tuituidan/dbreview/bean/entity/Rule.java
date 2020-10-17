package com.tuituidan.dbreview.bean.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Rule.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "T_RULES")
public class Rule implements Serializable {

    private static final long serialVersionUID = 5928642081872417175L;
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * 描述.
     */
    @Column(name = "DESC")
    private String desc;

    /**
     * 表达式.
     */
    @Column(name = "EXP")
    private String exp;


    /**
     * 提示.
     */
    @Column(name = "MSG")
    private String msg;

    /**
     * 是否有效.
     */
    @Column(name = "VALID")
    private Boolean valid;

}
