package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.IMenuitemDao;
import cn.zwsheng.lostandfound.domain.MenuItem;
import cn.zwsheng.lostandfound.service.IMenuitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("menuitemService")
public class MenuitemServiceImpl implements IMenuitemService {

    @Autowired
    private IMenuitemDao menuitemDao;


    public List<List<MenuItem>> getTwoMenuitems() {
        List<List<MenuItem>> result = new ArrayList<List<MenuItem>>();     //创建结果菜单menuList
        List<MenuItem> oneMenu = menuitemDao.getMenuItemsByParentId("-1");  //一级菜单
        List<MenuItem> twoMenu = menuitemDao.getMenuItemsByParentIdNot("-1");   //二级菜单
        Collections.sort(oneMenu);

        List<MenuItem> TempChildMenu = null;  //创建临时二级菜单
        for(MenuItem oneMenus:oneMenu){ //装载并遍历父菜单
            TempChildMenu = new ArrayList<MenuItem>();
            System.out.println(oneMenus);
            for(MenuItem twoMenus:twoMenu){
                if (oneMenus.getMenuId().equals(twoMenus.getParentId())){
                    TempChildMenu.add(twoMenus);//装载子菜单
                }
            }
            result.add(TempChildMenu);//装载父菜单
        }
        System.out.println(result);
        return result;
    }

    public List<MenuItem> getOneMenuitems() {
        List<MenuItem> menuItems = menuitemDao.getMenuItemsByParentId("-1");
        Collections.sort(menuItems);
        return menuItems;
    }
}
