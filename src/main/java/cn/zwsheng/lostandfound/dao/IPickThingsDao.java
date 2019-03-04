package cn.zwsheng.lostandfound.dao;

import cn.zwsheng.lostandfound.domain.PickThings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pickThingsDao")
public interface IPickThingsDao extends JpaRepository<PickThings,Long> {

}
