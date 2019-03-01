package cn.zwsheng.lostandfound.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "systemlog")
@Data
public class SystemLog implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String description;

	@Column(name = "exceptioncode")
	private String exceptionCode;

	@Column
	private String type;

	@Column(name = "requestip")
	private String requestIp;

	@Column(name = "exceptiondetail")
	private String exceptionDetail;

	@Column
	private String method;

	@Column
	private String params;

	@Column(name = "createby")
	private String createBy;

	@Column(name = "createdate")
	private Date createDate;

	public SystemLog() {
	}

	public SystemLog(Date createDate) {
		this.createDate = createDate;
	}

	public SystemLog(String description, String exceptionCode, String type,
                     String requestIp, String exceptionDetail, String method,
                     String params, String createBy, Date createDate) {
		this.description = description;
		this.exceptionCode = exceptionCode;
		this.type = type;
		this.requestIp = requestIp;
		this.exceptionDetail = exceptionDetail;
		this.method = method;
		this.params = params;
		this.createBy = createBy;
		this.createDate = createDate;
	}
}
