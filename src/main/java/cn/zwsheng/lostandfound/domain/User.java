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

    @Column(name = "user_type")
    private int userType;

    @Column(name = "state")
    private int state;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_new")
    private int isNew;

    @Column(name = "login_time")
    private Date loginTime;
}
