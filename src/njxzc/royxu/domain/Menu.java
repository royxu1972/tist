package njxzc.royxu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_menu")
public class Menu extends BaseDomain {
	private static final long serialVersionUID = -2198693949123252309L;

	private int menu_id;//菜单id
	private Integer father_id;//菜单父项id
	private String menu_name;//菜单名称
	private String menu_level;//菜单级别
	private String href;//连接
	private String sort;//排序
	private String icon;//图标
	private String create_by;//创建者
	private String create_time;//创建时间
	private String update_by;//修改者
	private String update_time;//修改时间
	private String note;//备注
	private String del_flag = "0";//删除标志位
	private List<Menu> menus = new ArrayList<Menu>();
	
	@Id
	@Column(columnDefinition="int(255) comment '菜单编号'")
	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	@Column(columnDefinition="int(11) comment '父项菜单id'")
	public Integer getFather_id() {
		return father_id;
	}

	public void setFather_id(Integer father_id) {
		this.father_id = father_id;
	}
	
	@Column(columnDefinition="varchar(30) comment '菜单名称'")
	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	@Column(columnDefinition="varchar(10) comment '菜单级别'")
	public String getMenu_level() {
		return menu_level;
	}

	public void setMenu_level(String menu_level) {
		this.menu_level = menu_level;
	}

	@Column(columnDefinition="varchar(255) comment 'url链接'")
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Column(columnDefinition="varchar(255) comment '排序'")
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Column(columnDefinition="varchar(100) comment '链接图片'")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(columnDefinition="varchar(20) comment '创建者'")
	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	
	@Column(columnDefinition="varchar(30) comment '创建时间'")
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Column(columnDefinition="varchar(20) comment '修改者'")
	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	@Column(columnDefinition="varchar(30) comment '修改时间'")
	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	@Column(columnDefinition="varchar(255) comment '备注'")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(columnDefinition="char(1) default 0 comment '删除标志位'", nullable = false)
	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "father_id")
	@OrderBy("sort,menu_id")
	@Where(clause = "del_flag=0")
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", father_id=" + father_id
				+ ", menu_name=" + menu_name + ", menu_level=" + menu_level
				+ ", href=" + href + ", sort=" + sort + ", icon=" + icon
				+ ", create_by=" + create_by + ", create_time=" + create_time
				+ ", update_by=" + update_by + ", update_time=" + update_time
				+ ", note=" + note + ", del_flag=" + del_flag + ", menus="
				+ menus + "]";
	}
	
}
