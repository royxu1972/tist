package njxzc.royxu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "t_hat_city")//实体类对应的表名
public class HatCity extends BaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;//ID

	private String cityID   ;//市编码

	private String  city ;//市名描述

	private String  father ;//省级编码

	@Id//设置主键
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}
}
