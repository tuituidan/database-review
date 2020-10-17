package com.tuituidan.dbreview.repository;

import com.tuituidan.dbreview.bean.entity.Rule;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RuleRepository.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
public interface RuleRepository extends JpaRepository<Rule, Integer> {

}
