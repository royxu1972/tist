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

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_dict")
public class SystemDictionary extends BaseDomain {
	private static final long serialVersionUID = 4953078896394961597L;
	
	private int increment_id;// 数据字典配置项ID
	private String name;// 数据字典配置项名称
	private String description;// 数据字典配置项内容
	private int father_id;// 配置项归属ID
	private String sort;// 数据字典顺序
	private String create_by;//创建者
	private String create_time;//创建时间
	private String update_by;//修改者
	private String update_time;//修改时间
	private String del_flag = "0";//删除标志位
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '自增编号'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}

	@Column(columnDefinition="varchar(100) comment '数据字典配置项名称'")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(columnDefinition="varchar(100) comment '数据字典配置项说明'")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(columnDefinition="int(11) comment '所属父类id'")
	public int getFather_id() {
		return father_id;
	}

	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}

	@Column(columnDefinition="varchar(10) comment '排序'")
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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
	
	@Column(columnDefinition="char(1) default 0 comment '删除标志位'", nullable = false)
	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	@Override
	public String toString() {
		return "SystemDictionary [increment_id=" + increment_id + ", name="
				+ name + ", description=" + description + ", father_id="
				+ father_id + ", sort=" + sort + ", create_by=" + create_by
				+ ", create_time=" + create_time + ", update_by=" + update_by
				+ ", update_time=" + update_time + ", del_flag=" + del_flag
				+ "]";
	}
	
}
