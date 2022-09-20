package com.db117.example.test;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * 获取父类私有属性
 *
 * @author db117
 * @since 2022/9/20 17:03
 **/
public class ExtendTest {


    @Test
    public void test() throws Exception {
        Son son = new Son();
        son.SetProp("222");

        Class<Father> fatherClass = Father.class;
        Field field = fatherClass.getDeclaredField("proFlag");
        field.setAccessible(true);
        System.out.println(field.get(son));
    }


    @Getter
    @Setter
    class Father {
        private String proFlag;

        public void SetProp(String proFlag) {
            this.proFlag = proFlag;
        }
    }

    @Getter
    @Setter
    class Son extends Father {
        private String proFlag;
    }
}
