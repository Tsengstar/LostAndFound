package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.domain.MenuItem;

import java.util.List;
import java.util.Map;

public interface IMenuitemService {
    /**
     * 获取菜单选项
     * @return
     */
    public Map<MenuItem, List<MenuItem>> getMenuitem();

    public List<MenuItem> getMenuitems();
}
