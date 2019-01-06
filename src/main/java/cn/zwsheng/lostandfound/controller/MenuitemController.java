package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.domain.MenuItem;
import cn.zwsheng.lostandfound.service.IMenuitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class MenuitemController {
    @Autowired
    private IMenuitemService menuitemService;

    @RequestMapping("/getMenuitems")
    public Map<MenuItem,List<MenuItem>> getMenuitems(){
        return menuitemService.getMenuitem();
    }
}
