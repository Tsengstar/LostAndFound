package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.ILoginlogDao;
import cn.zwsheng.lostandfound.domain.Loginlog;
import cn.zwsheng.lostandfound.service.ILoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginlogServiceImpl implements ILoginlogService {

    @Autowired
    private ILoginlogDao loginlogDao;

    public void save(Loginlog loginlog) {
        loginlogDao.save(loginlog);
    }
}
