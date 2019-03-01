package cn.zwsheng.lostandfound.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column
	private String password;

	@Column
	private String grade;

	@Column
	private String name;

	@Column(name = "nickname")
	private String nickName;

	@Column(name = "telphone")
	private String telPhone;

	@Column
	private String email;

	@Column
	private String qq;

	@Column
	private int state;

	@Column(name = "createtime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	@Column(name = "isnew")
	private int isNew;

	@Column(name = "lastlogintime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;

	public User() {
	}

	public User(String userName, String password, String grade,
                String telPhone, int state, Date createTime, int isNew) {
		this.password = password;
		this.grade = grade;
		this.telPhone = telPhone;
		this.state = state;
		this.createTime = createTime;
		this.isNew = isNew;
	}

	public User(String userName, String password, String grade, String name,
                String nickName, String telPhone, String email, String qq,
                int state, Date createTime, int isNew, Date lastLoginTime) {
		this.password = password;
		this.grade = grade;
		this.name = name;
		this.nickName = nickName;
		this.telPhone = telPhone;
		this.email = email;
		this.qq = qq;
		this.state = state;
		this.createTime = createTime;
		this.isNew = isNew;
		this.lastLoginTime = lastLoginTime;
	}

}
