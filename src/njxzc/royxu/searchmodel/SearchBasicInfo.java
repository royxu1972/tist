package njxzc.royxu.searchmodel;

//查询BasicInfo类
public class SearchBasicInfo {
	private String s_increment_id;// 主键自增id
	private String s_name;// 姓名
	private String s_gender;// 性别
	private String s_birthday;// 出生年月
	private String s_academic;// 学历
	private String s_pro_title;// 职称
	private String s_email;// 邮箱
	private String s_address;// 联系地址
	private String s_zh_introduction;// 中文简介
	private String s_en_introduction;// 英文简介
	private String s_detail_introduction;// 详细介绍
	
	public String getS_increment_id() {
		return this.s_increment_id;
	}
	
	public void setS_increment_id(String s_increment_id) {
		this.s_increment_id = s_increment_id;
	}
	
	public String getS_name() {
		return this.s_name;
	}
	
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	public String getS_gender() {
		return this.s_gender;
	}
	
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	
	public String getS_birthday() {
		return this.s_birthday;
	}
	
	public void setS_birthday(String s_birthday) {
		this.s_birthday = s_birthday;
	}
	
	public String getS_academic() {
		return this.s_academic;
	}
	
	public void setS_academic(String s_academic) {
		this.s_academic = s_academic;
	}
	
	public String getS_pro_title() {
		return this.s_pro_title;
	}
	
	public void setS_pro_title(String s_pro_title) {
		this.s_pro_title = s_pro_title;
	}
	
	public String getS_email() {
		return this.s_email;
	}
	
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	
	public String getS_address() {
		return this.s_address;
	}
	
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	
	public String getS_zh_introduction() {
		return this.s_zh_introduction;
	}
	
	public void setS_zh_introduction(String s_zh_introduction) {
		this.s_zh_introduction = s_zh_introduction;
	}
	
	public String getS_en_introduction() {
		return this.s_en_introduction;
	}
	
	public void setS_en_introduction(String s_en_introduction) {
		this.s_en_introduction = s_en_introduction;
	}
	
	public String getS_detail_introduction() {
		return this.s_detail_introduction;
	}
	
	public void setS_detail_introduction(String s_detail_introduction) {
		this.s_detail_introduction = s_detail_introduction;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"increment_id : " + s_increment_id + "," +
			"name : " + s_name + "," +
			"gender : " + s_gender + "," +
			"birthday : " + s_birthday + "," +
			"academic : " + s_academic + "," +
			"pro_title : " + s_pro_title + "," +
			"email : " + s_email + "," +
			"address : " + s_address + "," +
			"zh_introduction : " + s_zh_introduction + "," +
			"en_introduction : " + s_en_introduction + "," +
			"detail_introduction : " + s_detail_introduction + 
		"}";
	}
}


