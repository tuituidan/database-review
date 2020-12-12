package com.tuituidan.dbreview.controller;

import com.tuituidan.dbreview.bean.vo.TableInfo;
import com.tuituidan.dbreview.consts.Consts;
import com.tuituidan.dbreview.service.DataBaseService;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DataBaseController.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/12
 */
@RestController
@RequestMapping(Consts.API_V1)
public class DataBaseController {

    @Resource
    private DataBaseService dataBaseService;

    @GetMapping("/schema")
    public ResponseEntity<List<String>> selectSchemas() {
        return ResponseEntity.ok(dataBaseService.selectSchemas());
    }

    @GetMapping("/schema/{schema}/tables")
    public ResponseEntity<Collection<TableInfo>> selectList(@PathVariable String schema) {
        return ResponseEntity.ok(dataBaseService.selectList(schema));
    }
}
