package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

import com.core.BaseDomain;

/**
 * 消息发布Entity
 * @author Author
 * @version 2015-07-17
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_notice")
public class Notice extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String notice_id;// 消息id
	private String notice_title;// 消息标题
	private String notice_content;// 消息内容
	private String author;// 发布人
	private String notice_time;// 消息日期
	private String notice_origin;// 消息出处
	private String del_flag = "0";// 删除标志位
	
	@Id
	@Column(columnDefinition="varchar(30) comment '消息id'")
	public String getNotice_id() {
		return this.notice_id;
	}
	
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	
	@Column(columnDefinition="varchar(200) comment '消息标题'")
	public String getNotice_title() {
		return this.notice_title;
	}
	
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	
	@Column(columnDefinition="text comment '消息内容'")
	public String getNotice_content() {
		return this.notice_content;
	}
	
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
	@Column(columnDefinition="varchar(20) comment '发布人'")
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(columnDefinition="varchar(30) comment '消息日期'")
	public String getNotice_time() {
		return this.notice_time;
	}
	
	public void setNotice_time(String notice_time) {
		this.notice_time = notice_time;
	}
	
	@Column(columnDefinition="varchar(255) comment '消息出处'")
	public String getNotice_origin() {
		return this.notice_origin;
	}
	
	public void setNotice_origin(String notice_origin) {
		this.notice_origin = notice_origin;
	}
	
	@Column(columnDefinition="char(1) default 0 comment '删除标志位'", nullable = false)
	public String getDel_flag() {
		return this.del_flag;
	}
	
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	
	@Override
	public String toString() {
		return "{" +
			"notice_id : " + notice_id + "," +
			"notice_title : " + notice_title + "," +
			"notice_content : " + notice_content + "," +
			"author : " + author + "," +
			"notice_time : " + notice_time + "," +
			"notice_origin : " + notice_origin + "," +
			"del_flag : " + del_flag + 
		"}";
	}
}


