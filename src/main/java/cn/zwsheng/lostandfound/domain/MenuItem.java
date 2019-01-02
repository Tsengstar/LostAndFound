package cn.zwsheng.lostandfound.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "menuitem")
public class MenuItem {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //id

    @Column(name = "menu_id")
    private String menuId;     //菜单id

    @Column(name = "menu_name")
    private String menuName;    //菜单名称

    @Column(name = "menu_url")
    private String menuUrl;     //菜单路径

    @Column(name = "parent_id")
    private String parentId;    //父菜单id

    @Column(name = "status")
    private int status;     //状态

    @Column(name = "menu_des")
    private  String menuDes;    //菜单描述

    @Column(name = "authority")
    private String authority;   //菜单访问权限

    @Column(name = "sort")
    private int sort;   //菜单排序




}
