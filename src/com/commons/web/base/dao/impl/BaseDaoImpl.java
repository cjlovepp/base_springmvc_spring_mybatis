package com.commons.web.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.commons.page.Page;
import com.commons.page.Pageable;
import com.commons.page.SimplePageable;
import com.commons.web.base.dao.BaseDao;


/**
 * 
 * @author wangqiqi
 * @Date:2014年11月14日 下午6:38:42
 */
@Repository("baseDao")
public class BaseDaoImpl implements BaseDao {

	@Resource(name = "sqlSessionTemplate")
	protected SqlSession sqlSessionTemplate;

	public static final String SQLNAME_SEPARATOR = ".";
	public static final String LIST_ALL = "listAll";// getAll
	public static final String LIST = "list";
	public static final String TOTAL = "total";
	public static final String INSERT = "insert";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	public static final String GET_BY_ID = "getById";

	@Override
	public SqlSession getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

	/**
	 * 获取泛型类型的实体对象类全名:包名+类名
	 */
	protected String getDefaultSqlNamespace(Object obj) {
		return obj == null ? null : obj.getClass().getName();
	}

	/**
	 * SqlMapping命名空间 + “.” +sqlName
	 */
	protected String getSqlName(Object obj, String sqlId) {
		return getDefaultSqlNamespace(obj) + SQLNAME_SEPARATOR + sqlId;
	}
	protected String getSqlName(Class<?> clazz,String sqlId) {
		return clazz.getName() + SQLNAME_SEPARATOR + sqlId;
	}

	protected final Log log = LogFactory.getLog(super.getClass());

	public Object getObject(String paramString, Object paramObject) {
		if (paramObject == null)
			return this.sqlSessionTemplate.selectOne(getSqlName(paramObject, paramString));
		return this.sqlSessionTemplate.selectOne(getSqlName(paramObject, paramString), paramObject);
	}

	public Object getObject(Class<?> clazz,String paramString) {
		return this.sqlSessionTemplate.selectOne(getSqlName(clazz, paramString));
	}

	public Object getById(Class<?> paramClass, Serializable paramSerializable) {
		return this.sqlSessionTemplate.selectOne(getSqlName(paramClass, GET_BY_ID), paramSerializable);
	}

	public Collection<?> getObjects(String paramString, Object paramObject) {
		if (paramObject == null)
			return this.sqlSessionTemplate.selectList(getSqlName(paramObject, paramString));
		return this.sqlSessionTemplate.selectList(getSqlName(paramObject, paramString), paramObject);
	}

	public int insertObject(String paramString, Object paramObject) {
		return this.sqlSessionTemplate.insert(getSqlName(paramObject, paramString), paramObject);
	}

	public int updateObject(String paramString, Object paramObject) {
		return this.sqlSessionTemplate.update(getSqlName(paramObject, paramString), paramObject);
	}

	public Collection<?> getAll(Class<?> paramClass) {
		return this.sqlSessionTemplate.selectList(getSqlName(paramClass, LIST_ALL), null);
	}

	public Collection<?> getObjects(Class<?> paramClass, Object paramObject) {
		List<?> localList = null;
		try {
			localList = this.sqlSessionTemplate.selectList(getSqlName(paramClass, LIST), paramObject);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return localList;
	}
	public Collection<?> getObjects(String paramString, Class<?> clazz,Object paramObject) {
		List<?> localList = null;
		try {
			localList = this.sqlSessionTemplate.selectList(getSqlName(clazz, paramString), paramObject);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return localList;
	}
	public int getTotalRow(Class<?> paramClass, Object paramObject) {
		int num = this.sqlSessionTemplate.selectOne(getSqlName(paramClass, TOTAL), paramObject);
		return num;
	}

	public int getTotalRow(String paramString, Object paramObject) {
		int num = this.sqlSessionTemplate.selectOne(getSqlName(paramObject, paramString), paramObject);
		return num;
	}

	public int insertObject(Object paramObject) {
		return this.sqlSessionTemplate.insert(getSqlName(paramObject, INSERT), paramObject);
	}

	public int updateObject(Object paramObject) {
		return this.sqlSessionTemplate.update(getSqlName(paramObject, UPDATE), paramObject);
	}

	@Override
	public int deleteObject(Object paramObject) {
		return this.sqlSessionTemplate.delete(getSqlName(paramObject, DELETE), paramObject);
	}

	public int deleteObject(String paramString, Object paramObject) {
		return this.sqlSessionTemplate.delete(getSqlName(paramObject, paramString), paramObject);
	}

	public int deleteObject(Class<?> paramClass, Object paramObject) {
		return this.sqlSessionTemplate.delete(getSqlName(paramClass, DELETE), paramObject);
	}

	public <T> Pageable<T> findWithPage(String selectTotal, String selectData, Object paraObject, Page page) {
		Pageable<T> result = new SimplePageable<T>();
		int totalRecords = Integer.valueOf(this.sqlSessionTemplate.selectOne(getSqlName(paraObject, selectTotal), paraObject).toString()).intValue();
		int pageSize = 10;
		if (page.getPageSize() != null) {
			pageSize = page.getPageSize().intValue();
		}
		if (totalRecords == 0) {// 查询结果为空
			result.setPageSize(pageSize);
			result.setCurrentPage(0);
			result.setTotalRecords(0);
			result.setTotalPages(0);
		} else {
			int totalPages = (int) Math.ceil(totalRecords / (double) pageSize);
			int currentPage = 1;// 默认为第一页
			if (page.getCurrentPage() != null && page.getCurrentPage().intValue() > 1) {
				currentPage = page.getCurrentPage().intValue();
			}
			if (currentPage > totalPages)// 如果当前页超出总页范围,设置当前页为最后一页
				currentPage = totalPages;

			int startIndex = (currentPage - 1) * pageSize;
			int endIndex = startIndex + pageSize;
			setStartRowAndEndRow(startIndex, endIndex, paraObject);

			List<T> objectList = this.sqlSessionTemplate.selectList(getSqlName(paraObject, selectData), paraObject);

			result.addData(objectList);
			result.setTotalRecords(totalRecords);
			result.setTotalPages(totalPages);
			result.setPageSize(pageSize);
			result.setCurrentPage(currentPage);
		}
		return result;
	}

	@Override
	public <T> Pageable<T> findList4FrontPaging(String selectTotal, String selectData, Object paraObject, Integer start, Integer end) {
		Pageable<T> result = new SimplePageable<T>();
		int totalRecords = Integer.valueOf(this.sqlSessionTemplate.selectOne(getSqlName(paraObject, selectTotal), paraObject).toString()).intValue();
		if (totalRecords == 0) {// 查询结果为空
			result.setCurrentPage(0);
			result.setTotalRecords(0);
			result.setTotalPages(0);
		} else {
			setStartRowAndEndRow(start,end+1,paraObject);
			List<T> objectList = this.sqlSessionTemplate.selectList(getSqlName(paraObject, selectData), paraObject);
			result.addData(objectList);
			result.setTotalRecords(totalRecords);
		}
		return result;
	}

	/**
	 * 利用反射设置startRow endRow
	 * 
	 * @Date:2014年11月14日 下午6:38:20
	 * @Author:wangqiqi
	 * @param startRow
	 * @param endRow
	 * @param paraObject
	 * @throws
	 */
	private void setStartRowAndEndRow(int startRow, int endRow, Object paraObject) {
		Class<?> clazz = paraObject.getClass();
		int flag = 2;

		do {
			clazz = clazz.getSuperclass();
			try {
				Method[] methods = clazz.getDeclaredMethods();
				for (int i = 0; i < methods.length; i++) {
					if (methods[i].getName().startsWith("setStartRow")) {
						methods[i].invoke(paraObject, startRow);
						flag--;// 标记自减
					}
					if (methods[i].getName().startsWith("setEndRow")) {
						methods[i].invoke(paraObject, endRow);
						flag--;// 标记自减
					}
					if (flag == 0) {// 如果已经设值成功，直接返回
						return;
					}
				}
			} catch (Exception e) {
				throw new RuntimeException("分页查询出错了，无法设置startRow和endRow");
			}

		} while (clazz.getSuperclass() != null && flag > 0);

	}

}