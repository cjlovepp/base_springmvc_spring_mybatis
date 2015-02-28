package com.commons.page;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SimplePageable<T> extends SimplePage implements Pageable<T> {
	
	/**
	 * 总页数
	 */
	private Integer totalPages = 0;
	/**
	 * 总记录数
	 */
	private Integer totalRecords = 0;
	/**
	 * 集合数据
	 */
	private List<T> list = new LinkedList<T>();
	
	/**
	 * 默认构造函数, 默认当前页为第0页, 每页大小为20, 总记录数为0, 总页数为0
	 */
	public SimplePageable(){
		setCurrentPage(0);
	}
	
	/**
	 * SimplePageable构造函数
	 * @param currentPage 当前页
	 * @param pageCountData 每页大小
	 * @param totalPages 总页数
	 * @param totalRecords 总记录
	 */
	public SimplePageable(Integer currentPage, Integer pageCountData, Integer totalPages, Integer totalRecords) {
		super(currentPage, pageCountData);
		this.totalPages = totalPages;
		this.totalRecords = totalRecords;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer pages) {
		totalPages = pages;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer records) {
		totalRecords = records;
	}

	public List<T> getList() {
		return list;
	}

	public void addData(Collection<T> collection) {
		list.addAll(collection);
	}

	public void addData(T[] array) {
		if(array !=null){
			for(T t:array){
				list.add(t);
			}
		}
	}

}
