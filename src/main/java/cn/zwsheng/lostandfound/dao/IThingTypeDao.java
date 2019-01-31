package cn.zwsheng.lostandfound.dao;

import cn.zwsheng.lostandfound.domain.ThingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("thingTypeDao")
public interface IThingTypeDao extends JpaRepository<ThingType, Long> {
}
