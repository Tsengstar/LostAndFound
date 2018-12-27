package cn.zwsheng.lostandfound.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "loginlog")
public class Loginlog {

    public static final int LOGIN_SUCCESS = 0;
    public static final int LOGIN_FAILED = 1;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username; //登录用户名

    @Column(name = "ip")
    private String ip;  //登录ip

    @Column(name = "logintime")
    private Date loginTime;   //登录时间

    @Column(name = "loginstate")
    private int state = LOGIN_SUCCESS;  //登录状态:成功/失败

}
