package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.ILoginLogDao;
import cn.zwsheng.lostandfound.domain.LoginLog;
import cn.zwsheng.lostandfound.service.ILoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginlogServiceImpl implements ILoginlogService {

    @Autowired
    private ILoginLogDao loginlogDao;

    public void save(LoginLog loginlog) {
        loginlogDao.save(loginlog);
    }
}
