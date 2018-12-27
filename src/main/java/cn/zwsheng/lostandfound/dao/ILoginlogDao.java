package cn.zwsheng.lostandfound.dao;


import cn.zwsheng.lostandfound.domain.Loginlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("loginlogDao")
public interface ILoginlogDao extends JpaRepository<Loginlog,Long> {

}
