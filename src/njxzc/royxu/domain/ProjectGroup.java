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
 * 项目组Entity
 * @author LiangHong
 * @version 2015-10-24
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_project_group")
public class ProjectGroup extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int increment_id;//主键自增id
	private String group_zhname;// 项目组中文名
	private String group_enname;// 项目组英文名
	private String group_zhintro;// 中文介绍
	private String group_enintro;// 英文介绍
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '自增id'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目组中文名'")
	public String getGroup_zhname() {
		return this.group_zhname;
	}
	
	public void setGroup_zhname(String group_zhname) {
		this.group_zhname = group_zhname;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目组英文名'")
	public String getGroup_enname() {
		return this.group_enname;
	}
	
	public void setGroup_enname(String group_enname) {
		this.group_enname = group_enname;
	}
	
	@Column(columnDefinition="longtext comment '中文介绍'")
	public String getGroup_zhintro() {
		return this.group_zhintro;
	}
	
	public void setGroup_zhintro(String group_zhintro) {
		this.group_zhintro = group_zhintro;
	}
	
	@Column(columnDefinition="longtext comment '英文介绍'")
	public String getGroup_enintro() {
		return this.group_enintro;
	}
	
	public void setGroup_enintro(String group_enintro) {
		this.group_enintro = group_enintro;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"group_zhname : " + group_zhname + "," +
			"group_enname : " + group_enname + "," +
			"group_zhintro : " + group_zhintro + "," +
			"group_enintro : " + group_enintro + 
		"}";
	}
}


