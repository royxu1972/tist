package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_user_role")
public class UserRole extends BaseDomain {
	private static final long serialVersionUID = -281713861286615969L;
	private int increment_id;//自增id
	private int user_id;//用户编号
	private String role_ids;//角色编号
	private String role_names;//
	private String user_name;//用户名

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '用户角色自增id'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}

	@Column(columnDefinition="int(11) comment '用户编号'")
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Column(columnDefinition="varchar(255) comment '角色编号'")
	public String getRole_ids() {
		return role_ids;
	}

	public void setRole_ids(String role_ids) {
		this.role_ids = role_ids;
	}

	@Formula("(select GROUP_CONCAT(r.role_name) from sys_role r where r.role_id in (role_ids))")
	public String getRole_names() {
		return role_names;
	}

	public void setRole_names(String role_names) {
		this.role_names = role_names;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "UserRole [increment_id=" + increment_id + ", user_id="
				+ user_id + ", role_ids=" + role_ids + ", user_name="
				+ user_name + "]";
	}

}
