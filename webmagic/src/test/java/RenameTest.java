import org.junit.Test;

import java.io.File;

/**
 * @author 大兵
 * @date 2018-09-24 19:52
 **/
public class RenameTest {


    @Test
    public void rename() {
        // 文件集合
        File[] files = new File("D:\\webmagic").listFiles();
        for (File f : files) {
            if (f.isFile()) {
                String name = f.getPath().replace("_magent_magent","_magent");
                f.renameTo(new File(name));
            }
        }
    }
}
