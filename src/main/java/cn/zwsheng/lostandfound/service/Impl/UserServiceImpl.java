package cn.zwsheng.lostandfound.service.Impl;

import cn.zwsheng.lostandfound.dao.IUserDao;
import cn.zwsheng.lostandfound.domain.User;
import cn.zwsheng.lostandfound.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    public List<User> findAllUser() {
        return userDao.findAll();
    }

    public User login(String username, String password) {
        User current = userDao.findByUserNameAndPassword(username,password);
        return current;
    }
}
