package com.commons.page;

public class SimplePage implements Page {
	
	/**
	 * 当前页数
	 */
	private Integer currentPage = 1;
	/**
	 * 每页总数
	 */
	private Integer pageSize = 20;
	
	/**
	 * 默认构造函数, 默认当前页为第1页, 每页大小为10
	 */
	public SimplePage(){}
	
	/**
	 * SimplePage构造函数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 */
	public SimplePage(Integer currentPage, Integer pageSize){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	/**
	 * SimplePage构造函数
	 * @param currentPage 当前页
	 * @param pageSize 每页大小，默认20条
	 */
	public SimplePage(Integer currentPage){
		this.currentPage = currentPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}
