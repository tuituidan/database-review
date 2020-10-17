package com.tuituidan.dbreview.controller;

import com.tuituidan.dbreview.bean.dto.RuleDto;
import com.tuituidan.dbreview.bean.entity.Rule;
import com.tuituidan.dbreview.consts.Consts;
import com.tuituidan.dbreview.service.RuleService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RuleController.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@RestController
@RequestMapping(Consts.API_V1 + "/rule")
public class RuleController {

    @Resource
    private RuleService ruleService;

    @GetMapping
    public ResponseEntity<List<Rule>> select() {
        return ResponseEntity.ok(ruleService.select());
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody RuleDto ruleDto) {
        ruleService.save(ruleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody RuleDto ruleDto) {
        ruleDto.setId(id);
        ruleService.save(ruleDto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/{valid}")
    public ResponseEntity<Void> setValid(@PathVariable("id") Integer id, @PathVariable("valid") Boolean valid) {
        ruleService.setValid(id, valid);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        ruleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
