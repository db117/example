import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.file.FileWriter;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.PlainText;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.File;

/**
 * @author 大兵
 * @date 2018-09-16 1:41
 **/
public class MagentUpdate extends FilePersistentBase implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        try {
            File file = new File("D:\\webmagic\\Magent.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            PlainText data = (PlainText) resultItems.get("data");
            String ttt = "magnet:?xt=urn:btih:" + data.get();
            FileWriter.create(file).writeLines(CollUtil.newArrayList(ttt), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
