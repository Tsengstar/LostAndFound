package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.ILostThingsDao;
import cn.zwsheng.lostandfound.domain.LostThings;
import cn.zwsheng.lostandfound.domain.ThingType;
import cn.zwsheng.lostandfound.domain.User;
import cn.zwsheng.lostandfound.service.ILostThingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("LostThingsService")
public class LostThingsServiceImpl implements ILostThingsService {
    @Autowired
    private ILostThingsDao lostThingsDao;

    public LostThings getOne() {
        LostThings result = lostThingsDao.getOne(1L);
        System.out.println(result);
        return result;
    }

    @Override
    public LostThings publishLostthing(HttpServletRequest request, String thingImg) {
        String thingName = (String) request.getParameter("thingName");
        String thingType = (String) request.getParameter("thingType");
        String lostPlace = (String) request.getParameter("lostPlace");
        String thingDes = (String) request.getParameter("thingDes");
        String lostTime = (String) request.getParameter("lostTime");
        LostThings lostThings = new LostThings();
        ThingType thingTypeDomain = new ThingType();
        thingTypeDomain.setId(Long.parseLong(thingType));
        User current = new User();
        current.setId(1L);
        lostThings.setThingsName(thingName);
        lostThings.setThingsType(thingTypeDomain);
        lostThings.setUser(current);
        lostThings.setLostPlace(lostPlace);
        lostThings.setLostTime(lostTime);
        lostThings.setPublishTime(new Date());
        lostThings.setStatus(1);
        lostThings.setThingsDes(thingDes);
        lostThings.setThingsImg(thingImg);
        return lostThingsDao.save(lostThings);
    }
}
