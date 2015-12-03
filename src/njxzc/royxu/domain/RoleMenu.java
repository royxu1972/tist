package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

/**
 * 角色菜单管理Entity
 * @author Author
 * @version 2015-07-24
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_role_menu")
public class RoleMenu extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int role_menu_id;// 角色菜单编号
	private int role_id;// 角色id
	private String menu_id;// 角色对应菜单id
	private String menu_father_id;// 菜单父id
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '角色菜单编号'")
	public int getRole_menu_id() {
		return this.role_menu_id;
	}
	
	public void setRole_menu_id(int role_menu_id) {
		this.role_menu_id = role_menu_id;
	}
	
	@Column(columnDefinition="int(11) comment '角色id'")
	public int getRole_id() {
		return this.role_id;
	}
	
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	@Column(columnDefinition="varchar(255) comment '角色对应菜单id'")
	public String getMenu_id() {
		return this.menu_id;
	}
	
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	
	@Column(columnDefinition="varchar(255) comment '菜单父id'")
	public String getMenu_father_id() {
		return this.menu_father_id;
	}
	
	public void setMenu_father_id(String menu_father_id) {
		this.menu_father_id = menu_father_id;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"role_menu_id : " + role_menu_id + "," +
			"role_id : " + role_id + "," +
			"menu_id : " + menu_id + "," +
			"menu_father_id : " + menu_father_id + 
		"}";
	}
}


