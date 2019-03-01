package cn.zwsheng.lostandfound.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "menuitem")
public class MenuItem implements java.io.Serializable,Comparable<MenuItem>{

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Column(name = "menuid")
	private String menuId;

	@Column(name = "menuitemname")
	private String menuItemName;

	@Column(name = "menuitemurl")
	private String menuItemUrl;

	@Column(name = "parentid")
	private String parentId;

	@Column(name = "status")
	private int status;

	@Column(name = "menuitemdes")
	private String menuItemDes;

	@Column(name = "authority")
	private int authority;

	@Column(name = "sort")
	private Integer sort;

	public MenuItem() {
	}

	public MenuItem(String menuId, String menuItemName, int status,
                    int authority) {
		this.menuId = menuId;
		this.menuItemName = menuItemName;
		this.status = status;
		this.authority = authority;
	}

	public MenuItem(String menuId, String menuItemName, String menuItemUrl,
                    String parentId, int status, String menuItemDes, int authority,
                    Integer sort) {
		this.menuId = menuId;
		this.menuItemName = menuItemName;
		this.menuItemUrl = menuItemUrl;
		this.parentId = parentId;
		this.status = status;
		this.menuItemDes = menuItemDes;
		this.authority = authority;
		this.sort = sort;
	}
	@Override
	public int compareTo(MenuItem menuItem) {
		if(this.sort >= menuItem.getSort()){
			return 1;
		}
		return -1;
	}
}
