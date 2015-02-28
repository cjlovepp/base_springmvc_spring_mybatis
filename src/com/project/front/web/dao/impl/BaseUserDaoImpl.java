package com.project.front.web.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.commons.web.base.dao.impl.BaseDaoImpl;
import com.project.front.web.dao.BaseUserDao;
import com.project.front.web.entity.BaseUser;


@Repository
public class BaseUserDaoImpl extends BaseDaoImpl implements BaseUserDao {

	@Override
	public BaseUser findByAccountId(String sqlId, String accountId) {
		return sqlSessionTemplate.selectOne(getSqlName(BaseUser.class, sqlId), accountId);
	}

	@Override
	public BaseUser validateLogin(String sqlId, BaseUser user) {
		return sqlSessionTemplate.selectOne(getSqlName(BaseUser.class, sqlId), user);
	}

	@Override
	public List<BaseUser> findParentsByStudentId(String sqlId, String studentId) {
		List<BaseUser> list = getSqlSessionTemplate().selectList(getSqlName(BaseUser.class, sqlId), studentId);
		return list;
	}

	@Override
	public int checkUsername(String sqlId, BaseUser baseUser) {
		int num = getSqlSessionTemplate().selectOne(getSqlName(BaseUser.class, sqlId),baseUser);
		return num;
	}

	@Override
	public String getStudentIdByAccountId(String sqlId, String accountId) {
		return getSqlSessionTemplate().selectOne("getStudentIdByAccountId", accountId);
	}

	@Override
	public void lockOrUnlockUser(String sqlId, String state, String baseUserId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("baseUserId", baseUserId);
		map.put("state", state);
		try {
			getSqlSessionTemplate().update(getSqlName(BaseUser.class, sqlId), map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void batchAddBaseUser(List<BaseUser> baseUsers) {

		sqlSessionTemplate.insert("com.codyy.rrthenan.rrtbasedata.web.front.bean.BaseUser.batchInsert", baseUsers) ;
	}

	




	@Override
	public List<String> getParentUserIdByClassroomId(String classroomId) {
		return sqlSessionTemplate.selectList("com.codyy.rrthenan.rrtbasedata.web.front.bean.BaseUser.getParentUserIdByClassroomId",classroomId);
	}

	@Override
	public List<String> getStudentUserIdByClassroomId(String classroomId) {
		return sqlSessionTemplate.selectList("com.codyy.rrthenan.rrtbasedata.web.front.bean.BaseUser.getStudentUserIdByClassroomId",classroomId);
	}

	@Override
	public BaseUser validataUser(String sqlId, BaseUser user) {
		return getSqlSessionTemplate().selectOne(getSqlName(BaseUser.class, sqlId), user);
	}

	@Override
	public List<BaseUser> findListBySchoolId(String sqlId, String schoolId) {
		return getSqlSessionTemplate().selectList(getSqlName(BaseUser.class, sqlId), schoolId);
	}

	@Override
	public List<BaseUser> findListByDistrictId(String sqlId, String districtId) {
		return getSqlSessionTemplate().selectList(getSqlName(BaseUser.class, sqlId), districtId);
	}

	@Override
	public BaseUser validateBindParent(String sqlId, String accountId,
			String psw) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
