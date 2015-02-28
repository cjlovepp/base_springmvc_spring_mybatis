package com.commons.web.base.service;
import java.io.Serializable;
import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.commons.page.Page;
import com.commons.page.Pageable;
import com.commons.web.base.dao.BaseDao;




/**
 * @author wangqiqi
 * @Date:2014年11月14日 下午6:39:26
 */
@Service
public class BaseService {
	
	@Autowired
	@Qualifier("baseDao")
	protected BaseDao baseDao;

	public SqlSession	getSqlSessionTemplate(){
		return this.baseDao.getSqlSessionTemplate();
	}
	public Object getObject(String paramString, Object paramObject) {
		return this.baseDao.getObject(paramString, paramObject);
	}
	public Object getById(Class<?> clazz,Serializable paramSerializable){
		return this.baseDao.getById(clazz, paramSerializable);
	}
	public Collection<?> getObjects(String paramString, Object paramObject) {
		return this.baseDao.getObjects(paramString, paramObject);
	}
	public Collection<?> getObjects(String paramString,Class<?> clazz, Object paramObject){
		return this.baseDao.getObjects(paramString, clazz, paramObject);
	}
	public int updateObject(String paramString, Object paramObject) {
		return this.baseDao.updateObject(paramString, paramObject);
	}

	public int deleteObject(String paramString, Object paramObject) {
		return this.baseDao.deleteObject(paramString, paramObject);
	}

	public Collection<?> getAll(Class<?> paramClass) {
		return this.baseDao.getAll(paramClass);
	}

	public Collection<?> getObjects(Class<?> paramClass, Object paramObject) {
		return this.baseDao.getObjects(paramClass, paramObject);
	}

	public int insertObject(Object paramObject) {
		return this.baseDao.insertObject(paramObject);
	}

	public int insertObject(String paramString, Object paramObject) {
		return this.baseDao.insertObject(paramString, paramObject);
	}

	public int updateObject(Object paramObject) {
		return this.baseDao.updateObject(paramObject);
	}

	public int deleteObject(Class<?> paramClass, Object paramObject) {
		return this.baseDao.deleteObject(paramClass, paramObject);
	}

	public <T> Pageable<T> findWithPage(String selectTotal,String selectData,Object paraObject, Page page){
		return this.baseDao.findWithPage(selectTotal, selectData, paraObject, page);
	}
	public <T> Pageable<T> findList4FrontPaging(String selectTotal,String selectData,Object paraObject, Integer start, Integer end){
		return this.baseDao.findList4FrontPaging(selectTotal, selectData, paraObject,start,end);
	}
	
}
