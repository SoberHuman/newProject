package org.soft.hotel.model;

/**
 * 员工信息
 * @author Administrator
 *
 */
public class Staff {

	private int staffId;
	private String staffAccount;  //员工账号
	private String staffPassword; //员工密码
	private String staffName; //员工姓名
	
	public Staff() {
		
	}

	public Staff(int staffId, String staffAccount, String staffPassword, String staffName) {
		this.staffId = staffId;
		this.staffAccount = staffAccount;
		this.staffPassword = staffPassword;
		this.staffName = staffName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffAccount() {
		return staffAccount;
	}

	public void setStaffAccount(String staffAccount) {
		this.staffAccount = staffAccount;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
}
