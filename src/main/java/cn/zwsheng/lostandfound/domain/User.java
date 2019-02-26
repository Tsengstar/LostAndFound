package cn.zwsheng.lostandfound.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter@Setter@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "grade")
    private String grade;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "telphone")
    private String telPhone;

    @Column(name = "email")
    private String email;

    @Column(name = "qq")
    private String qq;

    @Column(name = "state")
    private int state;

    @Column(name = "createtime")
    private Date createTime;

    @Column(name = "isnew")
    private int isNew;

    @Column(name = "lastlogintime")
    private Date lastLoginTime;
}
