package cn.zwsheng.lostandfound.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="expressthanks")
public class ExpressThanks implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="Title")
	private String title;

	@Column(name="Substance")
	private String substance;

	@Column(name="Status")
	private int status;

	@Column(name="Username")
	private String username;

	@Column(name="Leavetime")
	private Date leaveTime;

	public ExpressThanks() {
	}

	public ExpressThanks(String title, String substance, int status,
                         String userName, Date leaveTime) {
		this.title = title;
		this.substance = substance;
		this.status = status;
		this.username = userName;
		this.leaveTime = leaveTime;
	}

}
