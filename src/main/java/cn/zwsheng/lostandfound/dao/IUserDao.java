package cn.zwsheng.lostandfound.dao;

import cn.zwsheng.lostandfound.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户的持久层接口
 */
@Repository("userDao")
public interface IUserDao extends JpaRepository<User,Long> {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    User findByUsernameAndPassword(String username, String password);
}
