package cn.zwsheng.lostandfound.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Entity
@Table(name = "lostthings")
public class LostThings {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //id

    @Column(name = "things_name")
    private String thingsName;

    @Column(name = "lost_place")
    private String lostPlace;

    @Column(name = "lost_time")
    private String lostTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "things_type")
    private ThingType thingsType;

    @Column(name = "things_img")
    private String thingsImg;

    @Column(name = "things_des")
    private String thingsDes;

    @Column(name = "publish_time")
    private Date publishTime;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    private User user;
}
