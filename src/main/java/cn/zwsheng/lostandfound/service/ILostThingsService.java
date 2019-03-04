package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.VO.LostThingsVO;
import cn.zwsheng.lostandfound.domain.LostThings;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ILostThingsService {
    List<LostThingsVO> findAll();

    LostThings publishLostthing(HttpServletRequest request, String thingImg);
}
