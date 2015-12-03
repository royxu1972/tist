package njxzc.royxu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "t_hat_province")//实体类对应的表名
public class HatProvince extends BaseDomain {
	private static final long serialVersionUID = 1L;

	//fields
	private int id;//ID

	private String provinceID  ;//省编码

	private String  province ;//省名描述

	@Id//设置主键
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
