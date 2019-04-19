package com.db117.example.poi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExcelImportUtilTest {
    private File file;

    @Before
    public void setUp() {
        file = new File(this.getClass().getResource("/importTest.xlsx").getFile());
    }

    @Test
    public void doImport() {
        List<Map<String, String>> maps = ExcelImportUtil.doImport(file, new String[]{"a", "b", "c"});
        Assert.assertEquals(maps.size(), 2);
        Assert.assertEquals(maps.get(0).get("a"), "a2");
    }

    @Test
    public void doImport1() {
        ExcelImportUtil.doImport(file, new String[]{"a", "b", "c"}, System.out::println);
    }
}