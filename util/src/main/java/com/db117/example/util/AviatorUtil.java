package com.db117.example.util;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;

import java.util.HashMap;
import java.util.Map;

/**
 * @author db117
 * @date 2020/9/15/015 11:53
 **/
public class AviatorUtil {
    public static void main(String[] args) {
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
        String expression = "金额/(1+税率)*0.1";
        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<>();
        env.put("金额", 100.3);
        env.put("税率", 0.5);
        Object o = compiledExp.execute(env);
        System.out.println(o.getClass());
        // 执行表达式
        System.out.println(o);  // false
    }
}
