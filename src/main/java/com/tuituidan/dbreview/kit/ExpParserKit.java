package com.tuituidan.dbreview.kit;

import java.util.Map;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * ExpParserKit.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/10/17
 */
@UtilityClass
public class ExpParserKit {

    private static final ExpressionParser PARSER = new SpelExpressionParser();

    /**
     * 执行.
     *
     * @param exp 表达式
     * @param map 参数
     * @return Object
     */
    public static boolean evaluate(String exp, Map<String, Object> map) {
        EvaluationContext context = new StandardEvaluationContext();
        map.forEach(context::setVariable);
        return BooleanUtils.isTrue(PARSER.parseExpression(exp).getValue(context, Boolean.class));
    }

    /**
     * 模版替换.
     *
     * @param source source
     * @param params params
     * @return String
     */
    public static String template(String source, Map<String, Object> params) {
        EvaluationContext context = new StandardEvaluationContext();
        params.forEach(context::setVariable);
        return PARSER.parseExpression(source).getValue(context, String.class);
    }

}
