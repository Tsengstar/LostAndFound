package cn.zwsheng.lostandfound.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "pickthings")
public class PickThings implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue
	private Long id;

	@Column(name = "thingsname")
	private String thingsName;

	@Column(name = "pickplace")
	private String pickPlace;

	@Column(name = "picktime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pickTime;

	@Column(name = "thingstype")
	private String thingsType;

	@Column(name = "thingsno")
	private String thingsNo;

	@Column(name = "thingsimg")
	private String thingsImg;

	@Column(name = "thingsdes")
	private String thingsDes;

	@Column(name = "storageplace")
	private String storagePlace;

	@Column(name = "telphone")
	private String telPhone;

	@Column(name = "publishtime")
	private Date publishTime;

	@Column
	private int status;

	@Column(name = "username")
	private String userName;

	@Column
	private long uid;

	public PickThings() {
	}
	
	public PickThings(String thingsName, String pickPlace, Date pickTime,
                      String thingsType, String thingsDes, int status, String userName, long uid) {
		this.thingsName = thingsName;
		this.pickPlace = pickPlace;
		this.pickTime = pickTime;
		this.thingsType = thingsType;
		this.thingsDes = thingsDes;
		this.status = status;
		this.userName = userName;
		this.uid = uid;
	}

	public PickThings(String thingsName, String pickPlace, Date pickTime,
                      String thingsType, String thingsNo, String thingsImg,
                      String thingsDes, String storagePlace, String telPhone,
                      Date publishTime, int status, String userName, long uid) {
		this.thingsName = thingsName;
		this.pickPlace = pickPlace;
		this.pickTime = pickTime;
		this.thingsType = thingsType;
		this.thingsNo = thingsNo;
		this.thingsImg = thingsImg;
		this.thingsDes = thingsDes;
		this.storagePlace = storagePlace;
		this.telPhone = telPhone;
		this.publishTime = publishTime;
		this.status = status;
		this.userName = userName;
		this.uid = uid;
	}
	
}
