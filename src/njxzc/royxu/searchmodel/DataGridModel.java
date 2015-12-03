package njxzc.royxu.searchmodel;

public class DataGridModel {
	private int page; // 当前页,名字必须为page
	private int rows; // 每页大小,名字必须为rows
	private String sort; // 排序字段
	private String order; // 排序规则

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
