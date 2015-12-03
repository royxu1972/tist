package ${packageName}.domain${subModuleName};

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
 * ${functionName}Entity
 * @author ${classAuthor}
 * @version ${classVersion}
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "${tableName}")
public class ${ClassName} extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int increment_id;//主键自增id
	<#list fields as fld>
	private ${fld.field_type} ${fld.field_name};// ${fld.field_comment}
	</#list>
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '自增id'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}
	
	<#list fields as fld>
	@Column(columnDefinition="${fld.db_field_type}(${fld.field_length}) comment '${fld.field_comment}'")
	public ${fld.field_type} get${fld.field_name?cap_first}() {
		return this.${fld.field_name};
	}
	
	public void set${fld.field_name?cap_first}(${fld.field_type} ${fld.field_name}) {
		this.${fld.field_name} = ${fld.field_name};
	}
	
	</#list>
	
	@Override
	public String toString() {
		return "{" +
			<#list fields as fld>
			"${fld.field_name} : " + ${fld.field_name} + <#if fld_has_next>"," +</#if>
			</#list>
		"}";
	}
}


