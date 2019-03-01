package cn.zwsheng.lostandfound.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "notice")
public class Notice implements java.io.Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Column
	private String title;

	@Column
	private String substance;

	@Column
	private int status;

	@Column(name = "publishtime")
	private Date publishTime;

	public Notice() {
	}

	public Notice(String substance, int status, Date publishTime) {
		this.substance = substance;
		this.status = status;
		this.publishTime = publishTime;
	}

	public Notice(String title, String substance, int status, Date publishTime) {
		this.title = title;
		this.substance = substance;
		this.status = status;
		this.publishTime = publishTime;
	}

}
