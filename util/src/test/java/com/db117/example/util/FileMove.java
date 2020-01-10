package com.db117.example.util;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 文件移动
 *
 * @author 117
 */
@Slf4j
public class FileMove {

    @Test
    public void test() {
        move("E:\\新建文件夹\\解压", "E:\\新建文件夹\\over");
    }

    private void move(String sourceDir, String targetDir) {
        List<String> del = Arrays.asList("在線視頻.url", "種子男導航.url", "最新網址.png", "FB.png", "FM.png");
        // 删除垃圾文件
        FileUtil.loopFiles(sourceDir).stream().filter(file -> del.contains(file.getName())).forEach(file -> {
            FileUtil.del(file);
            log.info("删除文件[{}]", file.getName());
        });

        File[] files = new File(sourceDir).listFiles();
        // 父文件夹

        assert files != null;
        for (File parent : files) {
            if (parent.isFile()) {
                continue;
            }
            // 删除空文件夹
            if (FileUtil.isDirEmpty(parent)) {
                FileUtil.del(parent);
                continue;
            }

            // 里面的文件
            File[] listFiles = parent.listFiles();
            if (listFiles.length == 1) {
                File file = listFiles[0];
                // 有名字的文件
                if (file.isFile() && file.length() > 1024 * 1024 * 10 && file.getName().length() > 10) {
                    FileUtil.move(file, new File(targetDir + File.separator + file.getName()), true);
                    log.info("移动文件[{}]", file.getName());
                    FileUtil.del(parent);
                    log.info("删除文件夹[{}]", parent.getName());
                }
                continue;
            }
            File file = Arrays.stream(listFiles).max(Comparator.comparingInt(o -> o.getName().length())).get();
            if (file.getName().length() > 10) {
                if (parent.renameTo(new File(parent.getParent() + File.separator + file.getName()))) {
                    log.info("重命名文件夹[{}]", parent.getName());
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
