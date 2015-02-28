package com.commons.web.base.entity;

import java.io.Serializable;


/**
 * @author CJ
 * @description: 
 * @date Feb 28, 2015 11:12:32 AM
 */
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -2599896905335811363L;
	private String id;
	private int startRow;
	private int endRow;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

}
