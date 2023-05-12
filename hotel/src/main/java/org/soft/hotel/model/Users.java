package org.soft.hotel.model;

/**
 * 会员信息
 * @author Administrator
 *
 */
public class Users {

	private int usersId;  
	private String userVipId; //会员账号
	private String userPass; //会员密码
	private String userRealName; //会员真实姓名
	private String userIdCard; //会员身份证号
	private String userPhone; //会员手机号
	private int userIntegral; //会员积分
	
	public Users() {
		
	}
	public Users(int usersId, String userVipId, String userPass, String userRealName, String userIdCard,
			String userPhone, int userIntegral) {
		this.usersId = usersId;
		this.userVipId = userVipId;
		this.userPass = userPass;
		this.userRealName = userRealName;
		this.userIdCard = userIdCard;
		this.userPhone = userPhone;
		this.userIntegral = userIntegral;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public String getUserVipId() {
		return userVipId;
	}
	public void setUserVipId(String userVipId) {
		this.userVipId = userVipId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
}
