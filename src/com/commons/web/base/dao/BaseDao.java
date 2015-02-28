package com.commons.web.base.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

import com.commons.page.Page;
import com.commons.page.Pageable;


/**
 * 
 * @author wangqiqi
 * @Date:2014年11月14日 下午6:39:13
 */
public abstract interface BaseDao {
	
	public abstract SqlSession	getSqlSessionTemplate();
	public abstract Object getObject(String paramString, Object paramObject);

	public abstract Object getObject(Class<?> clazz,String paramString);

	public abstract Object getById(Class<?> paramClass, Serializable paramSerializable);

	public abstract Collection<?> getObjects(String paramString, Object paramObject);
	
	public abstract Collection<?> getObjects(String paramString,Class<?> clazz, Object paramObject);

	public abstract int insertObject(String paramString, Object paramObject);

	public abstract int updateObject(String paramString, Object paramObject);

	public abstract Collection<?> getAll(Class<?> paramClass);

	public abstract Collection<?> getObjects(Class<?> paramClass, Object paramObject);

	public abstract int getTotalRow(Class<?> paramClass, Object paramObject);

	public abstract int getTotalRow(String paramString, Object paramObject);

	public abstract int insertObject(Object paramObject);

	public abstract int updateObject(Object paramObject);

	public abstract int deleteObject(Object paramObject);
	public abstract int deleteObject(Class<?> paramClass,Object paramObject);
	public abstract int deleteObject(String paramString, Object paramObject);

	public <T> Pageable<T> findWithPage(String selectTotal,String selectData,Object paraObject, Page page);
	public <T> Pageable<T> findList4FrontPaging(String selectTotal,String selectData,Object paraObject, Integer start, Integer end);
}
