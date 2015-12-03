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
 * 文献Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_paper")
public class Paper extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String paper_id;// 文献主键id
	private String title;// 文献标题
	private String author;// 作者
	private String paper_abstract;// 文献摘要
	private String publish_time;// 发表时间
	private String journal;// 发表期刊
	private String support_fund;// 支持资金
	private String user_no;// 所属人员编号
	//@Formula
	private String old_names;//文件名字
	private String file_paths;//文件路径
	private String file_ids;//文件主键id
	private String file_types;//文件类型
	
	@Id
	@Column(columnDefinition="varchar(30) comment '文献主键id'")
	public String getPaper_id() {
		return this.paper_id;
	}
	
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}
	
	@Column(columnDefinition="varchar(100) comment '文献标题'")
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(columnDefinition="varchar(1024) comment '作者'")
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(columnDefinition="varchar(1024) comment '文献摘要'")
	public String getPaper_abstract() {
		return this.paper_abstract;
	}
	
	public void setPaper_abstract(String paper_abstract) {
		this.paper_abstract = paper_abstract;
	}
	
	@Column(columnDefinition="varchar(30) comment '发表时间'")
	public String getPublish_time() {
		return this.publish_time;
	}
	
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
	
	@Column(columnDefinition="varchar(1024) comment '发表期刊'")
	public String getJournal() {
		return this.journal;
	}
	
	public void setJournal(String journal) {
		this.journal = journal;
	}
	
	@Column(columnDefinition="varchar(1024) comment '支持资金'")
	public String getSupport_fund() {
		return this.support_fund;
	}
	
	public void setSupport_fund(String support_fund) {
		this.support_fund = support_fund;
	}
	
	@Column(columnDefinition="varchar(50) comment '所属人员编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	
	@Formula("(select group_concat(att.original_name) from roy_attachment att "
			+ "where att.related_id=paper_id and att.del_flag=0 and att.table_of_attachment='roy_paper' "
			+ "order by att.attachment_id)")
	public String getOld_names() {
		return old_names;
	}

	public void setOld_names(String old_names) {
		this.old_names = old_names;
	}

	@Formula("(select group_concat(att.file_path) from roy_attachment att "
			+ "where att.related_id=paper_id and att.del_flag=0 and att.table_of_attachment='roy_paper' "
			+ "order by att.attachment_id)")
	public String getFile_paths() {
		return file_paths;
	}

	public void setFile_paths(String file_paths) {
		this.file_paths = file_paths;
	}

	@Formula("(select group_concat(att.attachment_id) from roy_attachment att "
			+ "where att.related_id=paper_id and att.del_flag=0 and att.table_of_attachment='roy_paper' "
			+ "order by att.attachment_id)")
	public String getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(String file_ids) {
		this.file_ids = file_ids;
	}
	
	@Formula("(select group_concat(att.file_type) from roy_attachment att "
			+ "where att.related_id=paper_id and att.del_flag=0 and att.table_of_attachment='roy_paper' "
			+ "order by att.attachment_id)")
	public String getFile_types() {
		return file_types;
	}

	public void setFile_types(String file_types) {
		this.file_types = file_types;
	}
	
	@Override
	public String toString() {
		return "{" +
			"paper_id : " + paper_id + "," +
			"title : " + title + "," +
			"author : " + author + "," +
			"paper_abstract : " + paper_abstract + "," +
			"publish_time : " + publish_time + "," +
			"journal : " + journal + "," +
			"support_fund : " + support_fund + 
		"}";
	}
}


