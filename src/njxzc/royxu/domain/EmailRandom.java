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
 * 邮箱验证码Entity
 * @author LiangHong
 * @version 2015-11-02
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_email_random")
public class EmailRandom extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int increment_id;//主键自增id
	private String email;// 邮箱
	private String random_code;// 发给邮箱的验证码
	private String send_time;// 发送时间
	private String validate_time;// 验证时间
	private String is_validated;// 是否验证通过
	private String user_no;// 用户编号
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '自增id'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}
	
	@Column(columnDefinition="varchar(255) comment '邮箱'")
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(columnDefinition="varchar(1024) comment '发给邮箱的验证码'")
	public String getRandom_code() {
		return this.random_code;
	}
	
	public void setRandom_code(String random_code) {
		this.random_code = random_code;
	}
	
	@Column(columnDefinition="varchar(50) comment '发送时间'")
	public String getSend_time() {
		return this.send_time;
	}
	
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	
	@Column(columnDefinition="varchar(50) comment '验证时间'")
	public String getValidate_time() {
		return this.validate_time;
	}
	
	public void setValidate_time(String validate_time) {
		this.validate_time = validate_time;
	}
	
	@Column(columnDefinition="varchar(20) comment '是否验证通过'")
	public String getIs_validated() {
		return this.is_validated;
	}
	
	public void setIs_validated(String is_validated) {
		this.is_validated = is_validated;
	}
	
	@Column(columnDefinition="varchar(255) comment '用户编号'")
	public String getUser_no() {
		return this.user_no;
	}
	
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"email : " + email + "," +
			"random_code : " + random_code + "," +
			"send_time : " + send_time + "," +
			"validate_time : " + validate_time + "," +
			"is_validated : " + is_validated + "," +
			"user_no : " + user_no + 
		"}";
	}
}


