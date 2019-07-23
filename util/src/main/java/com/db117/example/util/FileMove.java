package com.db117.example.util;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 文件移动
 *
 * @author 117
 */
@Slf4j
public class FileMove {
    public static void main(String[] args) {
        List<String> del = Arrays.asList("在线视频.url", "种子男导航.url", "最新网址.png");
        // 删除垃圾文件
        FileUtil.loopFiles("H:\\新建文件夹\\解压").stream().filter(file -> del.contains(file.getName())).forEach(file -> {
            FileUtil.del(file);
            log.info("删除文件[{}]", file.getName());
        });

        File[] files = new File("H:\\新建文件夹\\解压").listFiles();
        // 父文件夹

        assert files != null;
        for (File parent : files) {
            // 删除空文件夹
            if (FileUtil.isDirEmpty(parent)) {
                FileUtil.del(parent);
            }

            // 里面的文件
            File[] listFiles = parent.listFiles();
            for (File file : listFiles) {
                if (listFiles.length == 1) {
                    // 有名字的文件
                    long length = file.length();
                    if (file.isFile() && length > 1024 * 1024 * 100 && file.getName().length() > 10) {
                        FileUtil.move(file, new File("H:\\新建文件夹\\over\\" + file.getName()), true);
                        log.info("移动文件[{}]", file.getName());
                        FileUtil.del(parent);
                        log.info("删除文件夹[{}]", parent.getName());
                    }
                } else {
                    // 重命名文件夹
                    if (file.isFile() && file.getName().length() > 10) {
                        if (parent.renameTo(new File(parent.getParent() + File.separator + file.getName()))) {
                            log.info("重命名文件夹[{}]", parent.getName());
                        }
                    }
                }

            }
        }
    }
}
