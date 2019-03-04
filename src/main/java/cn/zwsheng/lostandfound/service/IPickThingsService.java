package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.VO.PickThingsVO;
import cn.zwsheng.lostandfound.domain.PickThings;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IPickThingsService {
    List<PickThingsVO> findAll();

    PickThings publishLostthing(HttpServletRequest request, String fileName);
}
