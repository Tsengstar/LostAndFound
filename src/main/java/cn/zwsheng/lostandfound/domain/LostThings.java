package cn.zwsheng.lostandfound.domain;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "lostthings")
public class LostThings implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column(name = "thingsname")
	private String thingsName;

	@Column(name = "lostplace")
	private String lostPlace;

	@Column(name = "losttime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lostTime;

	@Column(name = "thingstype")
	private String thingsType;

	@Column(name = "thingsno")
	private String thingsNo;

	@Column(name = "thingsimg")
	private String thingsImg;

	@Column(name = "thingsdes")
	private String thingsDes;

	@Column(name = "publishtime")
	private Date publishTime;

	@Column(name = "status")
	private int status;

	@Column(name = "username")
	private String userName;

	@Column(name = "uid")
	private long uid;

	public LostThings() {
	}

	public LostThings(String thingsName, String lostPlace, Date lostTime,
                      String thingsType, String thingsDes, Date publishTime, int status,
                      String userName, long uid) {
		this.thingsName = thingsName;
		this.lostPlace = lostPlace;
		this.lostTime = lostTime;
		this.thingsType = thingsType;
		this.thingsDes = thingsDes;
		this.publishTime = publishTime;
		this.status = status;
		this.userName = userName;
		this.uid = uid;
	}

	public LostThings(String thingsName, String lostPlace, Date lostTime,
                      String thingsType, String thingsNo, String thingsImg,
                      String thingsDes, Date publishTime, int status, String userName, long uid) {
		this.thingsName = thingsName;
		this.lostPlace = lostPlace;
		this.lostTime = lostTime;
		this.thingsType = thingsType;
		this.thingsNo = thingsNo;
		this.thingsImg = thingsImg;
		this.thingsDes = thingsDes;
		this.publishTime = publishTime;
		this.status = status;
		this.userName = userName;
		this.uid = uid;
	}

}
