package com.db117.example.poi;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author db117
 * @date 2019/12/23/023 11:53
 */
public class ExcelExportUtilTest {
    private File file;

    @Before
    public void setUp() {
        file = new File(this.getClass().getResource("/ExportTemplate.xlsx").getFile());
    }

    @Test
    public void test() {
        List<ExportObject> list = new ArrayList<>(10000);
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ExcelExportUtil.build(IoUtil.toStream(file)
                , new String[]{
                        "string"
                        , "integer"
                        , "aDouble"
                        , "decimal"
                        , "aBoolean"
                        , "localDate"
                        , "localDateTime"
                        , "date"
                }, 200000);

        for (int i = 0; i < 200; i++) {
            System.out.println("-------------" + i);
            for (int j = 0; j < 10000; j++) {

                list.add(ExportObject.builder()
                        .string("" + i)
                        .aBoolean(i % 2 == 0)
                        .date(date)
                        .integer(i)
                        .aDouble(i * 2.589d)
                        .decimal(new BigDecimal(i * 878.99))
                        .localDate(localDate)
                        .localDateTime(localDateTime)
                        .build());
                ExcelExportUtil.writeObject(list);
                list.clear();
            }
        }


        System.out.println("-------------");
        File file = ExcelExportUtil.stop();
        System.out.println(file.getPath());
    }


}
