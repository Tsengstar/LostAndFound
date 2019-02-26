package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.domain.LostThings;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ILostThingsService {
    List<LostThings> findAll();

    LostThings publishLostthing(HttpServletRequest request, String thingImg);
}
