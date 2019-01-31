package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.IThingTypeDao;
import cn.zwsheng.lostandfound.domain.ThingType;
import cn.zwsheng.lostandfound.service.IThingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("thingTypeService")
public class ThingTypeServiceImpl implements IThingTypeService {
    @Autowired
    private IThingTypeDao thingTypeDao;


    public List<ThingType> findAll() {
        return thingTypeDao.findAll();
    }
}
