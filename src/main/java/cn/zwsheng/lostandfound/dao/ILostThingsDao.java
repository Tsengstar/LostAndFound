package cn.zwsheng.lostandfound.dao;

import cn.zwsheng.lostandfound.domain.LostThings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lostThingsDao")
public interface ILostThingsDao extends JpaRepository<LostThings,Long> {
}
