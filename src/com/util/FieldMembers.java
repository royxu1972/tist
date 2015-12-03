package com.util;

public class FieldMembers {
	private String field_type;//成员类型
	private String field_name;//成员名称
	private String field_comment;//字段注释
	private String db_field_type;//数据库中字段类型
	private String field_length;//字段长度
	
	public FieldMembers(String field_type, String field_name,
			String field_comment) {
		super();
		this.field_type = field_type;
		this.field_name = field_name;
		this.field_comment = field_comment;
	}

	public FieldMembers(String field_type, String field_name,
			String field_comment, String field_length) {
		super();
		this.field_type = field_type;
		this.field_name = field_name;
		this.field_comment = field_comment;
		this.field_length = field_length;
	}
	

	public FieldMembers(String field_type, String field_name,
			String field_comment, String db_field_type, String field_length) {
		super();
		this.field_type = field_type;
		this.field_name = field_name;
		this.field_comment = field_comment;
		this.db_field_type = db_field_type;
		this.field_length = field_length;
	}

	public String getField_type() {
		return field_type;
	}

	public void setField_type(String field_type) {
		this.field_type = field_type;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getField_comment() {
		return field_comment;
	}

	public void setField_comment(String field_comment) {
		this.field_comment = field_comment;
	}

	public String getField_length() {
		return field_length;
	}

	public void setField_length(String field_length) {
		this.field_length = field_length;
	}

	public String getDb_field_type() {
		return db_field_type;
	}

	public void setDb_field_type(String db_field_type) {
		this.db_field_type = db_field_type;
	}

	@Override
	public String toString() {
		return "FieldMembers [field_type=" + field_type + ", field_name="
				+ field_name + ", field_comment=" + field_comment
				+ ", field_length=" + field_length + ", db_field_type="
				+ db_field_type + "]";
	}
}
