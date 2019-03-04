package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.VO.PickThingsVO;
import cn.zwsheng.lostandfound.dao.IPickThingsDao;
import cn.zwsheng.lostandfound.dao.IUserDao;
import cn.zwsheng.lostandfound.domain.LostThings;
import cn.zwsheng.lostandfound.domain.PickThings;
import cn.zwsheng.lostandfound.domain.User;
import cn.zwsheng.lostandfound.service.IPickThingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

@Service
public class PickThingsServiceImpl implements IPickThingsService {

    @Autowired
    IPickThingsDao pickThingsDao;

    @Autowired
    IUserDao userDao;

    @Override
    public List<PickThingsVO> findAll() {
        List<PickThings> pickThingsList = pickThingsDao.findAll();
        List<PickThingsVO> pickThingsVOList = new ArrayList<PickThingsVO>();
        for (PickThings pickThings: pickThingsList) {
            User user = userDao.getOne(pickThings.getUid());
            PickThingsVO pickThingsVO = new PickThingsVO(pickThings.getId(),pickThings.getThingsName(),pickThings.getPickPlace(),
                    pickThings.getPickTime(),pickThings.getThingsType(),pickThings.getThingsNo(),
                    pickThings.getThingsImg(),pickThings.getThingsDes(),pickThings.getPublishTime(),pickThings.getStatus(),user);
            pickThingsVOList.add(pickThingsVO);
        }
        Collections.sort(pickThingsVOList);
        return pickThingsVOList;
    }

    @Override
    public PickThings publishLostthing(HttpServletRequest request, String thingImg) {
        String thingName = (String) request.getParameter("thingName");
        String thingType = (String) request.getParameter("thingType");
        String pickPlace = (String) request.getParameter("pickPlace");
        String thingDes = (String) request.getParameter("thingDes");
        String pickTime = (String) request.getParameter("pickTime");
        String storagePlace = (String) request.getParameter("storagePlace");
        User current = (User) request.getSession().getAttribute("current");
        Date pickTimeDate = new Date();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            pickTimeDate = sdf.parse(pickTime);
        }catch (Exception e){
            throw new DateTimeException("时间格式错误！");
        }
        PickThings pickThings = new PickThings(thingName,pickPlace,pickTimeDate,thingType,UUID.randomUUID().toString().substring(0,8),thingImg,thingDes,storagePlace,"000000",new Date(),0,current.getUserName(),current.getId());
       // PickThings pickThings = new PickThings(thingName,pickPlace,pickTimeDate,thingType, UUID.randomUUID().toString().substring(0,8),thingImg,thingDes,new Date(),0,current.getUserName(),current.getId());
        return pickThingsDao.save(pickThings);
    }
}
