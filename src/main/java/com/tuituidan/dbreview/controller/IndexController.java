package com.tuituidan.dbreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/11
 */
@Controller
public class IndexController {


    /**
     * 首页.
     *
     * @return String
     */
    @GetMapping({"/", "index.html"})
    public String index() {
        return "index";
    }
}
