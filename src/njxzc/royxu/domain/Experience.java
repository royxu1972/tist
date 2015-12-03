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
 * 个人经历Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_experience")
public class Experience extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int experience_id;// 经历主键id
	private String time_period_start;// 开始日期
	private String time_period_end;// 结束日期
	private String experience_info;// 经历简介
	private String experience_role;// 角色
	private String user_no;// 所属人员编号
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '经历主键id'")
	public int getExperience_id() {
		return this.experience_id;
	}
	
	public void setExperience_id(int experience_id) {
		this.experience_id = experience_id;
	}
	
	@Column(columnDefinition="varchar(30) comment '开始日期'")
	public String getTime_period_start() {
		return this.time_period_start;
	}
	
	public void setTime_period_start(String time_period_start) {
		this.time_period_start = time_period_start;
	}
	
	@Column(columnDefinition="varchar(30) comment '结束日期'")
	public String getTime_period_end() {
		return this.time_period_end;
	}
	
	public void setTime_period_end(String time_period_end) {
		this.time_period_end = time_period_end;
	}
	
	@Column(columnDefinition="text comment '经历简介'")
	public String getExperience_info() {
		return this.experience_info;
	}
	
	public void setExperience_info(String experience_info) {
		this.experience_info = experience_info;
	}
	
	@Column(columnDefinition="varchar(50) comment '角色'")
	public String getExperience_role() {
		return this.experience_role;
	}
	
	public void setExperience_role(String experience_role) {
		this.experience_role = experience_role;
	}
	
	@Column(columnDefinition="varchar(50) comment '所属人员编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "{" +
			"experience_id : " + experience_id + "," +
			"time_period_start : " + time_period_start + "," +
			"time_period_end : " + time_period_end + "," +
			"experience_info : " + experience_info + "," +
			"experience_role : " + experience_role + 
		"}";
	}
}


