package com.tuituidan.dbreview.repository;

import com.tuituidan.dbreview.bean.entity.Setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * SettingRepository.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
public interface SettingRepository extends JpaRepository<Setting, Integer> {
    /**
     * updateAuto.
     *
     * @param auto auto
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update Setting set auto=:auto where id=1")
    void updateAuto(@Param("auto") Boolean auto);

    /**
     * updateCron.
     *
     * @param cron cron
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update Setting set cron=:cron where id=1")
    void updateCron(@Param("cron") String cron);

    /**
     * updateSchemas.
     *
     * @param schemas schemas
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update Setting set schemas=:schemas where id=1")
    void updateSchemas(@Param("schemas") String schemas);
}
