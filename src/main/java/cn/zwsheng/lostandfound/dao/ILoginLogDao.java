package cn.zwsheng.lostandfound.dao;


import cn.zwsheng.lostandfound.domain.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("loginlogDao")
public interface ILoginLogDao extends JpaRepository<LoginLog,Long> {

}
