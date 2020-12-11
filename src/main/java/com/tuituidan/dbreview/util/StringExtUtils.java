package com.tuituidan.dbreview.util;

import lombok.experimental.UtilityClass;
import org.slf4j.helpers.MessageFormatter;

/**
 * StringExtUtils.
 *
 * @author tuituidan
 * @version 1.0
 * @date 2020/12/11
 */
@UtilityClass
public class StringExtUtils {

    /**
     * 使用 Slf4j 中的字符串格式化方式来格式化字符串.
     *
     * @param pattern 待格式化的字符串
     * @param args 参数
     * @return 格式化后的字符串
     */
    public static String format(String pattern, Object... args) {
        return pattern == null ? "" : MessageFormatter.arrayFormat(pattern, args).getMessage();
    }


}
