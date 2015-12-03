package njxzc.royxu.searchmodel;

//查询Paper类
public class SearchPaper {
	private String s_paper_id;// 文献主键id
	private String s_title;// 文献标题
	private String s_author;// 作者
	private String s_paper_abstract;// 文献摘要
	private String s_publish_time;// 发表时间
	private String s_journal;// 发表期刊
	private String s_support_fund;// 支持资金
	private String s_user_no;// 所属人员编号
	
	public String getS_paper_id() {
		return this.s_paper_id;
	}
	
	public void setS_paper_id(String s_paper_id) {
		this.s_paper_id = s_paper_id;
	}
	
	public String getS_title() {
		return this.s_title;
	}
	
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}
	
	public String getS_author() {
		return this.s_author;
	}
	
	public void setS_author(String s_author) {
		this.s_author = s_author;
	}
	
	public String getS_paper_abstract() {
		return this.s_paper_abstract;
	}
	
	public void setS_paper_abstract(String s_paper_abstract) {
		this.s_paper_abstract = s_paper_abstract;
	}
	
	public String getS_publish_time() {
		return this.s_publish_time;
	}
	
	public void setS_publish_time(String s_publish_time) {
		this.s_publish_time = s_publish_time;
	}
	
	public String getS_journal() {
		return this.s_journal;
	}
	
	public void setS_journal(String s_journal) {
		this.s_journal = s_journal;
	}
	
	public String getS_support_fund() {
		return this.s_support_fund;
	}
	
	public void setS_support_fund(String s_support_fund) {
		this.s_support_fund = s_support_fund;
	}
	
	public String getS_user_no() {
		return this.s_user_no;
	}
	
	public void setS_user_no(String s_user_no) {
		this.s_user_no = s_user_no;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"paper_id : " + s_paper_id + "," +
			"title : " + s_title + "," +
			"author : " + s_author + "," +
			"paper_abstract : " + s_paper_abstract + "," +
			"publish_time : " + s_publish_time + "," +
			"journal : " + s_journal + "," +
			"support_fund : " + s_support_fund + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}


