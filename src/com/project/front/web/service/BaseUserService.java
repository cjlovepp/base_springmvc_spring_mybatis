package com.project.front.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.utils.MD5;
import com.commons.web.base.service.BaseService;
import com.project.front.web.dao.BaseUserDao;
import com.project.front.web.entity.BaseUser;

@Service
public class BaseUserService extends BaseService {

	public static final Integer BATCH_NUM = 200 ;
	@Autowired
	private BaseUserDao baseUserDao;

	/**
	 * 根据accountId 查询baseUser
	 * @Date:2014年11月12日 上午10:14:22
	 * @Author:wangqiqi
	 * @param sqlId
	 * @param accountId
	 * @return
	 * @throws
	 */
	public BaseUser findByAccountId(String sqlId,String accountId){
		return baseUserDao.findByAccountId(sqlId, accountId);
	}
	
	public List<BaseUser> findParentsByStudentId(String sqlId,String studentId){
		return baseUserDao.findParentsByStudentId(sqlId, studentId);
	}
	public List<BaseUser> findListBySchoolId(String sqlId,String schoolId){
		return baseUserDao.findListBySchoolId(sqlId, schoolId);
	}
	
	public List<BaseUser> findListByDistrictId(String sqlId,String districtId){
		return baseUserDao.findListByDistrictId(sqlId, districtId);
	}
	/**
	 * 登录验证
	 * @Date:2014年11月12日 上午10:20:02
	 * @Author:wangqiqi
	 * @param sqlId
	 * @param user
	 * @return
	 * @throws
	 */
	public BaseUser validateLogin(String sqlId,BaseUser user) {
		String passwordMD5 = MD5.md5(user.getPassword());
		user.setPassword(passwordMD5);
		user.setUsername(user.getUsername().trim());
		return baseUserDao.validateLogin(sqlId,user);
	}
	/**
	 * 老师绑定家长验证
	 * @Date:2014年11月29日 下午4:06:42
	 * @Author:wangqiqi
	 */
	public BaseUser validateBindParent(String sqlId,String accountId,String psw){
		return baseUserDao.validateBindParent(sqlId, accountId, psw);
	}
	
	public BaseUser validataUser(String sqlId,BaseUser user){
		return baseUserDao.validataUser(sqlId, user);
	}
	public void bandOrUnbandParent(BaseUser user,BaseUser parent){
		BaseUser userUpdate = new BaseUser();
		userUpdate.setId(user.getId());
		userUpdate.setrAccountId(user.getrAccountId());
		BaseUser parentUpdate = new BaseUser();
		parentUpdate.setId(parent.getId());
		parentUpdate.setrAccountId(parent.getrAccountId());
		baseUserDao.updateObject(userUpdate);
		baseUserDao.updateObject(parentUpdate);
	}
	public int checkUsername(String sqlId,BaseUser baseUser){
		return baseUserDao.checkUsername(sqlId, baseUser);
	}
	
	public void lockOrUnlockUser(String sqlId,String state,String baseUserId){
		baseUserDao.lockOrUnlockUser(sqlId, state, baseUserId);
	}
}
