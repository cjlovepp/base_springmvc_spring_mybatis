package com.project.front.web.entity;

import com.commons.web.base.entity.BaseEntity;

public class BaseUser extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5149374153994891225L;

	public static final String HEAD_PIC_DEFAULT = "headPicDefault.jpg";//用户默认头像
	
	public static final String SEX_MALE = "男";
	public static final String SEX_FEMALE = "女";
	public static final String SEX_UNKOWN = "未知";
	
	public static final String STATE_CLOSE = "CLOSE";//锁定
	public static final String STATE_OPEN = "OPEN";//解锁
	public static final String STATE_DELETE  = "DELETE";//删除
	
	public static final String CHANGE_INT_PSD_YES = "YES";//改过初始密码
	public static final String CHANGE_INT_PSD_NO = "NO";//没改过初始密码
	
	private	String	username;//用户名
	private	String	password;//密码
	private	String	realName;//真实姓名
	private	String	phoneNum;//手机号码
	private	String	headPic;//头像
	private	String	accountId;//ID
	private	String	email;//邮件
	private	String	sex;//性别 
	private	String	birthDate;//生日
	private	String	userType;//USER_TYPE in ('TEACHER','STUDENT','PARENT','SCHOOL','ORG_MANAGER','TEACH_ORG_MANAGER','ORG','MANAGER')
	private	String	state;//状态 CLOSE:锁定  OPEN:正常  DELETE:已删除
	private	String	createTime;
	private	String	createBaseUserId;//创建人
	private String 	createBaseUserName;
	private	String	rAccountId;//关联账户
	private	String	changeInitPsd;//YES :改过初始密码	NO:没改过初始密码
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateBaseUserId() {
		return createBaseUserId;
	}
	public void setCreateBaseUserId(String createBaseUserId) {
		this.createBaseUserId = createBaseUserId;
	}
	
	public String getChangeInitPsd() {
		return changeInitPsd;
	}
	public void setChangeInitPsd(String changeInitPsd) {
		this.changeInitPsd = changeInitPsd;
	}
	public String getCreateBaseUserName() {
		return createBaseUserName;
	}
	public void setCreateBaseUserName(String createBaseUserName) {
		this.createBaseUserName = createBaseUserName;
	}
	public String getrAccountId() {
		return rAccountId;
	}
	public void setrAccountId(String rAccountId) {
		this.rAccountId = rAccountId;
	}
	
	
}
