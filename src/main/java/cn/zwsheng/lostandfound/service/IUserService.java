package cn.zwsheng.lostandfound.service;

import cn.zwsheng.lostandfound.domain.User;

import java.util.List;

/**
 * 用户的业务层借口
 */
public interface IUserService {

    /**
     * 返回用户列表
     * @return
     */
    List<User> findAllUser();

    /**
     * 实现登录操作
     * 返回当前用户
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
