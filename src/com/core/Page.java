package com.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -2886268592463135562L;

	private static int DEFAULT_PAGE_SIZE = 20; 
	private int pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数
	private long start; // 当前页第一条数据在List中的位置,从0开始
	private List<Object> data; // 当前页中存放的记录,类型一般为List
	private long totalCount; // 总记录数
	
	//构造方法，只构造空页
	public Page() { 
	  this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<Object>()); 
	} 
	//默认构造方法
	public Page(long start, long totalSize, int pageSize, List<Object> data) { 
	  this.pageSize = pageSize; 
	  this.start = start; 
	  this.totalCount = totalSize; 
	  this.setData(data); 
	} 
	//取总页数 
	public long getTotalPageCount() { 
	  if (totalCount % pageSize == 0) 
	    return totalCount / pageSize; 
	  else 
	    return totalCount / pageSize + 1; 
	} 
	//取该页当前页码,页码从1开始
	public long getCurrentPageNo() { 
	  return start / pageSize + 1; 
	} 
	//该页是否有下一页
	public boolean isHasNextPage() { 
	  return this.getCurrentPageNo() < this.getTotalPageCount(); 
	} 
	//该页是否有上一页
	public boolean isHasPreviousPage() { 
	  return this.getCurrentPageNo() > 1; 
	} 
	
	//获取任一页第一条数据在数据集的位置，每页条数使用默认值
	protected static int getStartOfPage(int pageNo) { 
	  return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE); 
	}
    // 获取任一页第一条数据在数据集的位置
	public static int getStartOfPage(int pageNo, int pageSize) { 
	  return (pageNo - 1) * pageSize; 
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
