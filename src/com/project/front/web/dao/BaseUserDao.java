package com.project.front.web.dao;

import java.util.List;

import com.commons.web.base.dao.BaseDao;
import com.project.front.web.entity.BaseUser;

public interface BaseUserDao extends BaseDao {

	public BaseUser findByAccountId(String sqlId,String accountId);
	
	public BaseUser validateLogin(String sqlId,BaseUser user);
	
	public List<BaseUser> findParentsByStudentId(String sqlId,String studentId);
	
	public List<BaseUser> findListBySchoolId(String sqlId,String schoolId);
	
	public List<BaseUser> findListByDistrictId(String sqlId,String districtId);
	
	public int checkUsername(String sqlId,BaseUser baseUser);
	
	public String getStudentIdByAccountId(String sqlId,String accountId);
	
	public void lockOrUnlockUser(String sqlId,String state,String baseUserId);
	
	public void batchAddBaseUser(List<BaseUser> baseUsers) ;
	public BaseUser validateBindParent(String sqlId,String accountId,String psw);
	
	public BaseUser validataUser(String sqlId,BaseUser user);
	/**
	 * 根据班级id获取所有家长id 班级私信群发
	 * @author yangyonwu
	 * @param classroomId
	 * @return
	 */
	public List<String>getParentUserIdByClassroomId(String classroomId);
	/**
	 * 根据班级id获取所有学生id 班级私信群发
	 * @author yangyonwu
	 * @param classroomId
	 * @return
	 */
	public List<String>getStudentUserIdByClassroomId(String classroomId);
	
	
}
