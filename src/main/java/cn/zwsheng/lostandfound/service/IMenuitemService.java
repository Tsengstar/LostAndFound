package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.domain.MenuItem;

import java.util.List;

public interface IMenuitemService {
    /**
     * 获取菜单选项
     * @return
     */
    public List<List<MenuItem>> getTwoMenuitems();

    public List<MenuItem> getOneMenuitems();

}
