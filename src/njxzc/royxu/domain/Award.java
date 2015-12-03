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
 * 个人荣誉Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_award")
public class Award extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int award_id;// 荣誉主键id
	private String award_name;// 荣誉名称
	private String award_unit;// 颁发单位
	private String award_date;// 颁发日期
	private String award_rank;// 荣誉级别
	private String user_no;// 所属人员编号
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '荣誉主键id'")
	public int getAward_id() {
		return this.award_id;
	}
	
	public void setAward_id(int award_id) {
		this.award_id = award_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '荣誉名称'")
	public String getAward_name() {
		return this.award_name;
	}
	
	public void setAward_name(String award_name) {
		this.award_name = award_name;
	}
	
	@Column(columnDefinition="varchar(1024) comment '颁发单位'")
	public String getAward_unit() {
		return this.award_unit;
	}
	
	public void setAward_unit(String award_unit) {
		this.award_unit = award_unit;
	}
	
	@Column(columnDefinition="varchar(30) comment '颁发日期'")
	public String getAward_date() {
		return this.award_date;
	}
	
	public void setAward_date(String award_date) {
		this.award_date = award_date;
	}
	
	@Column(columnDefinition="varchar(30) comment '荣誉级别'")
	public String getAward_rank() {
		return this.award_rank;
	}
	
	public void setAward_rank(String award_rank) {
		this.award_rank = award_rank;
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
			"award_id : " + award_id + "," +
			"award_name : " + award_name + "," +
			"award_unit : " + award_unit + "," +
			"award_date : " + award_date + "," +
			"award_rank : " + award_rank + 
		"}";
	}
}


