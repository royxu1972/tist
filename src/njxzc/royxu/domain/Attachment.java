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
 * 附件Entity
 * @author LiangHong
 * @version 2015-10-02
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_attachment")
public class Attachment extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int attachment_id;// 附件主键id
	private String table_of_attachment;// 附件所属表
	private String related_id;// 附件关联id
	private String original_name;// 原文件名
	private String new_name;// 新文件名
	private String file_type;// 文件类型
	private String file_path;// 文件路径
	private String file_size;// 文件大小
	private String del_flag;// 删除标志位
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '附件主键id'")
	public int getAttachment_id() {
		return this.attachment_id;
	}
	
	public void setAttachment_id(int attachment_id) {
		this.attachment_id = attachment_id;
	}
	
	@Column(columnDefinition="varchar(100) comment '附件所属表'")
	public String getTable_of_attachment() {
		return this.table_of_attachment;
	}
	
	public void setTable_of_attachment(String table_of_attachment) {
		this.table_of_attachment = table_of_attachment;
	}
	
	@Column(columnDefinition="varchar(100) comment '附件关联id'")
	public String getRelated_id() {
		return this.related_id;
	}
	
	public void setRelated_id(String related_id) {
		this.related_id = related_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '原文件名'")
	public String getOriginal_name() {
		return this.original_name;
	}
	
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	
	@Column(columnDefinition="varchar(1024) comment '新文件名'")
	public String getNew_name() {
		return this.new_name;
	}
	
	public void setNew_name(String new_name) {
		this.new_name = new_name;
	}
	
	@Column(columnDefinition="varchar(100) comment '文件类型'")
	public String getFile_type() {
		return this.file_type;
	}
	
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	
	@Column(columnDefinition="text comment '文件路径'")
	public String getFile_path() {
		return this.file_path;
	}
	
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	@Column(columnDefinition="varchar(50) comment '文件大小'")
	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
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
			"attachment_id : " + attachment_id + "," +
			"table_of_attachment : " + table_of_attachment + "," +
			"related_id : " + related_id + "," +
			"original_name : " + original_name + "," +
			"new_name : " + new_name + "," +
			"file_type : " + file_type + "," +
			"file_path : " + file_path + "," +
			"del_flag : " + del_flag + 
		"}";
	}
}


