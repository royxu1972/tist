package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_log")
public class SystemLog extends BaseDomain {
	private static final long serialVersionUID = -1290392486990027796L;

	private int increment_id;// 自增id
	private String type;// 日志类型-exceprion;create;update;delete
	private String create_by;// 创建者
	private String create_time;// 创建时间
	private String remote_addr;// 远程地址
	private String user_agent;// 用户代理
	private String request_uri;// 请求uri
	private String method;// 请求方法
	private String params;// 参数
	private String exception;// 错误信息

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '用户编号'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}

	@Column(columnDefinition="char(10) comment '日志类型'")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Column(columnDefinition="varchar(255) comment '远端地址'")
	public String getRemote_addr() {
		return remote_addr;
	}

	public void setRemote_addr(String remote_addr) {
		this.remote_addr = remote_addr;
	}

	@Column(columnDefinition="varchar(255) comment '用户代理'")
	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	@Column(columnDefinition="varchar(255) comment '请求uri'")
	public String getRequest_uri() {
		return request_uri;
	}

	public void setRequest_uri(String request_uri) {
		this.request_uri = request_uri;
	}

	@Column(columnDefinition="varchar(10) comment '请求方法'")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Lob
	@Column(columnDefinition="text comment '请求参数'")
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Lob
	@Column(columnDefinition="text comment '异常信息'")
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "SystemLog [increment_id=" + increment_id + ", type=" + type
				+ ", create_by=" + create_by + ", create_time=" + create_time
				+ ", remote_addr=" + remote_addr + ", user_agent=" + user_agent
				+ ", request_uri=" + request_uri + ", method=" + method
				+ ", params=" + params + ", exception=" + exception + "]";
	}

}
