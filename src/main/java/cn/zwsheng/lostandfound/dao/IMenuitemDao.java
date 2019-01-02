package cn.zwsheng.lostandfound.dao;


import cn.zwsheng.lostandfound.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("menuitemDao")
public interface IMenuitemDao extends JpaRepository<MenuItem,Long> {

}
