package cn.zwsheng.lostandfound.VO;

import cn.zwsheng.lostandfound.domain.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LostThingsVO implements Serializable,Comparable<LostThingsVO> {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String thingsName;
    private String lostPlace;
    private Date lostTime;
    private String thingsType;
    private String thingsNo;
    private String thingsImg;
    private String thingsDes;
    private Date publishTime;
    private int status;
    private User user;

    public LostThingsVO() {
    }

    public LostThingsVO(Long id, String thingsName, String lostPlace, Date lostTime, String thingsType, String thingsNo, String thingsImg, String thingsDes, Date publishTime, int status, User user) {
        this.id = id;
        this.thingsName = thingsName;
        this.lostPlace = lostPlace;
        this.lostTime = lostTime;
        this.thingsType = thingsType;
        this.thingsNo = thingsNo;
        this.thingsImg = thingsImg;
        this.thingsDes = thingsDes;
        this.publishTime = publishTime;
        this.status = status;
        this.user = user;
    }

    public LostThingsVO(String thingsName, String lostPlace, Date lostTime,
                        String thingsType, String thingsDes, Date publishTime, int status,
                        User user) {
        this.thingsName = thingsName;
        this.lostPlace = lostPlace;
        this.lostTime = lostTime;
        this.thingsType = thingsType;
        this.thingsDes = thingsDes;
        this.publishTime = publishTime;
        this.status = status;
        this.user = user;
    }

    public LostThingsVO(String thingsName, String lostPlace, Date lostTime,
                      String thingsType, String thingsNo, String thingsImg,
                      String thingsDes, Date publishTime, int status, User user) {
        this.thingsName = thingsName;
        this.lostPlace = lostPlace;
        this.lostTime = lostTime;
        this.thingsType = thingsType;
        this.thingsNo = thingsNo;
        this.thingsImg = thingsImg;
        this.thingsDes = thingsDes;
        this.publishTime = publishTime;
        this.status = status;
        this.user = user;
    }

    @Override
    public int compareTo(LostThingsVO o) {
        if(this.publishTime.getTime() < o.getPublishTime().getTime()){
            return 1;
        }
        return -1;
    }
}
