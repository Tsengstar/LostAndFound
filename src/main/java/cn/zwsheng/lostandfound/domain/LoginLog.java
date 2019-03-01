package cn.zwsheng.lostandfound.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="loginlog")
public class LoginLog implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "osname")
	private String osname;

	@Column(name = "browsername")
	private String browserName;

	@Column(name = "loginip")
	private String loginIp;

	@Column(name = "logintime")
	private Date loginTime;

	@Column(name = "uid")
	private long uid;

	public LoginLog() {
	}

	public LoginLog(String userName, String loginIp, Date loginTime, long uid) {
		this.userName = userName;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.uid = uid;
	}

	public LoginLog(String userName, String osname, String browserName,
                    String loginIp, Date loginTime, long uid) {
		this.userName = userName;
		this.osname = osname;
		this.browserName = browserName;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.uid = uid;
	}

}
