package cn.zwsheng.lostandfound.dao;


import cn.zwsheng.lostandfound.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuitemDao")
public interface IMenuitemDao extends JpaRepository<MenuItem,Long> {

    public List<MenuItem> getMenuItemsByParentId(String parentId);

    public List<MenuItem> getMenuItemsByParentIdNot(String parentId);

}
