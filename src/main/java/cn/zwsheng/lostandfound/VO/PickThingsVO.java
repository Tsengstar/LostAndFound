package cn.zwsheng.lostandfound.VO;

import cn.zwsheng.lostandfound.domain.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PickThingsVO implements Serializable,Comparable<PickThingsVO>{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String thingsName;
    private String pickPlace;
    private Date pickTime;
    private String thingsType;
    private String thingsNo;
    private String thingsImg;
    private String thingsDes;
    private Date publishTime;
    private int status;
    private User user;

    public PickThingsVO() {
    }

    public PickThingsVO(Long id, String thingsName, String lostPlace, Date lostTime, String thingsType, String thingsNo, String thingsImg, String thingsDes, Date publishTime, int status, User user) {
        this.id = id;
        this.thingsName = thingsName;
        this.pickPlace = lostPlace;
        this.pickTime = lostTime;
        this.thingsType = thingsType;
        this.thingsNo = thingsNo;
        this.thingsImg = thingsImg;
        this.thingsDes = thingsDes;
        this.publishTime = publishTime;
        this.status = status;
        this.user = user;
    }

    public PickThingsVO(String thingsName, String lostPlace, Date lostTime,
                        String thingsType, String thingsDes, Date publishTime, int status,
                        User user) {
        this.thingsName = thingsName;
        this.pickPlace = lostPlace;
        this.pickTime = lostTime;
        this.thingsType = thingsType;
        this.thingsDes = thingsDes;
        this.publishTime = publishTime;
        this.status = status;
        this.user = user;
    }

    public PickThingsVO(String thingsName, String lostPlace, Date lostTime,
                        String thingsType, String thingsNo, String thingsImg,
                        String thingsDes, Date publishTime, int status, User user) {
        this.thingsName = thingsName;
        this.pickPlace = lostPlace;
        this.pickTime = lostTime;
        this.thingsType = thingsType;
        this.thingsNo = thingsNo;
        this.thingsImg = thingsImg;
        this.thingsDes = thingsDes;
        this.publishTime = publishTime;
        this.status = status;
        this.user = user;
    }

    @Override
    public int compareTo(PickThingsVO o) {
        if(this.publishTime.getTime() < o.getPublishTime().getTime()){
            return 1;
        }
        return -1;
    }
}
