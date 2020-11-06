package com.tuituidan.dbreview.service;

import com.tuituidan.dbreview.repository.EnvirRepository;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * EnvirService.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/23
 */
@Service
public class EnvirService {

    @Resource
    private EnvirRepository envirRepository;

}
