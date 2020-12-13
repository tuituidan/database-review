package com.tuituidan.dbreview.controller;

import com.tuituidan.dbreview.service.DataBaseService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * IndexController.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/11
 */
@Controller
public class IndexController {

    @Resource
    private DataBaseService dataBaseService;

    /**
     * 首页.
     *
     * @return String
     */
    @GetMapping({"/", "index.html", "/{schema}"})
    public String index(@PathVariable(required = false) String schema, ModelMap modelMap) {
        if (schema == null) {
            List<String> schemas = dataBaseService.selectSchemas();
            if (CollectionUtils.isNotEmpty(schemas)) {
                modelMap.put("schema", schemas.get(0));
            }
            return "index";
        }
        modelMap.put("schema", schema);
        return "index";
    }
}
