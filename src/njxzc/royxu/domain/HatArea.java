package njxzc.royxu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "t_hat_area")//实体类对应的表名
public class HatArea extends BaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;//ID

	private String areaID   ;//地区编码

	private String  area ;//地区名描述

	private String  father ;//市级编码

	@Id//设置主键
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getAreaID() {
		return areaID;
	}

	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
