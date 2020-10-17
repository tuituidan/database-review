package com.tuituidan.dbreview.kit;

import com.tuituidan.dbreview.consts.Consts;
import com.tuituidan.dbreview.exception.DbReviewException;

import java.util.Map;
import java.util.Objects;

import lombok.experimental.UtilityClass;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.scheduling.support.CronTrigger;

/**
 * StringKit.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@UtilityClass
public class StringKit {
    /**
     * 使用 Slf4j 中的字符串格式化方式来格式化字符串.
     *
     * @param pattern 待格式化的字符串
     * @param args    参数
     * @return 格式化后的字符串
     */
    public static String format(String pattern, Object... args) {
        return pattern == null ? "" : MessageFormatter.arrayFormat(pattern, args).getMessage();
    }

    /**
     * 模版替换.
     *
     * @param source source
     * @param params params
     * @return String
     */
    public static String template(String source, Map<String, Object> params) {
        if (source.contains(Consts.SEP_POUND)) {
            return ExpParserKit.template(source, params);
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            source = source.replace("{" + entry.getKey() + "}", Objects.toString(entry.getValue()));
        }
        return source;
    }

    /**
     * 利用spring的CronTrigger来检查cron表达对不对.
     *
     * @param cron 表达式
     */
    public static void cronCheck(String cron) {
        try {
            new CronTrigger(cron);
        } catch (Exception ex) {
            throw DbReviewException.builder().error("cron表达式格式错误：{}", cron, ex).build();
        }
    }
}
