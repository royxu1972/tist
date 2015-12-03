package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_role")
public class Role extends BaseDomain {
	private static final long serialVersionUID = 7745543022899025339L;

	private int role_id;// 角色编号
	private String role_name;// 角色名称
	private String menu_ids;//	角色对应菜单id
	private String create_by;// 创建者
	private String create_time;// 创建时间
	private String update_by;// 修改者
	private String update_time;// 修改时间
	private String note;// 备注

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '角色编号'")
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Column(columnDefinition="varchar(20) comment '角色名称'")
	public String getRole_name() {
		return role_name;
	}

	@Lob
	@Column(columnDefinition="text comment '角色对应菜单id'")
	public String getMenu_ids() {
		return menu_ids;
	}

	public void setMenu_ids(String menu_ids) {
		this.menu_ids = menu_ids;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Column(columnDefinition="varchar(64) comment '创建者'")
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

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name
				+ ", create_by=" + create_by + ", create_time=" + create_time
				+ ", update_by=" + update_by + ", update_time=" + update_time
				+ ", note=" + note + "]";
	}

}
