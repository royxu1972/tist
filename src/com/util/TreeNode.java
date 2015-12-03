package com.util;

/**
 * 树形结构实体工具类
 */

import java.util.List;
import java.util.Map;

public class TreeNode implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6753565327045848663L;
	private Integer id;
	private String text;// 树节点名称
	private String iconCls;// 前面的小图标样式
	private Boolean checked = false;// 是否勾选状态
	private Map<String, Object> attributes;// 其他参数
	private List<TreeNode> children;// 子节点
	private String state = "open";// 是否展开(open,closed)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	public String toString(){
		return '['+this.id+";"+this.text+"]";
	}

}
