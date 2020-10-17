package com.tuituidan.dbreview.service;

import com.tuituidan.dbreview.bean.entity.Setting;
import com.tuituidan.dbreview.repository.SettingRepository;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * SettingService.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@Service
public class SettingService {

    @Resource
    private SettingRepository settingRepository;
    public Setting get() {
        return settingRepository.findById(1).orElseThrow(NullPointerException::new);
    }
}
