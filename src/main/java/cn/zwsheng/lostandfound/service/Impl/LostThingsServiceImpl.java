package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.VO.LostThingsVO;
import cn.zwsheng.lostandfound.dao.ILostThingsDao;
import cn.zwsheng.lostandfound.dao.IUserDao;
import cn.zwsheng.lostandfound.domain.LostThings;
import cn.zwsheng.lostandfound.domain.User;
import cn.zwsheng.lostandfound.service.ILostThingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

@Service("LostThingsService")
public class LostThingsServiceImpl implements ILostThingsService {
    @Autowired
    private ILostThingsDao lostThingsDao;

    @Autowired
    private IUserDao userDao;

    @Override
    public List<LostThingsVO> findAll() {
        List<LostThings> lostThingsList = lostThingsDao.findAll();
        List<LostThingsVO> lostThingsVOList = new ArrayList<LostThingsVO>();
        for (LostThings lostThings: lostThingsList) {
            User user = userDao.getOne(lostThings.getUid());
            LostThingsVO lostThingsVO = new LostThingsVO(lostThings.getId(),lostThings.getThingsName(),lostThings.getLostPlace(),
                    lostThings.getLostTime(),lostThings.getThingsType(),lostThings.getThingsNo(),
                    lostThings.getThingsImg(),lostThings.getThingsDes(),lostThings.getPublishTime(),lostThings.getStatus(),user);
            lostThingsVOList.add(lostThingsVO);
        }
        Collections.sort(lostThingsVOList);
        return lostThingsVOList;
    }

    @Override
    public LostThings publishLostthing(HttpServletRequest request, String thingImg) {
        String thingName = (String) request.getParameter("thingName");
        String thingType = (String) request.getParameter("thingType");
        String lostPlace = (String) request.getParameter("lostPlace");
        String thingDes = (String) request.getParameter("thingDes");
        String lostTime = (String) request.getParameter("lostTime");
        User current = (User) request.getSession().getAttribute("current");
        Date lostTimeDate = new Date();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            lostTimeDate = sdf.parse(lostTime);
        }catch (Exception e){
            throw new DateTimeException("时间格式错误！");
        }
        LostThings lostThings = new LostThings(thingName,lostPlace,lostTimeDate,thingType,UUID.randomUUID().toString().substring(0,8),thingImg,thingDes,new Date(),0,current.getUserName(),current.getId());
        return lostThingsDao.save(lostThings);
    }
}
