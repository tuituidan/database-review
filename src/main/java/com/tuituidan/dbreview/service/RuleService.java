package com.tuituidan.dbreview.service;

import com.tuituidan.dbreview.bean.dto.RuleDto;
import com.tuituidan.dbreview.bean.entity.Rule;
import com.tuituidan.dbreview.repository.RuleRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * RuleService.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Service
public class RuleService {

    @Resource
    private RuleRepository ruleRepository;

    @Cacheable(value = "all")
    public List<Rule> getRule() {
        return select().stream().filter(item -> BooleanUtils.isTrue(item.getValid())).collect(Collectors.toList());
    }

    public List<Rule> select() {
        return ruleRepository.findAll();
    }

    @CacheEvict(value = "all", allEntries = true)
    public void save(RuleDto ruleDto) {
        Rule rule;
        if (ruleDto.getId() == null) {
            rule = new Rule();
            rule.setValid(true);
        } else {
            rule = ruleRepository.findById(ruleDto.getId()).orElse(new Rule());
        }
        BeanUtils.copyProperties(ruleDto, rule, "id");
        ruleRepository.save(rule);
    }

    @CacheEvict(value = "all", allEntries = true)
    public void setValid(Integer id, Boolean valid) {
        Rule rule = ruleRepository.findById(id).orElseThrow(NullPointerException::new);
        rule.setValid(valid);
        ruleRepository.save(rule);
    }

    @CacheEvict(value = "all", allEntries = true)
    public void delete(Integer id) {
        ruleRepository.deleteById(id);
    }
}
