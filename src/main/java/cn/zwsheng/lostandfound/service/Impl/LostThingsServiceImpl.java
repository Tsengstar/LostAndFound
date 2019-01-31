package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.ILostThingsDao;
import cn.zwsheng.lostandfound.domain.LostThings;
import cn.zwsheng.lostandfound.service.ILostThingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LostThingsService")
public class LostThingsServiceImpl implements ILostThingsService {
    @Autowired
    private ILostThingsDao lostThingsDao;

    public LostThings getOne() {
        LostThings result = lostThingsDao.getOne(1L);
        System.out.println(result);
        return result;
    }
}
