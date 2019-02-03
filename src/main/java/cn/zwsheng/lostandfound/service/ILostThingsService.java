package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.domain.LostThings;

import javax.servlet.http.HttpServletRequest;

public interface ILostThingsService {
    LostThings getOne();

    LostThings publishLostthing(HttpServletRequest request, String thingImg);
}
