package com.example.magent;

import cn.hutool.core.util.StrUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.PlainText;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.util.List;

/**
 * @author 大兵
 * @date 2018-09-17 23:35
 **/
public class CiliMaoPopeline extends FilePersistentBase implements Pipeline {
    private List<Entity> list;

    CiliMaoPopeline(List<Entity> list) {
        this.list = list;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        Entity entity = new Entity();
        PlainText data = resultItems.get("data");
        entity.setData(data.get());

        PlainText num = resultItems.get("num");

        String[] split = StrUtil.split(num.get(), "个文件");

        entity.setNum(Integer.valueOf(split[0]));

        list.add(entity);
    }

    class Entity {
        String data;
        int num;

        void setData(String data) {
            this.data = data;
        }

        void setNum(int num) {
            this.num = num;
        }

        String getData() {
            return data;
        }

        int getNum() {
            return num;
        }
    }
}
